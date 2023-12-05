import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        TicTacToeMenu game = new TicTacToeMenu();
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setTitle("Tic-Tac-Toe");
        game.setBounds(425, 110, 600, 550);
    }
}