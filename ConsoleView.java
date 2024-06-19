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

		for (int row = 0; row < world.getHeight(); row++) {
			for (int col = 0; col < world.getWidth(); col++) {
				// If the player is here, print #, otherwise print.
				String this_box = ".";
				if (row == startY && col == startX) {
					this_box = "S";
				} if (row == endY && col == endX) {
					this_box = "E";
				} if (row == playerY && col == playerX) {
					this_box = "#";
				}
				System.out.print(this_box);
			
			}
		System.out.println("");
		}

		// A newline between every update
		System.out.println();
	}

}
