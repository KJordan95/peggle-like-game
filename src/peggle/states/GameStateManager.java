package peggle.states;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class GameStateManager {
	public final static int PLAY = 0;
	private List<GameState> states;
	private int currentState;
	
	public GameStateManager() {
		states = new ArrayList<GameState>();
		
		states.add(new PlayState());
		
		currentState = PLAY;
	}
	
	public void update() {
		states.get(currentState).update();
	}
	
	public void render(Graphics2D g2d) {
		states.get(currentState).render(g2d);
	}
}
