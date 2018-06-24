package L11_June14.OOPS_Story2;

public class StudentClient {

	public static void main(String[] args) {
		Student s = new Student();
		s.name = "Rohit";

		try {
			System.out.println("hii");
			s.setName(null);
			Student s1 =  s;
			s.setAge(-10);

			System.out.println("bye");
		} catch (NullPointerException e) {
			System.out.println("in null catch");
			return;
		}
		catch (Exception e) {
			System.out.println("in parent catch");
			return;
		} finally {
			System.out.println("in finally");
			// return ;
		}

		// s.sayHi("Mohit");
		System.out.println("after catch");
	}

}
