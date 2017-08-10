package sample;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FunctionsExtended {

    public static String[] STRINGSEXT_STRUCTOLS2 = new String[5];
    public static String[] STRINGSEXT_CREATEOLS2 = new String[31];
    public static String[] STRINGSEXT_PRINTOLS = new String[9];
    public static String[] STRINGSEXT_STRUCTOLS1 = new String[4];
    static int i = 0;
    static String separator = System.lineSeparator();

    public static void structOLS2(BufferedWriter bw) throws IOException {
        for (i = 0; i < 4; i++) {
            bw.write(separator + STRINGSEXT_STRUCTOLS2[i]);
        }
    }

    public static void structOLS1(BufferedWriter bw) throws IOException {
        for (i = 0; i < 3; i++) {
            bw.write(separator + STRINGSEXT_STRUCTOLS1[i]);
        }
    }

    public static void createOLS2(BufferedWriter bw) throws IOException {
        for (i = 0; i < 30; i++) {
            bw.write(separator + STRINGSEXT_CREATEOLS2[i]);
        }
    }

    public static void printOLS(BufferedWriter bw, ArrayList requiredNames) throws IOException {
        //todo: custom
    }


}
