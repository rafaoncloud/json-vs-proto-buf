import Entities.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ClassUC classUC = build();

        //System.out.println("Json");
        //Json.run(classUC);

        System.out.println("Xml");
        Xml.run(classUC);

        //System.out.println("Binary");
        //Binary.run(classUC);

    }

    public static ClassUC build(){

        Contact contact1 = new Contact("919191", TypeContact.MOBILE);
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
}
