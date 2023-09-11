package exceptions;

public class Exception1Example {

	public static void main(String[] args) {
		System.out.println("First");
			doTask();
		System.out.println("Bye!!");
	}

	private static void doTask() {
		int x = 10;
		int y = 0;
		int res = x / y;
		System.out.println(res);
	}

}
