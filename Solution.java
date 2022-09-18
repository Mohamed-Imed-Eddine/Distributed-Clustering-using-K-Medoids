import java.io.Serializable;
import java.util.ArrayList;

public class Solution implements Serializable,Comparable {
    
    private ArrayList<Integer> medoids;
    private int[] labels;
    private Double cost;

    public Solution(ArrayList<Integer> medoids, int[] labels, Double cost){
        this.medoids = medoids;
        this.labels = labels;
        this.cost = cost;
    }

    public Solution() {
        this.cost = 0.0;
    }

    public Double get_cost(){
        return this.cost;
    }

    public int[] get_labels(){
        return this.labels;
    }

    public ArrayList<Integer> get_medoids(){
        return this.medoids;
    }

    @Override
    public int compareTo(Object o) {
        return this.cost.compareTo(((Solution)o).get_cost());
    }
    
}
