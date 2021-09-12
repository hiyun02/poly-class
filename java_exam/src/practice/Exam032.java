class Car2 {
	private String color;
	private int speed;

	Car2() {
		System.out.println("난 메모리를 생성할 때 자동으로 실행되는 생성자이다.");
		this.color = "빨강";
		this.speed = 0;

		System.out.println("난 메모리 생성 끝");
	}

	public String getColor() {
		return color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}

public class Exam032 {

	public static void main(String[] args) {
		Car2 myCar1 = new Car2();
		Car2 myCar2 = new Car2();

		
		System.out.println("1차 색상 : " + myCar1.getColor() + " , 현재속도 : " + myCar1.getSpeed());
		System.out.println("2차 색상 : " + myCar1.getColor() + " , 현재속도 : " + myCar1.getSpeed());

	}

}
