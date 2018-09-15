package Entities;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Student")
public class Student extends Person {

    public Student(int id, String name, String email, List<Contact> contacts) {
        super(id, name, email, contacts);
    }
}
