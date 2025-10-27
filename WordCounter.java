/*
The WordCounter class
You will write this class which is responsible for:

-   a method called processText that expects a StringBuffer as argument (the text), 
        and a String stopword, and counts the number of words in that text through that stopword. 
    If the stopword is not found the text, the method will raise an InvalidStopwordException. 
    If the stopword is null, your method will count all words in the file. The methods returns the integer word count, 
        unless the count was less than five, it which case it raises a TooSmallText exception (regardless of whether or not it found the stopword).
    For example, if there are only three words in the text, your code will raise the exception.
-   a method called processFile that expects a String path as an argument, and converts the contents of the file to a StringBuffer, which it returns. 
    If the file cannot be opened, it should prompt the user to re-enter the filename until they enter a file that can be opened. 
    If the file is empty, this method should raise an EmptyFileException that contains the file’s path in its message.
-   a main method that asks the user to choose to process a file with option 1, or text with option 2. 
    If the user enters an invalid option, allow them to choose again until they have a correct option. 
    Both of these items will be available as the first command line argument. 
    It then checks to see if there is a second command line argument specifying a stopword. 
    The method then calls the methods above to process the text, and outputs the number of words it counted. 
    If the file was empty, this method will display the message of the exception raised (which includes the path of the file),
        and then continue processing with an empty string in place of the contents of the file (note that this will raise a TooSmallText exception later). 
    Note that the path of the empty file may not be the same path that was specified in the command line by the time this exception is raised. 
    If the stopword wasn’t found in the text, allow the user one chance to re-specify the stopword and try to process the text again. 
    If they enter another stopword that can’t be found, report that to the user.
*/


/*
InputMismatchException - if the next token does not match the Integer regular expression, or is out of range
NoSuchElementException - if input is exhausted
IllegalStateException - if this scanner is closed
*/

import java.util.Scanner;

public class WordCounter {
    public static int processText(StringBuffer buffer, String stopword) throws InvalidStopwordException, TooSmallText{
        Scanner sc = new Scanner()
    }

    public static void main(String[] args) {

        boolean inputCheck = true;
        int option = 0;

        while(inputCheck){
            try(Scanner sc = new Scanner(System.in)){
                System.out.println("Select option [1, 2]: ");   // check options, throw wrong option exception, while loop
                option = scanner.nextInt();
                scanner.close()
            } catch (InputMismatchException e){
                System.out.println("Wrong input");
                continue;
            } catch (NoSuchElementException e){
                System.out.println("input is exhausted");
                continue;
            } catch (NoSuchElementException e){
                System.out.println("scanner is closed");
                continue;
            }
            inputCheck = false;
        }
        String stopword = null;
        if(args.length == 2) stopword = args[1];
        if(option == 1){
            // file
            String filepath = args[0];
        } else {
            // text
            String text = args[0];
        }
    }
}