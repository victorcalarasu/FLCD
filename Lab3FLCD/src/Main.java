import java.io.IOException;

public class Main {
    public static void main(String[] args){

        try {
            Scanner scanner = new Scanner("D:\\Faculta\\Lab3FLCD\\src\\tfile.in", "D:\\Faculta\\Lab3FLCD\\src\\program.in", "D:\\Faculta\\Lab3FLCD\\src\\symbol.out", "D:\\Faculta\\Lab3FLCD\\src\\pif.out");
            scanner.scan();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
