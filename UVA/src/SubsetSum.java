import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubsetSum {

    HashMap<String, Boolean> memo = new HashMap<>();

    boolean ifContainsSum(List<Integer> st, int n){
        if(n==0){
            return memo.get("0");
        }else if(n==st.get(0)){
            if(!memo.containsKey(""+n+st)){
                memo.put(""+n+st,true);
            }
            return memo.get(""+n+st);
        }else if(n > 0 && st.size() == 0){
            if(!memo.containsKey(""+n+st)){
                memo.put(""+n+st,false);
            }
            return memo.get(""+n+st);
        }
        else if(st.size() > 1){
            int nn = st.get(0);
            memo.put(""+n+st,ifContainsSum(st.subList(1, st.size()),n) || ifContainsSum(st.subList(1, st.size()),n-nn));
        }else{
            if (st.get(0) == n){
                if(!memo.containsKey(""+n+st)){
                    memo.put(""+n+st,true);
                }
                return memo.get(""+n+st);
            }else{
                if(!memo.containsKey(""+n+st)){
                    memo.put(""+n+st,true);
                }
                return memo.get(""+n+st);
            }
        }
        return memo.get(""+n+st);
    }
    SubsetSum(){
        this.memo.put("0",true);
    }
    public static void main(String args[]){
        SubsetSum sm = new SubsetSum();
        ArrayList<Integer> s = new ArrayList();
        s.add(8);
        s.add(5);
        s.add(6);
        s.add(7);
        System.out.println(sm.ifContainsSum(s,9));
    }
}
