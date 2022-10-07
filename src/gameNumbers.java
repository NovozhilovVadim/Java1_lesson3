import java.util.Random;
import java.util.Scanner;

public class gameNumbers {
    private static int user;
    private static int computer;

    public static void main(String[] args) {
        computer = randomNumber();
        System.out.println(computer);
        userNumber();
        System.out.println(user);
        if(checkNumber(user, computer)){
            System.out.println("You WIN!");
        }else System.out.println("You Lose. Try again.");


    }

    public static int randomNumber(){
        Random random = new Random();
        int number = random.nextInt(10);
        return number;
    }

    public static int userNumber(){
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.print("Please enter number of range 0-9: ");
            if (in.hasNextInt()){
                user = in.nextInt();
                if (user >= 0 && user <=9){
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

    public static boolean checkNumber(int user, int computer){
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
