import java.io.PrintWriter;

/**
 * A simple command line argument calculator for Fractions.
 *
 * @author Reed Colloton
 */
public class QuickCalculator {
    public static void main(String[] args) throws Exception {
        PrintWriter pen = new PrintWriter(System.out, true);
        BFCalculator calculator = new BFCalculator();
        for (int i = 0; i < args.length; i++) {
            String line = args[i];
            if (line.contains("STORE")) {
                calculator.store(line.charAt(line.length() - 1));
            } else {
                pen.println(line + " = " + calculator.evaluate(line));
            }
        }
    }
}