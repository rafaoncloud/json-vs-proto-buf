package classuc;

import benchmark.ClassUCProtos;
import benchmark.ClassUCProtosBuilders;
import benchmark.MainClassUCProtos;
import classuc.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainGson {

    public static int MAX_EXPONENT = 16;

    public static int NUM_STUDENTS;
    public static final String INITIAL_PATH = "textual-v2/number-students-";
    public static final String PATH_CSV = "textual-v2/results-v2.csv";
    public static String FILE_PATH; // O/I the Protocol Buffers Stream

    public static void main(String[] args) {

        int exponent = 0;
        NUM_STUDENTS = (int) Math.pow(2, exponent);
        FILE_PATH = INITIAL_PATH + NUM_STUDENTS + ".txt";

        initCSV(); // Fill column headers

        // Read Initialization Time
        ClassUC firstClassUCtoSerialize = ClassUCBuilders.buildClassUC(NUM_STUDENTS);
        BenchmarkTimes benchmarkTimesF = JsonFile.writeRead(firstClassUCtoSerialize,PATH_CSV);
        writeCSV(1,-1,
                benchmarkTimesF.getInitialization(),
                benchmarkTimesF.getSerialization(),
                benchmarkTimesF.getDeserialization(),
                benchmarkTimesF.getSerializedSize());

        while(exponent <= MAX_EXPONENT) {
            for (int i = 0; i < 10; i++) {
                FILE_PATH = INITIAL_PATH + NUM_STUDENTS + "-rep-" + (i+1) + ".txt";
                // Create Object to serialize and deserialize
                ClassUC classUC = ClassUCBuilders.buildClassUC(NUM_STUDENTS);

                /*
                // Write Time
                long startTimeWrite = startTimer();
                JsonFile.write(classUC,FILE_PATH);
                long writeTime = endTimer(startTimeWrite);
                System.out.println(writeTime + "write");

                // Read Time
                long startTimeRead = startTimer();
                ClassUC classUCread = JsonFile.read(FILE_PATH);
                long readTime = endTimer(startTimeRead);
                System.out.println(readTime + "read");
                */

                BenchmarkTimes benchmarkTimes = JsonFile.writeRead(classUC,FILE_PATH);

                //Print to CSV
                writeCSV(NUM_STUDENTS,i + 1,benchmarkTimes.getInitialization(),benchmarkTimes.getSerialization(),benchmarkTimes.getDeserialization(),benchmarkTimes.getSerializedSize());
            }
            exponent++;
            NUM_STUDENTS = (int) Math.pow(2, exponent);
            FILE_PATH = INITIAL_PATH + NUM_STUDENTS + ".txt";
        }

        /*
        String jsonRepresentation = buildJSON(classUC);
        //ClassUC test = buildClassUCfromJSON(jsonRepresentation);
        //System.out.println(jsonRepresentation);
        //printPrettyJSON(test);

        //printPrettyJSON(jsonRepresentation);

        JsonFile.write(jsonRepresentation);
        ClassUC classUCread = JsonFile.read();
        // Print to test the result
        printPrettyJSON(classUCread);
        */

    }



    public static String buildJSON(ClassUC classUC){

        Gson json = new Gson();
        String jsonRepresentation = json.toJson(classUC);

        return jsonRepresentation;

    }

    public static ClassUC buildClassUCfromJSON(String JSON){

        Gson gson = new Gson();
        ClassUC classUC = gson.fromJson(JSON, ClassUC.class);
        return classUC;
    }

    public static void printPrettyJSON(String jsonRepresentation){

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String toPrint = gson.toJson(jsonRepresentation);
        System.out.println(toPrint);
    }

    public static void printPrettyJSON(ClassUC classUC){

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String toPrint = gson.toJson(classUC);
        System.out.println(toPrint);
    }

    public static void receiveJSON(){

    }

    public static void writeCSV(int numStudents,int repetition,long initializerTime, long serializeTime, long deserializeTime, int serializedSize){

        try {
            FileWriter pw = new FileWriter(new File(PATH_CSV), true); // Append
            StringBuilder sb = new StringBuilder();
            sb.append(numStudents);
            sb.append(';');
            sb.append(repetition);
            sb.append(';');
            sb.append(initializerTime);
            sb.append(';');
            sb.append(serializeTime);
            sb.append(';');
            sb.append(deserializeTime);
            sb.append(';');
            sb.append(serializedSize);
            sb.append('\n');

            //pw.print(sb.toString());
            pw.write(sb.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initCSV(){

        try {
            FileWriter pw = new FileWriter(new File(PATH_CSV), true); // Append
            StringBuilder sb = new StringBuilder();
            sb.append("Num Students");
            sb.append(';');
            sb.append("Repetitions");
            sb.append(';');
            sb.append("Initializer Time");
            sb.append(';');
            sb.append("Serialize Time");
            sb.append(';');
            sb.append("Deserialize Time");
            sb.append(';');
            sb.append("Serialized File Size");
            sb.append('\n');

            //pw.print(sb.toString());
            pw.write(sb.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static long startTimer(){
        return System.nanoTime();
    }

    // Return Time time proceeded
    public static long endTimer(long startTime){
        return System.nanoTime() - startTime;
    }
}
