package com.example.consumingwebservice;

import java.util.ArrayList;

public class Driver {
    public static void main(String args[]){
        Assigner assigner = new Assigner("194.24.5.198","ipv4");
        assigner.assign("reve_dredging");
        assigner.assign("le_delicia");
        assigner.assign("le_reve");
        assigner.assign("reve");
        assigner.free("reve");
        assigner.free("le_reve");
        assigner.free("reve_dredging");
        assigner.assign("reve");

//        System.out.println(assigner.getIpPool()+" "+assigner.getIpPool().size());

        ArrayList<IPAddress> ips = assigner.getAssignedIPs();
        for (IPAddress ip : ips){
            System.out.println(ip + " " + ip.getAssignedUser());
        }
    }
}
