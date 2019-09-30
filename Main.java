package com.company;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLOutput;
import java.util.Random;

public class Main extends JFrame {
    Random rand = new Random();
    private boolean eersteZet = true;
    private JPanel contentPane;
    private JTextArea textArea;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private JButton btnNewButton_4;
    private JButton btnNewButton_5;
    private JButton btnNewButton_6;
    private JButton btnNewButton_7;
    private JButton btnNewButton_8;
    private JButton btnNewButton_9;
    private JButton btnEasy;
    private JButton btnPlayers;
    private JButton btnImpossible;
    private Boolean aanDeBeurt = true;
    private String[] inGevuld = new String[9];
    private boolean vol = false;
    private boolean bezet = true;
    private boolean easyDone = false;
    private boolean winnaar = false;
    private boolean firstMove = true;
    private int spelmodus;
    private int plek = rand.nextInt(3);


    /**
     * Launch the application.
     */
    public static void main(String[] args) { //maakt de Main Frame visible
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    private Main() { //toevoeging van componenten aan frame en keuze spelmodus wordt vastgelegd.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 536, 352);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 4, 0, 0));

        textArea = new JTextArea("Tic-Tac-Toe");
        contentPane.add(textArea);

        btnNewButton_1 = new JButton("");
        contentPane.add(btnNewButton_1);
        btnNewButton_1.setVisible(false);

        btnNewButton_2 = new JButton("");
        contentPane.add(btnNewButton_2);
        btnNewButton_2.setVisible(false);

        btnNewButton_3 = new JButton("");
        contentPane.add(btnNewButton_3);
        btnNewButton_3.setVisible(false);

        btnPlayers = new JButton("2 Players");
        contentPane.add(btnPlayers);


        btnNewButton_4 = new JButton("");
        contentPane.add(btnNewButton_4);
        btnNewButton_4.setVisible(false);

        btnNewButton_5 = new JButton("");
        contentPane.add(btnNewButton_5);
        btnNewButton_5.setVisible(false);

        btnNewButton_6 = new JButton("");
        contentPane.add(btnNewButton_6);
        btnNewButton_6.setVisible(false);

        btnEasy = new JButton("Easy");
        contentPane.add(btnEasy);

        btnNewButton_7 = new JButton("");
        contentPane.add(btnNewButton_7);
        btnNewButton_7.setVisible(false);

        btnNewButton_8 = new JButton("");
        contentPane.add(btnNewButton_8);
        btnNewButton_8.setVisible(false);

        btnNewButton_9 = new JButton("");
        contentPane.add(btnNewButton_9);
        btnNewButton_9.setVisible(false);

        btnImpossible = new JButton("Hard");
        contentPane.add(btnImpossible);

        textArea.setEditable(false);
        for (int i = 0; i < 9; i++) {
            inGevuld[i] = Integer.toString(i);
        }
        btnPlayers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                spelmodus = 1;
                btnPlayers.setVisible(false);
                btnEasy.setVisible(false);
                btnImpossible.setVisible(false);

                btnNewButton_1.setVisible(true);
                btnNewButton_2.setVisible(true);
                btnNewButton_3.setVisible(true);
                btnNewButton_4.setVisible(true);
                btnNewButton_5.setVisible(true);
                btnNewButton_6.setVisible(true);
                btnNewButton_7.setVisible(true);
                btnNewButton_8.setVisible(true);
                btnNewButton_9.setVisible(true);
                players();

            }

        });
        btnEasy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                spelmodus = 2;
                btnPlayers.setVisible(false);
                btnEasy.setVisible(false);
                btnImpossible.setVisible(false);

                btnNewButton_1.setVisible(true);
                btnNewButton_2.setVisible(true);
                btnNewButton_3.setVisible(true);
                btnNewButton_4.setVisible(true);
                btnNewButton_5.setVisible(true);
                btnNewButton_6.setVisible(true);
                btnNewButton_7.setVisible(true);
                btnNewButton_8.setVisible(true);
                btnNewButton_9.setVisible(true);
                easy();

            }

        });
        btnImpossible.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                spelmodus = 3;
                btnPlayers.setVisible(false);
                btnEasy.setVisible(false);
                btnImpossible.setVisible(false);

                btnNewButton_1.setVisible(true);
                btnNewButton_2.setVisible(true);
                btnNewButton_3.setVisible(true);
                btnNewButton_4.setVisible(true);
                btnNewButton_5.setVisible(true);
                btnNewButton_6.setVisible(true);
                btnNewButton_7.setVisible(true);
                btnNewButton_8.setVisible(true);
                btnNewButton_9.setVisible(true);
                medium();

            }

        });
    }

    private void players() { //spelmodus voor 2 spelers. Alleen bij button 1 uitleg, daar de rest hetzelfde werkt.

        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // display/center the jdialog when the button is pressed
                if (aanDeBeurt) { //als X aan de beurt is
                    btnNewButton_1.setText("X");
                    aanDeBeurt = false;
                    btnNewButton_1.setEnabled(false);
                    inGevuld[0] = "X";
                    textArea.setText("O is");
                } else { //als O aan de beurt is.
                    btnNewButton_1.setText("O");
                    aanDeBeurt = true;
                    btnNewButton_1.setEnabled(false);
                    inGevuld[0] = "O";
                    textArea.setText("X is");
                }
                checkWon(); //kijkt of iemand heeft gewonnen of het gelijkspel is.
            }

        });
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // display/center the jdialog when the button is pressed
                if (aanDeBeurt) {
                    btnNewButton_2.setText("X");
                    aanDeBeurt = false;
                    btnNewButton_2.setEnabled(false);
                    inGevuld[1] = "X";
                    textArea.setText("O is");
                } else {
                    btnNewButton_2.setText("O");
                    aanDeBeurt = true;
                    btnNewButton_2.setEnabled(false);
                    inGevuld[1] = "O";
                    textArea.setText("X is");
                }
                checkWon();
            }

        });
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // display/center the jdialog when the button is pressed
                if (aanDeBeurt) {
                    btnNewButton_3.setText("X");
                    aanDeBeurt = false;
                    btnNewButton_3.setEnabled(false);
                    inGevuld[2] = "X";
                    textArea.setText("O is");
                } else {
                    btnNewButton_3.setText("O");
                    aanDeBeurt = true;
                    btnNewButton_3.setEnabled(false);
                    inGevuld[2] = "O";
                    textArea.setText("X is");
                }
                checkWon();
            }

        });
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // display/center the jdialog when the button is pressed
                if (aanDeBeurt) {
                    btnNewButton_4.setText("X");
                    aanDeBeurt = false;
                    btnNewButton_4.setEnabled(false);
                    inGevuld[3] = "X";
                    textArea.setText("O is");
                } else {
                    btnNewButton_4.setText("O");
                    aanDeBeurt = true;
                    btnNewButton_4.setEnabled(false);
                    inGevuld[3] = "O";
                    textArea.setText("X is");
                }
                checkWon();
            }

        });
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // display/center the jdialog when the button is pressed
                if (aanDeBeurt) {
                    btnNewButton_5.setText("X");
                    aanDeBeurt = false;
                    btnNewButton_5.setEnabled(false);
                    inGevuld[4] = "X";
                    textArea.setText("O is");
                } else {
                    btnNewButton_5.setText("O");
                    aanDeBeurt = true;
                    btnNewButton_5.setEnabled(false);
                    inGevuld[4] = "O";
                    textArea.setText("X is");
                }
                checkWon();
            }

        });
        btnNewButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // display/center the jdialog when the button is pressed
                if (aanDeBeurt) {
                    btnNewButton_6.setText("X");
                    aanDeBeurt = false;
                    btnNewButton_6.setEnabled(false);
                    inGevuld[5] = "X";
                    textArea.setText("O is");
                } else {
                    btnNewButton_6.setText("O");
                    aanDeBeurt = true;
                    btnNewButton_6.setEnabled(false);
                    inGevuld[5] = "O";
                    textArea.setText("X is");
                }
                checkWon();
            }

        });
        btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // display/center the jdialog when the button is pressed
                if (aanDeBeurt) {
                    btnNewButton_7.setText("X");
                    aanDeBeurt = false;
                    btnNewButton_7.setEnabled(false);
                    inGevuld[6] = "X";
                    textArea.setText("O is");
                } else {
                    btnNewButton_7.setText("O");
                    aanDeBeurt = true;
                    btnNewButton_7.setEnabled(false);
                    inGevuld[6] = "O";
                    textArea.setText("X is");
                }
                checkWon();
            }

        });
        btnNewButton_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // display/center the jdialog when the button is pressed
                if (aanDeBeurt) {
                    btnNewButton_8.setText("X");
                    aanDeBeurt = false;
                    btnNewButton_8.setEnabled(false);
                    inGevuld[7] = "X";
                    textArea.setText("O is");
                } else {
                    btnNewButton_8.setText("O");
                    aanDeBeurt = true;
                    btnNewButton_8.setEnabled(false);
                    inGevuld[7] = "O";
                    textArea.setText("X is");
                }
                checkWon();
            }

        });
        btnNewButton_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // display/center the jdialog when the button is pressed
                if (aanDeBeurt) {
                    btnNewButton_9.setText("X");
                    aanDeBeurt = false;
                    btnNewButton_9.setEnabled(false);
                    inGevuld[8] = "X";
                    textArea.setText("O is");
                } else {
                    btnNewButton_9.setText("O");
                    aanDeBeurt = true;
                    btnNewButton_9.setEnabled(false);
                    inGevuld[8] = "O";
                    textArea.setText("X is");
                }
                checkWon();
            }

        });
    }

    private void playerTurn() { //beurt voor speler tegen computer (spelmodus 2 en 3)
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnNewButton_1.setText("X");
                btnNewButton_1.setEnabled(false);
                aanDeBeurt = false;
                easyDone = false;
                inGevuld[0] = "X";
                checkWon();
                if (spelmodus == 2) { //kijkt voor spelmodus
                    easy();
                    eersteZet = false;
                } else {
                    medium();
                }
            }
        });
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnNewButton_2.setText("X");
                btnNewButton_2.setEnabled(false);
                aanDeBeurt = false;
                easyDone = false;
                inGevuld[1] = "X";
                checkWon();
                if (spelmodus == 2) {
                    easy();
                } else {
                    medium();
                }
            }
        });
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnNewButton_3.setText("X");
                btnNewButton_3.setEnabled(false);
                aanDeBeurt = false;
                easyDone = false;
                inGevuld[2] = "X";
                checkWon();
                if (spelmodus == 2) {
                    easy();
                } else {
                    medium();
                }
            }
        });
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnNewButton_4.setText("X");
                btnNewButton_4.setEnabled(false);
                aanDeBeurt = false;
                easyDone = false;
                inGevuld[3] = "X";
                checkWon();
                if (spelmodus == 2) {
                    easy();
                } else {
                    medium();
                }
            }
        });
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnNewButton_5.setText("X");
                btnNewButton_5.setEnabled(false);
                aanDeBeurt = false;
                easyDone = false;
                inGevuld[4] = "X";
                checkWon();
                if (spelmodus == 2) {
                    easy();
                } else {
                    medium();
                }
            }
        });
        btnNewButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnNewButton_6.setText("X");
                btnNewButton_6.setEnabled(false);
                aanDeBeurt = false;
                easyDone = false;
                inGevuld[5] = "X";
                checkWon();
                if (spelmodus == 2) {
                    easy();
                } else {
                    medium();
                }
            }
        });
        btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnNewButton_7.setText("X");
                btnNewButton_7.setEnabled(false);
                aanDeBeurt = false;
                easyDone = false;
                inGevuld[6] = "X";
                checkWon();
                if (spelmodus == 2) {
                    easy();
                } else {
                    medium();
                }
            }
        });
        btnNewButton_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnNewButton_8.setText("X");
                btnNewButton_8.setEnabled(false);
                aanDeBeurt = false;
                easyDone = false;
                inGevuld[7] = "X";
                checkWon();
                if (spelmodus == 2) {
                    easy();
                } else {
                    medium();
                }
            }
        });
        btnNewButton_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnNewButton_9.setText("X");
                btnNewButton_9.setEnabled(false);
                aanDeBeurt = false;
                easyDone = false;
                inGevuld[8] = "X";
                checkWon();
                if (spelmodus == 2) {
                    easy();
                } else {
                    medium();
                }
            }
        });
    }

    private void easy() { //easy spelmodus, comptuter selecteert een willekeurig leeg vakje
        if (aanDeBeurt) { //als je aan de beurt bent gaat het programma naar playerturn();
            playerTurn();
        } else if (!(winnaar)) {

            int vakje = rand.nextInt(9);

            bezet = true;
            if (!(easyDone)) {
                while (bezet) {
                    if (inGevuld[vakje].equals("X") || inGevuld[vakje].equals("O")) {
                        vakje = rand.nextInt(9);
                    } else {
                        bezet = false;
                    }
                }


                inGevuld[vakje] = "O";
                switch (vakje) {
                    case 0:
                        btnNewButton_1.setText("O");
                        btnNewButton_1.setEnabled(false);
                        break;
                    case 1:
                        btnNewButton_2.setText("O");
                        btnNewButton_2.setEnabled(false);
                        break;
                    case 2:
                        btnNewButton_3.setText("O");
                        btnNewButton_3.setEnabled(false);
                        break;
                    case 3:
                        btnNewButton_4.setText("O");
                        btnNewButton_4.setEnabled(false);
                        break;
                    case 4:
                        btnNewButton_5.setText("O");
                        btnNewButton_5.setEnabled(false);
                        break;
                    case 5:
                        btnNewButton_6.setText("O");
                        btnNewButton_6.setEnabled(false);
                        break;
                    case 6:
                        btnNewButton_7.setText("O");
                        btnNewButton_7.setEnabled(false);
                        break;
                    case 7:
                        btnNewButton_8.setText("O");
                        btnNewButton_8.setEnabled(false);
                        break;
                    case 8:
                        btnNewButton_9.setText("O");
                        btnNewButton_9.setEnabled(false);
                        break;
                }
                aanDeBeurt = true;
                easyDone = true;
                checkWon();
                //easy();

            }
        }
    }

    private void medium() { //hard spelmodus, computer kiest in het begin als het vrij is het middelste vakje
        //als niet dan kiest hij een vakje aan de zijkant (geen hoek).
        //Hierna maakt hij 3 op een rij of verhindert hij een 3 op een rij van de opponent.
        //als er geen 3 op rij mogelijk is voor beide spelers selecteert hij een willekeurig vakje.
        if (aanDeBeurt) {
            playerTurn();
        } else if (!(winnaar)) {
            if (firstMove) {
                if (inGevuld[4].equals("X")) {
                    switch (plek) {
                        case 1:
                            inGevuld[1] = "O";
                            btnNewButton_2.setText("O");
                            btnNewButton_2.setEnabled(false);
                            firstMove = false;
                            break;
                        case 2:
                            inGevuld[3] = "O";
                            btnNewButton_4.setEnabled(false);
                            btnNewButton_4.setText("O");
                            firstMove = false;
                            break;
                        case 3:
                            inGevuld[5] = "O";
                            btnNewButton_6.setText("O");
                            btnNewButton_6.setEnabled(false);
                            firstMove = false;
                            break;
                        case 0:
                            inGevuld[7] = "O";
                            btnNewButton_8.setText("O");
                            btnNewButton_8.setEnabled(false);
                            firstMove = false;
                            break;
                    }
                }
                else{
                    inGevuld[4] = "O";
                    btnNewButton_5.setText("O");
                    btnNewButton_5.setEnabled(false);
                    firstMove = false;
                }
            }
            else{
                if(
                        (inGevuld[0].equals("O") &&inGevuld[1].equals("O") &&inGevuld[2].equals("2"))
                ){
                    inGevuld[2] = "O";
                    btnNewButton_3.setText("O");
                    btnNewButton_3.setEnabled(false);
                }
                else if(
                        (inGevuld[1].equals("O") &&inGevuld[2].equals("O")&&inGevuld[0].equals("0"))
                ){
                    inGevuld[0] = "O";
                    btnNewButton_1.setText("O");
                    btnNewButton_1.setEnabled(false);
                }
                else if(
                        (inGevuld[0].equals("O") &&inGevuld[2].equals("O")&&inGevuld[1].equals("1"))
                ){
                    inGevuld[1] = "O";
                    btnNewButton_2.setText("O");
                    btnNewButton_2.setEnabled(false);
                }
                else if(
                        (inGevuld[3].equals("O") &&inGevuld[4].equals("O")&&inGevuld[5].equals("5"))
                ){
                    inGevuld[5] = "O";
                    btnNewButton_6.setText("O");
                    btnNewButton_6.setEnabled(false);
                }
                else if(
                        (inGevuld[3].equals("O") &&inGevuld[5].equals("O")&&inGevuld[4].equals("4"))
                ){
                    inGevuld[4] = "O";
                    btnNewButton_5.setText("O");
                    btnNewButton_5.setEnabled(false);
                }
                else if(
                        (inGevuld[4].equals("O") &&inGevuld[5].equals("O")&&inGevuld[3].equals("3"))
                ){
                    inGevuld[3] = "O";
                    btnNewButton_4.setText("O");
                    btnNewButton_4.setEnabled(false);
                }
                else if(
                        (inGevuld[6].equals("O") &&inGevuld[7].equals("O")&&inGevuld[8].equals("8"))
                ){
                    inGevuld[8] = "O";
                    btnNewButton_9.setText("O");
                    btnNewButton_9.setEnabled(false);
                }
                else if(
                        (inGevuld[6].equals("O") &&inGevuld[8].equals("O")&&inGevuld[7].equals("7"))
                ){
                    inGevuld[7] = "O";
                    btnNewButton_8.setText("O");
                    btnNewButton_8.setEnabled(false);
                }
                else if(
                        (inGevuld[7].equals("O") &&inGevuld[8].equals("O")&&inGevuld[6].equals("6"))
                ){
                    inGevuld[6] = "O";
                    btnNewButton_7.setText("O");
                    btnNewButton_7.setEnabled(false);
                }
                else if(
                        (inGevuld[0].equals("O") &&inGevuld[3].equals("O")&&inGevuld[6].equals("6"))
                ){
                    inGevuld[6] = "O";
                    btnNewButton_7.setText("O");
                    btnNewButton_7.setEnabled(false);
                }
                else if(
                        (inGevuld[3].equals("O") &&inGevuld[6].equals("O")&&inGevuld[0].equals("0"))
                ){
                    inGevuld[0] = "O";
                    btnNewButton_1.setText("O");
                    btnNewButton_1.setEnabled(false);
                }
                else if(
                        (inGevuld[0].equals("O") &&inGevuld[6].equals("O")&&inGevuld[3].equals("3"))
                ){
                    inGevuld[3] = "O";
                    btnNewButton_4.setText("O");
                    btnNewButton_4.setEnabled(false);
                }
                else if(
                        (inGevuld[1].equals("O") &&inGevuld[4].equals("O")&&inGevuld[7].equals("7"))
                ){
                    inGevuld[7] = "O";
                    btnNewButton_8.setText("O");
                    btnNewButton_8.setEnabled(false);
                }
                else if(
                        (inGevuld[1].equals("O") &&inGevuld[7].equals("O")&&inGevuld[4].equals("4"))
                ){
                    inGevuld[4] = "O";
                    btnNewButton_5.setText("O");
                    btnNewButton_5.setEnabled(false);
                }
                else if(
                        (inGevuld[4].equals("O") &&inGevuld[7].equals("O")&&inGevuld[1].equals("1"))
                ){
                    inGevuld[1] = "O";
                    btnNewButton_2.setText("O");
                    btnNewButton_2.setEnabled(false);
                }
                else if(
                        (inGevuld[2].equals("O") &&inGevuld[5].equals("O")&&inGevuld[8].equals("8"))
                ){
                    inGevuld[8] = "O";
                    btnNewButton_9.setText("O");
                    btnNewButton_9.setEnabled(false);
                }
                else if(
                        (inGevuld[2].equals("O") &&inGevuld[8].equals("O")&&inGevuld[5].equals("5"))
                ){
                    inGevuld[5] = "O";
                    btnNewButton_6.setText("O");
                    btnNewButton_6.setEnabled(false);
                }
                else if(
                        (inGevuld[5].equals("O") &&inGevuld[8].equals("O")&&inGevuld[2].equals("2"))
                ){
                    inGevuld[2] = "O";
                    btnNewButton_3.setText("O");
                    btnNewButton_3.setEnabled(false);
                }
                else if(
                        (inGevuld[0].equals("O") &&inGevuld[4].equals("O")&&inGevuld[8].equals("8"))
                ){
                    inGevuld[8] = "O";
                    btnNewButton_9.setText("O");
                    btnNewButton_9.setEnabled(false);
                }
                else if(
                        (inGevuld[0].equals("O") &&inGevuld[8].equals("O")&&inGevuld[4].equals("4"))
                ){
                    inGevuld[4] = "O";
                    btnNewButton_5.setText("O");
                    btnNewButton_5.setEnabled(false);
                }
                else if(
                        (inGevuld[4].equals("O") &&inGevuld[8].equals("O")&&inGevuld[0].equals("0"))
                ){
                    inGevuld[0] = "O";
                    btnNewButton_1.setText("O");
                    btnNewButton_1.setEnabled(false);
                }
                else if(
                        (inGevuld[2].equals("O") &&inGevuld[4].equals("O")&&inGevuld[6].equals("6"))
                ){
                    inGevuld[6] = "O";
                    btnNewButton_7.setText("O");
                    btnNewButton_7.setEnabled(false);
                }
                else if(
                        (inGevuld[2].equals("O") &&inGevuld[6].equals("O")&&inGevuld[4].equals("4"))
                ){
                    inGevuld[4] = "O";
                    btnNewButton_5.setText("O");
                    btnNewButton_5.setEnabled(false);
                }
                else if(
                        (inGevuld[4].equals("O") &&inGevuld[6].equals("O")&&inGevuld[2].equals("2"))
                ){
                    inGevuld[2] = "O";
                    btnNewButton_3.setText("O");
                    btnNewButton_3.setEnabled(false);
                }
                else if(
                        (inGevuld[0].equals("X") &&inGevuld[1].equals("X") &&inGevuld[2].equals("2"))
                ){
                    inGevuld[2] = "O";
                    btnNewButton_3.setText("O");
                    btnNewButton_3.setEnabled(false);
                }
                else if(
                        (inGevuld[1].equals("X") &&inGevuld[2].equals("X")&&inGevuld[0].equals("0"))
                ){
                    inGevuld[0] = "O";
                    btnNewButton_1.setText("O");
                    btnNewButton_1.setEnabled(false);
                }
                else if(
                        (inGevuld[0].equals("X") &&inGevuld[2].equals("X")&&inGevuld[1].equals("1"))
                ){
                    inGevuld[1] = "O";
                    btnNewButton_2.setText("O");
                    btnNewButton_2.setEnabled(false);
                }
                else if(
                        (inGevuld[3].equals("X") &&inGevuld[4].equals("X")&&inGevuld[5].equals("5"))
                ){
                    inGevuld[5] = "O";
                    btnNewButton_6.setText("O");
                    btnNewButton_6.setEnabled(false);
                }
                else if(
                        (inGevuld[3].equals("X") &&inGevuld[5].equals("X")&&inGevuld[4].equals("4"))
                ){
                    inGevuld[4] = "O";
                    btnNewButton_5.setText("O");
                    btnNewButton_5.setEnabled(false);
                }
                else if(
                        (inGevuld[4].equals("X") &&inGevuld[5].equals("X")&&inGevuld[3].equals("3"))
                ){
                    inGevuld[3] = "O";
                    btnNewButton_4.setText("O");
                    btnNewButton_4.setEnabled(false);
                }
                else if(
                        (inGevuld[6].equals("X") &&inGevuld[7].equals("X")&&inGevuld[8].equals("8"))
                ){
                    inGevuld[8] = "O";
                    btnNewButton_9.setText("O");
                    btnNewButton_9.setEnabled(false);
                }
                else if(
                        (inGevuld[6].equals("X") &&inGevuld[8].equals("X")&&inGevuld[7].equals("7"))
                ){
                    inGevuld[7] = "O";
                    btnNewButton_8.setText("O");
                    btnNewButton_8.setEnabled(false);
                }
                else if(
                        (inGevuld[7].equals("X") &&inGevuld[8].equals("X")&&inGevuld[6].equals("6"))
                ){
                    inGevuld[6] = "O";
                    btnNewButton_7.setText("O");
                    btnNewButton_7.setEnabled(false);
                }
                else if(
                        (inGevuld[0].equals("X") &&inGevuld[3].equals("X")&&inGevuld[6].equals("6"))
                ){
                    inGevuld[6] = "O";
                    btnNewButton_7.setText("O");
                    btnNewButton_7.setEnabled(false);
                }
                else if(
                        (inGevuld[3].equals("X") &&inGevuld[6].equals("X")&&inGevuld[0].equals("0"))
                ){
                    inGevuld[0] = "O";
                    btnNewButton_1.setText("O");
                    btnNewButton_1.setEnabled(false);
                }
                else if(
                        (inGevuld[0].equals("X") &&inGevuld[6].equals("X")&&inGevuld[3].equals("3"))
                ){
                    inGevuld[3] = "O";
                    btnNewButton_4.setText("O");
                    btnNewButton_4.setEnabled(false);
                }
                else if(
                        (inGevuld[1].equals("X") &&inGevuld[4].equals("X")&&inGevuld[7].equals("7"))
                ){
                    inGevuld[7] = "O";
                    btnNewButton_8.setText("O");
                    btnNewButton_8.setEnabled(false);
                }
                else if(
                        (inGevuld[1].equals("X") &&inGevuld[7].equals("X")&&inGevuld[4].equals("4"))
                ){
                    inGevuld[4] = "O";
                    btnNewButton_5.setText("O");
                    btnNewButton_5.setEnabled(false);
                }
                else if(
                        (inGevuld[4].equals("X") &&inGevuld[7].equals("X")&&inGevuld[1].equals("1"))
                ){
                    inGevuld[1] = "O";
                    btnNewButton_2.setText("O");
                    btnNewButton_2.setEnabled(false);
                }
                else if(
                        (inGevuld[2].equals("X") &&inGevuld[5].equals("X")&&inGevuld[8].equals("8"))
                ){
                    inGevuld[8] = "O";
                    btnNewButton_9.setText("O");
                    btnNewButton_9.setEnabled(false);
                }
                else if(
                        (inGevuld[2].equals("X") &&inGevuld[8].equals("X")&&inGevuld[5].equals("5"))
                ){
                    inGevuld[5] = "O";
                    btnNewButton_6.setText("O");
                    btnNewButton_6.setEnabled(false);
                }
                else if(
                        (inGevuld[5].equals("X") &&inGevuld[8].equals("X")&&inGevuld[2].equals("2"))
                ){
                    inGevuld[2] = "O";
                    btnNewButton_3.setText("O");
                    btnNewButton_3.setEnabled(false);
                }
                else if(
                        (inGevuld[0].equals("X") &&inGevuld[4].equals("X")&&inGevuld[8].equals("8"))
                ){
                    inGevuld[8] = "O";
                    btnNewButton_9.setText("O");
                    btnNewButton_9.setEnabled(false);
                }
                else if(
                        (inGevuld[0].equals("X") &&inGevuld[8].equals("X")&&inGevuld[4].equals("4"))
                ){
                    inGevuld[4] = "O";
                    btnNewButton_5.setText("O");
                    btnNewButton_5.setEnabled(false);
                }
                else if(
                        (inGevuld[4].equals("X") &&inGevuld[8].equals("X")&&inGevuld[0].equals("0"))
                ){
                    inGevuld[0] = "O";
                    btnNewButton_1.setText("O");
                    btnNewButton_1.setEnabled(false);
                }
                else if(
                        (inGevuld[2].equals("X") &&inGevuld[4].equals("X")&&inGevuld[6].equals("6"))
                ){
                    inGevuld[6] = "O";
                    btnNewButton_7.setText("O");
                    btnNewButton_7.setEnabled(false);
                }
                else if(
                        (inGevuld[2].equals("X") &&inGevuld[6].equals("X")&&inGevuld[4].equals("4"))
                ){
                    inGevuld[4] = "O";
                    btnNewButton_5.setText("O");
                    btnNewButton_5.setEnabled(false);
                }
                else if(
                        (inGevuld[4].equals("X") &&inGevuld[6].equals("X")&&inGevuld[2].equals("2"))
                ){
                    inGevuld[2] = "O";
                    btnNewButton_3.setText("O");
                    btnNewButton_3.setEnabled(false);
                }
                else{
                    int vakje = rand.nextInt(9);

                    bezet = true;
                    if (!(easyDone)) {
                        while (bezet) {
                            if (inGevuld[vakje].equals("X") || inGevuld[vakje].equals("O")) {
                                vakje = rand.nextInt(9);
                            } else {
                                bezet = false;
                            }
                        }
                        inGevuld[vakje] = "O";
                        switch (vakje) {
                            case 0:
                                btnNewButton_1.setText("O");
                                btnNewButton_1.setEnabled(false);
                                break;
                            case 1:
                                btnNewButton_2.setText("O");
                                btnNewButton_2.setEnabled(false);
                                break;
                            case 2:
                                btnNewButton_3.setText("O");
                                btnNewButton_3.setEnabled(false);
                                break;
                            case 3:
                                btnNewButton_4.setText("O");
                                btnNewButton_4.setEnabled(false);
                                break;
                            case 4:
                                btnNewButton_5.setText("O");
                                btnNewButton_5.setEnabled(false);
                                break;
                            case 5:
                                btnNewButton_6.setText("O");
                                btnNewButton_6.setEnabled(false);
                                break;
                            case 6:
                                btnNewButton_7.setText("O");
                                btnNewButton_7.setEnabled(false);
                                break;
                            case 7:
                                btnNewButton_8.setText("O");
                                btnNewButton_8.setEnabled(false);
                                break;
                            case 8:
                                btnNewButton_9.setText("O");
                                btnNewButton_9.setEnabled(false);
                                break;
                        }
                        aanDeBeurt = true;
                        easyDone = true;
                        checkWon();
                        //easy();
                    }
                }
            }
            aanDeBeurt = true;
            checkWon();

        }
    }
    private void checkWon() { //deze functie kijkt of iemand heeft gewonnen of er gelijk is gespeeld
        if ((inGevuld[0].equals(inGevuld[1]) && inGevuld[0].equals(inGevuld[2])) ||
                (inGevuld[3].equals(inGevuld[4]) && inGevuld[3].equals(inGevuld[5])) ||
                (inGevuld[6].equals(inGevuld[7]) && inGevuld[6].equals(inGevuld[8])) ||
                (inGevuld[0].equals(inGevuld[3]) && inGevuld[0].equals(inGevuld[6])) ||
                (inGevuld[1].equals(inGevuld[4]) && inGevuld[1].equals(inGevuld[7])) ||
                (inGevuld[2].equals(inGevuld[5]) && inGevuld[2].equals(inGevuld[8])) ||
                (inGevuld[0].equals(inGevuld[4]) && inGevuld[0].equals(inGevuld[8])) ||
                (inGevuld[2].equals(inGevuld[4]) && inGevuld[2].equals(inGevuld[6]))
        ) {
            if (aanDeBeurt) {
                textArea.setText("O Wint!");
                winnaar = true;
                abort();

            } else {
                textArea.setText("X Wint!");
                winnaar = true;
                abort();


            }
            btnNewButton_1.setEnabled(false);
            btnNewButton_2.setEnabled(false);
            btnNewButton_3.setEnabled(false);
            btnNewButton_4.setEnabled(false);
            btnNewButton_5.setEnabled(false);
            btnNewButton_6.setEnabled(false);
            btnNewButton_7.setEnabled(false);
            btnNewButton_8.setEnabled(false);
            btnNewButton_9.setEnabled(false);
        } else {
            for (int i = 0; i < 9; i++) { //test of gelijkspel
                if (inGevuld[i].equals("X") || inGevuld[i].equals("O")) {
                    vol = true;
                } else {
                    vol = false;
                    i = 10;
                }
            }
            if (vol) {
                winnaar = true;
                textArea.setText("Gelijkspel!");
                abort();
            }
        }
    }

    private void abort() { //zorgt voor de restart of de abort button.
        btnEasy.setVisible(true);
        btnEasy.setEnabled(true);
        btnEasy.setText("Abort");
        btnEasy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                System.exit(1);
            }

        });
        btnImpossible.setVisible(true);
        btnImpossible.setEnabled(true);
        btnImpossible.setText("Restart");
        btnImpossible.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            Main frame = new Main();
                            frame.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

        });
    }
}

