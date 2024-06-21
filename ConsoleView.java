package view;

import model.World;

/**
 * A view that prints the current state of the world to the console upon every
 * update.
 */
public class ConsoleView implements View {

	@Override
	public void update(World world) {
		// The player's position
		int playerX = world.getPlayerX();
		int playerY = world.getPlayerY();

		// The start's position
		int startX = world.getStartX();
		int startY = world.getStartY();

		// The end's position
		int endX = world.getEndX();
		int endY = world.getEndY();

		//The Enemy's position
		int enemyX = world.myEnemy.getEnemyX();
		int enemyY = world.myEnemy.getEnemyY();

		for (int col = 0; col < world.getHeight(); col++) {
			for (int row = 0; row < world.getWidth(); row++) {
				// If the player is here, print #, otherwise print.
				String this_box = ".";
				if (row == startX && col == startY) {
					this_box = "S";
				} if (row == endX && col == endY) {
					this_box = "E";
				} if (row == playerX && col == playerY) {
					this_box = "#";
				} if (row == enemyX && col == enemyY) {
					this_box = "O";
				}
				 if (world.getWallBool(col, row)) {
					this_box = "\u2588";
				}
				System.out.print(this_box);
			
			}
		System.out.println("");
		}

		// A newline between every update
		System.out.println();
	}

}
