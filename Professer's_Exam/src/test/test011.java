package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class test011 {

	public static void main(String[] args) {
		// Q11. 컬렉션 프레임워크의 ArrayList 기반의 List 객체를 생성하고,
		// 그 List 객체에 "객체지향프로그래밍", "하둡", "MongoDB"의 문자열을 저장하고, while을 통해 저장된 데이터를 출력하시오.
		// 첫번째 출력되는 객체지향프로그래밍은 문자열의 앞과 뒤에 "<", ">"를 붙여서 출력하시오.
		List<String> list = new ArrayList<>();
		list.add("객체지향프로그래밍");
		list.add("하둡");
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
