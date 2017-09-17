package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class FXMLController {

    static ArrayList<VariablePair> requiredNames = new ArrayList<>();
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
    private int fieldAmount = 0;

    private void fillSlot(BufferedWriter bw, TextField someField, ChoiceBox<Object> choiceBox) {
        try {
            switch (choiceBox.getValue().toString()) {
                case "int":
                    bw.write("    " + choiceBox.getValue() + " " + someField.getText() + ';' + "\r\n");
                    break;
                case "char":
                    bw.write("    char " + someField.getText() + ';' + "\r\n");
                    break;
                case "char[2]":
                    bw.write("    char " + someField.getText() + "[2]" + ';' + "\r\n");
                    break;
                case "char[5]":
                    bw.write("    char " + someField.getText() + "[5]" + ';' + "\r\n");
                    break;
                case "char[10]":
                    bw.write("    char " + someField.getText() + "[10]" + ';' + "\r\n");
                    break;
                case "char[20]":
                    bw.write("    char " + someField.getText() + "[20]" + ';' + "\r\n");
                    break;
                case "char[30]":
                    bw.write("    char " + someField.getText() + "[30]" + ';' + "\r\n");
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void writeFunctions(int fieldAmount, BufferedWriter bw) {

        try {
            Functions.write(bw, fieldAmount, requiredNames);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void organizePair(String Text, String Variable) throws Exception { // I really need it to make a Functions.makeARecord() function
        switch (Variable) {
            case "int":
                requiredNames.add(new VariablePair(0, Text));
                break;
            case "char":
                requiredNames.add(new VariablePair(1, Text));
                break;
            case "char[2]":
                requiredNames.add(new VariablePair(2, Text));
                break;
            case "char[5]":
                requiredNames.add(new VariablePair(3, Text));
                break;
            case "char[10]":
                requiredNames.add(new VariablePair(4, Text));
                break;
            case "char[20]":
                requiredNames.add(new VariablePair(5, Text));
                break;
            case "char[30]":
                requiredNames.add(new VariablePair(6, Text));
                break;
        }
    }

    private int fillStruct(BufferedWriter bw) throws Exception {
        try {
            bw.write("\r\n" + "struct Table" + "\r\n" + '{' + "\r\n");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        if (someField_1.getText().length() > 1 && choice_1.getValue() != null) {
            fieldAmount++;
            fillSlot(bw, someField_1, choice_1);
            organizePair(someField_1.getText(), choice_1.getValue().toString());

        }
        if (someField_2.getText().length() > 1 && choice_2.getValue() != null) {
            fieldAmount++;
            fillSlot(bw, someField_2, choice_2);
            organizePair(someField_2.getText(), choice_2.getValue().toString());
        }
        if (someField_3.getText().length() > 1 && choice_3.getValue() != null) {
            fieldAmount++;
            fillSlot(bw, someField_3, choice_3);
            organizePair(someField_3.getText(), choice_3.getValue().toString());
        }
        if (someField_4.getText().length() > 1 && choice_4.getValue() != null) {
            fieldAmount++;
            fillSlot(bw, someField_4, choice_4);
            organizePair(someField_4.getText(), choice_4.getValue().toString());
        }
        if (someField_5.getText().length() > 1 && choice_5.getValue() != null) {
            fieldAmount++;
            fillSlot(bw, someField_5, choice_5);
            organizePair(someField_5.getText(), choice_5.getValue().toString());
        }
        if (someField_6.getText().length() > 1 && choice_6.getValue() != null) {
            fieldAmount++;
            fillSlot(bw, someField_6, choice_6);
            organizePair(someField_6.getText(), choice_6.getValue().toString());
        }
        if (someField_7.getText().length() > 1 && choice_7.getValue() != null) {
            fieldAmount++;
            fillSlot(bw, someField_7, choice_7);
            organizePair(someField_7.getText(), choice_7.getValue().toString());
        }

        try {
            bw.write("}" + " db[500];" + "\r\n");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return fieldAmount;
    }

    @FXML
    void helpMethod() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информация о программе");
        alert.setHeaderText("Руководство пользователя");
        alert.setContentText("Данная программа позволит Вам сгенерировать лабораторную работу по программированию.\r\n" +
                "На данный момент реализован функционал 7 задачи (без поиска).\r\n" +
                "Введите необходимые поля (слева - имя поля, справа - тип), нажмите \"Создать\" и вставьте полученный код в Visual Studio.\r\n" +
                "Код проверен 17-Сентября-17 в среде CLion 2017.\r\n" +
                "Также не забудьте создать в папке проекта файл \"table.dat\" для хранения информации.\r\n" +
                "Пояснение: программа должна стать вашим помощником в понимании, а не просто инструментом для сдачи лабораторной работы. " +
                "Я хочу, чтобы Вы поняли принцип готовой реализации и улучшили его.\r\n" +
                "Нашли ошибку? Помогите исправить её. Напишите на любой из контактов, указанных на сайте -\r\n" +
                "https://leff.su/\r\n" +
                "Версия: 1.1.0 17-Sep-17");

        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {

                System.out.println("Pressed Compile.");
            }
        });

    }

    @FXML
    void writeFile() throws Exception {
        int fieldAmount = 0;

        File file = new File(System.getProperty("java.io.tmpdir"), "something.txt");

        try {
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    writeFile();
                    return;
                }
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            Functions.namespaceSTD(bw);
            fieldAmount = fillStruct(bw);
            writeFunctions(fieldAmount, bw);
            bw.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информация о работе программы");
        alert.setHeaderText("Программа создана!");
        if ((fieldAmount > 0))
            alert.setContentText("Спасибо за использование!");
        else
            alert.setContentText("Но структура пустая, так что попробуйте заново (нормально)!");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                try {
                    String path = System.getProperty("java.io.tmpdir") + "\\" + "something.txt";
                    ProcessBuilder pb = new ProcessBuilder("notepad.exe", path);
                    if (Objects.equals(System.lineSeparator(), "\n"))
                        pb = new ProcessBuilder("gedit", path); // linux gedit compatibility, System.java:637 for reference
                    pb.start();

                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Pressed Compile.");
            }
        });
        file.deleteOnExit();
    }

    private void init_choiceBoxes() {

        final String[] ParamArray = new String[]{"int", "char", "char[2]", "char[5]", "char[10]", "char[20]", "char[30]"};

        choice_1.getItems().addAll((Object[]) ParamArray);
        choice_2.getItems().addAll((Object[]) ParamArray);
        choice_3.getItems().addAll((Object[]) ParamArray);
        choice_4.getItems().addAll((Object[]) ParamArray);
        choice_5.getItems().addAll((Object[]) ParamArray);
        choice_6.getItems().addAll((Object[]) ParamArray);
        choice_7.getItems().addAll((Object[]) ParamArray);
    }

    @FXML
    public void initialize() {
        init_choiceBoxes();
    }

}
