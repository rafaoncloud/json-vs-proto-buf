package Entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="ClassUC")
@XmlAccessorType (XmlAccessType.FIELD)
public class ClassUC {

    private static final long serialVersionUID = 8999999999999999999L;

    private String name;
    private List<Student> students;
    private Director director;

    public ClassUC(String name, List<Student> students, Director director) {
        this.name = name;
        this.students = students;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Director getDirector() {
        return director;
    }
}
