interface Student {

    public void name();
}

class StudentImp implements Student {

    @Override
    public void name() {
        System.out.println("working");
    }
}

interface Target {

    public void printName();
}

class AdaptorforStudent implements Target {

    Student student;

    public AdaptorforStudent(Student student) {
        this.student = student;
    }

    @Override
    public void printName() {
        student.name();
    }

}

public class AdapterDPDemo {

    public static void main(String args[]) {
        Student student = new StudentImp();
        Target st = new AdaptorforStudent(student);
        st.printName();
    }

}

