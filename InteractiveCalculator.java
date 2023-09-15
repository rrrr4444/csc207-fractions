import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class InteractiveCalculator {
    public static void main(String[] args) throws Exception {
        BFCalculator calculator = new BFCalculator();
        PrintWriter pen = new PrintWriter(System.out, true);
        BufferedReader eyes = new BufferedReader(new InputStreamReader(System.in));

        String line = eyes.readLine().strip();
        while (!line.equals("QUIT") || line.equals("")) {
            if (line.contains("STORE")) {
                calculator.store(line.charAt(line.length() - 1));
            }
            else {
                pen.println(line + " = " + calculator.evaluate(line));
            }
            line = eyes.readLine();
        }
    }
}
