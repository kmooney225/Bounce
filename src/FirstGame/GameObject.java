package FirstGame;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
/*
 * abstract method for all of the game objects in the 
 * game.
 */
	protected float x, y;
	protected ID id;
	protected float velX, velY;
	
	public GameObject(float x, float y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	
	public void setX(float x) {this.x = x;}
	
	public void setY(float y) {this.y = y;}
	
	public float getX() {return x;}
	
	public float getY() {return y;}
	
	public void setID(ID id) {this.id = id;}
	
	public ID getID() {return id;}
	
	public void setVelX(int velX) {this.velX = velX;}
	
	public float getvelX() {return velX;}
	
	public void setVelY(int velY) {this.velY = velY;}
	
	public float getvelY() {return velY;}
}
