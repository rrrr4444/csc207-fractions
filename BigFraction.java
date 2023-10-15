import java.math.BigInteger;
// TODO: this
/**
 * A simple implementation of BigFractions.
 * Adapted from the lab BigFractions.
 *
 * @author Samuel A. Rebelsky
 * @author Reed Colloton
 * @version 1.2 of August 2023
 */
public class BigFraction {
  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+
  /*
   * (1) Denominators are always positive. Therefore, negative fractions are represented
   * with a negative numerator. Similarly, if a fraction has a negative numerator, it
   * is negative.
   *
   * (2) BigFractions are not necessarily stored in simplified form. To obtain a fraction
   * in simplified form, one must call the `simplify` method.
   */

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** The numerator of the fraction. Can be positive, zero or negative. */
  BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new fraction with numerator num and denominator denom.
   *
   * Warning! Not yet stable.
   */
  public BigFraction(BigInteger num, BigInteger denom) {
    this.num = num;
    this.denom = denom;
  } // BigFraction(BigInteger, BigInteger)

  /**
   * Build a new fraction with numerator num and denominator denom.
   *
   * Warning! Not yet stable.
   */
  public BigFraction(int num, int denom) {
    this.num = BigInteger.valueOf(num);
    this.denom = BigInteger.valueOf(denom);
  } // BigFraction(int, int)

  /**
   * Build a new fraction by parsing a string.
   *
   * Warning! Not yet implemented.
   */
  public BigFraction(String str) {
    String[] args = str.split("/");
    this.num = new BigInteger(args[0]);
    if (args.length == 1) {
      this.denom = new BigInteger("1");
    }
    else {
      this.denom = new BigInteger(args[1]);
    }


  } // BigFraction

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Express this fraction as a double.
   */
  public double doubleValue() {
    return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()

  /**
   * Add the fraction `addMe` to this fraction.
   */
  public BigFraction add(BigFraction addMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and addMe's denominator
    resultDenominator = this.denom.multiply(addMe.denom);
    // The numerator is more complicated
    resultNumerator = (this.num.multiply(addMe.denom)).add(addMe.num.multiply(this.denom));

    return new BigFraction(resultNumerator, resultDenominator).simplify();
  }// add(BigFraction)

  /**
   * Subtract the fraction `addMe` from this fraction.
   */
  public BigFraction subtract(BigFraction subMe) {
    // Negate fraction
    BigFraction negativeSubMe = new BigFraction(BigInteger.ZERO.subtract(subMe.num), subMe.denom);
    return negativeSubMe.add(new BigFraction(this.num, this.denom));
  }// add(BigFraction)

  /**
   * Multiply the fraction `multMe` to this fraction.
   */
  public BigFraction multiply(BigFraction multMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // Multiply the numerators
    resultNumerator = this.num.multiply(multMe.num);
    // Multiply the denominators
    resultDenominator = this.denom.multiply(multMe.denom);

    return new BigFraction(resultNumerator, resultDenominator).simplify();
  }// multiply(BigFraction)

  /**
   * Divide this fraction by `divByMe`.
   */
  public BigFraction divide(BigFraction divByMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // Multiply this numerator by the divByMe denominator
    resultNumerator = this.num.multiply(divByMe.denom);
    // Multiply this denominator by the divByMe numerator
    resultDenominator = this.denom.multiply(divByMe.num);

    return new BigFraction(resultNumerator, resultDenominator).simplify();
  }// divide(BigFraction)

  /**
   * Return fractional remainder left over after dividing two numbers.
   */
  public BigFraction fractional() {
    // Multiply the numerators
    BigInteger remainder = this.num.remainder(this.denom);
    // Return the computed value
    return new BigFraction(remainder, this.denom);
  }// fractional()

  /**
   * Returns a simplified fraction.
   */
  public BigFraction simplify() {
    // Simplifies fraction
    BigInteger gcd = this.num.gcd(this.denom);
    this.num = this.num.divide(gcd);
    this.denom = this.denom.divide(gcd);
    if (this.denom.compareTo(BigInteger.ZERO) < 0) {
      // If denominator is negative
      // Multiply numerator and denominator by -1
      this.num = this.num.multiply(BigInteger.valueOf(-1));
      this.denom = this.denom.multiply(BigInteger.valueOf(-1));
    }
    return new BigFraction(this.num, this.denom);
  }// simplify()

  /**
   * Get the denominator of this fraction.
   */
  public BigInteger denominator() {
    return this.denom;
  } // denominator()

  /**
   * Get the numerator of this fraction.
   */
  public BigInteger numerator() {
    return this.num;
  } // numerator()

  /**
   * Convert this fraction to a string for ease of printing.
   */
  public String toString() {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO)) {
      return "0";
    } // if it's zero
    // Special case: Integer
    else if (this.denom.equals(BigInteger.ONE)) {
      return this.num.toString();
    } // if it's an integer

    // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  } // toString()
} // class BigFraction
