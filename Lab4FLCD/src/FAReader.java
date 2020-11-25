import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FAReader {

    private File file;
    private Set<String> States = new HashSet<>();
    private Set<String> InitialState= new HashSet<>();
    private Set<String> Alphabet = new HashSet<>();
    private MultiMap<Pair<String,String>,String> Transitions = new MultiMap<>();
    private Set<String> Final= new HashSet<>();


    public FAReader(File file)
    {
        this.file=file;
    }

    public Set<String> getStates(){return this.States;}
    public Set<String> getInitialState(){return this.InitialState;}
    public Set<String> getAlphabet(){return this.Alphabet;}
    public MultiMap<Pair<String,String>,String> getTransitions(){return this.Transitions;}
    public Set<String> getFinal(){return this.Final;}

    public void scan()
    {
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(this.file)));
            String[] line = scanner.nextLine().trim().split(" ");
            this.States.addAll(Arrays.asList(line));

            line = scanner.nextLine().trim().split(" ");
            this.InitialState.addAll(Arrays.asList(line));

            line = scanner.nextLine().trim().split(" ");
            this.Alphabet.addAll(Arrays.asList(line));

            line = scanner.nextLine().trim().split(" ");
            while(line.length==3)
            {
                Pair<String,String>pair= new Pair<String,String>(line[0],line[1]);
                Transitions.put(pair,line[2]);
                line = scanner.nextLine().trim().split(" ");
            }
            this.Final.addAll(Arrays.asList(line));

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public boolean isDeterministic(){
        for (Pair<String,String> pair: Transitions.keySet()){
            if(Transitions.get(pair).size() > 1)
                return false;
        }
        return true;
    }

    public boolean isAccepted(String sequence){
        Iterator iterator = getInitialState().iterator();
        String currentState = (String) iterator.next();
        while (!sequence.isEmpty()){
            boolean ok = false;
            System.out.println(sequence + "   " + currentState);
            for(Pair<String , String> pair: Transitions.keySet()){
                if(pair.getLeft().equals(currentState) && pair.getRight().equals(String.valueOf(sequence.charAt(0)))){
                    ok = true;
                    currentState = String.join("" ,Transitions.get(pair));
                    sequence = sequence.substring(1);
                    break;
                }
            }
            if(!ok)
                return false;
        }
        boolean finalStateCheck = false;
        for(String finalState : getFinal()){
            if (finalState.equals(currentState)) {
                finalStateCheck = true;
                break;
            }
        }

        return finalStateCheck;
        }


}
