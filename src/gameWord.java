import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class gameWord {
    private static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    private static Scanner in = new Scanner(System.in);
    private static char[] guessword ;
    private static char[] userWords;
    private static int size;

    public static void startGame() {
        guessword = arrayWord();
        size = guessword.length;
        userWords = emptyfield();
        printChar(guessword);
        System.out.println();
        printChar(userWords);
        System.out.println();
        while (!checkWord(inputUser())){
            printChar(userWords);
            System.out.println();
        }
        printChar(userWords);
    }

    private static boolean checkWord(char[] user){
        if (Arrays.equals(guessword,user)){
            System.arraycopy(guessword,0, userWords, 0, guessword.length);
            return true;
        }else {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < user.length; j++) {
                    if (guessword[i] == user[j] ){
                        userWords[i] = user[j];
                    }
                }
            }if (Arrays.equals(guessword,userWords)){
                return true;
            }
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
// метод запроса слова, методсравнения
    private static char[] emptyfield(){
        char[] field = new char[size];
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






}
