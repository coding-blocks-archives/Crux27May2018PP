package L26_July7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import L22_July3.HeapGeneric;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Jul-2018
 */

public class Graph {

	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	private HashMap<String, Vertex> vertices = new HashMap<>();

	public int numVertex() {
		return vertices.size();
	}

	public boolean containsVertex(String vname) {
		return vertices.containsKey(vname);

	}

	public void addVertex(String vname) {

		if (containsVertex(vname)) {
			return;
		}

		Vertex vtx = new Vertex();
		vertices.put(vname, vtx);
	}

	public void removeVertex(String vname) {

		Vertex vtx = vertices.get(vname);
		ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());

		for (String nbr : nbrs) {

			Vertex nbrvtx = vertices.get(nbr);
			nbrvtx.nbrs.remove(vname);

		}

		vertices.remove(vname);

	}

	public int numEdges() {

		int sum = 0;

		for (String key : vertices.keySet()) {

			Vertex vtx = vertices.get(key);
			sum += vtx.nbrs.size();
		}

		return sum / 2;

	}

	public boolean containsEdge(String vname1, String vname2) {

		Vertex vtx1 = vertices.get(vname1);
		Vertex vtx2 = vertices.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return false;
		}

		return true;
	}

	public void addEdge(String vname1, String vname2, int cost) {

		Vertex vtx1 = vertices.get(vname1);
		Vertex vtx2 = vertices.get(vname2);

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.put(vname2, cost);
		vtx2.nbrs.put(vname1, cost);
	}

	public void removeEdge(String vname1, String vname2) {

		Vertex vtx1 = vertices.get(vname1);
		Vertex vtx2 = vertices.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);
	}

	public void display() {

		System.out.println("----------------------");
		for (String key : vertices.keySet()) {
			Vertex vtx = vertices.get(key);
			System.out.println(key + "-> " + vtx.nbrs);
		}
		System.out.println("----------------------");
	}

	public boolean hasPath(String src, String dst, HashMap<String, Boolean> processed) {

		processed.put(src, true);

		if (containsEdge(src, dst)) {
			return true;
		}

		Vertex vtx = vertices.get(src);

		// [B, D]
		for (String nbrname : vtx.nbrs.keySet()) {
			if (!processed.containsKey(nbrname) && hasPath(nbrname, dst, processed)) {
				return true;
			}
		}

		return false;

	}

	private class Pair {
		String vname;
		String psf;
		Vertex vtx;

		String color;
	}

	public boolean BFS(String src, String dst) {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();
		// 1. create a new pair and put in queue
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;
		sp.vtx = vertices.get(src);

		queue.addLast(sp);

		// 2. while queue is not empty
		while (!queue.isEmpty()) {

			// 2.1 element remove
			Pair rp = queue.removeFirst();

			if (processed.containsKey(rp.vname)) {
				continue;
			}

			// 2.2 processing
			processed.put(rp.vname, true);

			// 2.3 de
			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			// 2.4 nbrs
			for (String nbr : rp.vtx.nbrs.keySet()) {

				// process only unprocessed nbrs
				if (!processed.containsKey(nbr)) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;
					np.vtx = vertices.get(nbr);
					queue.addLast(np);
				}

			}

		}

		return false;

	}

	public boolean DFS(String src, String dst) {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();
		// 1. create a new pair and put in queue
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;
		sp.vtx = vertices.get(src);

		stack.addFirst(sp);

		// 2. while queue is not empty
		while (!stack.isEmpty()) {

			// 2.1 element remove
			Pair rp = stack.removeFirst();

			if (processed.containsKey(rp.vname)) {
				continue;
			}

			// 2.2 processing
			processed.put(rp.vname, true);

			// 2.3 de
			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			// 2.4 nbrs
			for (String nbr : rp.vtx.nbrs.keySet()) {

				// process only unprocessed nbrs
				if (!processed.containsKey(nbr)) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;
					np.vtx = vertices.get(nbr);
					stack.addFirst(np);
				}

			}

		}

		return false;

	}

	public void BFT() {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		for (String key : vertices.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			// 1. create a new pair and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			sp.vtx = vertices.get(key);

			queue.addLast(sp);

			// 2. while queue is not empty
			while (!queue.isEmpty()) {

				// 2.1 element remove
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				// 2.2 processing
				processed.put(rp.vname, true);

				// 2.3 de
				System.out.println(rp.vname + " via " + rp.psf);

				// 2.4 nbrs
				for (String nbr : rp.vtx.nbrs.keySet()) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						np.vtx = vertices.get(nbr);
						queue.addLast(np);
					}

				}

			}

		}

	}

	public void DFT() {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		for (String key : vertices.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			// 1. create a new pair and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			sp.vtx = vertices.get(key);

			stack.addFirst(sp);

			// 2. while queue is not empty
			while (!stack.isEmpty()) {

				// 2.1 element remove
				Pair rp = stack.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				// 2.2 processing
				processed.put(rp.vname, true);

				// 2.3 de
				System.out.println(rp.vname + " via " + rp.psf);

				// 2.4 nbrs
				for (String nbr : rp.vtx.nbrs.keySet()) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						np.vtx = vertices.get(nbr);
						stack.addFirst(np);
					}

				}

			}

		}

	}

	public boolean isCyclic() {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		for (String key : vertices.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			// 1. create a new pair and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			sp.vtx = vertices.get(key);

			queue.addLast(sp);

			// 2. while queue is not empty
			while (!queue.isEmpty()) {

				// 2.1 element remove
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					return true;
				}

				// 2.2 processing
				processed.put(rp.vname, true);

				// 2.4 nbrs
				for (String nbr : rp.vtx.nbrs.keySet()) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						np.vtx = vertices.get(nbr);
						queue.addLast(np);
					}

				}

			}

		}

		return false;

	}

	public boolean isConnected() {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		int flag = 0;

		for (String key : vertices.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			flag++;
			// 1. create a new pair and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			sp.vtx = vertices.get(key);

			queue.addLast(sp);

			// 2. while queue is not empty
			while (!queue.isEmpty()) {

				// 2.1 element remove
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				// 2.2 processing
				processed.put(rp.vname, true);

				// 2.4 nbrs
				for (String nbr : rp.vtx.nbrs.keySet()) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						np.vtx = vertices.get(nbr);
						queue.addLast(np);
					}

				}

			}

		}

		if (flag > 1) {
			return false;
		} else {
			return true;
		}

	}

	public boolean isTree() {
		return isConnected() && !isCyclic();
	}

	public ArrayList<ArrayList<String>> getCC() {

		ArrayList<ArrayList<String>> ans = new ArrayList<>();

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		for (String key : vertices.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			ArrayList<String> subans = new ArrayList<>();

			// 1. create a new pair and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			sp.vtx = vertices.get(key);

			queue.addLast(sp);

			// 2. while queue is not empty
			while (!queue.isEmpty()) {

				// 2.1 element remove
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				// 2.2 processing
				processed.put(rp.vname, true);

				// 2.3 add in subans
				subans.add(rp.vname);

				// 2.4 nbrs
				for (String nbr : rp.vtx.nbrs.keySet()) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						np.vtx = vertices.get(nbr);
						queue.addLast(np);
					}

				}

			}

			ans.add(subans);

		}

		return ans;

	}

	public boolean isBipartite() {

		HashMap<String, String> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		for (String key : vertices.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			// 1. create a new pair and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			sp.vtx = vertices.get(key);
			sp.color = "r";

			queue.addLast(sp);

			// 2. while queue is not empty
			while (!queue.isEmpty()) {

				// 2.1 element remove
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {

					String nc = rp.color;
					String oc = processed.get(rp.vname);

					if (!nc.equals(oc)) {
						return false;
					}

					continue;
				}

				// 2.2 processing
				processed.put(rp.vname, rp.color);

				// 2.4 nbrs
				for (String nbr : rp.vtx.nbrs.keySet()) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						np.vtx = vertices.get(nbr);
						np.color = rp.color.equals("r") ? "g" : "r";
						queue.addLast(np);
					}

				}

			}

		}

		return true;

	}

	private class PrimsPair implements Comparable<PrimsPair> {

		String vtxname;
		String acqvertexname;
		int cost;

		@Override
		public int compareTo(PrimsPair o) {
			return o.cost - this.cost;
		}
	}

	public Graph prims() {

		HeapGeneric<PrimsPair> heap = new HeapGeneric<>();
		HashMap<String, PrimsPair> processed = new HashMap<>();
		Graph mst = new Graph();

		// make pairs and put in heap
		for (String key : vertices.keySet()) {

			PrimsPair np = new PrimsPair();
			np.vtxname = key;
			np.acqvertexname = null;
			np.cost = Integer.MAX_VALUE;

			// put in heap ans processed hash map
			heap.add(np);
			processed.put(key, np);

		}

		// work till heap is not empty
		while (!heap.isEmpty()) {

			// remove a pair from heap and processed hash map
			PrimsPair rp = heap.remove();
			processed.remove(rp.vtxname);

			// add to your mst
			if (rp.acqvertexname == null) {
				mst.addVertex(rp.vtxname);
			} else {
				mst.addVertex(rp.vtxname);
				mst.addEdge(rp.acqvertexname, rp.vtxname, rp.cost);
			}

			// do work for nbrs
			for (String nbr : vertices.get(rp.vtxname).nbrs.keySet()) {

				// only those nbrs which are present in heap
				if (processed.containsKey(nbr)) {

					// find the old cost and new cost
					int oc = processed.get(nbr).cost;
					int nc = vertices.get(nbr).nbrs.get(rp.vtxname);

					// update only when nc < oc
					if (nc < oc) {

						// update the p[air of heap
						processed.get(nbr).cost = nc;
						processed.get(nbr).acqvertexname = rp.vtxname;

						// heap
						heap.updatePriority(processed.get(nbr));
					}

				}
			}

		}

		return mst;

	}

}
