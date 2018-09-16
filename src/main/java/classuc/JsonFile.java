package classuc;

import classuc.ClassUC;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class JsonFile {

    public static final String PATH = "classUC.txt";

    public static ClassUC read(){

        Gson gson = new Gson();

        try (Reader reader = new FileReader(PATH)) {

            ClassUC classUC = gson.fromJson(reader, ClassUC.class);
            return classUC;
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully read from file!");
        return null;
    }

    public static void write(String jsonRepresentation){

        try (FileWriter writer = new FileWriter(PATH)) {

            writer.write(jsonRepresentation);
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully wrote on file!");
    }
}
