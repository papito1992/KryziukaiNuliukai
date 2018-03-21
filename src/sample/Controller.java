package sample;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import javax.swing.*;


public class Controller {

    @FXML
    public Button jbtnExit;
    @FXML
    public Button jbtnReset;
    @FXML
    public Button btn9;
    @FXML
    public Button btn8;
    @FXML
    public Button btn7;
    @FXML
    public Pane jlblPlayerO;
    @FXML
    public Button btn6;
    @FXML
    public Button btn5;
    @FXML
    public Button btn4;
    @FXML
    public Pane jlblPlayerX;
    @FXML
    public Button btn3;
    @FXML
    public Button btn2;
    @FXML
    public Button btn1;
    @FXML
    private Text playerXWinstreak;
    @FXML
    private Text playerOWinstreak;

    private String[] spaces = new String[9];
    private Button[] butns = new Button[9];
    private int[][] wins = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    public boolean turns = true;
    private boolean won = false;

    private boolean tie = false;

    Image imageX = new Image(getClass().getResourceAsStream("X.png"));

    Image imageO = new Image(getClass().getResourceAsStream("O.png"));

    public void initializeButtonArray() {
        butns[0] = btn1;
        butns[1] = btn2;
        butns[2] = btn3;
        butns[3] = btn4;
        butns[4] = btn5;
        butns[5] = btn6;
        butns[6] = btn7;
        butns[7] = btn8;
        butns[8] = btn9;
    }

    private String startGame = "X";
    private int xWinCount = 0;
    private int oWinCount = 0;



    private void checkForWin() {
        for (int i = 0; i < wins.length; i++) {
            if (this.spaces[wins[i][0]] == ("X") && this.spaces[wins[i][1]] == ("X") && this.spaces[wins[i][2]] == ("X")) {

                won = true;

                if (won == true) {
                    xWinCount++;
                    JOptionPane.showMessageDialog(null, "X PLAYER WON, Current win streak: " + xWinCount);

                    setPlayerXWinstreak();
                    for (int j = 0; j < butns.length; j++) {
                        butns[j].setGraphic(null);
                        spaces[j] = null;

                    }
                    startGame = "X";


                }
            }

            if (this.spaces[wins[i][0]] == ("O") && this.spaces[wins[i][1]] == ("O") && this.spaces[wins[i][2]] == ("O")) {


                won = true;


                if (won == true) {
                    oWinCount++;
                    JOptionPane.showMessageDialog(null, "O PLAYER WON, Current win streak: " + oWinCount);

                    setPlayerOWinstreak();
                    for (int j = 0; j < butns.length; j++) {
                        butns[j].setGraphic(null);
                        spaces[j] = null;
                    }
                    startGame = "X";


                }

            }

        }
    }


    private void choose_Player(int btnNr) {
        initializeButtonArray();
        if (spaces[btnNr] == null) {
            if (startGame.equalsIgnoreCase("X")) {
                this.spaces[btnNr] = "X";
                if (spaces[btnNr].equalsIgnoreCase("X")) {
                    butns[btnNr].setGraphic(new ImageView(imageX));
                    startGame = "O";

                }
                this.turns = false;


            } else if (startGame.equalsIgnoreCase("O")) {
                this.spaces[btnNr] = "O";
                if (spaces[btnNr].equalsIgnoreCase("O")) {
                    butns[btnNr].setGraphic(new ImageView(imageO));
                    startGame = "X";
                }
                this.turns = true;
            }
        }
    }

    @FXML
    public void onBtnClick1(javafx.event.ActionEvent actionEvent) {

        choose_Player(0);
        checkForWin();



    }

    @FXML
    public void onBtnClick2(javafx.event.ActionEvent actionEvent) {
        choose_Player(1);
        checkForWin();

    }

    @FXML
    public void onBtnClick3(javafx.event.ActionEvent actionEvent) {

        choose_Player(2);
        checkForWin();

    }

    @FXML
    public void onBtnClick4(javafx.event.ActionEvent actionEvent) {

        choose_Player(3);
        checkForWin();
    }

    @FXML
    public void onBtnClick5(javafx.event.ActionEvent actionEvent) {
        choose_Player(4);
        checkForWin();
    }

    @FXML
    public void onBtnClick6(javafx.event.ActionEvent actionEvent) {
        choose_Player(5);
        checkForWin();
    }

    @FXML
    public void onBtnClick7(javafx.event.ActionEvent actionEvent) {
        choose_Player(6);
        checkForWin();
    }

    public void onBtnClick8(javafx.event.ActionEvent actionEvent) {
        choose_Player(7);
        checkForWin();
    }

    @FXML
    public void onBtnClick9(javafx.event.ActionEvent actionEvent) {
        choose_Player(8);
        checkForWin();
    }

    @FXML
    public void onResetClick(javafx.event.ActionEvent actionEvent) {

        for (int i = 0; i < butns.length; i++) {
            butns[i].setGraphic(null);
            spaces[i] = null;
        }
        startGame = "X";
    }

    @FXML
    public void onExitClick(javafx.event.ActionEvent actionEvent) {
        JFrame frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame, "Do you want to Exit?", "Kryziukai Nuliukai", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
            ;
        {
            System.exit(0);
        }
    }


    private void winningGame() {

    }

    public void setPlayerXWinstreak() {
        String temp = String.valueOf(xWinCount);
        playerXWinstreak.setText(temp);
    }

    public void setPlayerOWinstreak() {
        String temp = String.valueOf(oWinCount);
        playerOWinstreak.setText(temp);
    }
}
