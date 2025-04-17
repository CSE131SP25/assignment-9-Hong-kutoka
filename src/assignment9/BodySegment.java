package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class BodySegment {

	private double x, y, size;
	private Color color;
	
	public BodySegment(double x, double y, double size) {
		//FIXME
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = Color.BLUE;
		//See ColorUtils for some color options (or choose your own)
	}
	
	public double getX() {
		return this.x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double getSize() {
		return this.size;
	}
	/**
	 * Draws the segment
	 */
	public void draw() {
		StdDraw.setPenColor(this.color); // the object got pass through here now it sets the color, and the size,
		StdDraw.setPenRadius(this.size); // set the position from the object body and then boom
		StdDraw.filledCircle(this.x, this.y, this.size); // drawn here, u may ask where did the value come from, the value come from the
		// BodySegments of this class on the top each time the object is called and created it is put inside the list.
		//FIXME
	}
	
}
