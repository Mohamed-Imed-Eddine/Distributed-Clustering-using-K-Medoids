import java.io.Serializable;

public class Entry implements Serializable {

    private Double[][] data;
    private int k;

    public Entry(Double[][] data,int k){
        this.data = data;
        this.k = k;
    }

    public int get_k(){return this.k;}
    
    public Double[][] get_data(){return this.data;}
}
