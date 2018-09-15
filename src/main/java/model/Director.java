package model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="Director")
public class Director extends Person {

    public Director(int id, String name, String email, List<Contact> contacts) {
        super(id, name, email, contacts);
    }
}
