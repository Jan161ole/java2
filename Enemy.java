package model;

import java.util.Random;


public class Enemy {
    private int positionX;
    private int positionY;
    private int dificulty;

    public Enemy(int dificulty) {
        this.dificulty = dificulty;

        //Create a random
        Random random = new Random();


        int ranX = random.nextInt(9);
        int ranY = random.nextInt(9);
        while (World.getWallBool(ranY, ranX)) {
            ranX = random.nextInt(9);
            ranY = random.nextInt(9);
        }

        this.positionX = ranX;
        this.positionY = ranY;

    }

    public int getEnemyX() {
        return positionX;
    }

    public void setEnemyX(int x) {
        this.positionX = x;
    }

    public int getEnemyY() {
        return positionY;
    }

    public void setEnemyY(int y) {
        this.positionY = y;
    }


    public int getDificulty() {
        return dificulty;
    }

    public void moveEnemey(Direction direction) {	
		// The direction tells us exactly how much we need to move along
		// every direction

		//check if new position is okay
		
		int newEnemyX = (getEnemyX() + direction.deltaX);
		int newEnemyY = (getEnemyY() + direction.deltaY);

		if (!World.getWallBool(newEnemyY, newEnemyX)){
			setEnemyX(newEnemyX);
			setEnemyY(newEnemyY);
		}
	}

    public void move(Direction directionPlayer) {
        if (this.dificulty == 0) {
            easy();
        } if (this.dificulty == 1){
            medium();
        } if (this.dificulty == 2) {
            hard(directionPlayer);
        }
    }

    private void easy() {
        //Enemy does not move
    }

    private void medium() {
        //Enemy moves randomly
        Random random = new Random();
        int direction = random.nextInt(4);

        switch (direction) {
            case 0:
                moveEnemey(Direction.NONE);
                break;
            case 1:
                moveEnemey(Direction.UP);
                break;
            case 2:
                moveEnemey(Direction.RIGHT);
                break;
            case 3:
                moveEnemey(Direction.DOWN);
                break;
            case 4:
                moveEnemey(Direction.LEFT);
                break;
        }
        
    }
    
    private void hard(Direction directionPlayer) {
        //Enemy coppys your evry move
        
        moveEnemey(directionPlayer);
    }
}
