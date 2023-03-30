package peggle.objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class BluePegObject extends GameObject {
	private final static int PEG_WIDTH = 20;
	private final static int PEG_HEIGHT = 10;

	public BluePegObject(int x, int y, int rotatedDegrees) {
		super(x, y, ObjectManager.PEG_BLUE);
		super.setHitbox(x, y, PEG_WIDTH, PEG_HEIGHT);
		super.transformHitbox((Rectangle2D.Float) getHitBox().getBounds2D(), rotatedDegrees);
		super.setRotatedDegrees(rotatedDegrees);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics2D g2d) {
		Rectangle rect = new Rectangle(Math.round(super.getXPos()), Math.round(super.getYPos()), PEG_WIDTH, PEG_HEIGHT);

//		g2d.setColor(Color.RED);
//		g2d.fill(getHitBox());

		g2d.setColor(Color.BLUE);
		g2d.rotate(Math.toRadians(super.getRotatedDegrees()), super.getXPos(), super.getYPos());
		g2d.fill(rect);

		g2d.draw(rect);
	}
}
