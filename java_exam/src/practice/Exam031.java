
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
		myCar1.color="����";
		myCar1.speed=0;
		
		Car myCar2= new Car();
		myCar2.color="�Ķ�";
		myCar2.speed=0;
		
		Car myCar3= new Car();
		myCar3.color="���";
		myCar3.speed=0;
		
		myCar1.upSpeed(30);
		System.out.println("1������ ���� "+myCar1.color+" �̸� ���� �ӵ��� "+myCar1.speed+" km/h �Դϴ�.");
		
		myCar2.upSpeed(60);
		System.out.println("1������ ���� "+myCar2.color+" �̸� ���� �ӵ��� "+myCar2.speed+" km/h �Դϴ�.");
		
		myCar3.upSpeed(0);
		System.out.println("1������ ���� "+myCar3.color+" �̸� ���� �ӵ��� "+myCar3.speed+" km/h �Դϴ�.");
	
		//new�� ������ ��ü�� �ݵ�� null�� �����ؼ� �޸𸮿��� ��������!
		myCar1 = null;
		myCar2 = null;
		myCar3 = null;
	}

}
