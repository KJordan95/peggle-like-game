package peggle.view;

import javax.swing.JFrame;

public class GameWindow extends JFrame{

	private static final long serialVersionUID = 1L;

	private String title;
	GamePanel gamePanel;
		
	GameWindow(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		this.title = "Peggle Like Game";
		
		setTitle(this.title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setContentPane(gamePanel);
		pack();
		setVisible(true);
	}
}
