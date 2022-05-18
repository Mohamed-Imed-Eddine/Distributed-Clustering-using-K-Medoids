import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject;
import java.rmi.Naming;
import java.util.*;

public class Client {
     public static void main(String[] args) {
          try{
               Interface stub = (Interface) Naming.lookup("rmi://localhost:1126/OBJ");
               
                

          }
          catch(Exception e){
               e.printStackTrace();
          }
    }
}
