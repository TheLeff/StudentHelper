package sample;

import java.io.BufferedWriter;
import java.io.IOException;
import java.rmi.UnexpectedException;
import java.util.ArrayList;

class Functions {

    private static String separator = System.lineSeparator();

    private static String getExistifier(ArrayList<VariablePair> requiredNames) throws UnexpectedException {
        for (VariablePair requiredName : requiredNames) {
            if (requiredName.getCode() == 0) {
                return requiredName.getName();
            }
        }
        throw new UnexpectedException("Пользователь не ввёл ни один int");
    }

    static void write(BufferedWriter bw, int fieldAmount, ArrayList<VariablePair> requiredNames) throws IOException {

        bw.write(separator + "using namespace std;" + separator + separator +
                "int countRecords = 0;" + separator + separator +
                "void output(int i){" + separator);
        outputOne(fieldAmount, bw);
        bw.write(
                "}" + separator + separator +
                        "void outputS() {" + separator +
                        "    for (int i = 0; i < countRecords; i++) {" + separator +
                        "        output(i);" + separator +
                        "    }" + separator +
                        '}' + separator + separator +
                        "void input() {" + separator +
                        "    FILE *file = fopen(\"table.dat\", \"rb\");" + separator +
                        "    for (int i = 0; i < 500; i++) {" + separator +
                        "        fread(&db[i], sizeof db[i], 1, file);" + separator +
                        "    }" + separator +
                        "    for (int i = 0; i < 499; i++) {" + separator +
                        "        if (db[i]." + getExistifier(requiredNames) + ">0)" + separator +
                        "            countRecords++;" + separator +
                        "    }" + separator +
                        '}');
        makeARecord(bw, requiredNames);
        hello(bw);
        writeMain(bw);
    }

    static void namespaceSTD(BufferedWriter bw) throws IOException {

        bw.write("#include \"stdafx.h\"" + separator + "#include \"iostream\"" + separator);

    }

    private static void outputOne(int fieldAmount, BufferedWriter bw) throws IOException {
        bw.write("    cout");
        for (int i = 0; i < fieldAmount; i++) {
            bw.write(" << " + "db[i]." + FXMLController.requiredNames.get(i).getName() + " << " + '"' + ' ' + '"');
        }
        bw.write(" << endl;" + separator);
    }


    private static void makeARecord(BufferedWriter bw, ArrayList<VariablePair> requiredNames) throws IOException {

        bw.write(separator + separator + "void saveRecord() { " + separator +
                "    FILE *file = fopen(\"table.dat\", \"ab\");" + separator);
        for (VariablePair requiredName : requiredNames) {
            bw.write("    cout << " + '"' + "Vvedite " + requiredName.getName() + '"' + " << endl;" + separator);
            System.out.println(requiredName.getCode());
            switch (requiredName.getCode()) {
                case 0:
                    bw.write("    cin >> db[countRecords]." + requiredName.getName() + ';' + separator);
                    break;
                case 1:
                    bw.write("    cin >> db[countRecords]." + requiredName.getName() + ';' + separator);
                    break;
                case 2:
                    bw.write("    cin >> db[countRecords]." + requiredName.getName() + ';' + separator);
                    break;
                case 3:
                    bw.write("    cin >> db[countRecords]." + requiredName.getName() + ';' + separator);
                    break;
                case 4:
                    bw.write("    cin >> db[countRecords]." + requiredName.getName() + ';' + separator);
                    break;
                case 5:
                    bw.write("    cin >> db[countRecords]." + requiredName.getName() + ';' + separator);
                    break;
                case 6:
                    bw.write("    cin >> db[countRecords]." + requiredName.getName() + ';' + separator);
                    break;
            }
        }
        bw.write("    fwrite(&db[countRecords], sizeof db[countRecords], 1, file);" + separator +
                "    countRecords++;" + separator);
        bw.write('}' + separator);
    }

    private static void hello(BufferedWriter bw) throws IOException {

        bw.write(separator + "int hello() {" + separator +
                "    int option;" + separator +
                "    cout << \"=====================\\n====Choose action====\\n1. Add info\\n2. Output whole base\\n" + separator +
                "3. Close Application\\n=====================\\n\";" + separator +
                "    cin >> option;" + separator +
                "    switch (option) {" + separator +
                "        case 1:" + separator +
                "            saveRecord();" + separator +
                "            break;" + separator +
                "        case 2:" + separator +
                "            outputS();" + separator +
                "            break;" + separator +
                "        case 3:" + separator +
                "            return 0;" + separator +
                "        default:" + separator +
                "            hello();" + separator +
                "            break;" + separator +
                "    }" + separator +
                "    hello();" + separator
                + '}' + separator
        );
    }

    private static void writeMain(BufferedWriter bw) throws IOException {

        bw.write(separator + "int main() { " + separator +
                "    input();" + separator +
                "    system(\"Cls\");" + separator +
                "    hello();" + separator + '}' + separator);
    }

}



