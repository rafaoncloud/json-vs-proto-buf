package Entities;

import java.util.List;

public class ClassUC {

    private static final long serialVersionUID = 8999999999999999999L;

    private final String name;
    private final List<Student> students;
    private final Director director;

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

