package L2_May29;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 31-May-2018
 * 
 */

public class DataTypeDemo {

	public static void main(String[] args) {

		byte by = 10;
		short sh = 10;
		int in = 10;
		long lo = 10;

		// case 1
		// by = sh ;
		// by = in ;
		// by = lo;

		sh = by;
		// sh = in ;
		// sh = lo;

		in = by;
		in = sh;
		// in = lo ;

		lo = by;
		lo = sh;
		lo = in;

		// case 2
		by = 10;
		by = -128;
		by = (byte) 128;
		System.out.println(by);

		// case 3
		in = (int) 10000000000L;
		System.out.println(in);
		lo = 10000000000L;

		// case 4
		float fl = 5.5f;
		fl = (float) 5.5;

		double db = 7.1;
		db = fl;
		// fl = db ;

		// case 5
		in = (int) fl;
		fl = in;

		// case 6
		boolean bl = true;

		if (in > 7) {

		}

		if (bl) {

		}

		// case 7
		char ch = 'a';
		System.out.println(ch);

		in = 'a';
		System.out.println(in);

		// System.out.println(Math.pow(2, 16));
		ch = 98;
		System.out.println(ch);

		ch = (char) (ch + 1);
		System.out.println(ch);

		in = ch + 3;

		System.out.println(in);

		// case 8
		System.out.println(10 + 20 + "Hello" + 10 + 20);
		System.out.println(2 + ' ' + 5);
		System.out.println(2 + " " + 5);
		System.out.println("Hello" + '\t' + "World");
		System.out.println("Hello" + "\t" + "World");

	}

}
