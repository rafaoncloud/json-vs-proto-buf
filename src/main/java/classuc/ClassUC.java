package classuc;

import classuc.Director;
import classuc.Student;

import java.util.List;

public class ClassUC {

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
