import java.util.LinkedList;
import java.util.List;

public class Exam025 {

	public static void main(String[] args) {
		
		List<String> rlist = new LinkedList<>();
		
		rlist.add("김하윤");
		rlist.add("최규인");
		rlist.add("건웅이형");
		rlist.add("동협이형");
		
		System.out.println("rlist의 크기 : "+ rlist.size());
		
		for(int i=0; i< rlist.size(); i++) {
			System.out.println("["+i+"]번째 rlist 기억공간 : "+ rlist.get(i));
		}
	}

}
