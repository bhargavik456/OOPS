package exceptions;

public class Error2Example {

	//java.lang.UnsatisfiedLinkError: no candyCrush.dll in java.library.path
	static {
		System.loadLibrary("candyCrush.dll");
	}
	public static void main(String[] args) {
		System.out.println("Start!!!");
	}

}
