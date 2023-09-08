
import java.io.PrintWriter;

/**
 * A simple experiment using fractions.
 *
 * @author Samuel A. Rebelsky.
 * @author Reed Colloton
 */
public class FractionExpt {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    BigFraction f1;
    f1 = new BigFraction(1, 2);
    BigFraction f2;
    f2 = new BigFraction(1, 4);
    pen.println("------------------");
    pen.println("1st fraction:  " + f1);
    pen.println("2nd fraction:  " + f2);
    pen.println("------------------");
    pen.println("Sum:           " + (f1.add(f2)));
    pen.println("Difference:    " + (f1.subtract(f2)));
    pen.println("Product:       " + (f1.multiply(f2)));
    pen.println("Quotient:      " + (f1.divide(f2)));
  } // main(String[])
} // class FractionExpt
