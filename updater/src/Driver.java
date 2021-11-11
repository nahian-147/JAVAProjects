import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class Driver{

	public static void runner(String[] args){
		Logger logger = Logger.getLogger(Driver.class.getName());
		Random rand = new Random();
		Dispatcher d = new Dispatcher();
		int k=0;
		if(args.length > 0){
			k = Integer.parseInt(args[0]);
		}
		HashMap<String,ArrayList<Shapes>> shapesHashMap = new HashMap<>();
		shapesHashMap.put("Circle",new ArrayList<>());
		shapesHashMap.put("Triangle",new ArrayList<>());
		shapesHashMap.put("Square",new ArrayList<>());
		while(true){
			if(args.length > 0){
				if(k <= 0) break;
				k--;
			}
			Shapes s = d.dispatch(rand.nextInt(3)+1,(double)(1+rand.nextInt(100))/10);
			if(s.getClass().getName().equals("Circle")) shapesHashMap.get("Circle").add(s);
			if(s.getClass().getName().equals("Triangle")) shapesHashMap.get("Triangle").add(s);
			if(s.getClass().getName().equals("Square")) shapesHashMap.get("Square").add(s);
			System.out.println(s.getArea());
		}
	}
	public static void main(String args[]){

		Logger logger = Logger.getLogger(Driver.class.getName());
		try {
			KServer k = new KServer();
			k.startServer();
			while (true){
				String[] i = k.getInput();
				if (i.length > 0 && i != null ){
					if (i[0].equalsIgnoreCase("shutdown")){
						k.shutDownServer();
						break;
					}else if (i[0].length() != 0)
						runner(i);
				}
			}
			logger.debug("...END...");
		} catch (IOException e) {
			logger.fatal(e);
		}
	}
}
