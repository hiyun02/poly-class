

public class Exam03 {

	public static void main(String[] args) {
		char a, b, c, d, e;
		
		a = 'A'; // 65
		
		System.out.println("a : " + a + " | a의 숫자값 : " + (int) a);

		b = 'a'; // 97
		c = (char) (b + 1); // 97+1

		System.out.println("b : " + b + " | b의 숫자값 : " + (int) b);
		System.out.println("c : " + c + " | c의 숫자값 : " + (int) c);

		d = '가'; // 44032
		e = (char) (d + 1); // 44032+1
		System.out.println("d : " + d + " | d의 숫자값 : " + (int) d);
		System.out.println("e : " + e + " | e의 숫자값 : " + (int) e);

	}

}
