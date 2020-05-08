package FirstGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class EnemyBossBullet extends GameObject{

	private Handler handler;
	Random r = new Random();
	
	
	public EnemyBossBullet(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		
		assert velX != 0 && velY != 0;
		velX = (r.nextInt(5 - (-5)) + -5);
		velY = (r.nextInt(5 - (-5)) + -5);
		
		if(velX == 0) velX = 1;
		if(velY == 0) velY = 1;
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick() {

		x += velX;
		y += velY;
		
		//if(y <= 0 || y >= Game.HEIGHT-32) {velY *= -1;}
		//if(x <= 0 || x >= Game.WIDTH-16) {velX *= -1;}
		
		if (y >= Game.HEIGHT) {
			handler.removeObject(this);
		}
		
		handler.addObject(new Trail((int)x, (int)y, 16, 16, ID.Trail, (float) 0.15, Color.orange, handler));
		
	}

	
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x,  (int)y,  16 , 16);
		
	}

}

