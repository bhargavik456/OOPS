package exceptions;

public class Error1Example {

	public static void main(String[] args) {
		System.out.println("Start!!!");
		doTask();
		System.out.println("Bye!!!");
	}

	private static void doTask() {
		System.out.println("do task called!!!");
		//java.lang.StackOverflowError
		doTask(); // recursive without exit flow
	}

}
