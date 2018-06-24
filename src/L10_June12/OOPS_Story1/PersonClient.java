package L10_June12.OOPS_Story1;

public class PersonClient {

	public static void main(String[] args) {

		Person p1 = new Person();
		System.out.println(p1.name);
		System.out.println(p1.age);

		p1.name = "Ankit";
		p1.age = 20;

		System.out.println(p1.name);
		System.out.println(p1.age);

		Person p2 = p1;
		System.out.println(p2.name);
		System.out.println(p2.age);

		p2.name = "Ram";
		p2.age = 50;

		System.out.println(p1.name);
		System.out.println(p1.age);

		Person p3 = new Person();
		p3.age = 10;
		p3.name = "A";

		Person p4 = new Person();
		p4.age = 20;
		p4.name = "B";

		// Test1(p3, p4);
		// System.out.println(p3.age + " " + p3.name);
		// System.out.println(p4.age + " " + p4.name);
		//
		// Test2(p3, p4);
		// System.out.println(p3.age + " " + p3.name);
		// System.out.println(p4.age + " " + p4.name);

		int myAge = 30;
		String myName = "C";

		Test3(p3, p4.age, p4.name, myAge, myName);
		System.out.println(p3.age + " " + p3.name);
		System.out.println(p4.age + " " + p4.name);
		System.out.println(myAge + " " + myName);

		p3.introduceYourself();
		p3.sayHi("pratham");

		Person p = new Person("Ankit", 20);

		System.out.println(p);

		// System.out.println(Character.toUpperCase('a'));

	}

	public static void Test3(Person p, int age, String name, int myAge, String myName) {
		p.age = 0;
		p.name = "_";
		age = 0;
		name = "_";
		myAge = 0;
		myName = "_";
	}

	public static void Test2(Person p1, Person p2) {

		// p2 = new Person();
		int tempa = p1.age;
		p1.age = p2.age;
		p2.age = tempa;

		// p1 = new Person();
		String tempn = p1.name;
		p1.name = p2.name;
		p2.name = tempn;
	}

	public static void Test1(Person p1, Person p2) {
		Person temp = p1;
		p1 = p2;
		p2 = temp;
	}

}
