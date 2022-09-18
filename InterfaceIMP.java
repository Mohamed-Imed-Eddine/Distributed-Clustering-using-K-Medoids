import java.util.*;
import java.util.concurrent.Semaphore;
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject;
import java.io.*;


public class InterfaceIMP  extends UnicastRemoteObject implements Interface,Serializable {

    protected  InterfaceIMP() throws RemoteException{
        super();
    }
    int k;
    int max_iterations;
    Double stagnation_step;
    int max_stagnation_iterations;
    Double[][] data;
    int num_iteration = 0;

    int nb_results;
    int nb_centers = 0;
    int nb_served_centers = 0;
    Solution best_solution = null;
    boolean stop = false;
    
    
    ArrayList<Solution> solutions = new ArrayList<Solution>();
    Comparator<Solution> compare_by_cost = (Solution o1, Solution o2) -> o1.get_cost().compareTo(o2.get_cost());


    public int get_nb_results()throws RemoteException {
        return this.nb_results;}

    public Entry get_data()throws RemoteException {
        return new Entry(this.data, this.k);
    }

    public void prepare_data(int choice_data_set,int nb_iteration) throws RemoteException{
        if(choice_data_set==1){
            this.data = new Double[][] {{5.1,3.5,1.4,0.2},{4.9,3.0,1.4,0.2},{4.7,3.2,1.3,0.2},{4.6,3.1,1.5,0.2},{5.0,3.6,1.4,0.2},{5.4,3.9,1.7,0.4},{4.6,3.4,1.4,0.3},{5.0,3.4,1.5,0.2},{4.4,2.9,1.4,0.2},{4.9,3.1,1.5,0.1},{5.4,3.7,1.5,0.2},{4.8,3.4,1.6,0.2},{4.8,3.0,1.4,0.1},{4.3,3.0,1.1,0.1},{5.8,4.0,1.2,0.2},{5.7,4.4,1.5,0.4},{5.4,3.9,1.3,0.4},{5.1,3.5,1.4,0.3},{5.7,3.8,1.7,0.3},{5.1,3.8,1.5,0.3},{5.4,3.4,1.7,0.2},{5.1,3.7,1.5,0.4},{4.6,3.6,1.0,0.2},{5.1,3.3,1.7,0.5},{4.8,3.4,1.9,0.2},{5.0,3.0,1.6,0.2},{5.0,3.4,1.6,0.4},{5.2,3.5,1.5,0.2},{5.2,3.4,1.4,0.2},{4.7,3.2,1.6,0.2},{4.8,3.1,1.6,0.2},{5.4,3.4,1.5,0.4},{5.2,4.1,1.5,0.1},{5.5,4.2,1.4,0.2},{4.9,3.1,1.5,0.1},{5.0,3.2,1.2,0.2},{5.5,3.5,1.3,0.2},{4.9,3.1,1.5,0.1},{4.4,3.0,1.3,0.2},{5.1,3.4,1.5,0.2},{5.0,3.5,1.3,0.3},{4.5,2.3,1.3,0.3},{4.4,3.2,1.3,0.2},{5.0,3.5,1.6,0.6},{5.1,3.8,1.9,0.4},{4.8,3.0,1.4,0.3},{5.1,3.8,1.6,0.2},{4.6,3.2,1.4,0.2},{5.3,3.7,1.5,0.2},{5.0,3.3,1.4,0.2},{7.0,3.2,4.7,1.4},{6.4,3.2,4.5,1.5},{6.9,3.1,4.9,1.5},{5.5,2.3,4.0,1.3},{6.5,2.8,4.6,1.5},{5.7,2.8,4.5,1.3},{6.3,3.3,4.7,1.6},{4.9,2.4,3.3,1.0},{6.6,2.9,4.6,1.3},{5.2,2.7,3.9,1.4},{5.0,2.0,3.5,1.0},{5.9,3.0,4.2,1.5},{6.0,2.2,4.0,1.0},{6.1,2.9,4.7,1.4},{5.6,2.9,3.6,1.3},{6.7,3.1,4.4,1.4},{5.6,3.0,4.5,1.5},{5.8,2.7,4.1,1.0},{6.2,2.2,4.5,1.5},{5.6,2.5,3.9,1.1},{5.9,3.2,4.8,1.8},{6.1,2.8,4.0,1.3},{6.3,2.5,4.9,1.5},{6.1,2.8,4.7,1.2},{6.4,2.9,4.3,1.3},{6.6,3.0,4.4,1.4},{6.8,2.8,4.8,1.4},{6.7,3.0,5.0,1.7},{6.0,2.9,4.5,1.5},{5.7,2.6,3.5,1.0},{5.5,2.4,3.8,1.1},{5.5,2.4,3.7,1.0},{5.8,2.7,3.9,1.2},{6.0,2.7,5.1,1.6},{5.4,3.0,4.5,1.5},{6.0,3.4,4.5,1.6},{6.7,3.1,4.7,1.5},{6.3,2.3,4.4,1.3},{5.6,3.0,4.1,1.3},{5.5,2.5,4.0,1.3},{5.5,2.6,4.4,1.2},{6.1,3.0,4.6,1.4},{5.8,2.6,4.0,1.2},{5.0,2.3,3.3,1.0},{5.6,2.7,4.2,1.3},{5.7,3.0,4.2,1.2},{5.7,2.9,4.2,1.3},{6.2,2.9,4.3,1.3},{5.1,2.5,3.0,1.1},{5.7,2.8,4.1,1.3},{6.3,3.3,6.0,2.5},{5.8,2.7,5.1,1.9},{7.1,3.0,5.9,2.1},{6.3,2.9,5.6,1.8},{6.5,3.0,5.8,2.2},{7.6,3.0,6.6,2.1},{4.9,2.5,4.5,1.7},{7.3,2.9,6.3,1.8},{6.7,2.5,5.8,1.8},{7.2,3.6,6.1,2.5},{6.5,3.2,5.1,2.0},{6.4,2.7,5.3,1.9},{6.8,3.0,5.5,2.1},{5.7,2.5,5.0,2.0},{5.8,2.8,5.1,2.4},{6.4,3.2,5.3,2.3},{6.5,3.0,5.5,1.8},{7.7,3.8,6.7,2.2},{7.7,2.6,6.9,2.3},{6.0,2.2,5.0,1.5},{6.9,3.2,5.7,2.3},{5.6,2.8,4.9,2.0},{7.7,2.8,6.7,2.0},{6.3,2.7,4.9,1.8},{6.7,3.3,5.7,2.1},{7.2,3.2,6.0,1.8},{6.2,2.8,4.8,1.8},{6.1,3.0,4.9,1.8},{6.4,2.8,5.6,2.1},{7.2,3.0,5.8,1.6},{7.4,2.8,6.1,1.9},{7.9,3.8,6.4,2.0},{6.4,2.8,5.6,2.2},{6.3,2.8,5.1,1.5},{6.1,2.6,5.6,1.4},{7.7,3.0,6.1,2.3},{6.3,3.4,5.6,2.4},{6.4,3.1,5.5,1.8},{6.0,3.0,4.8,1.8},{6.9,3.1,5.4,2.1},{6.7,3.1,5.6,2.4},{6.9,3.1,5.1,2.3},{5.8,2.7,5.1,1.9},{6.8,3.2,5.9,2.3},{6.7,3.3,5.7,2.5},{6.7,3.0,5.2,2.3},{6.3,2.5,5.0,1.9},{6.5,3.0,5.2,2.0},{6.2,3.4,5.4,2.3},{5.9,3.0,5.1,1.8}};
            this.k = 3;
        }
        else{
            Double temp_data[][] = new Double[165474][12];
        
            try{
                BufferedReader br = new BufferedReader(new FileReader("data_iriad.csv"));
                String line;
                int cpt = 0;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(";");
                    Double ligne[] = new Double[12];
                    String val;
                    for(int i=0;i<12;i++){
                        val = values[i];
                        ligne[i] = Double.parseDouble(val);
    
                    }
                    temp_data[cpt] = ligne;
                    cpt++;
                }
            }
    
    
            catch(Exception e){
                e.printStackTrace();
            }

            this.data = temp_data;
            this.k = 10;

        }

        this.max_iterations = nb_iteration;
        this.stagnation_step = Math.pow(10, -1);
        this.max_stagnation_iterations = 50;
    }

    public void set_nb_centers(int val)throws RemoteException {
        this.nb_centers = val;
    }

    public void return_solution(Solution s) throws RemoteException{
        this.solutions.add(s);  
    }

    public Solution get_best_solution() throws RemoteException{
        
        while(true){
            //System.out.println("2");
            System.out.println("nb sol: "+this.solutions.size());
            if(this.solutions.size()>=this.nb_centers){
                System.out.println("the "+this.nb_centers+" clients have finished one iteration");
                if(this.nb_served_centers==0){
                    Double min_cost = Double.POSITIVE_INFINITY;
                    Solution best_sol = new Solution();
                    for(Solution s:this.solutions){
                        System.out.println("compare: "+s.get_cost());
                        if(s.get_cost().compareTo(min_cost)<0){
                            min_cost = s.get_cost();
                            best_sol = s;
                        }

                    }
                    best_sol = new Solution(best_sol.get_medoids(), best_sol.get_labels(), best_sol.get_cost());
                    this.best_solution = best_sol;

                }
                this.nb_served_centers++;
                if(this.nb_served_centers==nb_centers){
                    System.out.println("All served ! ");
                    this.solutions = new ArrayList<Solution>();
                    this.nb_served_centers = 0;
                }
                return this.best_solution;
                
            }
        }

    }
    

    public boolean stop_algorithm() throws RemoteException{
        this.num_iteration++;
        if(num_iteration>max_iterations*nb_centers*2){
            this.stop = true;
        }
        return this.stop;
    }


    public boolean get_stop() throws RemoteException{
        //System.out.println("4");
        return this.stop;
    }

    public Solution get_final_solution() throws RemoteException{
        if(!this.stop){System.out.println("********************************************************************************************************************************************************************************************************************************************************Alerte the algorithm did\'t finish yet !!!");}
        return this.best_solution;
    }

    public int get_nb_iterations()  throws RemoteException{
        return this.num_iteration;
    }

}

