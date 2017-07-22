package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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

    public Label Licensekek;

    public ChoiceBox<Object> choice_1;
    public ChoiceBox<Object> choice_2;
    public ChoiceBox<Object> choice_3;
    public ChoiceBox<Object> choice_4;
    public ChoiceBox<Object> choice_5;
    public ChoiceBox<Object> choice_6;
    public ChoiceBox<Object> choice_7;

    static ArrayList<String> requiredNames = new ArrayList<>();

    private void licenseFailed(){

    }
    private boolean checkLicense(){

        return true;

    }

    private void fillSlot(BufferedWriter bw, TextField someField, ChoiceBox<Object> choiceBox){
            try {
                bw.write(choiceBox.getValue() + " " + someField.getText() + ';' + "\r\n");
            }
            catch(java.io.IOException e){
                e.printStackTrace();
            }
    }

    private void writeFunctions(int fieldAmount, BufferedWriter bw){

        Functions.namespaceSTD(bw);
        Functions.outputEverything(bw);
        Functions.outputOne(fieldAmount, bw);
        Functions.inputAll(bw);
        Functions.makeARecord(fieldAmount, bw, requiredNames);
        Functions.hello(fieldAmount, bw, requiredNames);
        Functions.writeMain(bw);

        FunctionsExtended.structOLS2(bw);
        FunctionsExtended.createOLS2(bw);
        FunctionsExtended.printOLS(fieldAmount, bw, requiredNames);
        FunctionsExtended.structOLS1(bw);

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
//    void writeFile(ActionEvent actionEvent){
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
//                Runtime runtime = Runtime.getRuntime();
                try {
                    String path = System.getProperty("user.home") +  "\\Desktop" + "\\"+ "something.txt";
                    ProcessBuilder pb = new ProcessBuilder("Notepad.exe", path);
                    pb.start();

//                    Process process = runtime.exec("C:\\path\\to\\notepad.exe "+path);
                }
                catch(java.io.IOException e){
                    e.printStackTrace();
                }
                System.out.println("Pressed Compile.");
            }
        });
    }


    private void init_choiceBoxes(){
        final String FieldInt = "int";
        final String FieldChar = "char";
        final String FieldChar2 = "char[2]";
        final String FieldChar5 = "char[5]";
        final String FieldChar10 = "char[10]";
        final String FieldChar20 = "char[20]";
        final String FieldChar30 = "char[30]";

        final Object ParamArray = new String[] {FieldInt, FieldChar, FieldChar2, FieldChar5, FieldChar10, FieldChar20, FieldChar30};



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

        if(checkLicense()) {
            init_choiceBoxes();


        }
        else {
            // something
            licenseFailed();


        }
    }



    public void something() {




    }
}
