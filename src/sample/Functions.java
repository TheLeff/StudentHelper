package sample;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

class Functions {

    static String[] STRINGS_NAMESPACESTD = new String[3];
    static String[] STRING_OUTPUTEVERYTHING = new String[5];
    static String[] STRINGS_OUTPUTONE = new String[2];
    static String[] STRINGS_INPUTALL = new String[8];
    static String[] STRINGS_MAKEARECORD = new String[5];
    static String[] STRINGS_HELLO = new String[9];
    static String[] STRINGS_MAIN = new String[6];

    private static int i = 0;


    private static String separator = System.lineSeparator();


    static void namespaceSTD(BufferedWriter bw) throws IOException {
        for (i = 0; i < 2; i++) {
            bw.write(STRINGS_NAMESPACESTD[i] + separator);
        }
    }
    static void outputEverything(BufferedWriter bw) throws IOException {
        for (i = 0; i < 5; i++) {
            bw.write(separator + STRING_OUTPUTEVERYTHING[i]);
        }
    }
    static void outputOne(int fieldAmount, BufferedWriter bw) throws IOException {
        bw.write(separator + separator + "void output(i){ " + "\r\n" + "cout");
        for (int i = 0; i < fieldAmount; i++) {
            bw.write(" << " + "db[i]." + FXMLController.requiredNames.get(i) + " << " + '"' + ' ' + '"');
        }
        bw.write(" << endl;" + separator + '}');
    }

    static void inputAll(BufferedWriter bw) throws IOException  {
        for (i = 0; i < 7; i++) {
            bw.write(separator + STRINGS_INPUTALL[i]);
        }
    }

    static void makeARecord(BufferedWriter bw, ArrayList<VariablePair> requiredNames) throws IOException {

        //todo: custom

        /*
        cout << "Режим ввода";
        cout << "Vvedite " + shto-to;

         */

        bw.write("void record() { " + separator + "cout <<" + '"' + "Rejim vvoda" + '"' + " << endl;" + separator);
        for (i = 0; i < requiredNames.size(); i++) {
            bw.write("cout << " + '"' + "Vvedite " + requiredNames.get(i).getName() + '"' + " << endl;" + separator);
            switch (requiredNames.get(i).getCode()) {
                case 1:
                    bw.write("cin >> db[countRecords]." + requiredNames.get(i).getName() + "<< endl;");
                    break;
                case 2:
                    bw.write("fgets(db[countRecords]." + requiredNames.get(i).getName() + ", 1, stdin);");
                    break;
                case 3:
                    bw.write("fgets(db[countRecords]." + requiredNames.get(i).getName() + ", 2, stdin);");
                    break;
                case 4:
                    bw.write("fgets(db[countRecords]." + requiredNames.get(i).getName() + ", 5, stdin);");
                    break;
                case 5:
                    bw.write("fgets(db[countRecords]." + requiredNames.get(i).getName() + ", 10, stdin);");
                    break;
                case 6:
                    bw.write("fgets(db[countRecords]." + requiredNames.get(i).getName() + ", 20, stdin);");
                    break;
                case 7:
                    bw.write("fgets(db[countRecords]." + requiredNames.get(i).getName() + ", 30, stdin);");
                    break;

            }

            // apparently I forgot to bring code with myself ROFL so...
            //todo: to do output
        }


//        bw.write("cout ");
//        for (int i = 0; i < fieldAmount; i++) {
//            bw.write(" << Type in the " + requiredNames.get(i) + " << endl;" + "\r\n" +
//                    "fgets(db[countRecords]." + requiredNames.get(i) + ", 30, stdin);" + "\r\n");
//
//        }




    }
    static void hello(int fieldAmount, BufferedWriter bw, ArrayList requiredNames) throws IOException {


        //todo: custom
    }
    static void writeMain(BufferedWriter bw) throws IOException {
        for (i = 0; i < 5; i++) {
            bw.write(separator + STRINGS_MAIN[i]);
        }
    }
    static void writeSearch(int fieldAmount, BufferedWriter bw, ArrayList requiredNames) throws IOException {

    }
    // todo: search

    // todo: all kinds of sorting

//    int  option    = 0;
//    int  phoneTemp = 0;
//    char nameTemp[20];
//    char addressTemp[30];
//    cout << endl << "What do you search for? (phone - 1, name - 2, address - 3)";
//    cin >> option;
//    cin.ignore();
//    switch (option) {
//        case 1: {
//            cout << endl << "Type in the phone";
//            cin >> phoneTemp;
//            cin.ignore();
//            for (int i = 0; i < countRecords; i++) {
//                if (phoneTemp == db[i].phone) {
//                    output(i);
//                    return i;
//                }
//            }
//            break;
//        }
//        case 2: {
//            cout << endl << "Type in the name";
//            fgets(nameTemp, 20, stdin);
//            for (int i = 0; i < countRecords; i++) {
//
//                if (strcmp(nameTemp, db[i].name) == false) {
//                    output(i);
//                    return i;
//                }
//            }
//            break;
//        }
//        case 3: {
//            cout << endl << "Type in the address";
//            fgets(addressTemp, 30, stdin);
//            for (int i = 0; i < countRecords; i++) {
//                if (strcmp(addressTemp, db[i].address) == false) {
//                    output(i);
//                    return i;
//                }
//            }
//            break;
//        }
//    }
//    return 0;
//}



}



