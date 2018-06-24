package ua.prog.kiev.lesson1.taskTwo;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Saver {
    private String text;
    @WriteTo
    public String filePath = "";

    public Saver() {

    }

    @WriteToFile
    public void saveTextToFile() {
        TextContainer tc = new TextContainer();
        text = tc.getText();
        try (PrintWriter pw = new PrintWriter(filePath)) {
            pw.write(text);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }


}
