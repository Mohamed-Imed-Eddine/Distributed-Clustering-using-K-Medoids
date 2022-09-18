import java.util.ArrayList;

public class KMedoid {

    private int k;
    private int max_iterations;
    private int max_stagnation_iterations;
    private Double stagnation_step;
    private Double[][] data;
    private int m;
    ArrayList<Integer> medoids;
    int[] labels;
    Double cost;
    int nb_iterations;



    public KMedoid(Double[][] data,int k){
        this.data = data;
        this.k = k;
        this.m = data.length;
        this.medoids = new ArrayList<Integer>();
        this.cost = 0.0;
        this.labels = new int[m];
    }


    public void initialise_medoids(){
        // Choisir K objets arbitrairement à partir de l'ensemble D pour former les centres initiaux.
        int val;
        while(this.medoids.size()<this.k){
            val = (int) (Math.random()*m);
            if(!this.medoids.contains(val)){
                this.medoids.add(val);
            }
        }

    }

    public void do_iteration(){

        int index_or,index_oj;
        boolean stop = false;
        Double new_cost = 0.0;
        int cpt = 0;     
        Double[] obj,medoid;
        Double min_distance,distance;
        int min_medoid = 0;
        
        //Assigner chaque objet au cluster auquel il est le plus similaire se basant sur la valeur de distance entre les objets.
        this.cost = 0.0;
        for(int i=0;i<m;i++){
            obj = data[i];
            min_distance = Double.POSITIVE_INFINITY;
            for(int j=0;j<k;j++){
                medoid = data[this.medoids.get(j)];
                distance = distance(obj, medoid);
                if(distance<min_distance){
                    min_medoid = j;
                    min_distance = distance;
                }
            }
            
            this.cost+=min_distance;
            this.labels[i] = min_medoid;
        }
        this.cost = this.cost / inter_clusters_distance(data, medoids);



            
        // Choisir aléatoirement un objet non représentatif (Or).
        index_or = this.medoids.get(0);
        while(this.medoids.contains(index_or)){
            index_or = (int) (Math.random()*m);
        }


            
        Double best_partial_cost;
        ArrayList<Integer> best_partial_medoids = new ArrayList<>();
        ArrayList<Integer> new_medoids;
            
        int best_oj = 0;
        best_partial_cost = Double.POSITIVE_INFINITY;
        // Essayer d'efectuer des echanges avec des objets representatif
        for(int i=0;i<k;i++){
            new_medoids = new ArrayList<>(this.medoids);
            new_medoids.set(i, index_or);
            new_cost = cost(data, new_medoids, this.labels);

            if(new_cost<best_partial_cost){
                //cpt = 0;
                best_partial_cost = new_cost;
                best_partial_medoids = new ArrayList<>(new_medoids);
                
            }

        }

        if(best_partial_cost<this.cost){
                this.medoids = new ArrayList<>(best_partial_medoids);
            this.cost = best_partial_cost;
        }

            
    }

    public Solution get_solution(){
        return new Solution(this.medoids, this.labels, this.cost);
    }

    public void update_solution(ArrayList<Integer> medoids,int[] labels){
        this.medoids = medoids;
        this.labels = labels;
    }



    public void fit(Double[][] data){

        initialise_medoids();

        this.labels = new int[m];

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
                this.labels[i] = min_medoid;
            }
            cost = cost / inter_clusters_distance(data, medoids);

            
            // Choisir aléatoirement un objet non représentatif (Or).
            index_or = medoids.get(0);
            while(medoids.contains(index_or)){
                index_or = (int) (Math.random()*m);
            }

            
            Double best_partial_cost;
            ArrayList<Integer> best_partial_medoids = new ArrayList<>();
            ArrayList<Integer> new_medoids;
            
            int best_oj = 0;
            best_partial_cost = Double.POSITIVE_INFINITY;
            // Essayer d'efectuer des echanges avec des objets representatif
            for(int i=0;i<k;i++){
                new_medoids = new ArrayList<>(medoids);
                new_medoids.set(i, index_or);
                new_cost = cost(data, new_medoids, this.labels);

                if(new_cost<best_partial_cost){
                    //cpt = 0;
                    best_partial_cost = new_cost;
                    best_partial_medoids = new ArrayList<>(new_medoids);
                    
                }

            }

            if(best_partial_cost<cost){
                cpt = 0;
                if((best_partial_cost>=(cost-stagnation_step))){
                    stop = true;
                }
                
                medoids = new ArrayList<>(best_partial_medoids);
                cost = best_partial_cost;
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
        return  intra_clusters_distante(x, medoids, labels) / inter_clusters_distance(x, medoids) ;
    }

    public static Double intra_clusters_distante(Double[][] x, ArrayList<Integer> medoids,int[] labels){
        Double val = 0.0;
        Double[] medoid,obj;
        for(int i=0;i<x.length;i++){
            obj = x[i];
            medoid = x[medoids.get(labels[i])];
            val += distance(obj, medoid);
        }
        return val;
    }

    public static Double inter_clusters_distance(Double[][] x,ArrayList<Integer> medoids){
        Double[] medoid1,medoid2;
        Double val = 0.0;
        for (int i=0;i<medoids.size();i++){
            medoid1 = x[i];
            //for(int j=i+1;i<medoids.size();j++){
            int j = 1+i;
            while(j<medoids.size()){
                medoid2 = x[j];
                val += distance(medoid1, medoid2);
                //System.out.print("k ");
                j++;
            }
        }
        //System.out.println();
        return val;
    }



}

