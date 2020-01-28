package world.coding.challenges

import spock.lang.Specification
import world.coding.challenges.useful.Graph

class GraphTest extends Specification{


    def "graph breadth first traversal"(){
        given:
        Graph<String> graph = new Graph<String>()
        graph.addEdge("S", "A", true);
        graph.addEdge("S", "B", true);
        graph.addEdge("S", "C", true);

        graph.addEdge("A", "D", true);
        graph.addEdge("B", "D", true);
        graph.addEdge("C", "D", true);
        /**
         *        S
         *      / | \
         *     A  B  C
         *      \ | /
         *        D
         */

        expect:
        graph.breadthFirstSearch("S") == ["S","A","B","C","D"]

        graph.depthFirstSearch("S") == ["S","A","D","B","C"]

        graph.dfsNonRecursive("S") == ["S","A","D","B","C"]
    }
}
