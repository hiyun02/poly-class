
public class Exam017 {

	public static void main(String[] args) {
	//다중for문을 이용한 구구단
		for (int i = 2; i < 10; i++) {
			System.out.println("[" + i + "]단");
			
			for (int k = 1; k < 10; k++) {
				System.out.println(i + "X" + k + "=" + (i * k));
			}
				
		}
	
	
	}

}
