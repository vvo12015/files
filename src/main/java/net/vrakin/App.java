package net.vrakin;

import java.util.Scanner;

/**
 * Files
 *
 */
public class App 
{
    public static void main(String[] args) {
        System.out.println( "This program is for work of file. Enter a code next actions:" );


        Scanner in = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println( "1 - text editor" );
            System.out.println( "2 - save array" );
            System.out.println( "3 - file list of directory" );
            System.out.println( "4 - view file size" );
            System.out.println( "0 - exit program" );

            choice = in.nextInt();
            switch (choice) {
                case 1 -> TextEditor.start();
                case 2 -> TextEditor.saveArray();
                case 3 -> FileManager.viewFileList();
                case 4 -> FileManager.sizeFile();
            }
        }
    }
}

