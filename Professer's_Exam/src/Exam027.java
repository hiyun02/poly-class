import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Exam027 {

	public static void main(String[] args) {
		
		Map<String, String> pmap = new HashMap<>();
		List< Map<String, String>> rlist = new ArrayList<Map<String, String>>();
		
		pmap.put("name", "김하윤");
		pmap.put("email", "psal@nav");
		pmap.put("addr", "서울");
		pmap.put("dept", "데분");
		
		rlist.add(pmap);
		pmap =null; //메모리에서 값을 지워 버리라는 의미
		
		pmap = new HashMap<String, String>(); //다시 메모리에 올림
		
		pmap.put("name", "홍길동");
		pmap.put("email", "hong@");
		pmap.put("addr", "경기");
		pmap.put("dept", "시각");
		
		rlist.add(pmap);
		pmap=null; //사용이 끝나면 메모리에서 지움22
		
		Iterator<Map<String, String>> it = rlist.iterator();
		System.out.println("------------------------");
		while(it.hasNext()) {
			Map<String, String> rmap= it.next();
			System.out.println("이름 : "+ rmap.get("name"));
			System.out.println("이메일 : "+ rmap.get("email"));
			System.out.println("주소 : "+ rmap.get("addr"));
			System.out.println("학과 : "+ rmap.get("dept"));
			System.out.println("------------------------");
		}
		}

}
