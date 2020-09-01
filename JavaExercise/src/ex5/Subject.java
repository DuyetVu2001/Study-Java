package ex5;

/**
 * mã môn học, tên môn học, số tiết, số tín chỉ(>= 1 và <=
 * 4), số bài kiểm tra (> 1 && < 5), người dạy. Môn học có thể thực hiện các hành
 * động như cung cấp đầy đủ thông tin bản thân, có các constructor, getter/setter
 * tương ứng các thuộ
 */
public class Subject {
    private String subjectId;
    private String subjectName;
    private int lesson;
    private int numberOfCredits;
    private int numberOfTests;
    private String teacher;

    public Subject() {
    }

    public Subject(String subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public Subject(String subjectId, String subjectName, int lesson) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.lesson = lesson;
    }

    public Subject(String subjectId, String subjectName, int lesson, int numberOfCredits) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.lesson = lesson;
        this.numberOfCredits = numberOfCredits;
    }

    public Subject(String subjectId, String subjectName, int lesson, int numberOfCredits, int numberOfTests) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.lesson = lesson;
        this.numberOfCredits = numberOfCredits;
        this.numberOfTests = numberOfTests;
    }

    public Subject(String subjectId, String subjectName, int lesson, int numberOfCredits, int numberOfTests, String teacher) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.lesson = lesson;
        this.numberOfCredits = numberOfCredits;
        this.numberOfTests = numberOfTests;
        this.teacher = teacher;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getLesson() {
        return lesson;
    }

    public void setLesson(int lesson) {
        this.lesson = lesson;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public int getNumberOfTests() {
        return numberOfTests;
    }

    public void setNumberOfTests(int numberOfTests) {
        this.numberOfTests = numberOfTests;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId='" + subjectId + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", lesson=" + lesson +
                ", numberOfCredits=" + numberOfCredits +
                ", numberOfTests=" + numberOfTests +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}
