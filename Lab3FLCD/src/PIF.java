import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PIF {

    private List<Integer> keys;
    private List<String> values;


    public PIF(){
        this.keys=new ArrayList<>();
        this.values=new ArrayList<>();
    }


    public void add(Integer i,String s){
        this.values.add(s);
        this.keys.add(i);
    }

    public String toString(){
        String x="";
        for (int i = 0; i < keys.size(); i++) {
            x=x+values.get(i) + " " + keys.get(i) + "\n";
        }
        return x;
    }

}
