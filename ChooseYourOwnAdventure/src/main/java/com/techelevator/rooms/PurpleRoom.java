package com.techelevator.rooms;

import com.techelevator.Game;
import com.techelevator.constants.GameConstants;
import com.techelevator.menu.MenuDisplay;
import com.techelevator.Player;

public class PurpleRoom {

    //if player goes into YellowRoom before going into PurpleRoom (see boolean hasBeenThruYellow in Yellow Room) , then the intro should be
    // "You enter a purple room, and all your friends are there with a big birthday cake. Now that the guest of honor is here, it's time to celebrate!"
    private static final String INTRO = "You enter a purple room, and all your friends are there with a big birthday cake. But someone's missing... the guest of honor! Where could they be?";
    private static final String INTROAFTERYELLOW = "All your friends are there with a big birthday cake. Now that the guest of honor is here, it's time to celebrate!";

    private static final String OPTION_CAKE = "Eat the cake";
    private static final String OPTION_PIZZA = "Eat a slice of pizza";
    private static final String OPTION_LEAVE = "Leave room";
    private static final String[] OPTIONS = {OPTION_CAKE, OPTION_PIZZA, OPTION_LEAVE};

    public void onEnterRoom(Player player) {

        while (true) {

            if(!player.hasItem(GameConstants.YELLOW_KEY)){
                System.out.println(INTRO);
            } else if(player.hasItem((GameConstants.YELLOW_KEY))) {
                System.out.println(INTROAFTERYELLOW);
            }

            String selectedOption = MenuDisplay.prompt(OPTIONS);
            if (selectedOption.equals(OPTION_CAKE) && !player.hasItem(GameConstants.YELLOW_KEY)) {
                System.out.println("You can't cut the cake until the guest of honor is here! Perhaps they need rescuing?");
            } else if (selectedOption.equals(OPTION_CAKE) && player.hasItem(GameConstants.YELLOW_KEY)) {
                onEatCake(player);
            } else if (selectedOption.equals(OPTION_PIZZA)) {
                onEatPizza(player);
            } else if (selectedOption.equals(OPTION_LEAVE)) {
                System.out.println("You exit the room");
                break;
            }


        }

    }

    private void onEatCake(Player player) {
        System.out.println("Congratulations, you can now eat the cake that fully restores your health and can now PARTY!");
        System.out.println("                           !     !     !\n" +
                "(          (    *         |V|   |V|   |V|        )   *   )       (\n" +
                " )   *      )             | |   | |   | |        (       (   *    )\n" +
                "(          (           (*******************)    *       *    )    *\n" +
                "(     (    (           (    *         *    )               )    (\n" +
                " )   * )    )          (   \\|/       \\|/   )         *    (      )\n" +
                "(     (     *          (<<<<<<<<<*>>>>>>>>>)               )    (\n" +
                " )     )        ((*******************************))       (  *   )\n" +
                "(     (   *     ((         HAPPY BIRTHDAY!!!!    ))      * )    (\n" +
                " ) *   )        ((   *    *   *    *    *    *   ))   *   (      )\n" +
                "(     (         ((  \\|/  \\|/ \\|/  \\|/  \\|/  \\|/  ))        )    (\n" +
                "*)     )        ((^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^))       (      )\n" +
                "(     (   (**********************************************) )  * (");
        player.setHealth(player.getHealth() + (100- player.getHealth()));
    }


    //Here is the code where onEatCake is redone so that it's called "pizza" instead:
    private void onEatPizza(Player player) {
        System.out.println("Yum, delicious pizza! You eat a slice and it restores your health.");
        player.setHealth(player.getHealth() + 20);
    }


    //Below is the revised onEatCake code, redone so it doesn't affect health, just prints a congrats message
   /* private void onEatBirthdayCake(Player player) {
                //if (GreenRoom.(onFightRobot)){
        if (Robot.killedRobot()) {
            System.out.println("Sweet victory! You defeated the robot! Well done, hero. Now you have the Yellow Key.");
            player.addItem(GameConstants.YELLOW_KEY);
        }
    }*/


}


