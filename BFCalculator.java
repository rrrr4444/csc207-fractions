/**
 * A calculator for Fractions.
 * Used by InteractiveCalculator and QuickCalculator.
 *
 * @author Reed Colloton
 */
public class BFCalculator {
    // A register for each letter of the alphabet
    BigFraction[] registers = new BigFraction[26];
    // Saves the last computation for the STORE command
    BigFraction result = null;

    public BigFraction evaluate(String exp) throws Exception {
        String[] elements = exp.split(" ");
        if (elements.length % 2 != 1) {
            throw new Exception("Invalid arguments");
        }
        // set total to first value
        BigFraction total = parseNumber(elements[0]);
        String operation = "";
        for (int i = 1; i < elements.length; i++) {
            if (i % 2 == 1) { // Odd elements are operations
                if (!"/*+-".contains(elements[i])) {
                    throw new Exception("Invalid operation");
                } else {
                    operation = elements[i];
                }
            } else { // Even elements are values
                if (operation.equals("/")) {
                    total = total.divide(parseNumber(elements[i]));
                } else if (operation.equals("*")) {
                    total = total.multiply(parseNumber(elements[i]));
                } else if (operation.equals("+")) {
                    total = total.add(parseNumber(elements[i]));
                } else if (operation.equals("-")) {
                    total = total.subtract(parseNumber(elements[i]));
                }
            }
        } // for
        // Save last result for store method
        this.result = total;
        return total;
    } // evaluate()

    // Stores the last result in named register a-z
    public void store(char register) throws Exception {
        int index = (int) register - (int) 'a';
        if (this.result == null) {
            throw new Exception("No value to store");
        } else {
            this.registers[index] = this.result;
        }
    } // store(char register)

    void validateValue(String num) throws Exception {
        if (num.length() == 1) {
            int i = (int) num.charAt(0) - (int) 'a';
            if (i >= 26 || i < 0) {
                throw new Exception("Invalid register value");
            } else if (this.registers[i] == null) {
                throw new Exception("Empty register");
            }
        } else {
            String digits = num.replace("/", "");
            for (int i = 0; i < digits.length(); i++) {
                if (!Character.isDigit(digits.charAt(i))) {
                    throw new Exception("Invalid value");
                }
            }
        }
        if (num.contains("/")) {
            String[] values = num.split("/");
            if (values.length != 2) {
                throw new Exception("Invalid fraction");
            }
        }
    }

    // Return BigFraction from string representation or register letter
    BigFraction parseNumber(String num) throws Exception {
        // Throws exceptions if invalid
        validateValue(num);
        // If register value, retrieve
        char c = num.charAt(0);
        if (Character.isAlphabetic(c)) {
            int i = (int) c - (int) 'a';
            return registers[i];
        } else {
            // Else number, convert to fraction
            return new BigFraction(num);
        } // else
    } // parseNumber()
} // class BFCalculator