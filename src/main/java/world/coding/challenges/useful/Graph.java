package world.coding.challenges.useful;

import java.util.*;

public class Graph<T> {

    static class Vertex {
        String label;

        Vertex(String label) {
            this.label = label;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return label.equals(vertex.label);
        }

        @Override
        public int hashCode() {
            return Objects.hash(label);
        }
    }

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

    public int getVertexCount() {
        return adjacentVertices.keySet().size();
    }

    public int getEdgesCount(boolean isBidirectional) {
        int count = 0;
        for (T vertex : adjacentVertices.keySet()) {
            count += adjacentVertices.get(vertex).size();
        }
        if (isBidirectional == true) {
            count /= 2;
        }
        return count;
    }

    public boolean hasVertex(T vertex) {
        return adjacentVertices.containsKey(vertex);
    }

    public boolean hasEdge(T start, T destination) {
        return adjacentVertices.containsKey(start) && adjacentVertices.get(start).contains(destination);
    }

    public List<T> breadthFirstSearch(T source) {
        List<T> bfs = new ArrayList<>();

        Queue<T> queue = new ArrayDeque<>();

        Set<T> visitedVertices = new HashSet<>();
        queue.add(source);
        visitedVertices.add(source);

        while (!queue.isEmpty()) {
            T vertex = queue.poll();
            bfs.add(vertex);
//            System.out.print(vertex + " ");

            for (T v : adjacentVertices.get(vertex)) {
                if (!visitedVertices.contains(v)) {
                    visitedVertices.add(v);
                    queue.add(v);
                }
            }

        }
        return bfs;
    }

    //hacky
    Set<T> dfsVisitedVertices;

    public List<T> depthFirstSearch(T source){
        List<T> dfs = new ArrayList<>();
        dfsVisitedVertices = new HashSet<>();
        dfs(source,dfs);
        return dfs;
    }

    private void dfs(T source, List<T> dfs) {
        dfsVisitedVertices.add(source);
        dfs.add(source);
//        System.out.print(source + " ");

        for (T adjNode : adjacentVertices.get(source)) {
            if (!dfsVisitedVertices.contains(adjNode))
                dfs(adjNode, dfs);
        }
    }

    public List<T> dfsNonRecursive(T source) {
        List<T> dfs = new ArrayList<>();

        Stack<T> stack = new Stack<>();    // get a stack
        Set<T> visitedVertices = new HashSet<>();
        stack.push(source);

        while (!stack.isEmpty()) {
            T vertex = stack.pop();         // remove the top node from the stack and start exploring its branches
            if (!visitedVertices.contains(vertex)) {
//                System.out.print(vertex + " ");
                dfs.add(vertex);
                visitedVertices.add(vertex);

                ListIterator<T> it =  adjacentVertices.get(vertex).listIterator(adjacentVertices.get(vertex).size());
                while (it.hasPrevious()){
                    T adjNode = it.previous();
                    if (!visitedVertices.contains(adjNode))
                        stack.push(adjNode);
                }
            }
        }
        return dfs;
    }

}
