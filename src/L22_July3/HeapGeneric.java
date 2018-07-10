package L22_July3;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 03-Jul-2018
 */

public class HeapGeneric<T extends Comparable<T>> {

	ArrayList<T> data = new ArrayList<>();
	HashMap<T, Integer> indexing = new HashMap<>();

	public int size() {
		return data.size();

	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void add(T item) {

		this.data.add(item);
		this.indexing.put(item, data.size() - 1);
		upheapify(this.data.size() - 1);
	}

	private void upheapify(int ci) {

		int pi = (ci - 1) / 2;

		if (isLarger(data.get(ci), data.get(pi)) > 0) {
			swap(pi, ci);
			upheapify(pi);
		}

	}

	private void swap(int i, int j) {

		T ith = this.data.get(i);
		T jth = this.data.get(j);

		data.set(i, jth);
		data.set(j, ith);

		indexing.put(ith, j);
		indexing.put(jth, i);
	}

	public T remove() {

		swap(0, this.data.size() - 1);
		T rv = data.remove(this.size() - 1);
		indexing.remove(rv);

		dowheapify(0);

		return rv;
	}

	private void dowheapify(int pi) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int mini = pi;

		if (lci < this.data.size() && isLarger(data.get(lci), data.get(mini)) > 0) {
			mini = lci;
		}

		if (rci < this.data.size() && isLarger(data.get(rci), data.get(mini)) > 0) {
			mini = rci;
		}

		if (mini != pi) {
			swap(mini, pi);
			dowheapify(mini);
		}

	}

	public T get() {
		return this.data.get(0);
	}

	public int isLarger(T t, T o) {
		return t.compareTo(o);
	}

	public void updatePriority(T pair) {

		// int idx = 0;
		//
		// for (int i = 0; i < data.size(); i++) {
		// if (data.get(i) == pair) {
		// idx = i;
		// }
		//
		// }

		int idx = indexing.get(pair);

		upheapify(idx);
	}

}
