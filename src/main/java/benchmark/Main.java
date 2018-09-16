package benchmark;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static ClassUC classUC;

    public static void main(String[] args) {

        classUC = build();
        String jsonRepresentation = buildJSON(classUC);
        //ClassUC test = buildClassUCfromJSON(jsonRepresentation);
        //System.out.println(jsonRepresentation);
        //printPrettyJSON(test);

        //printPrettyJSON(jsonRepresentation);

        JsonFile.write(jsonRepresentation);
        ClassUC classUCread = JsonFile.read();
        // Print to test the result
        printPrettyJSON(classUCread);

    }

    public static ClassUC build(){

        Contact contact1 = new Contact("919191",TypeContact.MOBILE);
        Contact contact2 = new Contact("919191", TypeContact.MOBILE);
        Contact contact3 = new Contact("262262",TypeContact.HOME);
        Contact contact4 = new Contact("111111",TypeContact.HOME);
        Contact contact5 = new Contact("222222",TypeContact.WORK);
        Contact contact6 = new Contact("333333",TypeContact.WORK);

        List<Contact> contacts1 = new ArrayList<>();
        contacts1.add(contact5);
        contacts1.add(contact6);

        Person director = new Director(1,"Filipe Araujo","unknown@uc.portugal",contacts1);
        Person student1 = new Student(1, "Tony","tony@eu.com",contacts1);
        Person student2 = new Student(1,"Rafa","rafa@eu.com",contacts1);

        List<Student> students = new ArrayList<>();
        students.add((Student)student1);
        students.add((Student)student2);

        ClassUC classUC = new ClassUC("Systems Integration",students,(Director)director);

        return classUC;
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
}
