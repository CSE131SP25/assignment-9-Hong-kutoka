package assignment9;

import java.awt.Color;
import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	private Snake snake;
	private Food food;
	
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		this.snake = new Snake();
		this.food = new Food();
		//FIXME - construct new Snake and Food objects
	}
	
	public void play() {
		while (snake.isInbounds()) { //TODO: Update this condition to check if snake is in bounds
			int dir = getKeypress();
			snake.changeDirection(dir);
			snake.move();
			food.draw();
			
			if (snake.eatFood(food)) { //if the size encounter among them is true it get eat and the snake get added
				food = new Food(); //the variable food now as a new generated position
			}
			//Testing only: you will eventually need to do more work here
			updateDrawing();
			System.out.println("Keypress: " + dir);
			
			/*
			 * 1. Pass direction to your snake
			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */
		}
		displayGameOver();
	}
	private void displayGameOver() {
		StdDraw.clear();
		StdDraw.setPenColor(Color.RED);
		StdDraw.text(0.5, 0.5, "Game Over! You Lose!");
		StdDraw.show();
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		StdDraw.clear(); //clear the main screen each time this is run
		snake.draw(); //the new object is thus drawn, initialized in this file but call the draw in snake.java
		food.draw(); //the food object is thus drawn, initialized in this file but call the draw in food.java
		StdDraw.pause(50);
		StdDraw.show();
		//FIXME
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
	}
	
	public static void main(String[] args) {
		StdDraw.setPenColor(Color.black);
		StdDraw.text(0.5,  0.5, "Snake Game! Press Space to Begin.");
		StdDraw.text(0.50, 0.40, "Controls: W A S D");
		StdDraw.show();
		
		while(true) {
			if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {
				Game g = new Game();
				g.play();
			}
			StdDraw.pause(10);
		}
	}
}
