import java.util.ArrayList;

public class KMedoid {

    private int k;
    private int max_iterations;
    private int max_stagnation_iterations;
    private Double stagnation_step;
    private Double[][] data;
    private int m;
    //private int n;
    ArrayList<Integer> medoids;
    int[] labels;
    Double cost;
    int nb_iterations;

    public KMedoid(int k,int max_iterations,Double stagnation_step,int max_stagnation_iterations){
        //this.data = data;
        this.k = k;
        this.max_iterations = max_iterations;
        this.stagnation_step = stagnation_step;  
        this.max_stagnation_iterations = max_stagnation_iterations;  
        //this.n = data[0].length;
        medoids = new ArrayList<Integer>();
        cost = 0.0;
        nb_iterations = 0;
        
    }




    public void fit(Double[][] data){
        this.data = data;
        this.m = data.length;
        labels = new int[m];

        // Choisir K objets arbitrairement à partir de l'ensemble D pour former les centres initiaux.
        int val;
        while(medoids.size()<k){
            val = (int) (Math.random()*m);
            if(!medoids.contains(val)){
                medoids.add(val);
            }
        }
        //Double[] or,oj;
        int index_or,index_oj;
        
        boolean stop = false;
        // cost = 0.0;
        Double new_cost = 0.0;
        int cpt = 0;     
        Double[] obj,medoid;
        Double min_distance,distance;
        int min_medoid;
  
        while((!stop)&&(nb_iterations<max_iterations)){
            //Assigner chaque objet au cluster auquel il est le plus similaire se basant sur la valeur de distance entre les objets.
            min_medoid=0;
            cost = 0.0;
            for(int i=0;i<m;i++){
                obj = data[i];
                min_distance = Double.POSITIVE_INFINITY;
                for(int j=0;j<k;j++){
                    medoid = data[medoids.get(j)];
                    distance = distance(obj, medoid);
                    if(distance<min_distance){
                        min_medoid = j;
                        min_distance = distance;
                    }
                }
                
                cost+=min_distance;
                labels[i] = min_medoid;
            }

            //System.out.println("medoids"+medoids);
            //System.out.println("cost1:"+String.format("%.2f", cost));
            //System.out.println("cost2:"+String.format("%.2f", cost(data,medoids,labels)));
            // Choisir aléatoirement un objet non représentatif (Or).
            index_or = medoids.get(0);
            while(medoids.contains(index_or)){
                index_or = (int) (Math.random()*m);
            }
            index_oj = medoids.get(labels[index_or]);
            //System.out.println("or:"+index_or+" oj:"+index_oj);
            ArrayList<Integer> new_medoids = new ArrayList<>(medoids);
            new_medoids.set(labels[index_or], index_or);
            //System.out.println("new"+new_medoids);
            //  Calculer le coût total "S" des échanges d'objets représentatifs (oj) avec (Or)
            new_cost = cost(data, new_medoids, labels);
            //System.out.println("new cost"+String.format("%.2f", new_cost));
            if(new_cost<cost){
                cpt = 0;
                if((new_cost>=(cost-stagnation_step))){
                    stop = true;
                }
                
                //System.out.println("UPDATE : cost: "+String.format("%.2f",cost)+"\tnew cost: "+String.format("%.2f",new_cost));
                medoids = new ArrayList<>(new_medoids);
                cost = new_cost;
            }
            else{
                cpt++;
                if(cpt>max_stagnation_iterations){
                    stop = true;
                }
            }                   
            nb_iterations++;

        }


    }

    public ArrayList<Integer> get_medoids(){return this.medoids;}
    public int[] get_labels(){return this.labels;}
    public Double get_cost(){return this.cost;}
    public int get_nb_iterations(){return this.nb_iterations;}

    
    private static Double distance(Double[] x1,Double[] x2){
        Double val = 0.0;
        for(int i=0;i<x1.length;i++){
            val+=Math.abs(x1[i]-x2[i]);
        }
        return val;
    }

    public static Double cost(Double[][] x, ArrayList<Integer> medoids,int[] labels){
        Double val = 0.0;
        Double[] medoid,obj;
        for(int i=0;i<x.length;i++){
            obj = x[i];
            medoid = x[medoids.get(labels[i])];
            val += distance(obj, medoid);
        }
        return val;
    }



}

