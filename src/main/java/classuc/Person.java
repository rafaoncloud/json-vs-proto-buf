package classuc;

import java.util.List;

public class Person {

    private final int id;
    private final String name;
    private final String email;
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
