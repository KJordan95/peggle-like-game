package peggle.objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball extends GameObject{
	private final static int STARTING_X_VELOCITY = 1;
	private final static int STARTING_Y_VELOCITY = 5;
	
	private final static int BALL_SIZE = 30;
	
	private int xPos;
	private int yPos;
	private int xVel;
	private int yVel;
	
	public Ball(int x, int y, int objType) {
		super(x, y, objType);
		super.setHitbox(x, y);
		xPos = x;
		yPos = y;
		xVel = STARTING_X_VELOCITY;
		yVel = STARTING_Y_VELOCITY;
	}

	@Override
	public void render(Graphics2D g2d) {
		g2d.setColor(Color.BLACK);
		g2d.fillArc(xPos, 140, BALL_SIZE, BALL_SIZE, 0, 360);
//		System.out.println(xPos);
	}

	@Override
	public void update() {
		xPos = xPos + xVel;
		
	}
}
