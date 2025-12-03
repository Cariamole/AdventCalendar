import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static String readFile(String filename){
        String everything;
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return everything;
    }

    public static void main(String[] args) {
        String s=readFile("C:\\Users\\Mariacole\\Documents\\AdventCalendar\\src\\day1.txt");
        Jour1 j=new Jour1(s,50);
        j.countZeros();
    }
}