package L22_July3;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 03-Jul-2018
 */

public class Heap {

	ArrayList<Integer> data = new ArrayList<>();

	public int size() {
		return data.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	// O(logn)
	public void add(int item) {

		this.data.add(item);
		upheapify(this.data.size() - 1);
	}

	private void upheapify(int ci) {

		int pi = (ci - 1) / 2;

		if (data.get(ci) < data.get(pi)) {
			swap(pi, ci);
			upheapify(pi);
		}

	}

	private void swap(int i, int j) {

		int ith = this.data.get(i);
		int jth = this.data.get(j);

		data.set(i, jth);
		data.set(j, ith);
	}

	// O(logn)
	public int remove() {

		swap(0, this.data.size() - 1);
		int rv = data.remove(this.size() - 1);
		dowheapify(0);

		return rv;
	}

	private void dowheapify(int pi) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int mini = pi;

		if (lci < this.data.size() && data.get(lci) < data.get(mini)) {
			mini = lci;
		}

		if (rci < this.data.size() && data.get(rci) < data.get(mini)) {
			mini = rci;
		}

		if (mini != pi) {
			swap(mini, pi);
			dowheapify(mini);
		}

	}

	// O(1)
	public int get() {
		return this.data.get(0);
	}
}
