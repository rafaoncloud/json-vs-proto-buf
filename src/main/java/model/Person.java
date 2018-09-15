package model;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Person {
    @XmlAttribute
    private final int id;
    @XmlElement
    private final String name;
    @XmlElement
    private final String email;
    @XmlElement
    private List<Contact> contacts;

    public Person(int id, String name, String email, List<Contact> contacts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contacts = contacts;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
