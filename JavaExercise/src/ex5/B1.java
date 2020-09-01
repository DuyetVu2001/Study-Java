package ex5;

public class B1 {
    public static void main(String[] args) {
        Student student1 = new Student("A4275", "Tran Van Thai", "Mong Cai", "thaidui@gmail.com",
                "0379446167");
        student1.goToSchool();
        student1.doHomework("Math");
        student1.payFee("Math", "350000");
        System.out.println(student1.doFinalTest("Math"));
        System.out.println(student1);

        student1.setStudentID("ABC123");
        System.out.println(student1.getStudentID());
    }
}
