import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Exam027 {

	public static void main(String[] args) {
		
		Map<String, String> pmap = new HashMap<>();
		List< Map<String, String>> rlist = new ArrayList<Map<String, String>>();
		
		pmap.put("name", "������");
		pmap.put("email", "psal@nav");
		pmap.put("addr", "����");
		pmap.put("dept", "����");
		
		rlist.add(pmap);
		pmap =null; //�޸𸮿��� ���� ���� ������� �ǹ�
		
		pmap = new HashMap<String, String>(); //�ٽ� �޸𸮿� �ø�
		
		pmap.put("name", "ȫ�浿");
		pmap.put("email", "hong@");
		pmap.put("addr", "���");
		pmap.put("dept", "�ð�");
		
		rlist.add(pmap);
		pmap=null; //����� ������ �޸𸮿��� ����22
		
		Iterator<Map<String, String>> it = rlist.iterator();
		System.out.println("------------------------");
		while(it.hasNext()) {
			Map<String, String> rmap= it.next();
			System.out.println("�̸� : "+ rmap.get("name"));
			System.out.println("�̸��� : "+ rmap.get("email"));
			System.out.println("�ּ� : "+ rmap.get("addr"));
			System.out.println("�а� : "+ rmap.get("dept"));
			System.out.println("------------------------");
		}
		}

}
