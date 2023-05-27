package com.techelevator.rooms;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    private final int MAX_HEALTH = 100;
    private final int MIN_HEALTH = 0;

    private boolean isRobotDead = false;

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

    public void killedRobot(){
        if(health == MIN_HEALTH) {
            isRobotDead = true;
        }
    }

}
