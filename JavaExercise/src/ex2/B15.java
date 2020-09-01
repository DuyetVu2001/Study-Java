package ex2;

public class B15 {
    public static void main(String[] args) {
        String s = "HoC    HHOC  NUa   HOC  MAI          ";

        System.out.println("Original String: " + s);

        chuanHoa(s);
    }

    private static void chuanHoa(String s) {
        s = s.toLowerCase();
        String[] ss = s.split(" ");
        String s2 = "";

        for (int i = 0; i < ss.length; i++) {
            String s1 = "";
            if (ss[i].length() != 0) {
                s1 += Character.toUpperCase(ss[i].charAt(0));
                if (ss[i].length() > 1) s1 += ss[i].substring(1);
                s2 += s1;
                if (i < ss.length) s2 += " ";
            }
        }
        if (s2.charAt(s2.length() - 1) == ' ') s2 += "\b";
        System.out.println("Xau sau chuan hoa: " + s2);
    }
}
