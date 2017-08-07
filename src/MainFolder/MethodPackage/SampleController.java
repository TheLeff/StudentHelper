package MainFolder.MethodPackage;

import MainFolder.ExceptionPackage.FillContentsException;
import MainFolder.ExceptionPackage.ReadIssueException;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.util.ArrayList;

public class SampleController {

    public Button button_task7;
    public Button button_task9;
    public Button button_task10;
    public Button button_compile;
    public TextField someField_1;
    public TextField someField_2;
    public TextField someField_3;
    public TextField someField_4;
    public TextField someField_5;
    public TextField someField_6;
    public TextField someField_7;


    public ChoiceBox<Object> choice_1;
    public ChoiceBox<Object> choice_2;
    public ChoiceBox<Object> choice_3;
    public ChoiceBox<Object> choice_4;
    public ChoiceBox<Object> choice_5;
    public ChoiceBox<Object> choice_6;
    public ChoiceBox<Object> choice_7;





    static ArrayList<String> requiredNames = new ArrayList<>();

    private void fillSlot(BufferedWriter bw, TextField someField, ChoiceBox<Object> choiceBox){
            try {
                bw.write(choiceBox.getValue() + " " + someField.getText() + ';' + "\r\n");
            }
            catch(java.io.IOException e){
                e.printStackTrace();
            }
    }

    private void writeFunctions(int fieldAmount, BufferedWriter bw){

        try {
            Functions.namespaceSTD(bw);
            Functions.outputEverything(bw);
            Functions.outputOne(fieldAmount, bw);
            Functions.inputAll(bw);
            Functions.makeARecord(fieldAmount, bw, requiredNames);
            Functions.hello(fieldAmount, bw, requiredNames);
            Functions.writeMain(bw);

            FunctionsExtended.structOLS2(bw);
            FunctionsExtended.createOLS2(bw);
            FunctionsExtended.printOLS(bw, requiredNames);
            FunctionsExtended.structOLS1(bw);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        //todo: put functions here, without 9+10
    }

    private int fillStruct(BufferedWriter bw){
        int fieldAmount = 0;
        try {
            bw.write("#include " + '"' + "stdafx.h" + '"' + "\r\n" +
                    "#include " + '"' + "iostream.h" + '"' + "\r\n\r\n" + "struct Table" + "\r\n" + '{' + "\r\n");
        }
        catch(java.io.IOException e){
            e.printStackTrace();
        }
        if (someField_1.getText().length()>1 && choice_1.getValue()!=null){
            fieldAmount++;
            fillSlot(bw, someField_1, choice_1);
            requiredNames.add(someField_1.getText());
        }
        if (someField_2.getText().length()>1 && choice_2.getValue()!=null){
            fieldAmount++;
            fillSlot(bw, someField_2, choice_2);
            requiredNames.add(someField_2.getText());
        }
        if (someField_3.getText().length()>1 && choice_3.getValue()!=null){
            fieldAmount++;
            fillSlot(bw, someField_3, choice_3);
            requiredNames.add(someField_3.getText());
        }
        if (someField_4.getText().length()>1 && choice_4.getValue()!=null){
            fieldAmount++;
            fillSlot(bw, someField_4, choice_4);
            requiredNames.add(someField_4.getText());
        }
        if (someField_5.getText().length()>1 && choice_5.getValue()!=null){
            fieldAmount++;
            fillSlot(bw, someField_5, choice_5);
            requiredNames.add(someField_5.getText());
        }
        if (someField_6.getText().length()>1 && choice_6.getValue()!=null){
            fieldAmount++;
            fillSlot(bw, someField_6, choice_6);
            requiredNames.add(someField_6.getText());
        }
        if (someField_7.getText().length()>1 && choice_7.getValue()!=null){
            fieldAmount++;
            fillSlot(bw, someField_7, choice_7);
            requiredNames.add(someField_7.getText());
        }

        try{
        bw.write("}" + " db[500];" +"\r\n");
        }
        catch(java.io.IOException e){
            e.printStackTrace();
        }
        return fieldAmount;
    }
    @FXML
    void writeFile(){
        int fieldAmount = 0;

        File file = new File(System.getProperty("user.home") +  "\\Desktop", "something.txt");
        try {
            if (!file.exists()) {
                if(!file.createNewFile()){
                    writeFile();
                    return;
                }
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            fieldAmount = fillStruct(bw);
            writeFunctions(fieldAmount, bw);
            bw.close();
        }
        catch(java.io.IOException e){
            e.printStackTrace();
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информация о работе программы");
        alert.setHeaderText("Программа создана!");
        if((fieldAmount>0))
        alert.setContentText("Спасибо за использование!");
        else
            alert.setContentText("Но структура пустая, так что попробуйте заново (нормально)!");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                try {
                    String path = System.getProperty("user.home") +  "\\Desktop" + "\\"+ "something.txt";
                    ProcessBuilder pb = new ProcessBuilder("Notepad.exe", path);
                    pb.start();

                }
                catch(java.io.IOException e){
                    e.printStackTrace();
                }
                System.out.println("Pressed Compile.");
            }
        });
    }


    private void init_choiceBoxes(){

        final String[] ParamArray = new String[] {"int", "char", "char[2]", "char[5]", "char[10]", "char[20]", "char[30]"};

        //I fixed it with generifying the whole class. I don't know what I've done but it works
//        Warning:(198, 40) java: non-varargs call of varargs method with inexact argument type for last parameter;
//        cast to java.lang.Object for a varargs call
//        cast to java.lang.Object[] for a non-varargs call and to suppress this warning

            choice_1.getItems().addAll(ParamArray);
            choice_2.getItems().addAll(ParamArray);
            choice_3.getItems().addAll(ParamArray);
            choice_4.getItems().addAll(ParamArray);
            choice_5.getItems().addAll(ParamArray);
            choice_6.getItems().addAll(ParamArray);
            choice_7.getItems().addAll(ParamArray);

    }


    @FXML
    public void initialize(){

        Thread tr1 = new Thread(() -> {
            try {
                init_storage();
            } catch (FillContentsException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ОП, ОШИБКА");
                alert.setHeaderText(null);
                alert.setContentText("Ошибка памяти. Перезапустите программу!");
                alert.showAndWait();
            } catch (ReadIssueException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ОП, ОШИБКА");
                alert.setHeaderText(null);
                alert.setContentText("Ошибка чтения. Перезапустите программу!");
                alert.showAndWait();
            }

        });
        Thread tr2 = new Thread(this::init_choiceBoxes);
        tr1.start();
        tr2.start();
        try {
            tr1.join();
            tr2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            //todo: error, kill thread
        }


    }



    public void something() {
    }

    private void init_storage() throws ReadIssueException, FillContentsException {
        FileInputStream fstream;
        try {
            fstream = new FileInputStream("LineStorage");
        } catch (FileNotFoundException e) {
            throw new ReadIssueException(e.toString());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        int i;
        try {
            for (i = 0; i < 3; i++) {
                Functions.STRINGS_NAMESPACESTD[i] = br.readLine();
            }
            for (i = 0; i < 4; i++) {
                Functions.STRINGS_FILLSTRUCT[i] = br.readLine();
            }
            for (i = 0; i < 4; i++) {
                Functions.STRING_OUTPUTEVERYTHING[i] = br.readLine();
            }
            for (i = 0; i < 2; i++) {
                Functions.STRINGS_OUTPUTONE[i] = br.readLine();
            }
            for (i = 0; i < 8; i++) {
                Functions.STRINGS_INPUTALL[i] = br.readLine();
            }
            for (i = 0; i < 5; i++) {
                Functions.STRINGS_MAKEARECORD[i] = br.readLine();
            }
            for (i = 0; i < 9; i++) {
                Functions.STRINGS_HELLO[i] = br.readLine();
            }
            for (i = 0; i < 6; i++) {
                Functions.STRINGS_MAIN[i] = br.readLine();
            }


            for (i = 0; i < 5; i++) {
                FunctionsExtended.STRINGSEXT_STRUCTOLS2[i] = br.readLine();
            }
            for (i = 0; i < 31; i++) {
                FunctionsExtended.STRINGSEXT_CREATEOLS2[i] = br.readLine();
            }
            for (i = 0; i < 9; i++) {
                FunctionsExtended.STRINGSEXT_PRINTOLS[i] = br.readLine();
            }
            for (i = 0; i < 4; i++) {
                FunctionsExtended.STRINGSEXT_STRUCTOLS1[i] = br.readLine();
            }
        } catch (IOException e) {

            throw new FillContentsException(e.toString());
        }


    }
}
