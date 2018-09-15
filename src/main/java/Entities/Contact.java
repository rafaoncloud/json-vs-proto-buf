package Entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Contact")
public class Contact {
    @XmlAttribute
    private String number;
    @XmlElement
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
