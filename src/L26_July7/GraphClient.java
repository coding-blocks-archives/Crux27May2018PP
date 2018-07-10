package L26_July7;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Jul-2018
 */

public class GraphClient {

	public static void main(String[] args) {

		Graph graph = new Graph();

		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");

		graph.addEdge("A", "B", 1);
		graph.addEdge("A", "D", 10);
		graph.addEdge("C", "B", 1);
		graph.addEdge("C", "D", 5);
		graph.addEdge("D", "E", 2);
		graph.addEdge("E", "F", 4);
		graph.addEdge("G", "E", 2);
		graph.addEdge("F", "G", 3);

		graph.display();

		// graph.removeEdge("B", "C");
		// graph.removeEdge("E", "F");
		// System.out.println(graph.hasPath("A", "F", new HashMap<>()));
		// System.out.println(graph.BFS("A", "F"));
		// System.out.println(graph.DFS("A", "F"));

		// graph.BFT();
		// graph.DFT();

		// System.out.println(graph.isCyclic());
		// System.out.println(graph.isConnected());
		// System.out.println(graph.isTree());
		// System.out.println(graph.getCC());

		// System.out.println(graph.isBipartite());

		graph.prims().display();

	}

}
