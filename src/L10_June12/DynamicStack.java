package L10_June12;

public class DynamicStack extends Stack {

	int abc;

	// public DynamicStack(int cap) {
	// super(cap);
	//
	// abc = 10;
	//
	// }
	//
	// public DynamicStack() {
	// super(10);
	// }

	@Override
	public void push(int item) throws Exception {

		if (this.size() == this.data.length) {

			int[] oa = this.data;
			int[] na = new int[oa.length * 2];

			for (int i = 0; i < this.size(); i++) {
				na[i] = oa[i];
			}

			this.data = na;
		}

		super.push(item);

	}
}
