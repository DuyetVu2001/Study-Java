package ex5;

public class B2 {
    public static void main(String[] args) {
        Subject subject = new Subject("ABC123", "Math", 4, 3, 2,
                "Co Hoa");
        System.out.println("Mon hoc: " + subject.getSubjectName());
        System.out.println(subject);
    }
}