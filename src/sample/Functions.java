package sample;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

class Functions {


    static void namespaceSTD(BufferedWriter bw){
        try {
            bw.write("\r\n" + "using namespace std;" + "\r\n" + "\r\n"
            +"int countRecords = 0; " + "\r\n" + "\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void outputEverything(BufferedWriter bw) {

        try {
            bw.write("void output() {" + "\r\n" +
                    "for (int i = 0; i < countRecords; i++) {" + "\r\n" +
                    "output(i);" + "\r\n" +
                    '}' + "\r\n" + "\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void outputOne(int fieldAmount, BufferedWriter bw){


        try {
            bw.write("void output(int i){" + "\r\n" +
                    "cout");
            for (int i = 0; i < fieldAmount; i++) {
                bw.write(" << " + " db[i]." + SampleController.requiredNames.get(i) + " << " + "endl");
            }
            bw.write("\r\n" + "}" + "\r\n");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    static void inputAll(BufferedWriter bw) {

        try { // todo: change for to while to make it work without one more bool field
            bw.write("\r\n" + "void input() {" + "\r\n" + "FILE *file = fopen(" + '"' + "table.dat" + '"' + ", " + '"' + 'r' + '"' + ");" + "\r\n" +
                    "for (int i = 0; i < 500; i++) { " + "\r\n" +
                    " fread(&db[i], sizeof db[i], 1, file);" + "\r\n" +
                    "countRecords++" + "\r\n" +
                    '}' + "\r\n" + "fclose(file);" + "\r\n" + '}' + "\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    static void makeARecord(int fieldAmount, BufferedWriter bw, ArrayList requiredNames){

        try { // todo: fix bad input (ints and chars)
            bw.write("\r\n" + "void saveRecord() {" + "\r\n" +
            "FILE *f = fopen(" + '"' + "table.dat" + '"' + ", " + '"' + 'a' + '"' + ");" + "\r\n");


            bw.write("cout ");
            for (int i = 0; i<fieldAmount; i++){
                bw.write(" << Type in the " + requiredNames.get(i) + " << endl;" + "\r\n" +
                        "fgets(db[countRecords]." + requiredNames.get(i) + ", 30, stdin);" + "\r\n");

            }

            bw.write("countRecords++;" + "\r\n" + "fclose(f);" + "\r\n" + '}' + "\r\n");

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    static void hello(int fieldAmount, BufferedWriter bw, ArrayList requiredNames){
        try {
            bw.write("\r\n" + "void hello() {" + "\r\n" + "cout << =====================\r\n====Choose action====\r\n1. Add info\r\n2.Output everything\r\n"
            + "something else\r\n");
            bw.write("cin >> option;\r\ncin.ignore();\r\nswitch(option) {\r\ncase 1:\r\n something();\r\nbreak;");
            bw.write("}\r\nhello();\r\n}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void writeMain(BufferedWriter bw){

        try {
            bw.write("\r\nint main(){" +
            "\r\nsystem(" + '"' + "Cls" + '"' + ");" +
            "\r\nSetConsoleCP(1251);\r\nSetConsoleOutputCP(1251);" +
                    "\r\nhello();\r\n}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static void writeSearch(int fieldAmount, BufferedWriter bw, ArrayList requiredNames){

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



