
public class Exam021 {
//for(;;) 무한루프와 main()함수의 return
	public static void main(String[] args) {
		int hap = 0;
		int i = 0;

		for (;;) {
			for (i = 1; i < 101; i++) {
				hap += i;

				if (hap > 2000) {
					System.out.println("합계: " + hap);
					hap = 0;
					break;
//					return; : main 함수를 종료시킴.
				}
			}
			System.out.println("아직도 반복중...");
		}
	}

}
