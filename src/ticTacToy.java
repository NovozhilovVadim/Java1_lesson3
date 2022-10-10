import java.util.Scanner;

public class ticTacToy {
    private static char[][] field;
    private static final int SIZEFIELDX  = 3;
    private static final int SIZEFIELDY = SIZEFIELDX;
    private static final char charComp = 'X';
    private static final char charHuman = 'O';
    private static Scanner in = new Scanner(System.in);


    public static void main(String[] args) {
        emptyField();
        printGameField();
        move(1,1, charComp);
        System.out.println();
        printGameField();
        moveHuman();
        System.out.println();
        printGameField();

    }

    private static void emptyField(){
        field = new char[SIZEFIELDX][SIZEFIELDY];
        for (int i = 0; i < SIZEFIELDX; i++) {
            for (int j = 0; j < SIZEFIELDY; j++) {
                field[i][j] = '-';
            }
        }
    }

    private static void printGameField(){
        for (int i = 0; i < SIZEFIELDX; i++) {
            for (int j = 0; j < SIZEFIELDY; j++) {
                System.out.print(field[i][j] + "  ");
            }
            System.out.println();
        }
    }

    private static boolean move(int indexX, int indexY, char chars){
        if(field[indexX][indexY] == '-'){
            field[indexX][indexY] = chars;
            return true;
        }
        return false;
    }

    private static void moveHuman(){
        int x = 0;
        int y = 0;
        while (true){
            while (true){
                System.out.println("Enter horizontal coordinates in the range 1 - " + SIZEFIELDX + " :" );
                if (in.hasNextInt()){
                    x = in.nextInt();
                    if (x > 0 && x <= SIZEFIELDX){

                        break;
                    }

                }else
                    System.out.println("Enter correct number!!!");
            }
            while (true){
                System.out.println("Enter vertical coordinates in the range 1 - " + SIZEFIELDY + " :" );
                if (in.hasNextInt()){
                    y = in.nextInt();
                    if (y > 0 && y <= SIZEFIELDY){

                        break;
                    }

                }else
                    System.out.println("Enter correct number!!!");
            }
            if (x !=0  && y != 0 ){

                if (move(x-1,y-1,charHuman)){
                    break;
                }
//                field[x][y] = charHuman;

            }



        }






    }

}
