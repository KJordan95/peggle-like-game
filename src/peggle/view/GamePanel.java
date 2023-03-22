package peggle.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{

	private static final long serialVersionUID = 1L;

	public Game game;
	
	public GamePanel(Game game) {
		setPreferredSize(new Dimension(Game.GAME_WIDTH, Game.GAME_HEIGHT));
		setFocusable(true);
		requestFocus();
		this.game = game;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.render(g);
	}

}
