package benchmark;

import java.io.*;

public class MainClassUCProtos {


    public static int MAX_EXPONENT = 16;

    public static int NUM_STUDENTS;
    public static final String INITIAL_PATH = "binary/number-students-";
    public static final String PATH_CSV = "binary/results.csv";
    public static String FILE_PATH; // O/I the Protocol Buffers Stream

    public static void main(String[] args) {

        int exponent = 0;
        NUM_STUDENTS = (int) Math.pow(2, exponent);
        FILE_PATH = INITIAL_PATH + NUM_STUDENTS + ".txt";

        while(exponent <= MAX_EXPONENT) {
            for (int i = 0; i < 10; i++) {
                FILE_PATH = INITIAL_PATH + NUM_STUDENTS + "-rep-" + (i+1) + ".txt";
                // Create Object to serialize and deserialize
                ClassUCProtos.ClassUC classUC = ClassUCProtosBuilders.buildClassUC(NUM_STUDENTS);

                // Write Time
                long startTimeWrite = startTimer();
                write(classUC);
                long writeTime = endTimer(startTimeWrite);
                System.out.println(writeTime + "write");

                // Read Time
                long startTimeRead = startTimer();
                read();
                long readTime = endTimer(startTimeRead);
                System.out.println(readTime + "read");

                //Print to CSV
                writeCSV(NUM_STUDENTS,i + 1,writeTime,readTime);
            }
            exponent++;
            NUM_STUDENTS = (int) Math.pow(2, exponent);
            FILE_PATH = INITIAL_PATH + NUM_STUDENTS + ".txt";
        }
    }

    public static void writeCSV(int numStudents,int repetition, long writeTime, long readTime){

        try {
            FileWriter pw = new FileWriter(new File(PATH_CSV), true);
            StringBuilder sb = new StringBuilder();
            sb.append(numStudents);
            sb.append(';');
            sb.append(repetition);
            sb.append(';');
            sb.append(writeTime);
            sb.append(';');
            sb.append(readTime);
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
}
