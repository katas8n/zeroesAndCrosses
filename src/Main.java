import java.util.Scanner;

public class Main {
    private static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '},
    };

    private static char player = 'X';

    public static void main(String[] args) {
        showBoard();
        play();
    }

    private static void play() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("CrossesZeroes game you now play as a '[x]' , Enter here in following way : row , column. \n Example : '1 2' ");


            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if(isValid(row , col)) {
                board[row][col] = player;
                showBoard();


                if(isWinner(player)) {
                    System.out.println("You has won the game , congratulations!");
                    break;
                }

                player = (player == 'X') ? 'O' : 'X';
            }
        }
    }


    private static void showBoard() {
        System.out.println("\t 1 \t 2 \t 3");
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  -----");
            }
        }
        System.out.println();
    }

    private static boolean isValid(int row ,int col) {
        boolean validRow = row >= 0 && row < 3;
        boolean validCol = col >= 0 && col < 3;

        boolean validField = board[row][col] == ' ';

        if(validRow && validCol && validField) return true;

        return false;

    }

    private static boolean isWinner(char sign) {
        for(int i = 0 ; i < 3 ; i++) {
            boolean chekedRow = board[i][0] == sign && board[i][1] == sign && board[i][2] == sign;
            boolean chekedCol = board[0][i] == sign && board[1][i] == sign && board[2][i] == sign;
            boolean horizontalVertical = chekedRow || chekedCol;

            boolean mainDiagonal = board[0][0] == sign && board[1][1] == sign && board[2][2] == sign;
            boolean reverseDiagonal = board[0][2] == sign && board[1][1] == sign && board[2][0] == sign;
            boolean diagonals = mainDiagonal || reverseDiagonal;

            if(horizontalVertical || diagonals) return true;
        }

        return false;
    }

}