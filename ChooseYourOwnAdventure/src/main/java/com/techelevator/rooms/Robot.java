package com.techelevator.rooms;

import com.techelevator.Player;
import com.techelevator.constants.GameConstants;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    private final int MAX_HEALTH = 100;
    private final int MIN_HEALTH = 0;

    private int health = MAX_HEALTH;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health > MAX_HEALTH) {
            this.health = MAX_HEALTH;
        } else if (health < MIN_HEALTH) {
            this.health = MIN_HEALTH;
        } else {
            this.health = health;
        }
    }

    public boolean killedRobot(){
        if(health == MIN_HEALTH) {
            return true;
        }
        return false;
    }
    public void onRobotKilled(Robot robot, Player player) {
        if (robot.killedRobot()) {
            System.out.println("Congratulations! You found a yellow key!");
            player.addItem(GameConstants.YELLOW_KEY);
        }
    }

}
