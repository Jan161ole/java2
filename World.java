package model;

import java.util.ArrayList;

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
	
	/** The Start's x position in the world */
	private int startX = 0;
	/** The Start's y position in the world */
	private int startY = 0;
	
	/** The end's x position in the world */
	private int endX = 0;
	/** The end's y position in the world */
	private int endY = 0;
	
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
		setPlayerX(getPlayerX() + direction.deltaX);
		setPlayerY(getPlayerY() + direction.deltaY);
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
