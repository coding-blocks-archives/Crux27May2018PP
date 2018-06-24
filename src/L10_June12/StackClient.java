package L10_June12;

public class StackClient {

	public static void main(String[] args) throws Exception {

		Stack s = new Stack();
		s.push(10);
		s.display();
		s.push(20);
		s.display();
		s.push(30);
		s.push(40);
		s.push(50);
		// s.push(60);
		s.display();
		// System.out.println(s.pop());
		// System.out.println(s.pop());
		// System.out.println(s.top());
		// s.display();

		// actualReverse(s, new Stack());
		// s.display();

		int[] prices = { 2, 3, 1, 8, 6, 2, 5, 10, 7 };
		int[] span = stockSpan(prices);
		for (int val : span) {
			System.out.print(val + " ");
		}
		
		// ans : 1 2 1 4 1 1 2 8 1 
	}

	public static void displayReverse(Stack s) throws Exception {

		if (s.isEmpty()) {
			return;
		}

		int temp = s.pop();

		displayReverse(s);

		System.out.println(temp);
		s.push(temp);

	}

	public static void actualReverse(Stack s, Stack helper) throws Exception {

		if (s.isEmpty()) {

			if (helper.isEmpty()) {
				return;
			}
			int temph = helper.pop();
			actualReverse(s, helper);
			s.push(temph);

			return;
		}
		int temp = s.pop();
		helper.push(temp);

		actualReverse(s, helper);

	}

	public static int[] stockSpan(int[] prices) throws Exception {

		DynamicStack stack = new DynamicStack();

		int[] span = new int[prices.length];
		span[0] = 1;
		stack.push(0);

		for (int i = 1; i < prices.length; i++) {

			while (!stack.isEmpty() && prices[stack.top()] < prices[i]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				span[i] = i + 1;
			} else {
				span[i] = i - stack.top();
			}

			stack.push(i);
		}

		return span;

	}

}
