package peggle.view;

import javax.swing.JFrame;

public class GameWindow extends JFrame{

	private static final long serialVersionUID = 1L;

	private String title;
	GamePanel gamePanel;
	
	private static GameWindow window = null;
	
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
	
//	public static Window get() {
//		if(Window.window == null) {
//			Window.window = new Window(gamePanel);
//		}
//		
//		return Window.window;
//	}
}
