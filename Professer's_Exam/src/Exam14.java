
public class Exam14 {

	static int bbbb = 0; // 클래스 전체에서 사용되는 변수 (전역변수)

	public static void main(String[] args) {

		int hap = 0; // main 함수가 실행되는 동안만 살아있는 변수. for문이 종료되기까지 값을 유지하기 위해 여기에 선언
		

		for (int i = 1; i <= 10; i++) {
			int b = 0; // for문이 한 번씩 도는 동안 살아있는 변수
			hap += i;
		}
		System.out.println("1부터 10까지의 합 : " + hap);
		System.out.println(bbbb);
	}

}
