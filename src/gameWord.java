import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class gameWord {
    //передаём приложению массив со словами
    private static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    private static Scanner in = new Scanner(System.in); // создаём и инициализируем экземпляр сканера
    private static char[] guessword ; // создаём массив из символов для загаданного слова
    private static char[] userWords; // создаём массив из символов для пользовательского слова
    private static final int SIZEFIELD = 15; // Задаём размер игрового поля

    public static void startGame() {
        guessword = arrayWord();
        emptyfield();
        printChar(guessword); // для отладки. заменить на приветствие
        System.out.println();
        printCharField(userWords);
        System.out.println();
        while (!checkWord(inputUser())){ //играем до тех пор, пока checkWord(inputUser()) не даст ответ true
            printCharField(userWords);
            System.out.println();
        }
    }

    private static boolean checkWord(char[] user){ // проверка ответов
        if (Arrays.equals(guessword,user)){ // сравниваем массив из загаданного слова с массивом введеным пользователем
            System.arraycopy(guessword,0, userWords, 0, guessword.length); //если совпало - копирум правильный ответ в игровой массив и заканчиваем игру
            printChar(userWords);
            System.out.println();
            System.out.println("You Win. End game");
            return true;
        }else {
            for (int i = 0; i < guessword.length; i++) {
                for (int j = 0; j < user.length; j++) {
                    if (guessword[i] == user[j] ){ //сравниваем содержимое массивов
                        userWords[i] = user[j]; // то что совпало - записываем в соответствующие ячейки игрового поля
                    }
                }
            }if (Arrays.equals(guessword,userWords)){ // не забываем проверять - если мы собрали все загаданное слово -  поздавлям и заканчиваем игру
                printChar(userWords);
                System.out.println();
                System.out.println("You win. End game");
                return true;
            }
            System.out.println("try again.");
            return false;// продолжаем
        }
    }

    private static char[] inputUser(){ //пользовательский ввод
        System.out.println("Please, enter you word: ");
        char[] userWord = in.next().toCharArray(); // читаем стоку в символьный массив до первого пробела
        return userWord; // возвращаем массив
    }

    private static char[] arrayWord(){
        Random random = new Random() ;
        int index = random.nextInt(words.length - 1); // случаёным образом выбираем индекс из "длинна массива слов"-1
        String string = words[index]; // вытаскиваем случайное слово из массива в переменную типа String
        char[] word = string.toCharArray(); // используя встроенный в Sting метод - передаём строку в символьный массив
        return word; //возвращаем массив символов
    }

    private static void emptyfield(){
        userWords = new char[guessword.length]; // инициализируем массив
        for (int i = 0; i < guessword.length; i++) { //забиваем его "#"
            userWords[i] = '#';
        }
    }
    private static void printChar(char[] chars){ // печать обычного символьного массива
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
    }

    private static void printCharField(char[] chars){ // печать игрового поля
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
        for (int i = 0; i < SIZEFIELD - chars.length; i++) { // любое количестов символов добиваем до 15 "#"
            System.out.print("#");
        }
    }






}
