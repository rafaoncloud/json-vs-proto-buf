package Entities;



public class Contact {

    private String number;

    private TypeContact type;

    public Contact(String number, TypeContact type) {
        this.number = number;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public TypeContact getType() {
        return type;
    }
}
