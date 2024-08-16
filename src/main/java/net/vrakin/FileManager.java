package net.vrakin;

import java.io.File;
import java.util.Scanner;

public class FileManager {

    public static final int KILO = 1024;
    public static final int MEGA = 1048576;

    public static void viewFileList() {
        System.out.println("Enter a directory name:");
        Scanner in = new Scanner(System.in);
        String dir = in.nextLine();
        File file = new File(dir);
        if (!file.exists()) {
            System.out.println("Directory does not exist");
            return;
        }
        if (!file.isDirectory()) {
            System.out.println("Not a directory");
            return;
        }

        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                System.out.println(f.getName());
            }
        }
    }

    public static void sizeFile() {
        System.out.println("Enter a file name:");
        Scanner in = new Scanner(System.in);
        String filename = in.nextLine();
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }

        int size = (int) file.length();

        System.out.print("File size is ");
        if (size < KILO) {
            System.out.println(size + " bytes");
        }else if ((size > KILO) && (size <= MEGA)) {
            System.out.println(size/KILO + " KB");
        }else if ((size >= MEGA)) {
            System.out.println(size/MEGA + " MB");
        }
    }
}
