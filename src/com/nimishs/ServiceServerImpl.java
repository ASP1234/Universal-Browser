package com.nimishs;

import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

/**
 * Created by NMSH on 04-04-2016.
 */


public class ServiceServerImpl extends UnicastRemoteObject implements ServiceServer {

    HashMap serviceList;

    public ServiceServerImpl() throws RemoteException{
        setUpServices();
    }

    private void setUpServices()
    {
        serviceList=new HashMap();
        serviceList.put("Dice Rolling Service",new DiceService());
        serviceList.put("Day of the Week Service",new DayOfTheWeekService());
       // serviceList.put("Visual Music Service",new MiniMusicService());

    }

    public Object[] getServiceList()
    {
        System.out.println("in Remote");
        return serviceList.keySet().toArray();
    }

    public Service getService(Object serviceKey) throws RemoteException
    {
        Service theService = (Service)serviceList.get(serviceKey);
        return theService;
    }

    public static void main(String[] args)
    {
        try{
            Naming.rebind("ServiceServer",new ServiceServerImpl());

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        System.out.println("Remote Service is running");
    }



}
