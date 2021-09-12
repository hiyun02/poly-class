package test;

public class Exam015 {

	public static void main(String[] args) {
		//쪽지시험 문제 : 3의 배수 표시하기
		for (int i = 1; i < 11; i++) {
			if (i % 3 == 0) {
				System.out.print("[3의 배수] ");
			}

			System.out.println(i);
		}
		
		//1부터 100까지의 수 중에서 3의 배수와 5의 배수인 숫자만 출력하시오
		for(int i=1;i<101;i++) {
			if(i%3==0&&i%5==0) { //15의 배수를 찾아도 무방하다
				System.out.print(i+" ");
			}
		}
	}

}
