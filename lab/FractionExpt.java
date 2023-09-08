package lab;

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
    Fraction f1;
    f1 = new Fraction(11, 3);
    Fraction f2;
    f2 = new Fraction(5, 2);
    Fraction f3;
    f3 = new Fraction(1, 2);
    Fraction f4;
    f4 = new Fraction(4, 2);
    pen.println("First fraction: " + f1);
    pen.println("Second fraction: " + f2);
    pen.println("Sum: " + (f1.add(f2)));
    pen.println("Product: " + (f1.multiply(f2)));
    pen.println("Fractional f1: " + (f1.fractional()));
    pen.println("Fractional f2: " + (f2.fractional()));
    pen.println("Fractional f3: " + (f3.fractional()));
    pen.println("Fractional f4: " + (f4.fractional()));
  } // main(String[])
} // class FractionExpt
