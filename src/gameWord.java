import java.util.Random;

public class gameWord {
    private static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};


    public static void main(String[] args) {
        char[] guessword = arrayWord();
        printChar(guessword);
        System.out.println();
        emptyfield(guessword.length);


    }

    private static char[] arrayWord(){
        Random random = new Random() ;
        int index = random.nextInt(words.length - 1);
        String string = words[index];
        char[] word = string.toCharArray();
        return word;
    }
// метод запроса слова, методсравнения
    private static void emptyfield(int size){
        char[] field = new char[size];
        for (int i = 0; i < field.length; i++) {
            field[i] = '#';
        }
       printChar(field);
    }
    private static void printChar(char[] chars){
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
    }






}
