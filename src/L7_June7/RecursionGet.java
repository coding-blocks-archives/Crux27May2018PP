package L7_June7;

import java.util.ArrayList;

public class RecursionGet {

	public static void main(String[] args) {

		// System.out.println(getSSAscii("ab"));
		System.out.println(getMazePathDMM(0, 0, 2, 2).size());

		// convert string to respective character
		int a = Integer.parseInt("");
		char c = (char) (a + 96);
		System.out.println(c);

	}

	public static ArrayList<String> getSS(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getSS(ros);
		ArrayList<String> mr = new ArrayList<>();

		for (String rrs : rr) {

			mr.add(rrs); // ch says no
			mr.add(ch + rrs); // ch says yes
		}

		return mr;

	}

	public static ArrayList<String> getSSAscii(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getSSAscii(ros);
		ArrayList<String> mr = new ArrayList<>();

		for (String rrs : rr) {

			mr.add(rrs); // ch says no
			mr.add(ch + rrs); // ch says yes
			mr.add((int) ch + rrs); // ch as ascii
		}

		return mr;

	}

	public static String getCode(char ch) {

		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";
		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "stu";
		else if (ch == '8')
			return "vwx";
		else if (ch == '9')
			return "yz";
		else if (ch == '0')
			return "@#";
		else
			return "";
	}

	public static ArrayList<String> getKPC(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getKPC(ros);
		ArrayList<String> mr = new ArrayList<>();

		String code = getCode(ch);

		for (int i = 0; i < code.length(); i++) {
			for (String rrs : rr) {
				mr.add(code.charAt(i) + rrs);
			}
		}
		return mr;
	}

	public static ArrayList<String> getPermutation(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getPermutation(ros);
		ArrayList<String> mr = new ArrayList<>();

		for (String rrs : rr) {

			for (int i = 0; i <= rrs.length(); i++) {
				StringBuilder sb = new StringBuilder(rrs);
				sb.insert(i, ch);
				// mr.add(rrs.substring(0, i) + ch + rrs.substring(i));
				mr.add(sb.toString());
			}
		}

		return mr;

	}

	public static ArrayList<String> getCoinToss(int n) {

		if (n == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		ArrayList<String> rr = getCoinToss(n - 1);

		ArrayList<String> mr = new ArrayList<>();

		for (String rrs : rr) {
			mr.add("H" + rrs);
			mr.add("T" + rrs);
		}

		return mr;
	}

	public static ArrayList<String> getBoardPath(int curr, int end) {

		if (curr == end) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}

		if (curr > end) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		for (int dice = 1; dice <= 6; dice++) {

			ArrayList<String> rr = getBoardPath(curr + dice, end);

			for (String rrs : rr) {
				mr.add(dice + rrs);
			}

		}

		return mr;
	}

	public static ArrayList<String> getMazePath(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		ArrayList<String> rrh = getMazePath(cr, cc + 1, er, ec);
		for (String rrhs : rrh) {
			mr.add("H" + rrhs);
		}

		ArrayList<String> rrv = getMazePath(cr + 1, cc, er, ec);
		for (String rrvs : rrv) {
			mr.add("V" + rrvs);
		}

		return mr;
	}

	public static ArrayList<String> getMazePathD(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		ArrayList<String> rrh = getMazePathD(cr, cc + 1, er, ec);
		for (String rrhs : rrh) {
			mr.add("H" + rrhs);
		}

		ArrayList<String> rrv = getMazePathD(cr + 1, cc, er, ec);
		for (String rrvs : rrv) {
			mr.add("V" + rrvs);
		}

		ArrayList<String> rrd = getMazePathD(cr + 1, cc + 1, er, ec);
		for (String rrds : rrd) {
			mr.add("D" + rrds);
		}

		return mr;
	}

	public static ArrayList<String> getMazePathDMM(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		for (int i = 1; i <= ec; i++) {
			ArrayList<String> rrh = getMazePathDMM(cr, cc + i, er, ec);
			for (String rrhs : rrh) {
				mr.add("H" + i + rrhs);
			}
		}

		for (int j = 1; j <= er; j++) {
			ArrayList<String> rrv = getMazePathDMM(cr + j, cc, er, ec);
			for (String rrvs : rrv) {
				mr.add("V" + j + rrvs);
			}
		}

		for (int k = 1; k <= er && k <= ec; k++) {
			ArrayList<String> rrd = getMazePathDMM(cr + k, cc + k, er, ec);
			for (String rrds : rrd) {
				mr.add("D" + k + rrds);
			}
		}
		return mr;

	}

}
