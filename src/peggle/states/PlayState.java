package peggle.states;

import java.awt.Color;
import java.awt.Graphics2D;

import peggle.objects.Ball;
import peggle.objects.BluePegObject;
import peggle.objects.ObjectManager;
import peggle.view.Game;

public class PlayState extends GameState{
	private ObjectManager objectManager;
	private Ball currentBallOnScreen;

	public PlayState() {
		objectManager = new ObjectManager();
		Ball ball = new Ball(100, 100, ObjectManager.BALL);
		BluePegObject bluePeg = new BluePegObject(500, 500, 1);
		
		/*
		 *  TODO: update currentBall when launching ball into game
		 */
		currentBallOnScreen = ball;
		
		objectManager.addGameObject(ball);
		objectManager.addGameObject(bluePeg);
	}
	
	@Override
	public void update() {
		objectManager.onCollisionWithPeg(currentBallOnScreen);
		objectManager.update();
	}

	@Override
	public void render(Graphics2D g2d) {
		g2d.setColor(Color.darkGray);
		g2d.fillRect(0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT);
		objectManager.render(g2d);
	}
}
