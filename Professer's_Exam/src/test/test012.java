package test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class test012 {

	public static void main(String[] args) {
	//Q12. �÷��� �����ӿ�ũ�� ArrayList ����� List��ü�� Hash����� Map��ü���� ����Ǵ� �����ͱ����� ���� �׸��� ���� �����͸� �����ϰ� ����Ͻÿ�.
		Map<String, String> pmap = new HashMap<>();
		List< Map<String, String>> rlist = new ArrayList<>();
		
		pmap.put("name", "������");
		pmap.put("Email", "psal@nav");
		pmap.put("addr", "����");
		
		rlist.add(pmap);
		pmap =null; //�޸𸮿��� ���� ���� ������� �ǹ�
		
		pmap = new HashMap<String, String>(); //�ٽ� �޸𸮿� �ø�
		
		pmap.put("name", "ȫ�浿");
		pmap.put("Email", "hong@");
		pmap.put("addr", "���");
		
		rlist.add(pmap);
		pmap=null; //����� ������ �޸𸮿��� ����22
		
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
