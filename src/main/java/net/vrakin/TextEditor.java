package net.vrakin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class TextEditor {
    public static void start()
    {
        System.out.println( "This text editor. Enter a code next actions:" );

        Scanner in = new Scanner(System.in);
        int choice = -1;

        while (choice != 0){
            System.out.println( "1 - create text file" );
            System.out.println( "2 - view text file" );
            System.out.println( "3 - edit text file" );
            System.out.println( "4 - remove file" );
            System.out.println( "0 - exit the program" );
            if (in.hasNextInt()){
                choice = in.nextInt();
            }else {
                System.out.println("Invalid choice");
                choice = 0;
            }
            switch(choice) {
                case 1 -> {
                    System.out.println("Enter file name");
                    String fileName = in.next();
                    System.out.println("Enter text for new file. For exit enter \"q\"");
                    saveFile(in, fileName);
                }
                case 2 -> {
                    in.nextLine();
                    System.out.println("Enter file name");
                    String filename = in.nextLine();
                    view(filename);
                }
                case 3 -> {

                    in.nextLine();
                    System.out.println("Enter file name");
                    String filename = in.nextLine();
                    view(filename);

                    System.out.println("Enter new text");
                    saveFile(in, filename);
                    choice = -1;
                }
                case 4 -> {
                    in.nextLine();
                    System.out.println("Enter file name");
                    File file = new File(in.nextLine());
                    if (file.exists() && !file.isDirectory()){
                        if (file.delete()){
                            System.out.println("File deleted successfully");
                        }
                    }else{
                        System.out.println("File not found or it is a directory");
                    }
                }
            }
        }
    }

    private static void view(String filename) {

        System.out.println("Text from file: " + filename);
        File file = new File(filename);
        if (file.exists()){
            try (Scanner sc = new Scanner(new File(filename))) {
                while (sc.hasNextLine()) {
                    System.out.println(sc.nextLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void saveFile(Scanner in, String filename) {
        String text = "-";
        StringBuilder sb = new StringBuilder();
        while (!text.equals("q")){
            text = in.nextLine();
            if (!text.equals("q")){
                sb.append(text).append(System.lineSeparator());
            }
        }

        try(PrintWriter pw = new PrintWriter(new PrintWriter(filename))){
            pw.println(sb);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void saveArray() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter count rows of array");
        int row = in.nextInt();
        System.out.println("Enter count columns of array");
        int col = in.nextInt();
        int[][] array = new int[row][col];
        for (int i = 0; i < row; i++) {
            System.out.println("Enter row " + (i + 1) + " of array");
            for (int j = 0; j < col; j++) {
                array[i][j] = in.nextInt();
            }
        }
        System.out.println("Enter filename for save array");
        String filename = in.nextLine();
        File file = new File(filename);

        try(PrintWriter pw = new PrintWriter(file)){
            pw.println(Arrays.deepToString(array));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
