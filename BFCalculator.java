public class BFCalculator {
    // Create a register for each letter of the alphabet
    BigFraction registers[] = new BigFraction[26];
    // Reflects the last computation in case it needs to be stored
    BigFraction result;

    public BigFraction evaluate(String exp) {
        String[] elements = exp.split(" ");
        BigFraction[] values = new BigFraction[exp.length()];
        // Separate operations from values
        // If numerical string, convert to BigFraction
        for (int i = 0; i < elements.length; i++) {
            // If fraction, convert to fraction
            if (elements[i].contains("/")
                    && elements[i].length() != 1
                    || is_numeric(elements[i])) {
                values[i] = new BigFraction(elements[i]);
            } // if
            // If register value, retrieve
            else if (Character.isAlphabetic(elements[i].charAt(0))) {
                Character c = elements[i].charAt(0);
                int register_index = (int) c - (int) 'a';
                values[i] = registers[register_index];
            } // else if
        } // for
        // set total to first value
        BigFraction total = values[0];
        Boolean is_value = false;
        String operation;
        for (int i = 1; i < elements.length; i++) {
            if (is_value) {
                if (operation.equals("\\")) {
                    total.divide(values[i]);
                }
                else if (operation.equals("*")) {
                    total.multiply(values[i]);
                }
                else if (operation.equals("+")) {
                    total.add(values[i]);
                }
                else if (operation.equals("-")) {
                    total.subtract(values[i]);
                }
            }
            else {
                operation = elements[i];
            }
            is_value = !is_value;
        } // for
        return total;
    } // evaluate()

    // Stores the last result in named register a-z
    public void store(char register) {
        int index = (int) register - (int) 'a';
        registers[index] = this.result;
    } // store(char register)

    Boolean is_numeric(String element) {
        for (int i = 0; i < element.length(); i++) {
            if (!Character.isDigit(element.charAt(i))) {
                return false;
            } // if
        } // for
        return true;
    } // is_numeric

} // class BFCalculator
