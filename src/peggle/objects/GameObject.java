package peggle.objects;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

import peggle.view.Game;

public abstract class GameObject {

	private float x;
	private float y;
	private int rotatedDegrees;
	private int objType;
	private Path2D.Float hitbox;

	public abstract void update();

	public abstract void render(Graphics2D g2d);

	public GameObject(int x, int y, int objType) {
		this.x = x;
		this.y = y;
		this.objType = objType;
		this.rotatedDegrees = 0;
	}

	public void setHitbox(int x, int y, int width, int height) {
		hitbox = new Path2D.Float(new Rectangle2D.Float(x, y, (int) (width * Game.SCALE), (int) (height * Game.SCALE)));
	}

	public Path2D.Float getHitBox() {
		return hitbox;
	}

	public float getXPos() {
		return x;
	}

	public void setXPos(float x) {
		this.x = x;
	}

	public float getYPos() {
		return y;
	}

	public void setYPos(float y) {
		this.y = y;
	}

	public int getObjType() {
		return objType;
	}

	public void setObjType(int objType) {
		this.objType = objType;
	}

	public void transformHitbox(Rectangle2D.Float rect, int rotateDegrees) {
		AffineTransform transform = new AffineTransform();
		double angle = Math.toRadians(rotateDegrees);
//	    transform.translate(width / 2, height / 2);
//	    transform.rotate(angle, rect.x + rect.width / 2, rect.y + rect.height / 2);
		transform.rotate(angle, rect.x, rect.y);

		hitbox = new Path2D.Float(rect, transform);
//	    return new Path2D.Float(rect, transform);
	}

	public int getRotatedDegrees() {
		return rotatedDegrees;
	}

	public void setRotatedDegrees(int rotatedDegrees) {
		this.rotatedDegrees = rotatedDegrees;
	}
}
