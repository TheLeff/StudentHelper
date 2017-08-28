package sample;

public class VariablePair {

    int VariableCode;
    String VariableName;

    public VariablePair(int VariableCode, String VariableName) {
        this.VariableCode = VariableCode;
        this.VariableName = VariableName;
    }

    public int getCode() {
        return this.VariableCode;
    }

    public String getName() {
        return this.VariableName;
    }

    public int getIQ() {
        return 0;
    }

}
