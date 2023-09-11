package exceptions;

public class Exception2Example {

	public static void main(String[] args) {
		Thread.setDefaultUncaughtExceptionHandler((thread, ex) -> System.out.println(thread.getName() + " Boom :-("));
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
