package peggle.objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class BluePegObject extends GameObject{
	private final static int PEG_WIDTH = 20;
	private final static int PEG_HEIGHT = 10;
	
	public BluePegObject(int x, int y, int objType) {
		super(x, y, objType);
		super.setHitbox(x, y, PEG_WIDTH, PEG_HEIGHT);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics2D g2d) {
		Rectangle rect = new Rectangle(super.getXPos(), super.getYPos(), PEG_WIDTH, PEG_HEIGHT); 
		g2d.setColor(Color.BLUE);
		g2d.fill(rect);
		g2d.draw(rect);
	}
}
