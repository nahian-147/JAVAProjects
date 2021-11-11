public class Circle extends Shapes{
	private double radious = 0.0;
	Circle(double radious){
		this.radious = radious;
		System.out.println("A circle of radious "+radious+" has been created.");
	}
	double getArea(){
		return 3.1415926535 * this.radious * this.radious;
	}
}
