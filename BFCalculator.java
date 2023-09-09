public class BFCalculator {
    // Create a register for each letter of the alphabet
    BigFraction registers[] = new BigFraction[26];
    // Reflects the last computation in case it needs to be stored
    BigFraction result;

    public BigFraction evaluate(String exp) {
        // remove all spaces;
        exp.replaceAll(" ", "");

        return new BigFraction(0, 0);
    } // evaluate()

    // Stores the last result in named register a-z
    public void store(char register) {
        int index = (int) register - (int) 'a';
        registers[index] = this.result;
    } // store(char register)

} // class BFCalculator
