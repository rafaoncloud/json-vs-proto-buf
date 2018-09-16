package classuc;

import classuc.ClassUC;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class JsonFile {

    public static ClassUC read(String path){

        Gson gson = new Gson();

        try (Reader reader = new FileReader(path)) {

            ClassUC classUC = gson.fromJson(reader, ClassUC.class);
            return classUC;
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully read from file!");
        return null;
    }

    public static void write(ClassUC classUC, String path){

        Gson gson = new Gson();
        String json = gson.toJson(classUC);
        try (FileWriter writer = new FileWriter(path)) {

            writer.write(json);
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully wrote on file!");
    }
}
