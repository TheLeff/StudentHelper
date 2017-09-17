package sample;

class VariablePair {

    private int VariableCode;
    private String VariableName;

    VariablePair(int VariableCode, String VariableName) {
        this.VariableCode = VariableCode;
        this.VariableName = VariableName;
    }

    int getCode() {
        return this.VariableCode;
    }

    String getName() {
        return this.VariableName;
    }

}
