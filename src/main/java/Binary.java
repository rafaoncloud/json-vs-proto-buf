import model.*;

import java.io.*;
import java.util.Arrays;

public class Binary {

    public static  void run(ClassUC classUC)
    {
        System.out.println("Class Name: " + classUC.getName());
        long startTime = System.nanoTime();
        byte[] stream = serialize(classUC);
        long sDuration = (System.nanoTime() - startTime);


        long startSTime = System.nanoTime();
        ClassUC newClassUC = Deserializes(stream);
        long dDuration = (System.nanoTime() - startSTime);

        System.out.println("Serialize duration " + sDuration + " milliseconds");
        System.out.println("Deserializes duration " + dDuration + " milliseconds");

    }

    public static byte[] serialize(ClassUC classUC)
    {
        byte[] stream = null;

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos);) {
            oos.writeObject(classUC);
            stream = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stream;
    }

    public static ClassUC Deserializes(byte[] stream)
    {
        ClassUC classUC = null;

        try (ByteArrayInputStream bais = new ByteArrayInputStream(stream);
             ObjectInputStream ois = new ObjectInputStream(bais);) {
            classUC = (ClassUC) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return classUC;
    }
}
