package test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class test012 {

	public static void main(String[] args) {
	//Q12. 컬렉션 프레임워크의 ArrayList 기반의 List객체에 Hash기반의 Map객체들이 저장되는 데이터구조로 다음 그림과 같은 데이터를 저장하고 출력하시오.
		Map<String, String> pmap = new HashMap<>();
		List< Map<String, String>> rlist = new ArrayList<>();
		
		pmap.put("name", "김하윤");
		pmap.put("Email", "psal@nav");
		pmap.put("addr", "서울");
		
		rlist.add(pmap);
		pmap =null; //메모리에서 값을 지워 버리라는 의미
		
		pmap = new HashMap<String, String>(); //다시 메모리에 올림
		
		pmap.put("name", "홍길동");
		pmap.put("Email", "hong@");
		pmap.put("addr", "경기");
		
		rlist.add(pmap);
		pmap=null; //사용이 끝나면 메모리에서 지움22
		
		Iterator<Map<String, String>> it = rlist.iterator();
		while(it.hasNext()) {
			Map<String, String> rmap= it.next();
			System.out.println("name : "+ rmap.get("name"));
			System.out.println("Email : "+ rmap.get("email"));
			System.out.println("addr : "+ rmap.get("addr"));
			System.out.println();
		}
		}

}
