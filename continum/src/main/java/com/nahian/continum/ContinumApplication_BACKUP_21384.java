package com.nahian.continum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContinumApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ContinumApplication.class, args);
	}
        
        public static void runner(String[] args){
		
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

	@Override
	public void run(String... args) {
<<<<<<< HEAD
		Logger logger = LoggerFactory.getLogger(ContinumApplication.class);

                logger.info("Continuum Application Starting...");
		logger.debug("Debugging...");
		logger.info("This is an Info...");
		logger.warn("This is a Warning...");
		logger.info("From Eclipse");
		
		double s = 0.0;
		for (int k=0;k<5;k++) {
			s += 1/java.lang.Math.pow(3, k);
		}
		logger.info("sum "+s);
		logger.info("Continuum Application Shutting Down");
	}
=======
	Logger logger = LoggerFactory.getLogger(ContinumApplication.class);

        logger.info("Continuum Application Starting...");
	logger.debug("Debugging...");
	logger.info("From Eclipse");
	logger.info("from NetBeans");
//	double s = 0.0;
//	for (int k=0;k<5;k++) {
//            s += 1/java.lang.Math.pow(3, k);
//	}
//	logger.info("sum "+s);
//	logger.info("Continuum Application Shutting Down");

        
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
                    logger.debug(""+e);
		}
        }
>>>>>>> 508e91bf4bc0c115293661ad77cc4878075c6913
}
