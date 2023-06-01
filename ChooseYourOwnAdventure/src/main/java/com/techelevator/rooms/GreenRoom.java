package com.techelevator.rooms;

import com.techelevator.constants.GameConstants;
import com.techelevator.menu.MenuDisplay;
import com.techelevator.Player;
import com.techelevator.rooms.Robot;

public class GreenRoom {

    private static final String INTRO = "Welcome to the green room! There is a robot powered by ChatGPT and it wants to fight you. What do you do?";
    private static final String OUTRO = "You've already defeated the robot and obtained a new key.";

    private static final String OPTION_FIGHT = "Fight the robot";
    private static final String OPTION_LEAVE = "Leave room";
    private static final String[] OPTIONS = {OPTION_FIGHT, OPTION_LEAVE};

    public void onEnterRoom(Player player, Robot robot) {

        while (true) {
            if (!robot.killedRobot()) {

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
                if (selectedOption.equals(OPTION_FIGHT)) {

                    onFightRobot(player, robot);
                } else if (selectedOption.equals(OPTION_LEAVE)) {
                    System.out.println("You exit the room");
                    break;
                }
            } else if (robot.killedRobot()) {
                System.out.println("           ____________             ");
                System.out.println("          |            |            ");
                System.out.println("         D| ( X ) ( X )|D           ");
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


                System.out.println("Congrats! You have finally defeated the ChatBot. Looks like he left you a precious item!");
                System.out.println("");
                robot.onRobotKilled(robot, player);


                String selectedOption = MenuDisplay.prompt(OPTIONS);
                if (selectedOption.equals(OPTION_FIGHT)) {
                    System.out.println(OUTRO);

                }else if (selectedOption.equals(OPTION_LEAVE)) {
                    System.out.println("You exit the room");
                    break;
                }


            }

            /*String selectedOption = MenuDisplay.prompt(OPTIONS);
            if (selectedOption.equals(OPTION_FIGHT)) {

                onFightRobot(player, robot);
            } else if (selectedOption.equals(OPTION_LEAVE)) {
                System.out.println("You exit the room");
                break;
            } */


        }

    }


    public void onFightRobot(Player player, Robot robot) {

        boolean robotWins = ((int) (Math.random() * 10)) <= 5;

        if (player.getHealth()>0) {
            if (robotWins) {
                int healthDeduction = (int) (Math.random() * 20);
                player.setHealth(player.getHealth() - healthDeduction);
                System.out.println("Oh no! The robot is too fast. Your health is down to " + player.getHealth());
            } else {
            /*if (robot.killedRobot()) {
                System.out.println("Congrats! You have finally defeated the ChatBot.Looks like he left you a precious item!");
                System.out.println("");
                robot.onRobotKilled(robot, player);
            } else {*/
                int healthDeduction = (int) (Math.random() * 50);
                robot.setHealth(robot.getHealth() - healthDeduction);
                System.out.println("You damaged the robot! Robot's health is: " + robot.getHealth());
                //}

            }
        } else {
            System.out.println("GAME OVER...The ChatBot has defeated you! Try Again!");
        }

    }


}


// Some loose code for what happens if the robot loses:
// set onFightRobot to public void
// if robot loses
// Display robot art with x's for eyes
// Display "The robot has been defeated! The guest of honor has been freed!" or something similar
// Add yellow key to player inventory

// We will also need to set up another while loop for the Purple Room - one where if you go into the purple room
// and isRobotDead is false, it runs as it was originally written
// but once isRobotDead is true, the intro for the purple room changes
// and the option for eat cake says "*Now* eat the birthday cake."
// I'm thinking we could accomplish this with an if statement at the very beginning of the class (if(robotWins = false) {
// ...it runs as it was originally written
// if true, the we use if else and basically paste in a copy of the existing code, modified.