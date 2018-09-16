package benchmark;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainClassUCProtos {

    public static final int NUM_STUDENTS = 2048;

    public static void main(String[] args) {

        ClassUCProtos.ClassUC classUC = ClassUCProtosBuilders.buildClassUC(NUM_STUDENTS);


        // Write to a file
        try {
            FileOutputStream out = new FileOutputStream("binary/number-students-" + NUM_STUDENTS + ".txt");
            classUC.writeTo(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ClassUC read(){
        return null;
    }

    public static void write(ClassUCProtos.ClassUC classUC){

    }
}
