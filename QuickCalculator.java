import java.io.PrintWriter;

public class QuickCalculator {
    public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    BFCalculator calculator = new BFCalculator();
        for (int i = 0; i < args.length; i++) {
            String line = args[i];
            if (line.contains("STORE")) {
                calculator.store(line.charAt(line.length() - 1));
            }
            else {
                pen.println(line + " = " + calculator.evaluate(line));
            }
        }
    }
}
