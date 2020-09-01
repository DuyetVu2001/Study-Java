package ex5;

/**
 * Thông tin về sinh viên gồm: họ đệm tên, địa chỉ, email, số điện thoại, mã
 * sinh viên(cả chữ và số, ví dụ B22DCCN175).
 * - Hành động của sinh viên gồm: đi học, làm bài tập, nộp học phí, làm bài kiểm
 * tra và cho biết thông tin đầy đủ của bản thân, các hàm tạo có và không có
 * tham số, các phương thức get/set.
 */
public class Student {
    private String studentID;
    private String fullName;
    private String address;
    private String email;
    private String phoneNumber;

    public void goToSchool() {
        System.out.println("I'm going to school...");
    }

    public void doHomework(String subject) {
        System.out.println("I am doing my " + subject + " homework.");
    }

    public void payFee(String subject, String mount) {
        System.out.println("Pay fee for: " + subject + ", fee: " + mount);
    }

    public boolean doFinalTest(String subject) {
        if (subject != null && subject.toLowerCase().compareTo("math") == 0) {
            return true;
        }
        return false;
    }

    public Student() {
    }

    public Student(String studentID) {
        this.studentID = studentID;
    }

    public Student(String studentID, String fullName) {
        this(studentID);
        this.fullName = fullName;
    }

    public Student(String studentID, String fullName, String address) {
        this(studentID, fullName);
        this.address = address;
    }

    public Student(String studentID, String fullName, String address, String email) {
        this(studentID, fullName, address);
        this.email = email;
    }

    public Student(String studentID, String fullName, String address, String email, String phoneNumber) {
        this(studentID, fullName, address, email);
        this.phoneNumber = phoneNumber;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}