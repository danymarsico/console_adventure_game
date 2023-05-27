package com.techelevator.rooms;

import com.techelevator.constants.GameConstants;
import com.techelevator.menu.MenuDisplay;
import com.techelevator.Player;

public class PurpleRoom {

    private static final String INTRO = "You enter a purple room, and all your friends are there with a big birthday cake. But someone's missing... the guest of honor! Where could they be?";

    private static final String OPTION_CAKE = "Eat the cake";
    private static final String OPTION_PIZZA = "Eat a slice of pizza";
    private static final String OPTION_LEAVE = "Leave room";
    private static final String[] OPTIONS = {OPTION_CAKE, OPTION_PIZZA, OPTION_LEAVE};

    public void onEnterRoom(Player player) {

        while(true) {

            System.out.println(INTRO);

            String selectedOption = MenuDisplay.prompt(OPTIONS);
            if(selectedOption.equals(OPTION_CAKE)){
                System.out.println("You can't cut the cake until the guest of honor is here! Perhaps they need rescuing?");
            }else if(selectedOption.equals(OPTION_PIZZA)){
                onEatPizza(player);
            }else if(selectedOption.equals(OPTION_LEAVE)){
                System.out.println("You exit the room");
                break;
            }


        }

    }

    //Here it the original code for "onEatCake":
    // private void onEatCake(Player player) {
    //    System.out.println("Congratulations! You eat cake and restore your health!");
    //    player.setHealth( player.getHealth() + 20);
    //}


    //Here is the code where onEatCake is redone so that it's called "pizza" instead:
    private void onEatPizza(Player player)   {
        System.out.println("Yum, delicious pizza! You eat a slice and it restores your health.");
        player.setHealth( player.getHealth() + 20);
    }


    //Below is the revised onEatCake code, redone so it doesn't affect health, just prints a congrats message
    private void onEatBirthdayCake(Player player) {
        if (Robot.killedRobot()){
            System.out.println("Sweet victory! You defeated the robot! Well done, hero. Now you have the Yellow Key.");
            player.addItem(GameConstants.YELLOW_KEY);
        }
    }




}
