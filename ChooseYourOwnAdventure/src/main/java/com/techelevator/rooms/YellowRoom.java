package com.techelevator.rooms;

import com.techelevator.Player;
import com.techelevator.constants.GameConstants;
import com.techelevator.menu.MenuDisplay;

public class YellowRoom {
    private static final String INTRO_YELLOW = "The door opens, and you enter the Yellow room.......";
    private static final String OPTION_LEAVE = "Leave room";
    private static final String OPTION_SAY_HI = "Say hello to our Birthday Person";
    private static final String[] OPTIONS = {OPTION_SAY_HI, OPTION_LEAVE};


    public void onEnterRoom(Player player){
        while (true) {
            if(player.hasItem(GameConstants.YELLOW_KEY)){
                YellowRoom.onOpenDoor(player);
                String selectedOption = MenuDisplay.prompt(OPTIONS);
                if (selectedOption.equals(OPTION_SAY_HI)) {
                    System.out.println("Thank you very much for setting me free! I am so happy to able to celebrate my Birthday!");
                } else if (selectedOption.equals(OPTION_LEAVE)) {
                    System.out.println("You exit the room");
                    break;
                }
                break;
                //System.out.println(INTRO_YELLOW);
            } else {
                System.out.println("Hmm, looks like the door requires a key!");
                break;
            }


        }
    }

    private static void onOpenDoor(Player player) {
        if(player.hasItem(GameConstants.YELLOW_KEY)){
            System.out.println(INTRO_YELLOW);
            System.out.println("");
            System.out.println("");
            System.out.println("Hurraaay! You've saved the guest of honor: the Birthday person! You can go back to celebrate in the Blue room ^_^");
        }
    }
}
