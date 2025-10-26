// Stage 2: The Model
// Yeh class ek 'blueprint' hai. Iska object student data ko hold karega.
public class Student {

    // Fields to hold student data
    private String fullName;
    private String studentId;
    private String email;
    private String phone;

    // Constructor to create a new Student object
    public Student(String fullName, String studentId, String email, String phone) {
        this.fullName = fullName;
        this.studentId = studentId;
        this.email = email;
        this.phone = phone;
    }

    // 'Getter' methods to get the data
    public String getFullName() {
        return fullName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}

