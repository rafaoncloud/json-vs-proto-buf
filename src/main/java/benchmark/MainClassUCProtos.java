package benchmark;

import classuc.BenchmarkTimes;
import classuc.ClassUC;
import classuc.MainGson;

import java.io.*;

public class MainClassUCProtos {


    public static int MAX_EXPONENT = 16;

    public static int NUM_STUDENTS;
    public static final String INITIAL_PATH = "binary-v2/number-students-";
    public static final String PATH_CSV = "binary-v2/results-v2.csv";
    public static String FILE_PATH; // O/I the Protocol Buffers Stream

    public static void main(String[] args) {

        int exponent = 0;
        NUM_STUDENTS = (int) Math.pow(2, exponent);
        FILE_PATH = INITIAL_PATH + NUM_STUDENTS + ".txt";

        initCSV(); // Fill column headers

        while(exponent <= MAX_EXPONENT) {
            for (int i = 0; i < 10; i++) {
                FILE_PATH = INITIAL_PATH + NUM_STUDENTS + "-rep-" + (i+1) + ".txt";
                // Create Object to serialize and deserialize
                ClassUCProtos.ClassUC classUC = ClassUCProtosBuilders.buildClassUC(NUM_STUDENTS);

                /*
                // Write Time
                long startTimeWrite = startTimer();
                write(classUC);
                long writeTime = endTimer(startTimeWrite);
                System.out.println(writeTime + "write");

                // Read Time
                long startTimeRead = startTimer();
                read();
                long readTime = endTimer(startTimeRead);
                */

                BenchmarkTimes benchmarkTimes = MainClassUCProtos.writeRead(classUC,PATH_CSV);

                //Print to CSV
                writeCSV(NUM_STUDENTS,i + 1,
                        benchmarkTimes.getInitialization(),
                        benchmarkTimes.getSerialization(),
                        benchmarkTimes.getDeserialization(),
                        benchmarkTimes.getSerializedSize());
            }
            exponent++;
            NUM_STUDENTS = (int) Math.pow(2, exponent);
            FILE_PATH = INITIAL_PATH + NUM_STUDENTS + ".txt";
        }
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

    public static ClassUCProtos.ClassUC read(){
        ClassUCProtos.ClassUC readClassUC = null;

        try {
            readClassUC = ClassUCProtos.ClassUC.parseFrom(new FileInputStream(FILE_PATH));
            //System.out.println(readClassUC.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return readClassUC;
    }

    public static void write(ClassUCProtos.ClassUC classUC){
        // Write to a file
        try {
            FileOutputStream out = new FileOutputStream(FILE_PATH);
            classUC.writeTo(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BenchmarkTimes writeRead(ClassUCProtos.ClassUC classUC, String path){

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = null;
        int serializedObjectSize = 0;
        long serializeTime = 0;
        long deserializeTime = 0;

        try {
            long serializeStart = MainGson.startTimer();
            // Serialization
            classUC.writeTo(byteArrayOutputStream);
            serializeTime = endTimer(serializeStart);

            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            serializedObjectSize = byteArrayOutputStream.toByteArray().length;


            long deserializeStart = MainGson.startTimer();
            // Deserialization
            ClassUCProtos.ClassUC classUCdes =  ClassUCProtos.ClassUC.parseFrom(byteArrayInputStream);
            deserializeTime = endTimer(deserializeStart);

            byteArrayInputStream.close();
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new BenchmarkTimes(0,serializeTime,deserializeTime,serializedObjectSize);
    }
}
