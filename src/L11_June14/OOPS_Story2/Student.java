package L11_June14.OOPS_Story2;

public class Student {

	String name;
	int age;

	public void setAge(int age) throws Exception {

		if (age < 0) {
			throw new Exception("Invalid age");
		}

		this.age = age;
	}

	public void setName(String name) throws NullPointerException {

		if (name == null) {
			throw new NullPointerException("Invalid name");
		}

		this.name = name;
	}

	public void sayHi(String name) {
		System.out.println(this.name + " says hi to " + name);
	}
}
