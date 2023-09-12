import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListExample {

	public static void main(String[] args) {
		List<String> list = new CopyOnWriteArrayList<>();
		list.add("A");
		list.add("B");
		
		Iterator<String> iter = list.iterator();
		
		list.add("C");
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		for(String s : list) {
			System.out.println(s);
		}
	}

}
