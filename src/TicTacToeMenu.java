import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeMenu extends JFrame {

    private JComboBox themes;
    private JButton PLAYButton;
    private JTextField player1;
    private JTextField player2;
    private JPanel panel1;
    private String name1;
    private String name2;

    public TicTacToeMenu(){
        setContentPane(panel1);
        setVisible(true);

        PLAYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    name1 = player1.getText();
                    name2 = player2.getText();
                } catch (Exception ex){
                    name1 = "Player 1";
                    name2 = "Player 2";
                }
                setVisible(false);

                if (themes.getSelectedIndex() == 0){
                    BasicTheme basic = new BasicTheme(name1, name2);
                    basic.setVisible(true);
                } else { //mga decorators or mga naay theme
                    switch (themes.getSelectedIndex()){
                        case 1:
                            break;
                    }
                }
            }
        });
    }
}
