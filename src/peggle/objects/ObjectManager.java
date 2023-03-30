package peggle.objects;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class ObjectManager {	
	public final static int BALL = 0;
	public final static int PEG_BLUE = 1;
	public final static int PEG_RED = 2;
	public final static int PEG_GREEN = 3;
	
	private List<GameObject> objects;
	
	public ObjectManager() {
		objects = new ArrayList<GameObject>();
	}
	
	public void addGameObject(GameObject object) {
		objects.add(object);
	}
	
	public void removeGameObject(GameObject object) {
		objects.remove(object);
	}
	
	public void update() {
		for(GameObject object : objects) {
			object.update();
		}
	}
	
	public void render(Graphics2D g2d) {
		for(GameObject object : objects) {
			object.render(g2d);
		}
	}
	
	public void onCollisionWithPeg(Ball ball) {
		for(GameObject peg : objects) {
			if(peg.getObjType() != ObjectManager.BALL) {
				double distanceFormulaX = (ball.getXPos() - peg.getXPos()) * (ball.getXPos() - peg.getXPos());
				double distanceFormulaY = (ball.getYPos() - peg.getYPos()) * (ball.getYPos() - peg.getYPos());
				//double distanceFormulaX = (ball.getHitBox().getBounds().getCenterX() - peg.getHitBox().getBounds().getCenterX()) * (ball.getHitBox().getBounds().getCenterX() - peg.getHitBox().getBounds().getCenterX());
				//double distanceFormulaY = (ball.getHitBox().getBounds().getCenterY() - peg.getHitBox().getBounds().getCenterY()) * (ball.getHitBox().getBounds().getCenterY() - peg.getHitBox().getBounds().getCenterY());
				
				
				double distanceResult = Math.sqrt(distanceFormulaX + distanceFormulaY);
				System.out.println(distanceResult);
//				if(peg.getHitBox().getBounds().intersects(ball.getHitBox().getBounds())) {
				if(distanceResult > 0 && distanceResult <= 20) {
					System.out.println("HIT");
					ball.onCollision(peg);
				}
			}
		}
	}
}
