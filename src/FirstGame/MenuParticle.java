package FirstGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject{

	private Handler handler;
	
	Random r = new Random();
	
	
	private int red = r.nextInt(255);
	private int green = r.nextInt(255);
	private int blue = r.nextInt(255);
	private Color col;
	
	private int dir = 0;
	
	public MenuParticle(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = (r.nextInt(5 - (-5)) + -5);
		velY = (r.nextInt(5 - (-5)) + -5);
		
		if(velX == 0) velX = 1;
		if(velY == 0) velY = 1;
		
		col = new Color(red, green, blue);
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick() {

		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT-32) {velY *= -1;}
		if(x <= 0 || x >= Game.WIDTH-16) {velX *= -1;}
		
		handler.addObject(new Trail((int)x, (int)y, 16, 16, ID.Trail, (float) 0.04, col, handler));
		
	}

	
	
	public void render(Graphics g) {
		g.setColor(col);
		g.fillRect((int)x,  (int)y,  16 , 16);
		
	}

}
