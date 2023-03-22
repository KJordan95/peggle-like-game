package peggle.objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball extends GameObject{

	public Ball(int x, int y, int objType) {
		super(x, y, objType);
		super.setHitbox(20, 20);
	}

	@Override
	public void render(Graphics2D g2d) {
		//Graphics2D g2d = (Graphics2D) g;
		Rectangle rect = new Rectangle(50, -50, 1000, 100); 
		g2d.setColor(Color.BLACK);
		g2d.fill(rect);
		g2d.draw(rect);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
