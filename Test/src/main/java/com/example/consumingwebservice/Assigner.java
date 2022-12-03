package com.example.consumingwebservice;

import java.util.ArrayList;
import java.util.HashMap;

public class Assigner {
    private HashMap<String,IPAddress> ipPool = null;

    public HashMap<String, IPAddress> getIpPool() {
        return ipPool;
    }

    public void setIpPool(HashMap<String, IPAddress> ipPool) {
        this.ipPool = ipPool;
    }

    public Assigner(String ip,String ipv){
        this.ipPool = new HashMap<>();
        genPool(ip,ipv);
    }
    private void genPool(String ip, String ipv){
        String[] IP = ip.split("\\.");
        System.out.println("IP LIST "+IP);
        int begin = new Integer(IP[IP.length-1]);
        if (ipv.equals("ipv4")){
            for (int k=begin;k<255;k++){
                String kIP = ip.substring(0,ip.length()-IP[IP.length -1].length()) + k;
                IPAddress newIP = new IPAddress(kIP,k);
                this.ipPool.put(k+"",newIP);
            }
        }
    }
    public void assign(String user){
        IPAddress ip = null;
        for(String i : this.ipPool.keySet()){
            try {
                int n = Integer.parseInt(i);
                ip = this.ipPool.get(i);
                ip.setAssignedUser(user);
                ip.setAvailable(false);
                this.ipPool.put(user,ip);
                System.out.println("A User has been assigned to IP: "+ip);
                this.ipPool.remove(i);
                break;
            }catch (Exception e){
                continue;
            }
        }
    }
    public void free(String user){
        IPAddress ip = this.ipPool.get(user);
        ip.setAssignedUser(ip.n+"");
        ip.setAvailable(true);
        this.ipPool.remove(user);
        System.out.println("IP: "+ip+" has been freed.");
        this.ipPool.put(ip.n+"",ip);
    }
    public ArrayList<IPAddress> getAssignedIPs(){
        ArrayList<IPAddress> ips = new ArrayList<>();
        for (String k : this.ipPool.keySet()){
            if(!this.ipPool.get(k).isAvailable()){
                ips.add(this.ipPool.get(k));
            }
        }
        return ips;
    }
}
