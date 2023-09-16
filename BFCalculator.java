/**
 * A simple calculator for Fractions.
 * Used by InteractiveCalculator and QuickCalculator.
 *
 * @author Reed Colloton
 */
public class BFCalculator {
    // A register for each letter of the alphabet
    BigFraction[] registers = new BigFraction[26];
    // Saves the last computation for the STORE command
    BigFraction result = null;

    // Evaluates an expression for the calculator
    public BigFraction evaluate(String exp) throws Exception {
        String[] elements = exp.split(" ");
        if (elements.length % 2 != 1) {
            throw new Exception("Invalid arguments");
        } // if
        // set total to first value
        BigFraction total = parseValue(elements[0]);
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
                    total = total.divide(parseValue(elements[i]));
                } else if (operation.equals("*")) {
                    total = total.multiply(parseValue(elements[i]));
                } else if (operation.equals("+")) {
                    total = total.add(parseValue(elements[i]));
                } else if (operation.equals("-")) {
                    total = total.subtract(parseValue(elements[i]));
                }
            } // if
        } // for
        // Save last result for store method
        this.result = total;
        return total;
    } // evaluate()

    // Stores the last result in named register a-z
    public void store(char register) throws Exception {
        int i = registerIndex(register);
        if (this.result == null) {
            throw new Exception("No value to store");
        } else {
            this.registers[i] = this.result;
        }
    } // store(char register)

    // Return BigFraction from string representation or register letter
    BigFraction parseValue(String num) throws Exception {
        // Throws exceptions if value is invalid
        validateValue(num);
        // If register value, retrieve
        char c = num.charAt(0);
        if (Character.isAlphabetic(c)) {
            int i = registerIndex(c);
            return registers[i];
        } else {
            // Else number, convert to fraction
            return new BigFraction(num);
        } // else
    } // parseValue()

    // Validates a value for the calculator, raises appropriate errors if invalid
    void validateValue(String num) throws Exception {
        if (num.length() == 1 && !Character.isDigit(num.charAt(0))) {
            int i = registerIndex(num.charAt(0));
            if (this.registers[i] == null) {
                throw new Exception("Empty register");
            }
        } else {
            String digits = num.replace("/", "");
            char c = digits.charAt(0);
            if (c == '+' || c == '-') {
                digits = digits.substring(1);
            }
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
    } // validateValue()

    // Calculates an index value for the register given char c
    int registerIndex(Character c) throws Exception {
        int i = (int) c - (int) 'a';
        if (i >= 26 || i < 0) {
            throw new Exception("Invalid register value");
        }
        return i;
    } // registerIndex()
} // class BFCalculator