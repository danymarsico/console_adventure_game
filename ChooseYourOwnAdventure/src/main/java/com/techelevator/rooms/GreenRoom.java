package com.techelevator.rooms;

import com.techelevator.menu.MenuDisplay;
import com.techelevator.Player;

public class GreenRoom {

    private static final String INTRO = "Welcome to the green room! There is a robot powered by ChatGPT and it wants to fight you. What do you do?";

    private static final String OPTION_FIGHT = "Fight the robot";
    private static final String OPTION_LEAVE = "Leave room";
    private static final String[] OPTIONS = {OPTION_FIGHT, OPTION_LEAVE};

    public void onEnterRoom(Player player) {

        while(true) {

            // Robot Baddie!
            System.out.println("           ____________             ");
            System.out.println("          |            |            ");
            System.out.println("         D| ( O ) ( O )|D           ");
            System.out.println("          |      >     |            ");
            System.out.println("          | ########## |            ");
            System.out.println("   ________|__________|_________    ");
            System.out.println("   |                           |    ");
            System.out.println("   |     |               |     |    ");
            System.out.println("   |     | ~* ChatBot *~ |     |    ");
            System.out.println("   |     |               |     |    ");
            System.out.println("   |     |               |     |    ");
            System.out.println("   |     |               |     |    ");
            System.out.println("   |     |               |     |    ");
            System.out.println("  ) )   ) )             ) )    ) )  ");
            System.out.println("           _______________          ");
            System.out.println("         |     |     |     |        ");
            System.out.println("         |     |     |     |        ");
            System.out.println("         |     |     |     |        ");
            System.out.println("         |     |     |     |        ");
            System.out.println("         |     |     |     |        ");
            System.out.println("         |     |____ |     |____    ");
            System.out.println("        {___________||___________}  ");

            System.out.println(INTRO);

            String selectedOption = MenuDisplay.prompt(OPTIONS);
            if(selectedOption.equals(OPTION_FIGHT)){

                onFightRobot(player);
            }else if(selectedOption.equals(OPTION_LEAVE)){
                System.out.println("You exit the room");
                break;
            }


        }

    }

    private void onFightRobot(Player player) {

        boolean robotWins = ((int)(Math.random() * 10)) <= 5;

        if(robotWins) {
            int healthDeduction = (int) (Math.random() * 20);
            player.setHealth(player.getHealth() - healthDeduction);
            System.out.println("Oh no! The robot is too fast. Your health is down to " + player.getHealth());
        } else {
            int healthDeduction = (int) (Math.random() * 30);
            robot.s
            System.out.println("You damaged the robot!");
        }
    }
}


//Some loose code for what happens if the robot loses:
// set onFightRobot to public voicd
// if robot loses
// Display robot art with x's for eyes
// Display "The robot has been defeated! The guest of honor has been freed!" or something similiar
// Add birthday candles to player inventory

// We will also need to set up another while loop for the Purple Room - one where if you go into the purple room
// and isRobotDead is false, it runs as it was originally written
// but once isRobotDead is true, the intro for the purple room changes
// and the option for eat cake says "*Now* eat the birthday cake."
// I'm thinking we could accomplish this with an if statement at the very beginning of the class (if(robotWins = false) {
// ...it runs as it was originally written
// if true, the we use if else and basically paste in a copy of the existing code, modified.