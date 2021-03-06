package tictactoe;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static char[][] inputMultiArray = new char[3][3];
    static int fillCounter = 0;
    static char turn = 'X';

    public static void main(String[] args) {
        // tahap persiapan
        for (char[] list : inputMultiArray) {
            Arrays.fill(list, ' ');
        }

        // print pertama
        printGameBoard();

        // minta input selama game belum kelar
        char winner = '-';
        while (fillCounter != 9 && winner != 'X' && winner != 'O') {
            System.out.print("Enter the coordinates: ");
            String result = scanner.nextLine();

            // validasi minta number
            if (result.split(" ").length != 2) {
                System.out.println("You should enter numbers!");
                continue;
            }

            int x;
            int y;

            try {
                x = Integer.parseInt(result.split(" ")[0]);
                y = Integer.parseInt(result.split(" ")[1]);

                if (x > 3 || x < 1 || y > 3 || y < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }

                if (inputMultiArray[3 - y][x - 1] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                } else {
                    inputMultiArray[3 - y][x - 1] = turn;
                    changeTurn();
                    printGameBoard();
                    fillCounter++;
                    winner = checkWin();
                }

            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }
        }

        if (winner == '-') {
            System.out.println("Draw");
        } else {
            System.out.println(winner + " wins");
        }
    }

    static char checkWin() {
        // cek horizontal
        char wins = '-';
        for (char[] array : inputMultiArray) {
            if (array[0] == array[1] && array[0] == array[2]) {
                if (wins == '-') {
                    wins = array[0];
                } else {
                    return 'i';
                }
            }
        }
        if (wins != '-') {
            return wins;
        }

        // cek vertikal
        for (int i = 0; i < 3; i++) {
            if (inputMultiArray[0][i] == inputMultiArray[1][i] && inputMultiArray[0][i] == inputMultiArray[2][i]) {
                if (wins == '-') {
                    wins = inputMultiArray[0][i];
                } else {
                    return 'i';
                }
            }
        }
        if (wins != '-') {
            return wins;
        }

        // cek diagonal
        if (inputMultiArray[0][0] == inputMultiArray[1][1] && inputMultiArray[0][0] == inputMultiArray[2][2]) {
            return inputMultiArray[1][1];
        }
        if (inputMultiArray[0][2] == inputMultiArray[1][1] && inputMultiArray[0][2] == inputMultiArray[2][0]) {
            return inputMultiArray[1][1];
        }

        return '-';
    }

    static void changeTurn() {
        if (turn == 'O') {
            turn = 'X';
        } else {
            turn = 'O';
        }
    }

    static void printGameBoard() {
        System.out.println("---------");
        for (char[] array : inputMultiArray) {
            System.out.print("| ");
            for (char c : array) {
                System.out.print(c + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}