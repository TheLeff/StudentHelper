package sample;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FunctionsExtended {

    public static String[] STRINGSEXT_STRUCTOLS2 = new String[5];
    public static String[] STRINGSEXT_CREATEOLS2 = new String[31];
    public static String[] STRINGSEXT_PRINTOLS = new String[9];
    public static String[] STRINGSEXT_STRUCTOLS1 = new String[4];

    public static void structOLS2(BufferedWriter bw) throws IOException {
        for (String LINE : STRINGSEXT_STRUCTOLS2) {
            bw.write(LINE);
        }
    }

    public static void structOLS1(BufferedWriter bw) throws IOException {
        for (String LINE : STRINGSEXT_STRUCTOLS1) {
            bw.write(LINE);
        }
    }

    public static void createOLS2(BufferedWriter bw) throws IOException {
        for (String LINE : STRINGSEXT_CREATEOLS2) {
            bw.write(LINE);
        }
    }

    public static void printOLS(BufferedWriter bw, ArrayList requiredNames) throws IOException {
        //todo: custom
    }


}
