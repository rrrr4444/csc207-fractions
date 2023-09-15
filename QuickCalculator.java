import java.io.PrintWriter;

public class QuickCalculator {
    public static void main(String[] args) {
        String[] temp = new String[4];
        temp[0] = "1/2 + 1/4";
        temp[1] = "STORE a";
        temp[2] = "a * a";
        temp[3] = "8 / 2";
        args = temp;
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
