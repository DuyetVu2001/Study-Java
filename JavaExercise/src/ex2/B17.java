package ex2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class B17 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\NgocDuyet-PC\\IdeaProjects\\JavaExercise\\src\\Theory\\input.txt");
        FileWriter fileWriter = new FileWriter("C:\\Users\\NgocDuyet-PC\\IdeaProjects\\JavaExercise\\src\\Theory\\output.txt");
        Scanner scanner = new Scanner(file);
        String name = scanner.nextLine();

        name = name.trim();
        String[] names = name.split(" ");
        StringBuilder builder = new StringBuilder();
        builder.append(names[names.length - 1]);
        builder.append(" ");
        builder.append(names[0] + " ");

        for (int i = 1; i < names.length - 1; i++) {
            if (names[i].length() != 0) {
                builder.append(names[i] + " ");
            }
        }

        name = builder.toString();
        fileWriter.write(name);
        System.out.println(name);
        fileWriter.close();
    }
}
