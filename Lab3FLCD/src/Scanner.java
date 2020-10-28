import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Scanner {


    private File tfile;
    private File program;
    private List<String> tokens = new ArrayList<>();
    private File outsymbol;
    private File outpif;

    Scanner(String tfile,String program,String o1, String o2) throws IOException {
        this.tfile=new File(tfile);
        this.program=new File(program);
        this.outsymbol=new File(o1);
        this.outpif=new File(o2);
        addTokens();
    }

    void addTokens() throws IOException
    {
        FileReader fileReader= new FileReader(this.tfile);
        BufferedReader bufferedReader= new BufferedReader(fileReader);
        String s;
        while(( s=bufferedReader.readLine())!=null)
        {
            tokens.add(s);
        }
    }

    public boolean isReserved(String token){
        for (String s:this.tokens)
        {
            if (s.equals(token))
                return true;
        }
        return false;
    }

    public boolean isOk(String token){
        if ( Character.isDigit(token.charAt(0)) )
            return false;
        else
            if(token.startsWith("!") || token.startsWith("$") ||token.startsWith("#") || token.startsWith("%") || token.startsWith("@") || token.startsWith("`"))
                return false;
            return true;
    }


    void scan() throws Exception {

        SymbolTable symbolTable= new SymbolTable();
        PIF pif=new PIF();


        BufferedReader bufferedReader=new BufferedReader(new FileReader(this.program));
        StringBuilder stringBuilder= new StringBuilder();
        String line= bufferedReader.readLine();
        while (line!=null)
        {
            stringBuilder.append(line);
            stringBuilder.append("\n");
            line=bufferedReader.readLine();

        }

        StringTokenizer tokenizer=new StringTokenizer(stringBuilder.toString()," .,;\n");


        while(tokenizer.hasMoreTokens()){
            String token=tokenizer.nextToken();
            if (!isReserved(token)){
                if (!isOk(token)) throw new Exception("Lexical error");
                symbolTable.add(token);
                int x=symbolTable.get().search(token).index;
                pif.add(x,token);
            }
            else {
                pif.add(-1,token);
            }

        }



        FileWriter wsymbol=new FileWriter(this.outsymbol);
        wsymbol.write(symbolTable.toString());
        wsymbol.close();

        FileWriter wpif=new FileWriter(this.outpif);
        wpif.write(pif.toString());
        wpif.close();

    }
}
