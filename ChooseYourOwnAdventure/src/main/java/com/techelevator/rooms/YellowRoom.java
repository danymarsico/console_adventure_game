package com.techelevator.rooms;

import com.techelevator.Player;
import com.techelevator.constants.GameConstants;

public class YellowRoom {
    private static final String INTRO_YELLOW = "The door opens, and you enter the Yellow room";


    public void onEnterRoom(Player player){

    }

    private void onOpenDoor(Player player) {
        if(player.hasItem(GameConstants.YELLOW_KEY)){
            System.out.println(INTRO_YELLOW);
            System.out.println("Hurraaay! You've saved the guest of honor: the Birthday person! You can go back to celebrate in the Blue room ^_^");
            //yellowRoom.onEnterRoom(player);
        } else {
            System.out.println("Hmm, looks like the door requires a key");
        }
    }
}
