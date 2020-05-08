package FirstGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject{

	private Handler handler;
	
	Random r = new Random(); 
	
	private float timer = 70;
	private float timer2 = 50;
	
	public EnemyBoss(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		velX = 0;
		velY = 2;
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 64, 64);
	}

	public void tick() {

		x += velX;
		y += velY;
		
		if(timer <= 0) {velY = 0;}
		
		else {timer--;}
		
		if (timer <= 0) {timer2--;}
		
		if (timer2 <= 0) {
			if (velX == 0) {
				velX = 2;}
				velX += 0.01;
			
			int spawn = r.nextInt(10);
			if (spawn == 0) {
				handler.addObject(new EnemyBossBullet((int) x+48, (int)y+48, ID.BasicEnemy, handler));
				}
		}
		//if(y <= 0 || y >= Game.HEIGHT-32) {velY *= -1;}
		if(x <= 0 || x >= Game.WIDTH-48) {velX *= -1;}
		
		//handler.addObject(new Trail((int)x, (int)y, 64, 64, ID.Trail, (float) 0.2, Color.red, handler));
		
	}

	
	
	public void render(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect((int)x,  (int)y,  64 , 64);
		
	}

}