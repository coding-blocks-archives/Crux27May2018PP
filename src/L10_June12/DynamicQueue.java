package L10_June12;

public class DynamicQueue extends Queue {

	@Override
	public void enqueue(int item) throws Exception {

		if (this.data.length == this.size) {

			int[] oa = this.data;
			int[] na = new int[oa.length * 2];

			for (int i = 0; i < this.size; i++) {
				int idx = (i + this.front) % this.data.length;
				na[i] = oa[idx];
			}

			this.data = na;
			this.front = 0;
		}
		super.enqueue(item);
	}

}
