package util;

public class Vector {
	public float x;
	public float y;
	
	public Vector(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public static Vector addition(Vector a, Vector b) {
		return new Vector(a.x + b.x, a.y + b.y);
	}
	
	public static Vector subtraction(Vector a, Vector b) {
		return new Vector(a.x - b.x, a.y - b.y);
	}
	
	public static float dotProduct(Vector a, Vector b) {
		return a.x * b.x + a.y * b.y;
	}
	
	public static Vector scalarMultiply(float multi, Vector vec) {
		return new Vector(vec.x * multi, vec.y * multi);
	}
	
	public static Vector ballBounce(Vector a, Vector b) {
		Vector temp = Vector.scalarMultiply(-2 * Vector.dotProduct(a, b), a);
		return Vector.addition(temp, b);
	}
	
	public String toString() {
		return "x: " + x + ", y: " + y;
	}
}
