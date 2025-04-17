package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		//FIXME - set up the segments instance variable
		this.deltaX = 0; //change in x value
		this.deltaY = 0; //change in y value
		this.segments = new LinkedList<>(); //setting a empty list
		BodySegment head = new BodySegment(0.5, 0, SEGMENT_SIZE); //marking the first object of the list as head with this value
		segments.add(head); // then adding it to the list as the first object.
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		BodySegment head = segments.get(0); //setting the first value of the list to this object type name called head
		
		double oldHeadX = head.getX(); //saving the first object x and y from the list in this temporary variable
		double oldHeadY = head.getY();
		
		head.setX(head.getX() + deltaX); //the position of the head value/the first object from the segment list X and Y value get
		head.setY(head.getY() + deltaY); //updated, by setting the new value by calling the old value adding the delta x and Y
		
		for(int i = 1; i < segments.size(); i++) { //for each index in the segments list, go over them one by one
			double tempX = segments.get(i).getX(); // temporary set the segment index object position x and y to a variable
			double tempY = segments.get(i).getY();
			
			segments.get(i).setX(oldHeadX); // segment object index now has the the first object X and Y position now
			segments.get(i).setY(oldHeadY); 
			
			oldHeadX = tempX; //Now this process will continue, setting the first body segment object index x and y, and setting
			oldHeadY = tempY; //it to the next body, so object 1 now has head position, and object 3 now has object 2's position and 
		}// and so on, this than effectively updates the movement. 
		//FIXME
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for (BodySegment body : segments){ //this is going through the list segments which contains a object type
			body.draw();//FIXME // we set the object type temporary to body and call the draw method to draw the body from Body Segment.java.
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		BodySegment head = segments.get(0);
		double distance = Math.sqrt(Math.pow(head.getX() - f.getX(), 2) + Math.pow(head.getY() - f.getY(), 2));
		
		if (distance < MOVEMENT_SIZE) {
			BodySegment tail = segments.get(segments.size() -1); //get the last object value position
			BodySegment newSegment = new BodySegment(tail.getX(), tail.getY(), SEGMENT_SIZE); //set it to the new one here
			segments.add(newSegment); //then adding the newly created body to the end, the rest has already indexed, thus perfectly
			//line it at the end
			return true;
		}
		
		//FIXME
		return false;
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		BodySegment head = segments.get(0); //make sure the main control system "head" object is not out of bound
		double headX = head.getX(); // get the x value of the head
		double headY = head.getY();// get the y value of the head 
		return (headX >= 0 && headX <= 1 && headY >= 0 && headY <=1); //make sure they are within bound. 
		//FIXME
	}
}
