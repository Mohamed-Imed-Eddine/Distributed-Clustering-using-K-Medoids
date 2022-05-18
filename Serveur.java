import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.rmi.Naming;
import java.util.*;
// import java.rmi.RMISecurityManager;

public class Serveur  {
    public static void main(String[] args){
        try{
            int port = 1126;
            LocateRegistry.createRegistry(port);
            InterfaceIMP obj = new InterfaceIMP(); 
            Naming.rebind("rmi://localhost:"+Integer.toString(port)+"/OBJ",obj);
            System.out.println("Demarage du serveur :\n\t\tAppuez sur 0 pour Quitter");


     
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}