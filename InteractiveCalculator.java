import java.io.PrintWriter;
import java.util.Scanner;

public class InteractiveCalculator {
    public static void main(String[] args) {
        BFCalculator calculator = new BFCalculator();
        PrintWriter pen = new PrintWriter(System.out, false);
        Scanner eyes = new Scanner(System.in);
        pen.print("> ");
        pen.flush();
        String line = eyes.nextLine().strip();
        while (!line.equals("QUIT") || line.equals("")) {
            if (line.contains("STORE")) {
                calculator.store(line.charAt(line.length() - 1));
            }
            else {
                pen.println(line + " = " + calculator.evaluate(line));
                pen.flush();
            }
            pen.print("> ");
            pen.flush();
            line = eyes.nextLine().strip();
        }
    }
}
