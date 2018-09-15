package Entities;

import java.util.List;

public class Student extends Person {

    public Student(int id, String name, String email, List<Contact> contacts) {
        super(id, name, email, contacts);
    }
}
