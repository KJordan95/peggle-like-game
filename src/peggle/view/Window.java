package peggle.view;

import javax.swing.JFrame;

public class Window extends JFrame{

	private static final long serialVersionUID = 1L;

	private String title;
	
	private static Window window = null;
	
	private Window() {
		this.title = "Peggle Like Game";
		
		setTitle(this.title);
		setContentPane(new GamePanel(new Game()));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static Window get() {
		if(Window.window == null) {
			Window.window = new Window();
		}
		
		return Window.window;
	}
}
