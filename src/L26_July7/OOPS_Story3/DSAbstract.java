package L26_July7.OOPS_Story3;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Jul-2018
 */

public abstract class DSAbstract {

	int size = 0;

	public abstract void display();

	public boolean isEmpty() {
		return this.size() == 0;
	}

	private int size() {
		return this.size;
	}
}
