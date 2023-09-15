import java.io.PrintWriter;
import java.util.Scanner;

/**
 * A simple command line calculator for Fractions.
 *
 * @author Reed Colloton
 */
public class InteractiveCalculator {
    public static void main(String[] args) throws Exception {
        BFCalculator calculator = new BFCalculator();
        PrintWriter pen = new PrintWriter(System.out, true);
        Scanner eyes = new Scanner(System.in);
        pen.printf("> ");
        String line = eyes.nextLine().strip();
        while (!line.isEmpty() && !line.equals("QUIT")) {
            if (line.contains("STORE")) {
                calculator.store(line.charAt(line.length() - 1));
            } else {
                pen.println(line + " = " + calculator.evaluate(line));
            }
            pen.printf("> ");
            line = eyes.nextLine().strip();
        }
    }
}