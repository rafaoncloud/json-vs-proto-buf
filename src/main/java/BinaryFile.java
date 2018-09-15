import model.ClassUC;

import java.io.*;

public class BinaryFile {

    private static final String PATH = "Binary_classUC.txt";

    public static void save(ClassUC stu)
    {
        try (FileOutputStream fos = new FileOutputStream(PATH);

             ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(stu);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ClassUC read()
    {

        ClassUC classUc = null;

        try (FileInputStream fis = new FileInputStream(PATH); ObjectInputStream ois = new ObjectInputStream(fis);) {

            classUc = (ClassUC) ois.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return classUc;
    }
}
