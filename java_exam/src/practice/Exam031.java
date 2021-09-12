
class Car {
	String color;
	int speed;
	
	void upSpeed(int value) {
		speed+=value;
	}
	
	void downSpeed(int value) {
		speed-=value;
	}
}
public class Exam031 {

	public static void main(String[] args) {
		Car myCar1= new Car();
		myCar1.color="빨강";
		myCar1.speed=0;
		
		Car myCar2= new Car();
		myCar2.color="파랑";
		myCar2.speed=0;
		
		Car myCar3= new Car();
		myCar3.color="노랑";
		myCar3.speed=0;
		
		myCar1.upSpeed(30);
		System.out.println("1번차의 색은 "+myCar1.color+" 이며 현재 속도는 "+myCar1.speed+" km/h 입니다.");
		
		myCar2.upSpeed(60);
		System.out.println("1번차의 색은 "+myCar2.color+" 이며 현재 속도는 "+myCar2.speed+" km/h 입니다.");
		
		myCar3.upSpeed(0);
		System.out.println("1번차의 색은 "+myCar3.color+" 이며 현재 속도는 "+myCar3.speed+" km/h 입니다.");
	
		//new로 생성된 객체는 반드시 null을 저장해서 메모리에서 제거하자!
		myCar1 = null;
		myCar2 = null;
		myCar3 = null;
	}

}
