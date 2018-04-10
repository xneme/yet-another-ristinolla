package ristinolla.ui;

import java.util.Scanner;
import ristinolla.logic.GameLogic;

public class TextUi {
    
    GameLogic logic;
    Scanner scanner;

    public TextUi(GameLogic logic) {
        this.logic = logic;
        this.scanner = new Scanner(System.in);
    }
    
    private void printBoard(int[][] board) {
        System.out.println("  a  b  c");
        for (int y = 0; y < 3; y++) {
            System.out.print(y+1);
            for (int x = 0; x < 3; x++) {
                if (board[y][x] == 1) {
                    System.out.print("[X]");
                } else if (board[y][x] == -1) {
                    System.out.print("[O]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.print("\n");
        }
    }
    
    public void start() {
        while (logic.isActive()) {
            printBoard(logic.getBoard());
            
            System.out.println(toText(logic.getTurn()) + "'s turn.");
            System.out.print("Give coords [a1-c3]: ");
            String coords = scanner.nextLine();
            
            logic.makeMove(getX(coords), getY(coords));
            System.out.println("");
        }
        printBoard(logic.getBoard());
        if (logic.getWinner() == 0) {
            System.out.println("Draw!");
        } else {
            System.out.println(toText(logic.getWinner()) + " won!");
        }
    }
    
    private String toText(int n) {
        if (n == 1) {
            return "X";
        }
        if (n == -1) {
            return "O";
        }
        return " ";
    }
    
    private int getX(String coords) {
        return coords.charAt(0) - 97;
    }
    
    private int getY(String coords) {
        return Integer.parseInt(coords.substring(1)) - 1;
    }
}
