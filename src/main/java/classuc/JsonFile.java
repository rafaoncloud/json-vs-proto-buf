package classuc;

import classuc.ClassUC;
import com.google.gson.Gson;
import sun.applet.Main;

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
    }

    public static BenchmarkTimes writeRead(ClassUC classUC, String path){

        long startInitializer = MainGson.startTimer();
        Gson gson = new Gson();
        long initializerTime = MainGson.endTimer(startInitializer);

        long startSerialization = MainGson.startTimer();
        String json = gson.toJson(classUC);
        long serializationTime = MainGson.endTimer(startSerialization);

        int byteSize = json.getBytes().length;

        long startDeserialization = MainGson.startTimer();
        ClassUC classUCdeserialized =  gson.fromJson(json,ClassUC.class);
        long deserializationTime = MainGson.endTimer(startDeserialization);

        // Benchmark times
        return new BenchmarkTimes(initializerTime, serializationTime, deserializationTime, byteSize);
    }
}
