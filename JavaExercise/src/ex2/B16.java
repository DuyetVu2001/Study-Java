package ex2;

import java.util.Scanner;

public class B16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        input = scanner.nextLine();
        String[] s = input.split(" ");

        int index = 0;
        int lenMax = 0;

        for (int i = 0; i < s.length; i++) {
            if (s[i].length() > lenMax) {
                lenMax = s[i].length();
                index = i;
            }
        }

        System.out.println("Tu: \"" + s[index] + "\" dai nhat." +
                "\nTai vi tri thu: " + (index + 1) +
                "\nCo do dai: " + lenMax);

    }
}
