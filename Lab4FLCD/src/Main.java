import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        FAReader faReader= new FAReader(new File("D:\\Lab4FLCD\\src\\FA.txt"));
        faReader.scan();
        printMenu();
        Scanner scanner= new Scanner(System.in);
        int input= scanner.nextInt();
        while(input != 0)
        {
            if (input == 1)
            {
                System.out.println(faReader.getStates().toString());
            }

            if (input == 2)
            {
                System.out.println(faReader.getAlphabet().toString());
            }

            if (input == 3 )
            {
                for(Object o : faReader.getTransitions().entrySet())
                {
                    System.out.println(o.toString());
                }
            }

            if (input == 4)
            {
                System.out.println(faReader.getFinal().toString());
            }
            printMenu();
            input=scanner.nextInt();
        }
    }

    public static void printMenu(){
        System.out.println("0. Exit.");
        System.out.println("1. Display states.");
        System.out.println("2. Display alphabet.");
        System.out.println("3. Display transitions.");
        System.out.println("4. Display final states.");

    }
}
