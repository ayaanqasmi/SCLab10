package expressivo;

class Operation implements Expression {
    private final char operator;
    private final Expression leftOperand, rightOperand;
    
    // Abstraction function:
    //   represents an operation on leftOperand and rightOperand
    // Rep invariant:
    //   operator is either '+' or '*'
    // Safety from rep exposure:
    //   all fields are final and immutable
    
    /**
     * Create an Operation.
     * 
     * @param operator '+' or '*'
     * @param leftOperand left-hand expression
     * @param rightOperand right-hand expression
     */
    public Operation(char operator, Expression leftOperand, Expression rightOperand) {
        this.operator = operator;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        checkRep();
    }
    
    /**
     * Validates the rep invariant.
     */
    private void checkRep() {
        assert operator == '+' || operator == '*';
    }
    
    @Override 
    public String toString() {
        return "(" + leftOperand.toString() + " " + operator + " " + rightOperand.toString() + ")";
    }

    @Override 
    public boolean equals(Object obj) {
        if (!(obj instanceof Operation)) return false;
        Operation other = (Operation) obj;
        return this.operator == other.operator &&
               this.leftOperand.equals(other.leftOperand) &&
               this.rightOperand.equals(other.rightOperand);
    }

    @Override 
    public int hashCode() {
        return Character.hashCode(operator) + leftOperand.hashCode() + rightOperand.hashCode();
    }
}
