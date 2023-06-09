package peggle.objects;

import java.awt.Color;
import java.awt.Graphics2D;

import peggle.view.Game;

public class Ball extends GameObject {
	private final static float STARTING_X_VELOCITY = 1;
	private final static float STARTING_Y_VELOCITY = 1;

	private final static int BALL_SIZE = 30;

	private float xPos;
	private float yPos;
	private float xVel;
	private float yVel;
	private boolean isColliding;

	public Ball(int x, int y, int objType) {
		super(x, y, objType);
		super.setHitbox(x, y, BALL_SIZE, BALL_SIZE);
		xPos = x;
		yPos = y;
		xVel = STARTING_X_VELOCITY;
		yVel = STARTING_Y_VELOCITY;
		isColliding = false;
	}

	@Override
	public void render(Graphics2D g2d) {
		g2d.setColor(Color.BLACK);
		g2d.fillArc(Math.round(xPos), Math.round(yPos), BALL_SIZE, BALL_SIZE, 0, 360);
	}

	@Override
	public void update() {
		super.setHitbox(Math.round(xPos), Math.round(yPos), BALL_SIZE, BALL_SIZE);
		onCollision();
		
		xPos = xPos + xVel;
		yPos = yPos + yVel;
		setXPos(xPos);
		setYPos(yPos);
	}

	public void onCollision() {
		float currentXPos = xPos;
		float currentYPos = yPos;

		if (currentXPos >= Game.GAME_WIDTH || currentXPos <= 0) {
			xVel = -xVel;
		}

		if (currentYPos >= Game.GAME_HEIGHT || currentYPos <= 0) {
			yVel = -yVel;
		}
	}

	public void onCollision(GameObject object) {
		if (xPos >= object.getHitBox().getBounds().width || xPos <= object.getXPos()) {
			xVel = -xVel;
		}

		else if (yPos >= object.getHitBox().getBounds().height || yPos <= object.getYPos()) {
			yVel = -yVel;
		}

	}

	public boolean isColliding() {
		return isColliding;
	}

	public void setColliding(boolean isColliding) {
		this.isColliding = isColliding;
	}
}
