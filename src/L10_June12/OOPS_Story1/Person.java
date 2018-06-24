package L10_June12.OOPS_Story1;

public class Person {

	String name;
	int age;
	int rollNo;

	static int noOfPerson;

	public Person() {

	}

	public Person(String name, int age) { // throws Exception {

		// if(age < 0) {
		// throw new Exception("Invalid age") ;
		// }

		noOfPerson++;
		this.rollNo = noOfPerson;
		this.name = name;
		this.age = age;
	}

	void introduceYourself() {
		System.out.println(this.name + " is " + this.age + " years old.");
	}

	void sayHi(String name) {
		System.out.println(this.name + " says hi to " + name);
	}

	static int getNoOfPerson() {
		int a;
		return noOfPerson;
	}

}
