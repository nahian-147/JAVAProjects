import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {

    HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();

    static String ReadLn (int maxLg) {
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;
        String line = "";

        try {
            while (lg < maxLg) {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin [lg++] += car;
            }
        }
        catch (IOException e) {
            return (null);
        }

        if ((car < 0) && (lg == 0)) return (null);  // eof
        return (new String (lin, 0, lg));
    }

    public static void main (String args[]) {
        Main myWork = new Main();
        myWork.memo.put(1,1);
        myWork.Begin(myWork);            // the true entry point
    }

    int calculateLength(int n){
        if(memo.containsKey(n)){
            return memo.get(n);
        }else if(n % 2 == 0){
            memo.put(n,1+calculateLength(n/2));
        }else{
            memo.put(n,1+calculateLength(3*n+1));
        }
        return memo.get(n);
    }

    void Begin(Main ob) {
        String input;
        StringTokenizer idata;
        int a, b, min, max, cyclemax;
        while ((input = Main.ReadLn (2048)) != null)
        {
            cyclemax = 0;
            idata = new StringTokenizer (input);
            a = Integer.parseInt (idata.nextToken());
            b = Integer.parseInt (idata.nextToken());
            if (a < b) { min=a; max=b; } else { min=b; max=a; }
            for(int k = min; k <= max; k++){
                int t = ob.calculateLength(k);
                if(t > cyclemax) cyclemax = t;
            }
            System.out.println (a + " " + b + " " + cyclemax);
        }
    }
}