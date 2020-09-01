package ex2;

public class B13 {
    public static void main(String[] args) {
        for (int i = 100000000; i < 1000000000; i++) {
            if (isConverse(i + ""))
                System.out.println(i);
        }
    }

    public static boolean isConverse(String s) {
        String other;
        StringBuilder builder = new StringBuilder(s);
        other = builder.reverse().toString();

        return (s.compareTo(other) == 0);
    }
}
