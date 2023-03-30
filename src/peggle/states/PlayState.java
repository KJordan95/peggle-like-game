package peggle.states;

import java.awt.Color;
import java.awt.Graphics2D;

import peggle.objects.Ball;
import peggle.objects.BluePegObject;
import peggle.objects.ObjectManager;
import peggle.view.Game;

public class PlayState extends GameState {
	private ObjectManager objectManager;
	private Ball currentBallOnScreen;

	public PlayState() {
		objectManager = new ObjectManager();
		Ball ball = new Ball(100, 100, ObjectManager.BALL);
		BluePegObject bluePeg = new BluePegObject(500, 475, 0);
//		BluePegObject bluePeg2 = new BluePegObject(275, 3008, 0);
//		BluePegObject bluePeg3 = new BluePegObject(657, 34, 0);
//		BluePegObject bluePeg4 = new BluePegObject(243, 345, 0);
//		BluePegObject bluePeg5 = new BluePegObject(785, 354, 0);
//		BluePegObject bluePeg6 = new BluePegObject(1068, 486, 0);
//		BluePegObject bluePeg7 = new BluePegObject(483, 752, 0);
//		BluePegObject bluePeg8 = new BluePegObject(687, 674, 0);
//		BluePegObject bluePeg9 = new BluePegObject(345, 246, 0);
//		BluePegObject bluePeg10 = new BluePegObject(548, 796, 0);

		/*
		 * TODO: update currentBall when launching ball into game
		 */
		currentBallOnScreen = ball;

		objectManager.addGameObject(ball);
		objectManager.addGameObject(bluePeg);
//		objectManager.addGameObject(bluePeg2);
//		objectManager.addGameObject(bluePeg3);
//		objectManager.addGameObject(bluePeg4);
//		objectManager.addGameObject(bluePeg5);
//		objectManager.addGameObject(bluePeg6);
//		objectManager.addGameObject(bluePeg7);
//		objectManager.addGameObject(bluePeg8);
//		objectManager.addGameObject(bluePeg9);
//		objectManager.addGameObject(bluePeg10);
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
