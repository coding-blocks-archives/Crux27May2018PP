package L21_July1.GenericFxn;

import java.util.Comparator;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 01-Jul-2018
 */

public class CarColorComparator implements Comparator<Car> {

	@Override
	public int compare(Car t, Car o) {
		return t.color.compareTo(o.color);
	}

}
