package classuc;

import classuc.TypeContact;

public class Contact {

    private final String number;
    private final TypeContact type;

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
