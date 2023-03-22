package peggle.objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import peggle.view.Game;

public class Ball extends GameObject {
	private final static int STARTING_X_VELOCITY = 5;
	private final static int STARTING_Y_VELOCITY = 5;

	private final static int BALL_SIZE = 30;

	private int xPos;
	private int yPos;
	private int xVel;
	private int yVel;

	public Ball(int x, int y, int objType) {
		super(x, y, objType);
		super.setHitbox(x, y, BALL_SIZE, BALL_SIZE);
		xPos = x;
		yPos = y;
		xVel = STARTING_X_VELOCITY;
		yVel = STARTING_Y_VELOCITY;
	}

	@Override
	public void render(Graphics2D g2d) {
		g2d.setColor(Color.BLACK);
		g2d.fillArc(xPos, yPos, BALL_SIZE, BALL_SIZE, 0, 360);
	}

	@Override
	public void update() {
		super.setHitbox(xPos, yPos, BALL_SIZE, BALL_SIZE);
		onCollision();

		xPos = xPos + xVel;
		yPos = yPos + yVel;
	}

	public void onCollision() {
		float currentXPos = this.getHitBox().x;
		float currentYPos = this.getHitBox().y;

		if (currentXPos >= Game.GAME_WIDTH || currentXPos <= 0) {
			xVel = -xVel;
		}

		if (currentYPos >= Game.GAME_HEIGHT || currentYPos <= 0) {
			yVel = -yVel;
		}
	}
}
