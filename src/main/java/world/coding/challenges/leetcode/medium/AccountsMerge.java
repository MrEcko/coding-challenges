package world.coding.challenges.leetcode.medium;

import java.util.*;

public class AccountsMerge {

    static class Graph<T> {
        private Map<T, List<T>> adjacentVertices;

        public Graph() {
            adjacentVertices = new HashMap<>();
        }

        public void addVertex(T vertex) {
            adjacentVertices.put(vertex, new LinkedList<>());
        }

        public void addEdge(T source,
                            T destination,
                            boolean isBidirectional) {

            if (!adjacentVertices.containsKey(source)) addVertex(source);
            if (!adjacentVertices.containsKey(destination)) addVertex(destination);
            adjacentVertices.get(source).add(destination);
            if (isBidirectional) adjacentVertices.get(destination).add(source);
        }

        Set<T> dfsVisitedVertices;

        public List<T> depthFirstSearch(T source) {
            List<T> dfs = new ArrayList<>();
            dfsVisitedVertices = new HashSet<>();
            dfs(source, dfs);
            return dfs;
        }

        private void dfs(T source, List<T> dfs) {
            dfsVisitedVertices.add(source);
            dfs.add(source);
            for (T adjNode : adjacentVertices.get(source)) {
                if (!dfsVisitedVertices.contains(adjNode))
                    dfs(adjNode, dfs);
            }
        }


    }

    static class Vertex {
        String value;
        boolean isName;
        Integer nameIndex;

        public Vertex(String value) {
            this.value = value;
            this.isName = false;
        }

        public Vertex(String value, Integer nameIndex) {
            this.value = value;
            this.isName = true;
            this.nameIndex = nameIndex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return isName == vertex.isName &&
                value.equals(vertex.value) &&
                Objects.equals(nameIndex, vertex.nameIndex);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, isName, nameIndex);
        }

        @Override
        public String toString() {
            if (isName) return value + "-" + nameIndex;
            else return value;
        }
    }


    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> output = new ArrayList<>();

        //build graph and unique names to start traversal from
        Graph<Vertex> graph = new Graph<>();
        Set<Vertex> names = new HashSet<>();
        int index = 0;
        for (List<String> personAndEmails : accounts) {
            String name = personAndEmails.get(0);
            List<String> emails = personAndEmails.subList(1, personAndEmails.size());
            for (String email : emails) {
                Vertex nameVertex = new Vertex(name, index);
                graph.addEdge(nameVertex, new Vertex(email), true);
                names.add(nameVertex);
            }
            index++;
        }

        //perform dfs on each name once
        Set<Vertex> visitedNames = new HashSet<>();
        for (Vertex name : names) {
            List<String> emails = new ArrayList<>();
            if (visitedNames.contains(name)) continue;
            List<Vertex> vertices = graph.depthFirstSearch(name);
            for (Vertex vertex : vertices) {
                if (vertex.isName) visitedNames.add(vertex);
                else emails.add(vertex.value);
            }
            if (emails.size() > 0) {
                List<String> personAccounts = new ArrayList<>();
                Collections.sort(emails);
                personAccounts.add(name.value);
                personAccounts.addAll(emails);
                output.add(personAccounts);
            }
        }
        return output;
    }

}
