import java.util.LinkedList;
import java.util.List;

public class Exam025 {

	public static void main(String[] args) {
		
		List<String> rlist = new LinkedList<>();
		
		rlist.add("������");
		rlist.add("�ֱ���");
		rlist.add("�ǿ�����");
		rlist.add("��������");
		
		System.out.println("rlist�� ũ�� : "+ rlist.size());
		
		for(int i=0; i< rlist.size(); i++) {
			System.out.println("["+i+"]��° rlist ������ : "+ rlist.get(i));
		}
	}

}
