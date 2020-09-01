package ex2;

public class B17s {
    public static void main(String[] args) {
        String name = "   Vu     Ngoc     Duyet  ";
        name = name.trim();
        String[] names = name.split(" ");
        StringBuilder myName = new StringBuilder();
        myName.append(names[names.length - 1] + " ");
        myName.append(names[0] + " ");

        for (int i = 1; i < names.length - 1; i++) {
            if (names[i].length() != 0) {
                myName.append(names[i] + " ");
            }
        }

        System.out.println(myName);
    }
}
