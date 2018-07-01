package L21_July1.GenericFxn;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 01-Jul-2018
 */

public class Car // implements Comparable<Car> {
{
	int price;
	int speed;
	String color;

	public Car(int price, int speed, String color) {
		this.price = price;
		this.speed = speed;
		this.color = color;
	}

	@Override
	public String toString() {
		return "P:" + this.price + " S:" + this.speed + " C:" + this.color;
	}

	// @Override
	// public int compareTo(Car o) {
	// // return this.speed - o.speed;
	// // return o.price - this.price;
	//
	// return this.color.compareTo(o.color);
	// }

}
