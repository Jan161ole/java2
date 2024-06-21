package model;

import java.util.ArrayList;
import java.util.Arrays;

import view.View;

/**
 * The world is our model. It saves the bare minimum of information required to
 * accurately reflect the state of the game. Note how this does not know
 * anything about graphics.
 */
public class World {

	/** The world's width. */
	private final int width;
	/** The world's height. */
	private final int height;
	
	/** The player's x position in the world. */
	private int playerX = 0;
	/** The player's y position in the world. */
	private int playerY = 0;
	/** The player's x startposition in the world. */
	private int startPlayerX = 0;
	/** The player's y startposition in the world. */
	private int startPlayerY = 0;
	
	/** The Start's x position in the world */
	private int startX = 0;
	/** The Start's y position in the world */
	private int startY = 0;
	
	/** The end's x position in the world */
	private int endX = 0;
	/** The end's y position in the world */
	private int endY = 0;

	private static int difficulty = 0;

	/**The positions of the Walls by row */
	private static final ArrayList<Boolean> wals0 = new ArrayList<>(Arrays.asList(false, false, false, true, false, false, false, false, false, false));
	private static final ArrayList<Boolean> wals1 = new ArrayList<>(Arrays.asList(false, true, false, true, false, true, true, true, true, false));
	private static final ArrayList<Boolean> wals2 = new ArrayList<>(Arrays.asList(false, true, false, true, false, true, false, false, false, false));
	private static final ArrayList<Boolean> wals3 = new ArrayList<>(Arrays.asList(false, true, true, true, false, true, false, true, true, true));
	private static final ArrayList<Boolean> wals4 = new ArrayList<>(Arrays.asList(false, true, false, false, false, false, false, false, true, false));
	private static final ArrayList<Boolean> wals5 = new ArrayList<>(Arrays.asList(false, true, false, true, true, true, true, false, true, false));
	private static final ArrayList<Boolean> wals6 = new ArrayList<>(Arrays.asList(false, false, false, false, false, true, false, false, false, false));
	private static final ArrayList<Boolean> wals7 = new ArrayList<>(Arrays.asList(false, true, true, true, false, true, true, true, true, false));
	private static final ArrayList<Boolean> wals8 = new ArrayList<>(Arrays.asList(false, false, false, true, false, true, false, true, false, false));
	private static final ArrayList<Boolean> wals9 = new ArrayList<>(Arrays.asList(false, true, true, true, false, false, false, true, false, false));

	/**The positions of the Walls combined */
	private static ArrayList<ArrayList<Boolean> > walls = new ArrayList<>(Arrays.asList(wals0, wals1, wals2, wals3, wals4, wals5, wals6, wals7, wals8, wals9));

	public static Enemy myEnemy = new Enemy(difficulty);


	
	/** Set of views registered to be notified of world updates. */
	private final ArrayList<View> views = new ArrayList<>();
	
	/**
	 * Creates a new world with the given size.t
	 */
	public World(int width, int height) {
		// Normally, we would check the arguments for proper values
		this.width = width;
		this.height = height;
		this.endX = width -1;
		this.endY = height -1;
	}

	///////////////////////////////////////////////////////////////////////////
	// Getters and Setters

	/**
	 * Returns the width of the world.
	 * 
	 * @return the width of the world.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Returns the height of the world.
	 * 
	 * @return the height of the world.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Returns the player's x position.
	 * 
	 * @return the player's x position.
	 */
	public int getPlayerX() {
		return playerX;
	}

	/**
	 * Sets the player's x position.
	 * 
	 * @param playerX the player's x position.
	 */
	public void setPlayerX(int playerX) {
		playerX = Math.max(0, playerX);
		playerX = Math.min(getWidth() - 1, playerX);
		this.playerX = playerX;
		
		updateViews();
	}

	/**
	 * Returns the player's y position.
	 * 
	 * @return the player's y position.
	 */
	public int getPlayerY() {
		return playerY;
	}

	/**
	 * Sets the player's y position.
	 * 
	 * @param playerY the player's y position.
	 */
	public void setPlayerY(int playerY) {
		playerY = Math.max(0, playerY);
		playerY = Math.min(getHeight() - 1, playerY);
		this.playerY = playerY;
		
		updateViews();
	}

	
	////
	/**
	 * Returns the start's x position.
	 * 
	 * @return the start's x position.
	 */
	public int getStartX() {
		return startX;
	}

	/**
	 * Sets the start's x position.
	 * 
	 * @param startX the start's x position.
	 */
	public void setStartX(int startX) {
		startX = Math.max(0, startX);
		startX = Math.min(getWidth() - 1, startX);
		this.startX = startX;
		
		updateViews();
	}

	/**
	 * Returns the start's y position.
	 * 
	 * @return the start's y position.
	 */
	public int getStartY() {
		return startY;
	}

	/**
	 * Sets the start's y position.
	 * 
	 * @param startY the start's y position.
	 */
	public void setStartY(int startY) {
		startY = Math.max(0, startY);
		startY = Math.min(getHeight() - 1, startY);
		this.startY = startY;
		
		updateViews();
	}


	////
	/**
	 * Returns the start's x position.
	 * 
	 * @return the start's x position.
	 */
	public int getEndX() {
		return endX;
	}

	/**
	 * Sets the end's x position.
	 * 
	 * @param endX the end's x position.
	 */
	public void setEndX(int endX) {
		endX = Math.max(0, endX);
		endX = Math.min(getWidth() - 1, endX);
		this.endX = endX;
		
		updateViews();
	}

	/**
	 * Returns the end's y position.
	 * 
	 * @return the end's y position.
	 */
	public int getEndY() {
		return endY;
	}

	/**
	 * Sets the end's y position.
	 * 
	 * @param endY the end's y position.
	 */
	public void setEndY(int endY) {
		endY = Math.max(0, endY);
		endY = Math.min(getHeight() - 1, endY);
		this.endY = endY;
		
		updateViews();
	}



	////
	/**
	 * Returns the bool of a Wall at a posittion.
	 * 
	 * @return the wall's boolean value at a posittion.
	 */
	public static boolean getWallBool(int x, int y) {
		return walls.get(x).get(y); 
	}

	////
	/**
	 * Returns the list of  Wall's.
	 * 
	 * @return the list of Wall's.
	 */
    public static ArrayList<ArrayList<Boolean>> getWalls() {
        return walls;
	}


	/**
	 * Sets the diffuculty.
	 * 
	 * @param endY the end's y position.
	 */
	public void setdifficulty(int diffuculty) {
		this.difficulty = diffuculty;
		
		updateViews();
	}



	///////////////////////////////////////////////////////////////////////////
	// Player Management
	
	/**
	 * Moves the player along the given direction.
	 * 
	 * @param direction where to move.
	 */
	public void movePlayer(Direction direction) {	
		// The direction tells us exactly how much we need to move along
		// every direction

		//check if new position is okay
		
		int newPlayerX = (getPlayerX() + direction.deltaX);
		int newPlayerY = (getPlayerY() + direction.deltaY);

		if (!getWallBool(newPlayerY, newPlayerX)){
			setPlayerX(newPlayerX);
			setPlayerY(newPlayerY);
		}

		if (newPlayerX == endX && newPlayerY == endY) {
			resetGame();
		}

		if (newPlayerX == myEnemy.getEnemyX() && newPlayerY == myEnemy.getEnemyY()) {
			resetGame();
		}
		myEnemy.move(direction);

		updateViews();
	}

	/**
	 * Resets all players and enemys.
	 * 
	 */
	public void resetGame() {
		//move the Player back to the start.
		setPlayerX(startPlayerX);
		setPlayerY(startPlayerY);
		myEnemy = new Enemy(difficulty);
		updateViews();

	}

	///////////////////////////////////////////////////////////////////////////
	// View Management

	/**
	 * Adds the given view of the world and updates it once. Once registered through
	 * this method, the view will receive updates whenever the world changes.
	 * 
	 * @param view the view to be registered.
	 */
	public void registerView(View view) {
		views.add(view);
		view.update(this);
	}

	/**
	 * Updates all views by calling their {@link View#update(World)} methods.
	 */
	private void updateViews() {
		for (int i = 0; i < views.size(); i++) {
			views.get(i).update(this);
		}
	}

}
