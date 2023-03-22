package peggle.objects;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class ObjectManager {	
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
}
