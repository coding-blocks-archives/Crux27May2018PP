package L3_May31;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 31-May-2018
 * 
 */

public class FunctionOps {

	public static void main(String[] args) {

		printAllArmstrong(0, 1000);
	}

	public static void printAllArmstrong(int ll, int ul) {

		for (int i = ll; i <= ul; i++) {

			int digits = numberOfDigits(i);
			boolean ans = isArmstrong(i, digits);
			if (ans) {
				System.out.println(i);
			}
		}
	}

	public static boolean isArmstrong(int num, int nod) {

		int ans = 0;
		int on = num ;
		
		while (num != 0) {

			int rem = num % 10;
			ans = ans + (int) Math.pow(rem, nod);
			num = num / 10;
		}

		if (on == ans) {
			return true;
		} else {
			return false;
		}
	}

	public static int numberOfDigits(int num) {

		int count = 0;
		while (num != 0) {
			count++;
			num = num / 10;
		}

		return count;

	}

}
