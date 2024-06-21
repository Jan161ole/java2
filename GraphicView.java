package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import java.util.ArrayList;

import javax.swing.JPanel;

import model.World;

/**
 * A graphical view of the world.
 */
public class GraphicView extends JPanel implements View {

	/** The view's width. */
	private final int WIDTH;
	/** The view's height. */
	private final int HEIGHT;

	private Dimension fieldDimension;

	public GraphicView(int width, int height, Dimension fieldDimension) {
		this.WIDTH = width;
		this.HEIGHT = height;
		this.fieldDimension = fieldDimension;
		this.bg = new Rectangle(WIDTH, HEIGHT);
	}

	/** The background rectangle. */
	private final Rectangle bg;
	/** The rectangle we're moving. */
	private final Rectangle player = new Rectangle(1, 1);

	/** The start rectangle. */
	private final Rectangle start = new Rectangle(1, 1);
	/** The end rectangle. */
	private final Rectangle end = new Rectangle(1,1);

	private final Rectangle enemy1 = new Rectangle(1,1);


	/**
	 * Creates a new instance.
	 */
	@Override
	public void paint(Graphics g) {
		// Paint background
		g.setColor(Color.RED);
		g.fillRect(bg.x, bg.y, bg.width, bg.height);
		// Paint start
		g.setColor(Color.GREEN);
		g.fillRect(start.x, start.y, start.width, start.height);
		// Paint end
		g.setColor(Color.GRAY);
		g.fillRect(end.x, end.y, end.width, end.height);
		// Paint player
		g.setColor(Color.BLACK);
		g.fillRect(player.x, player.y, player.width, player.height);

		g.setColor(Color.yellow);
		g.fillRect(enemy1.x, enemy1.y, enemy1.width, enemy1.height);

		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++){
				if (World.getWallBool(row, col)){
					g.setColor(Color.CYAN);
					g.fillRect(col*25, row*25, 25, 25);
				}
	
			}

		}
		

	}

	@Override
	public void update(World world) {
		
		// Update players size and location
		start.setSize(fieldDimension);
		start.setLocation(
			(int) (world.getStartX() * fieldDimension.width),
			(int) (world.getStartY() * fieldDimension.height)
		);
		repaint();

		// Update players size and location
		end.setSize(fieldDimension);
		end.setLocation(
			(int) (world.getEndX() * fieldDimension.width),
			(int) (world.getEndY() * fieldDimension.height)
		);
		repaint();

		// Update players size and location
		player.setSize(fieldDimension);
		player.setLocation(
			(int) (world.getPlayerX() * fieldDimension.width),
			(int) (world.getPlayerY() * fieldDimension.height)
		);
		repaint();

		// Update players size and location
		player.setSize(fieldDimension);
		player.setLocation(
			(int) (world.getPlayerX() * fieldDimension.width),
			(int) (world.getPlayerY() * fieldDimension.height)
		);
		repaint();

			
		// Update enemy size and location
		enemy1.setSize(fieldDimension);
		enemy1.setLocation(
			(int) (World.myEnemy.getEnemyX() * fieldDimension.width),
			(int) (World.myEnemy.getEnemyY() * fieldDimension.height)
		);
		repaint();
	
	}



}
