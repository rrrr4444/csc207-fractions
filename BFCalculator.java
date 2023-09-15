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
    BigFraction result;

    public BigFraction evaluate(String exp) throws Exception {
        String[] elements = exp.split(" ");
        // set total to first value
        BigFraction total = parseNumber(elements[0]);
        String operation = "";
        for (int i = 1; i < elements.length; i++) {
            if (i % 2 == 1) { // Odd elements are operations
                operation = elements[i];
            } else  { // Even elements are values
                if (operation.equals("/")) {
                    total = total.divide(parseNumber(elements[i]));
                } else if (operation.equals("*")) {
                    total = total.multiply(parseNumber(elements[i]));
                } else if (operation.equals("+")) {
                    total = total.add(parseNumber(elements[i]));
                } else if (operation.equals("-")) {
                    total = total.subtract(parseNumber(elements[i]));
                } else {
                    throw new Exception("Invalid operation");
            }
            }
        } // for
        // Save last result for store method
        this.result = total;
        return total;
    } // evaluate()

    // Stores the last result in named register a-z
    public void store(char register) {
        int index = (int) register - (int) 'a';
        this.registers[index] = this.result;
    } // store(char register)

    // Return BigFraction from string representation or register letter
    BigFraction parseNumber(String num) {
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