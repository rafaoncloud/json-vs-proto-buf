package classuc;

import benchmark.ClassUCProtos;

import java.util.ArrayList;
import java.util.List;

public class ClassUCBuilders {

    // Build ClassUC giving the number of students
    // Each person has 2 contacts
    // The string attributes have 10 characters
    public static ClassUC buildClassUC(int numStudents){

        ClassUC classUC = new ClassUC();

        classUC.setName("CLASSCLASS");
        classUC.setDirector(buildPerson(0));

        List<Person> students = new ArrayList<>();
        for(int i = 0; i < numStudents; i++){
            students.add(buildPerson(i + 1));
        }
        classUC.setStudents(students);

        return classUC;
    }

    public static Person buildPerson(int id){

        String number = String.valueOf(id);
        String name = "", email = "";

        // Keep the 10 characters per String
        if(number.length() == 1){
            name = "ucucucucu" + number;
            email = number + "@ucucucuc";
        }else if(number.length() == 2){
            name = "ucucucuc" + number;
            email = number + "@ucucucu";
        }else if(number.length() == 3){
            email = number + "@ucucuc";
        }else if(number.length() == 4){
            name = "ucucucu" + number;
            email = number + "@ucucu";
        }else if(number.length() == 5){
            name = "ucucuc" + number;
            email = number + "@ucuc";
        }else{
            throw new RuntimeException("Too Large.");
        }

        List<Contact> contacts = new ArrayList<>();
        contacts.add(buildContact());
        contacts.add(buildContact());

        Person person = new Person(id,name, email, contacts);

        return person;
    }

    public static Contact buildContact(){
        Contact contact = new Contact("+919191919",TypeContact.HOME);
        return contact;
    }
}
