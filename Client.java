import java.rmi.Naming;


public class Client {
     public static void main(String[] args) {
          try{
               Interface stub = (Interface) Naming.lookup("rmi://localhost:1111/OBJ");
               
               System.out.println("Demarage du clustering...");
               Entry e = stub.get_data();
               Solution s = null;
               Boolean stop = false;
               KMedoid model = new KMedoid(e.get_data(),e.get_k());
               model.initialise_medoids();
               while(!stop){
                    System.out.println("Client stop = "+stop);
                    
                         model.do_iteration();
                    
                    stub.return_solution(model.get_solution());
                    System.out.println("dans client sol cost: "+model.get_solution().get_cost());
                    System.out.println("dans client demande best sol");
                    stop = stub.stop_algorithm();
                    if(stop){break;}
                    s = stub.get_best_solution(); 
                    System.out.println("Client a recu la meilleure sol cost: "+s.get_cost());
                    model.update_solution(s.get_medoids(),s.get_labels());
                    stop = stub.stop_algorithm();

               }
               System.out.println("Client a fini");


          }
          catch(Exception e){
               e.printStackTrace();
          }
    }
}
