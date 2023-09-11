package exceptions;

public class CheckedException3 {

	public static void main(String[] args) {
		try {
			Class.forName("com.visa.prj.SomeClass");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
