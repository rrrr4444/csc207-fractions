import java.math.BigInteger;

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
    this.denom = new BigInteger(args[1]);
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

    // Simplify fraction
    BigInteger gcd = resultDenominator.gcd(resultNumerator);
    resultNumerator = resultNumerator.divide(gcd);
    resultDenominator = resultDenominator.divide(gcd);
    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator);
  }// add(BigFraction)

  /**
   * Subtract the fraction `addMe` from this fraction.
   */
  public BigFraction subtract(BigFraction subMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // Negate fraction
    BigFraction negativeSubMe = new BigFraction(BigInteger.ZERO.subtract(subMe.num), subMe.num);

    // The denominator of the result is the
    // product of this object's denominator
    // and addMe's denominator
    resultDenominator = this.denom.multiply(negativeSubMe.denom);
    // The numerator is more complicated
    resultNumerator = (this.num.multiply(negativeSubMe.denom)).add(negativeSubMe.num.multiply(this.denom));

    // Simplify fraction
    BigInteger gcd = resultDenominator.gcd(resultNumerator);
    resultNumerator = resultNumerator.divide(gcd);
    resultDenominator = resultDenominator.divide(gcd);
    // Return the computed value
    return new BigFraction(resultNumerator, gcd);
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

    // Simplify fraction
    BigInteger gcd = resultDenominator.gcd(resultNumerator);
    resultNumerator = resultNumerator.divide(gcd);
    resultDenominator = resultDenominator.divide(gcd);
    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator);
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

    // Simplify fraction
    BigInteger gcd = resultDenominator.gcd(resultNumerator);
    resultNumerator = resultNumerator.divide(gcd);
    resultDenominator = resultDenominator.divide(gcd);
    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator);
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

    // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  } // toString()
} // class BigFraction
