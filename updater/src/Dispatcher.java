public class Dispatcher{
	Dispatcher(){
		System.out.println("A New Dispatcher.");
	}
	public Shapes dispatch(int n,double l){
		if(n==1){
			return new Circle(l);
		}else if(n==2){
			return new Square(l);
		}else if(n==3){
			return new Triangle(l);
		}else{
			return new Shapes();
		}
	}

}
