package com.techelevator;

import com.techelevator.menu.MenuDisplay;
import com.techelevator.rooms.*;
import com.techelevator.rooms.Robot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    JFrame window;
    Container container;
    JPanel titlePanel, startButtonPanel, mainTextPanel;
    JLabel titleName;
    Font titleFont = new Font("Helvetica",Font.PLAIN,55);
    Font normalFont = new Font("Helvetica", Font.PLAIN, 40);
    JButton startButton;
    JTextArea mainTextArea;

    TitleScreenHandler titleScreenHandler = new TitleScreenHandler();

    private static final String INTRO = "You are in the lobby of a haunted mansion!";

    private static final String OPTION_RED = "Go to red room";
    private static final String OPTION_BLUE = "Go to blue room";
    private static final String OPTION_GREEN = "Go to green room";
    private static final String OPTION_YELLOW = "Go to yellow room";
    private static final String OPTION_EXIT = "Exit";
    private static final String[] OPTIONS = {OPTION_RED, OPTION_BLUE, OPTION_GREEN, OPTION_YELLOW, OPTION_EXIT};

    private BlueRoom blueRoom = new BlueRoom();
    private RedRoom redRoom = new RedRoom();
    private GreenRoom greenRoom = new GreenRoom();
    private YellowRoom yellowRoom = new YellowRoom();

    public static void main(String[] args) {


        Game game = new Game();
        game.beginGame();

    }

    public Game(){
        window = new JFrame();
        window.setSize(1200,800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        container = window.getContentPane();
        titlePanel = new JPanel();
        titlePanel.setBounds(200,100,800,250);
        titlePanel.setBackground(Color.black);
        titleName = new JLabel("BIRTHDAY'S MYSTERY");
        titleName.setForeground(Color.white);
        titleName.setFont(titleFont);
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(500, 500,200,100);
        startButtonPanel.setBackground(Color.black);
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(titleScreenHandler);

        startButtonPanel.add(startButton);
        container.add(startButtonPanel);

        titlePanel.add(titleName);
        container.add(titlePanel);

    }

    public void gameScreen(){
        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100,800,350);
        mainTextPanel.setBackground(Color.blue);
        container.add(mainTextPanel);

        mainTextArea = new JTextArea("Game content text will appear here");
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

    }

    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            gameScreen();

        }
    }

    public void beginGame() {

        Player player = new Player();
        Robot robot = new Robot();

        while (true) {

            System.out.println(INTRO);

            String selectedOption = MenuDisplay.prompt(OPTIONS);
            if (selectedOption.equals(OPTION_RED)) {
                redRoom.onEnterRoom(player);
            } else if (selectedOption.equals(OPTION_BLUE)) {
                blueRoom.onEnterRoom(player);
            } else if (selectedOption.equals(OPTION_GREEN)) {
                greenRoom.onEnterRoom(player, robot);
            } else if (selectedOption.equals(OPTION_YELLOW)) {
                yellowRoom.onEnterRoom(player);
            } else {
                System.out.println("Goodbye!");
                break;
            }


        }

    }

}
