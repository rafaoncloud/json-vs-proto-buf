package classuc;

import java.util.List;

public class ClassUC {

    private String name;
    private List<Person> students;
    private Person director;

    public ClassUC(String name, List<Person> students, Person director) {
        this.name = name;
        this.students = students;
        this.director = director;
    }

    public ClassUC(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getStudents() {
        return students;
    }

    public void setStudents(List<Person> students) {
        this.students = students;
    }

    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) {
        this.director = director;
    }
}
