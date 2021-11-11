public class Triangle extends Shapes{
	private double side = 0.0;
	Triangle(double side){
		this.side = side;
		System.out.println("A triangle of side length "+side+" has been created.");
	}
	double getArea(){
		return 0.4330127018922193 * this.side * this.side;
	}
}
