package peggle.states;

import java.awt.Color;
import java.awt.Graphics2D;

import peggle.objects.Ball;
import peggle.objects.ObjectManager;
import peggle.view.Game;

public class PlayState extends GameState{
	private ObjectManager objectManager;

	public PlayState() {
		objectManager = new ObjectManager();
		Ball ball = new Ball(100, 100, 1);
		objectManager.addGameObject(ball);
	}
	
	@Override
	public void update() {
		objectManager.update();
	}

	@Override
	public void render(Graphics2D g2d) {
		g2d.setColor(Color.darkGray);
		g2d.fillRect(0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT);
		objectManager.render(g2d);
	}

}
