package peggle.objects;

import java.awt.Graphics2D;

public class PegObject extends GameObject {
	private final static int PEG_WIDTH = 10;
	private final static int PEG_HEIGHT = 3;

	public PegObject(int x, int y, int objType) {
		super(x, y, objType);
		super.setHitbox(x, y, PEG_WIDTH, PEG_HEIGHT);
	}

//	@Override
	public void update() {
	}

//	@Override
	public void render(Graphics2D g2d) {
	}

}
