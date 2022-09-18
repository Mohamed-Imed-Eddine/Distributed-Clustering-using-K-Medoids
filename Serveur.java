import java.rmi.registry.LocateRegistry; 
import java.rmi.Naming;
import java.util.*;



public class Serveur  {
    public static void main(String[] args){
        try{
            Scanner scan = new Scanner(System.in);
            int port = 1111;
            int nb_centers = 0;
            LocateRegistry.createRegistry(port);
            InterfaceIMP obj = new InterfaceIMP(); 
            Naming.rebind("rmi://localhost:"+Integer.toString(port)+"/OBJ",obj);
            System.out.println("Demarage du serveur :");
            
            
            //menu .... choix des param 
            int k = 3;
            int max_iterations = 200;
            Double stagnation_step = Math.pow(10, -1);
            int max_stagnation_iterations = 50;
            System.out.println("Quel data-set voullez-vous choisir?\n1-Iris\t2-e-shop clothing 2008");
            int choice_data_set = scan.nextInt();
            System.out.println("Donnez le nombre d\'terations");
            int nb_iteration = scan.nextInt();

            obj.prepare_data(choice_data_set,nb_iteration);
            System.out.println("Les donnees ont ete preparees");

            System.out.println("Donnez le nombre de centres (clients) que vous allez creer:");
            nb_centers = scan.nextInt();
            obj.set_nb_centers(nb_centers);
            System.out.println("Maintenant vous pouvez lancer les clients.");
            //while(obj.get_nb_results()<nb_centers){}
            System.out.println("Server i'm here------------------------------------");
            boolean stop;

            System.out.println("Saisissez 0 pour quitter l\'application");
            int val = -1;
            while(true){
                val = scan.nextInt();
                if(val==0){
                    Solution final_solution = obj.get_final_solution();
                    System.out.println("Le cout de la solution trouvee: "+final_solution.get_cost());
                    System.out.println("Merci !");
                    System.exit(0);
                }
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}