package sample;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

class FunctionsExtended {
    static void structOLS2(BufferedWriter bw){
        try {
            bw.write("\r\n" + "struct OLS {" + "\r\n" + "Table element;" + "\r\n" + "OLS *next;" + "\r\n" + "OLS *last" + "\r\n"+ "};" + "\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void structOLS1(BufferedWriter bw){
        try {
            bw.write("\r\n" + "struct OLS {" + "\r\n" + "Table element;" + "\r\n" + "OLS *next;" + "\r\n" + "};" + "\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void createOLS2(BufferedWriter bw){
        try {
            bw.write("\r\n" + "void createOLS() {" + "\r\n" + "OLS *element, *current, *pred;" + "\r\n" + "*FILE A = fopen" + '"' + "table.dat" + '"' + ", " + '"' + "rb" + '"' + ");" + "\r\n" +
            "\r\n" + "first = NULL;" + "\r\n" + "while(fread(&listh, sizeof(listh), 1, A)) { " + "\r\n" + "element = new (OLS);" + "\r\n" +
            "element->db=listh;" + "\r\n" + "element->next=NULL;" + "\r\n" + "if (first == NULL) first = element;" + "\r\n" +
            "else {" + "\r\n" + "current = first;" + "\r\n" + "pred = NULL;" + "\r\n" + "while ((current != NULL))"+
        "\r\n" + '{' + "\r\n" + "pred = current;" + "\r\n" + "current = current->next;" + "\r\n" + '}' + "\r\n" + "if (current == first)" + "\r\n"+
            '{' + "\r\n" + "element->next = first;" + "\r\n" + "first = element;" + "\r\n" + '}' + "\r\n" + "\r\n" + "else" + "\r\n" +
            '{' + "\r\n" + "element->next = pred->next;" + "\r\n" + "pred->next = element;" + "\r\n" + '}' + "\r\n" + '}' + "\r\n" + '}' + "\r\n"+
            "fclose(A);" + "\r\n"+'}'+"\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void printOLS(int fieldAmount, BufferedWriter bw, ArrayList requiredNames){
        try {
            bw.write("\r\n" + "void printOLS(OLS *current) {" + "\r\n" + "OLS *tek;" + "\r\n" + "tek = current;" + "\r\n" +
                    "while (tek != NULL)" + "\r\n" + '{' + "\r\n" + "cout << endl ");
            for (int i = 0; i<fieldAmount;i++){
                bw.write("<< tek->" + requiredNames.get(i) + " " + '"' + ' ' + '"' );
            }
            bw.write(';'+"\r\n" + "tek=tek->next;" + "\r\n" + '}' + "\r\n" + '}' + "\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }








}
