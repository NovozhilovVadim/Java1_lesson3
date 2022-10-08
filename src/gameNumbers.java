import java.util.Random;
import java.util.Scanner;

public class gameNumbers {
    /*
    startGame() - основная логика игры. В цикле, за состояние которого отвечает переменная "stop",
    выводятся диалоги, вызываются в определённой последовательности методы, описывающие функционал игры
    randomNumber() - Переменной хранящей цифру загаданную компьютером, случайным образом присваивается цифра
    из заданного диапозона.
    userNumber() - Пользователю предлогается ввести цифру и её значение присваивается соответствующей переменной
    checkNumber(int user, int computer) - Сравниваем загаданную и введённую цифру
    resultWin() -  в случае попеды поздравляем и спрашиваем играть ли дальше.
     */
    private static int user; // Хранит цифру пользователя вводимую с клавиатуры
    private static int computer; // Хранит загаданную компьтером случайню цифру из заданного диавпазона
    private static boolean stop = true; // переключатель состояния игры: игра продолжается пока stop = true
    private static Scanner in = new Scanner(System.in); // Экземпляр объекта отслеживающего ввод из консоли

    public static void startGame(){
        while (stop){ // основной цикл игры
            computer = randomNumber(); // загадываем число
            System.out.println("The computer guessed a number, try to guess it. " );
            for (int i = 0; i <= 5; i++) { // ограничиваем количество попыток
                userNumber(); // получаем цифру от пользователя
                if(checkNumber(user, computer)){ // сравниваем два значения - eсли  "true" - вызываем диалог победителя
                    if (!resultWin()){ // усли игрок не хочет продолжать игру "false" -
                        stop = false; // переводим переключатель в "false" и возвращаемся в основной цикл, который уже не перезапускается
                        break;
                    }else  break; // Если игрок хочет продолжить - возвращаемся в начало основного цикла
                }
            }
        }
    }

    private static boolean resultWin(){
        System.out.println("You WIN!");
        while (true){
            System.out.print("If you continue game - enter 1, " + "\n" + "If you end game - enter 2 : ");
            if (in.hasNextInt()){ // проверка соответствует ли введеное значение типу инт
                int temp = in.nextInt();
                if (temp == 1){
                    return true;
                }else if (temp == 2){
                    System.out.println("bay");
                    return false;
                }
            }else {
                System.out.println("You enter not number!!! Try again. ");
                in.skip(".*\n"); //сброс
            }
        }
    }

    private static int randomNumber(){
        Random random = new Random(); // экземпляр объекта возвращающего случаное число
        int number = random.nextInt(10); // не забываем указать диапозон. по умолчанию начинается с 0.
        return number;
    }

    private static int userNumber(){
        while (true){
            System.out.print("Please enter number of range 0-9: ");
            if (in.hasNextInt()){ // обязательно проверка соответствия типа.  иначе можем получить ошибку
                user = in.nextInt();
                if (user >= 0 && user <=9){ // провека диапозона
                    return user;
                }else {
                    System.out.println("Your number out of range!!! Try again. ");
                }
            }else {
                System.out.println("You enter not number!!! Try again. ");
                in.skip(".*\n");
            }
        }
    }

    private static boolean checkNumber(int user, int computer){
        if ( user < computer){
            System.out.println("Your number is small. Try again. ");
            return false;
        } else if (user > computer) {
            System.out.println("Your nuber is big. Try again. ");
            return false;
        }
        return true;
    }
}
