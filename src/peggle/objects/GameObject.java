package peggle.objects;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import peggle.view.Game;

public abstract class GameObject {

	private int x;
	private int y;
	private int objType;
	private Rectangle2D.Float hitbox;
	private int xOffset;
	private int yOffset;
	
	public GameObject(int x, int y, int objType) {
		this.x = x;
		this.y = y;
		this.objType = objType;
	}
	
	public void setHitbox(int x, int y, int width, int height) {
		hitbox = new Rectangle2D.Float(x, y, (int) (width * Game.SCALE), (int) (height * Game.SCALE));
	}
	
	public Rectangle2D.Float getHitBox(){
		return hitbox;
	}
	
	public abstract void update();
	public abstract void render(Graphics2D g2d);
}
