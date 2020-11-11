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
    private Map<Pair<String,String>,String> Transitions = new HashMap<>();
    private Set<String> Final= new HashSet<>();


    public FAReader(File file)
    {
        this.file=file;
    }

    public Set<String> getStates(){return this.States;}
    public Set<String> getInitialState(){return this.InitialState;}
    public Set<String> getAlphabet(){return this.Alphabet;}
    public Map<Pair<String,String>,String> getTransitions(){return this.Transitions;}
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
}
