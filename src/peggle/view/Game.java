package peggle.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.image.BufferedImage;

import peggle.states.GameStateManager;

public class Game implements Runnable{
	
	public final static int GAME_WIDTH = 1920;
	public final static int GAME_HEIGHT = 1080;
	private final int FPS = 120;
	private final int UPS = 200;
	
	public final static float SCALE = 1f;
	
	private GamePanel gamePanel;
	private Thread gameThread;
	private GameStateManager gameStateManager;
//	private BufferedImage img;
	
	public Game() {
		initilaze();
		
		gameStateManager = new GameStateManager();
		gamePanel = new GamePanel(this);
		new GameWindow(gamePanel);
		gamePanel.requestFocusInWindow();
		
		startGame();
	}
	
	private void initilaze(){
//		img = new BufferedImage(GAME_WIDTH,GAME_HEIGHT,BufferedImage.TYPE_INT_ARGB);
	}
	
	private void startGame() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {

		double timePerFrame = 1000000000.0 / FPS;
		double timePerUpdate = 1000000000.0 / UPS;
		
		long prevTime = System.nanoTime();
		
		int frames = 0;
		int updates = 0;
		long lastCheck = System.currentTimeMillis();
		
		double deltaU = 0;
		double deltaF =0;
		
		while(true) {
			long currentTime = System.nanoTime();
			
			deltaU += (currentTime - prevTime) / timePerUpdate;
			deltaF += (currentTime - prevTime) / timePerFrame;
			prevTime = currentTime;
			
			if(deltaU >= 1) {
				update();
				updates++;
				deltaU--;
			}
			
			if(deltaF >= 1) {
				gamePanel.repaint();
				frames++;
				deltaF--;
			}
			
			if(System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames + " | UPS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
		
	}
	
	public void render(Graphics g) {
		gameStateManager.render((Graphics2D) g);
	}
	
	private void update() {
		gameStateManager.update();
	}
}
