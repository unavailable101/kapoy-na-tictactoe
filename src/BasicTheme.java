import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BasicTheme extends JFrame implements Playing, Checking{
    private String name1;
    private String name2;
    private char curr = 'X';
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JPanel panel;
    private JLabel point2;
    private JLabel point1;
    private JLabel player1;
    private JLabel player2;
    private int pt1 = 0;
    private int pt2 = 0;

    //    private char wala = '\0';
    private JButton[] buttons = {button1, button2, button3, button4, button5, button6, button7, button8, button9};
    public BasicTheme(String name1, String name2){
        this.name1 = name1;
        this.name2 = name2;
        setContentPane(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tic-Tac-Toe");
        setBounds(425, 110, 600, 550);
        player1.setText(name1);
        player2.setText(name2);
        point1.setText(String.valueOf(pt1));
        point2.setText(String.valueOf(pt2));
        clicking();
    }

    @Override
    public void clicking() {
        for (int i = 0; i<9; i++){
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton click = (JButton)e.getSource();
                    click.setText(String.valueOf(curr));
                    click.setEnabled(false);
                    if (curr == 'X') {
                        click.setBackground(Color.WHITE);
                        curr = 'O';
                    } else {
                        click.setBackground(Color.PINK);
                        curr = 'X';
                    }
                    matchEnd();
                }
            });
        }
    }

    public void reset(){
        for (int i=0; i<9; i++){
            buttons[i].setText(null);
            buttons[i].setEnabled(true);
            buttons[i].setBackground(Color.lightGray);
        }
    }

    @Override
    public void matchEnd() {
        if (isWinner()){
            if (curr == 'X') { //bali sha
                JOptionPane.showMessageDialog(null, "Game Over. Winner is " + name2 + ".");
                pt2++;
                reset();
            }
            if (curr == 'O') {
                JOptionPane.showMessageDialog(null, "Game Over. Winner is " + name1 + ".");
                pt1++;
                reset();
            }
        } else if (isMatchDraw()){
            JOptionPane.showConfirmDialog(null, "Game Draw");
        }
    }

    @Override
    public boolean isMatchDraw() {
        for (int i = 0; i<9; i++){
            if (buttons[i].getText().isEmpty()) return false;
        }
        return true;
    }

    @Override
    public boolean isWinner() {
//        if (checkCols() !=  wala) return checkCols();
//        if (checkRows() != wala) return checkRows();
//        if (checkDiagonal() != wala) return checkDiagonal();
//        return wala;
        if (isMatchDraw()) return false;
        return checkCols() || checkRows() || checkDiagonal();
    }

    @Override
    public boolean checkCols() {
        int i = 0;
        for (int j = 0; j < 3; j++) {
            if (buttons[i].getText().equals(buttons[i + 1].getText()) &&
                    buttons[i].getText().equals(buttons[i + 2].getText()) &&
                    !buttons[i].getText().isEmpty()) {
                return true;
            }
            i = i + 3;
        }
        return false;
//        if ((button1.getText().equals(button4.getText())) &&
//                (button4.getText().equals(button7.getText())) &&
//                (button1.getText().equals(button7.getText()))
//        ) //return button1.getText().charAt(0); //col1
//            return true;
//        else if ((button2.getText().equals(button5.getText())) &&
//                (button5.getText().equals(button8.getText())) &&
//                (button2.getText().equals(button8.getText()))
//        ) return true;//button2.getText().charAt(0); //col2
//        else if ((button3.getText().equals(button6.getText())) &&
//                (button6.getText().equals(button9.getText())) &&
//                (button3.getText().equals(button9.getText()))
//        ) return true;//button3.getText().charAt(0); //col3
//        return false;//wala; //if wala
    }

    @Override
    public boolean checkRows() {
        int i = 0;
        for (int j = 0; j < 3; j++) {
            if (buttons[i].getText().equals(buttons[i + 3].getText()) &&
                    buttons[i].getText().equals(buttons[i + 6].getText()) &&
                    !buttons[i].getText().isEmpty()) {
                return true;
            }
            i++;
        }
        return false;
//        if ((button1.getText().equals(button2.getText())) &&
//                (button2.getText().equals(button3.getText())) &&
//                (button1.getText().equals(button3.getText()))
//        ) return true;//button1.getText().charAt(0); //row 1
//        else if ((button4.getText().equals(button5.getText())) &&
//                (button5.getText().equals(button6.getText())) &&
//                (button4.getText().equals(button6.getText()))
//        ) return true;//button4.getText().charAt(0);//row 2
//        else if ((button7.getText().equals(button8.getText())) &&
//                (button8.getText().equals(button9.getText())) &&
//                (button7.getText().equals(button9.getText()))
//        ) return true;//button7.getText().charAt(0); //row3
//        return false; //wala; //wala
    }

    @Override
    public boolean checkDiagonal() {
        if (buttons[0].getText().equals(buttons[4].getText()) &&
                buttons[0].getText().equals(buttons[8].getText()) &&
                !buttons[0].getText().isEmpty())
            return true;
        else
            return buttons[2].getText().equals(buttons[4].getText()) &&
                    buttons[2].getText().equals(buttons[6].getText()) &&
                    !buttons[2].getText().isEmpty();
//        if ((button1.getText().equals(button5.getText())) &&
//                (button5.getText().equals(button9.getText())) &&
//                (button1.getText().equals(button9.getText()))
//        ) return true;//button1.getText().charAt(0); //1-5-9
//        else if ((button3.getText().equals(button5.getText())) &&
//                (button5.getText().equals(button7.getText())) &&
//                (button3.getText().equals(button7.getText()))
//        ) return true; //button3.getText().charAt(0); //3-5-7
//        return false;//wala; //wala
    }
}
