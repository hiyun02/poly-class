package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class test011 {

	public static void main(String[] args) {
		// Q11. �÷��� �����ӿ�ũ�� ArrayList ����� List ��ü�� �����ϰ�,
		// �� List ��ü�� "��ü�������α׷���", "�ϵ�", "MongoDB"�� ���ڿ��� �����ϰ�, while�� ���� ����� �����͸� ����Ͻÿ�.
		// ù��° ��µǴ� ��ü�������α׷����� ���ڿ��� �հ� �ڿ� "<", ">"�� �ٿ��� ����Ͻÿ�.
		List<String> list = new ArrayList<>();
		list.add("��ü�������α׷���");
		list.add("�ϵ�");
		list.add("MongoDB");

		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String str = it.next();
			if (str.equals(list.get(0))) {
				System.out.println("<" + str + ">");
			} else
				System.out.println(str);
		}

		/*
		 * int i=0; while(i<list.size()) { if(i==0)
		 * System.out.println("<"+list.get(i)+">"); else
		 * System.out.println(list.get(i)); i++; }
		 */

	}
}
