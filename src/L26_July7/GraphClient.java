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

		graph.addEdge("A", "B", 10);
		graph.addEdge("A", "D", 20);
		graph.addEdge("C", "B", 30);
		graph.addEdge("C", "D", 40);
		graph.addEdge("D", "E", 60);
		graph.addEdge("E", "F", 70);
		graph.addEdge("G", "E", 80);
		graph.addEdge("F", "G", 90);

		graph.display();

		graph.removeEdge("D", "E");
		// System.out.println(graph.hasPath("A", "F", new HashMap<>()));
		System.out.println(graph.BFS("A", "F"));
		System.out.println(graph.DFS("A", "F"));

		graph.BFT();
		// graph.DFT();
	}

}
