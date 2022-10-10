import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class gameWord {

    private static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    private static Scanner in = new Scanner(System.in);
    private static char[] guessword ;
    private static char[] userWords;
    private static final int SIZEFIELD = 15;

    public static void startGame() {
        guessword = arrayWord();
        userWords = emptyfield();
        printChar(guessword);
        System.out.println();
        printCharField(userWords);
        System.out.println();
        while (!checkWord(inputUser())){
            printCharField(userWords);
            System.out.println();
        }
    }

    private static boolean checkWord(char[] user){
        if (Arrays.equals(guessword,user)){
            System.arraycopy(guessword,0, userWords, 0, guessword.length);
            printChar(userWords);
            System.out.println();
            System.out.println("You Win. End game");
            return true;
        }else {
            for (int i = 0; i < guessword.length; i++) {
                for (int j = 0; j < user.length; j++) {
                    if (guessword[i] == user[j] ){
                        userWords[i] = user[j];
                    }
                }
            }if (Arrays.equals(guessword,userWords)){
                printChar(userWords);
                System.out.println();
                System.out.println("You win. End game");
                return true;
            }
            System.out.println("try again.");
            return false;
        }
    }

    private static char[] inputUser(){
        System.out.println("Please, enter you word: ");
        char[] userWord = in.next().toCharArray();
        return userWord;
    }

    private static char[] arrayWord(){
        Random random = new Random() ;
        int index = random.nextInt(words.length - 1);
        String string = words[index];
        char[] word = string.toCharArray();
        return word;
    }

    private static char[] emptyfield(){
        char[] field = new char[guessword.length];
        for (int i = 0; i < field.length; i++) {
            field[i] = '#';
        }
        return field;
    }
    private static void printChar(char[] chars){
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
    }

    private static void printCharField(char[] chars){
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
        for (int i = 0; i < SIZEFIELD - chars.length; i++) {
            System.out.print("#");
        }
    }






}
