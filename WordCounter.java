import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.InputMismatchException;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.util.Scanner;

public class WordCounter {
    public static int processText(StringBuffer buffer, String stopword) throws InvalidStopwordException, TooSmallText{
        int count = 0;

        boolean invalidStopword = true;
        boolean allowRegardlessRule = false;

        Pattern regex = Pattern.compile("[A-Za-z0-9']+");
        Matcher regexMatcher = regex.matcher(buffer.toString());

        while (regexMatcher.find()) {
            String token = regexMatcher.group();
            count++;
            if (stopword != null && token.equalsIgnoreCase(stopword)) {
                invalidStopword = false;
                if(count<5 || allowRegardlessRule){
                    allowRegardlessRule = true;
                } else break;
            }
        }

        if (count < 5) throw new TooSmallText("Only found " + count + " words.");
        if (stopword != null && invalidStopword) throw new InvalidStopwordException("Couldn't find stopword: " + stopword);

        return count;
    }

    public static StringBuffer processFile(String filepath) throws EmptyFileException{
        Scanner sc = null;
        File file = null;

        while (true) {
            try {
                file = new File(filepath);
                sc = new Scanner(file);
                break;
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + filepath);
                System.out.print("Enter another file path: ");
                Scanner in = new Scanner(System.in);
                filepath = in.nextLine();   // flush 
            }
        }
        StringBuffer buffer = new StringBuffer();
        while (sc.hasNextLine()) buffer.append(sc.nextLine());
        sc.close();

        if (buffer.length() == 0) throw new EmptyFileException(file.getPath() + " was empty");

        return buffer;
    }

    public static void main(String[] args) {

        boolean inputCheck = true;
        int option = 0;

        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Select option [1, 2]: ");
                option = sc.nextInt();
                if (option == 1 || option == 2) break;
                System.out.println("Invalid option, try again.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, enter 1 or 2.");
                sc.nextLine();
            }
        }
        sc.close();

        
        String stopword = (args.length == 2) ? args[1] : null;
        StringBuffer buffer = null;

        try {
            buffer = (option == 1) ? processFile(args[0]) : new StringBuffer().append(args[0]);
        } catch (EmptyFileException e) {
            buffer = new StringBuffer("");
        }

        try {
            int result = processText(buffer, stopword);
            System.out.println("Found " + result + " words.");
        } catch (InvalidStopwordException e) {
            System.out.println(e.toString());
        } catch (TooSmallText e) {
            System.out.println(e.toString());
        }
    }
}