import java.text.DecimalFormat;
import java.util.ArrayList;


public class Test{

    /*public static Double distance(Double[] x1,Double[] x2){
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
    }*/
    // private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        
        
        Double[][] data = {{6.1,3.0,4.6,1.4},{4.4,3.0,1.3,0.2},{5.6,2.5,3.9,1.1},{6.4,3.2,5.3,2.3},{6.2,2.2,4.5,1.5},{6.4,2.8,5.6,2.2},{4.6,3.4,1.4,0.3},{6.3,2.9,5.6,1.8},{5.9,3.2,4.8,1.8},{6.7,3.3,5.7,2.1},{6.7,2.5,5.8,1.8},{6.2,2.9,4.3,1.3},{5.8,4.0,1.2,0.2},{5.2,2.7,3.9,1.4},{5.0,3.4,1.6,0.4},{6.3,3.4,5.6,2.4},{5.7,3.0,4.2,1.2},{5.6,2.7,4.2,1.3},{6.6,2.9,4.6,1.3},{6.3,3.3,6.0,2.5},{5.6,3.0,4.5,1.5},{5.5,2.4,3.7,1.0},{6.2,3.4,5.4,2.3},{5.1,3.5,1.4,0.2},{5.1,3.3,1.7,0.5},{6.3,2.5,5.0,1.9},{6.3,2.8,5.1,1.5},{4.9,3.1,1.5,0.1},{6.4,2.7,5.3,1.9},{5.6,2.9,3.6,1.3},{6.7,3.0,5.0,1.7},{7.7,3.8,6.7,2.2},{6.7,3.3,5.7,2.5},{7.3,2.9,6.3,1.8},{6.2,2.8,4.8,1.8},{4.9,3.1,1.5,0.1},{5.3,3.7,1.5,0.2},{5.6,2.8,4.9,2.0},{5.4,3.7,1.5,0.2},{6.4,2.8,5.6,2.1},{5.7,2.6,3.5,1.0},{6.8,3.2,5.9,2.3},{6.4,3.2,4.5,1.5},{6.0,3.4,4.5,1.6},{5.8,2.8,5.1,2.4},{5.0,3.4,1.5,0.2},{6.3,3.3,4.7,1.6},{6.9,3.1,5.1,2.3},{5.0,3.0,1.6,0.2},{6.1,2.8,4.0,1.3},{5.1,3.8,1.6,0.2},{4.6,3.1,1.5,0.2},{5.0,2.0,3.5,1.0},{5.5,2.3,4.0,1.3},{6.4,3.1,5.5,1.8},{5.4,3.9,1.3,0.4},{6.0,2.9,4.5,1.5},{4.3,3.0,1.1,0.1},{6.5,2.8,4.6,1.5},{5.0,3.2,1.2,0.2},{6.8,3.0,5.5,2.1},{6.3,2.5,4.9,1.5},{6.5,3.0,5.8,2.2},{5.1,3.8,1.5,0.3},{7.2,3.2,6.0,1.8},{6.0,3.0,4.8,1.8},{5.2,4.1,1.5,0.1},{4.6,3.6,1.0,0.2},{5.2,3.4,1.4,0.2},{6.8,2.8,4.8,1.4},{5.1,3.7,1.5,0.4},{5.0,3.5,1.6,0.6},{6.0,2.2,4.0,1.0},{4.6,3.2,1.4,0.2},{5.4,3.9,1.7,0.4},{7.2,3.0,5.8,1.6},{5.9,3.0,4.2,1.5},{5.7,2.9,4.2,1.3},{5.7,3.8,1.7,0.3},{6.0,2.2,5.0,1.5},{5.5,4.2,1.4,0.2},{4.8,3.4,1.6,0.2},{6.7,3.1,5.6,2.4},{4.9,2.5,4.5,1.7},{7.4,2.8,6.1,1.9},{5.4,3.0,4.5,1.5},{6.9,3.2,5.7,2.3},{4.7,3.2,1.3,0.2},{7.7,2.8,6.7,2.0},{4.8,3.4,1.9,0.2},{5.7,2.8,4.5,1.3},{5.1,3.8,1.9,0.4},{6.7,3.1,4.7,1.5},{4.5,2.3,1.3,0.3},{6.1,3.0,4.9,1.8},{5.1,3.5,1.4,0.3},{5.8,2.7,3.9,1.2},{5.5,2.5,4.0,1.3},{4.9,2.4,3.3,1.0},{5.0,2.3,3.3,1.0}};
        /*int m = data.length;
        int n = data[0].length;
        int k = 3;
        ArrayList<Integer> medoids = new ArrayList<Integer>();
        int[] labels = new int[m];
        // Choisir K objets arbitrairement à partir de l'ensemble D pour former les centres initiaux.
        while(medoids.size()<k){
            int val = (int) (Math.random()*m);
            if(!medoids.contains(val)){
                medoids.add(val);
            }
        }
        System.out.println("initial"+medoids);
        Double[] or,oj;
        int index_or,index_oj;
        boolean stop = false;
        // Debut de l'algo
        Double cost = 0.0;
        Double new_cost = 0.0;
        int num_iteration = 0;
        int max_iterations = 100;
        int max_stagnation_iterations = 30;
        int cpt = 0;
        while((!stop)&&(num_iteration<max_iterations)){
            //Assigner chaque objet au cluster auquel il est le plus similaire se basant sur la valeur de distance entre les objets.
            Double[] obj,medoid;
            Double min_distance,distance;
            int min_medoid=0;
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
                if((new_cost>=(cost-0.1))){
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
            num_iteration++;

        }
        System.out.println("Fin num iteration:"+num_iteration+"\tmax iteration:"+max_iterations+" cost:"+String.format("%.2f",cost));        
        // System.out.println("f="+(2<Math.pow(10, -9)));

        for(int i=0;i<m;i++){
            if(labels[i]==0){
                //System.out.println(i+1);
            }
        }*/
        Double[][] all_data = {{5.1,3.5,1.4,0.2},{4.9,3.0,1.4,0.2},{4.7,3.2,1.3,0.2},{4.6,3.1,1.5,0.2},{5.0,3.6,1.4,0.2},{5.4,3.9,1.7,0.4},{4.6,3.4,1.4,0.3},{5.0,3.4,1.5,0.2},{4.4,2.9,1.4,0.2},{4.9,3.1,1.5,0.1},{5.4,3.7,1.5,0.2},{4.8,3.4,1.6,0.2},{4.8,3.0,1.4,0.1},{4.3,3.0,1.1,0.1},{5.8,4.0,1.2,0.2},{5.7,4.4,1.5,0.4},{5.4,3.9,1.3,0.4},{5.1,3.5,1.4,0.3},{5.7,3.8,1.7,0.3},{5.1,3.8,1.5,0.3},{5.4,3.4,1.7,0.2},{5.1,3.7,1.5,0.4},{4.6,3.6,1.0,0.2},{5.1,3.3,1.7,0.5},{4.8,3.4,1.9,0.2},{5.0,3.0,1.6,0.2},{5.0,3.4,1.6,0.4},{5.2,3.5,1.5,0.2},{5.2,3.4,1.4,0.2},{4.7,3.2,1.6,0.2},{4.8,3.1,1.6,0.2},{5.4,3.4,1.5,0.4},{5.2,4.1,1.5,0.1},{5.5,4.2,1.4,0.2},{4.9,3.1,1.5,0.1},{5.0,3.2,1.2,0.2},{5.5,3.5,1.3,0.2},{4.9,3.1,1.5,0.1},{4.4,3.0,1.3,0.2},{5.1,3.4,1.5,0.2},{5.0,3.5,1.3,0.3},{4.5,2.3,1.3,0.3},{4.4,3.2,1.3,0.2},{5.0,3.5,1.6,0.6},{5.1,3.8,1.9,0.4},{4.8,3.0,1.4,0.3},{5.1,3.8,1.6,0.2},{4.6,3.2,1.4,0.2},{5.3,3.7,1.5,0.2},{5.0,3.3,1.4,0.2},{7.0,3.2,4.7,1.4},{6.4,3.2,4.5,1.5},{6.9,3.1,4.9,1.5},{5.5,2.3,4.0,1.3},{6.5,2.8,4.6,1.5},{5.7,2.8,4.5,1.3},{6.3,3.3,4.7,1.6},{4.9,2.4,3.3,1.0},{6.6,2.9,4.6,1.3},{5.2,2.7,3.9,1.4},{5.0,2.0,3.5,1.0},{5.9,3.0,4.2,1.5},{6.0,2.2,4.0,1.0},{6.1,2.9,4.7,1.4},{5.6,2.9,3.6,1.3},{6.7,3.1,4.4,1.4},{5.6,3.0,4.5,1.5},{5.8,2.7,4.1,1.0},{6.2,2.2,4.5,1.5},{5.6,2.5,3.9,1.1},{5.9,3.2,4.8,1.8},{6.1,2.8,4.0,1.3},{6.3,2.5,4.9,1.5},{6.1,2.8,4.7,1.2},{6.4,2.9,4.3,1.3},{6.6,3.0,4.4,1.4},{6.8,2.8,4.8,1.4},{6.7,3.0,5.0,1.7},{6.0,2.9,4.5,1.5},{5.7,2.6,3.5,1.0},{5.5,2.4,3.8,1.1},{5.5,2.4,3.7,1.0},{5.8,2.7,3.9,1.2},{6.0,2.7,5.1,1.6},{5.4,3.0,4.5,1.5},{6.0,3.4,4.5,1.6},{6.7,3.1,4.7,1.5},{6.3,2.3,4.4,1.3},{5.6,3.0,4.1,1.3},{5.5,2.5,4.0,1.3},{5.5,2.6,4.4,1.2},{6.1,3.0,4.6,1.4},{5.8,2.6,4.0,1.2},{5.0,2.3,3.3,1.0},{5.6,2.7,4.2,1.3},{5.7,3.0,4.2,1.2},{5.7,2.9,4.2,1.3},{6.2,2.9,4.3,1.3},{5.1,2.5,3.0,1.1},{5.7,2.8,4.1,1.3},{6.3,3.3,6.0,2.5},{5.8,2.7,5.1,1.9},{7.1,3.0,5.9,2.1},{6.3,2.9,5.6,1.8},{6.5,3.0,5.8,2.2},{7.6,3.0,6.6,2.1},{4.9,2.5,4.5,1.7},{7.3,2.9,6.3,1.8},{6.7,2.5,5.8,1.8},{7.2,3.6,6.1,2.5},{6.5,3.2,5.1,2.0},{6.4,2.7,5.3,1.9},{6.8,3.0,5.5,2.1},{5.7,2.5,5.0,2.0},{5.8,2.8,5.1,2.4},{6.4,3.2,5.3,2.3},{6.5,3.0,5.5,1.8},{7.7,3.8,6.7,2.2},{7.7,2.6,6.9,2.3},{6.0,2.2,5.0,1.5},{6.9,3.2,5.7,2.3},{5.6,2.8,4.9,2.0},{7.7,2.8,6.7,2.0},{6.3,2.7,4.9,1.8},{6.7,3.3,5.7,2.1},{7.2,3.2,6.0,1.8},{6.2,2.8,4.8,1.8},{6.1,3.0,4.9,1.8},{6.4,2.8,5.6,2.1},{7.2,3.0,5.8,1.6},{7.4,2.8,6.1,1.9},{7.9,3.8,6.4,2.0},{6.4,2.8,5.6,2.2},{6.3,2.8,5.1,1.5},{6.1,2.6,5.6,1.4},{7.7,3.0,6.1,2.3},{6.3,3.4,5.6,2.4},{6.4,3.1,5.5,1.8},{6.0,3.0,4.8,1.8},{6.9,3.1,5.4,2.1},{6.7,3.1,5.6,2.4},{6.9,3.1,5.1,2.3},{5.8,2.7,5.1,1.9},{6.8,3.2,5.9,2.3},{6.7,3.3,5.7,2.5},{6.7,3.0,5.2,2.3},{6.3,2.5,5.0,1.9},{6.5,3.0,5.2,2.0},{6.2,3.4,5.4,2.3},{5.9,3.0,5.1,1.8}};

        int k = 3;
        int max_iterations = 200;
        Double stagnation_step = Math.pow(10, -1);
        int max_stagnation_iterations = 50;

        KMedoid model = new KMedoid(k, max_iterations, stagnation_step,max_stagnation_iterations);
        model.fit(all_data); 

        int[] labels = model.get_labels();
        int a=0,b=0,c=0;
        for(int i=0;i<labels.length;i++){
            System.out.println((i+1)+")"+labels[i]);;
        }
        System.out.println("final cost:"+String.format("%.2f",model.get_cost())+"\t number of iteration:"+model.get_nb_iterations());
        //System.out.println("a= "+a+" b= "+b+" c= "+c);
        //System.out.println("Accuracy= ");




    }
}