package FirstGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import FirstGame.Game.STATE;

public class Menu extends MouseAdapter{

	private Game game;
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	public Menu(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;
	}
	
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if (game.gameState == STATE.Menu) {
		//play button
		if(mouseOver(mx, my, 210, 150, 200, 64)) {
			//game.gameState = STATE.Game;
			//handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
			//handler.clearEnemys();
			//handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r. nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
			game.gameState = STATE.Select;
			
			AudioPlayer.getSound("menu_sound").play();
			return;
		}
		
		//help button
		if (mouseOver(mx, my, 210, 250, 200, 64)) {
			game.gameState = STATE.Help;
			
			AudioPlayer.getSound("menu_sound").play();
		}
		

		
			
		//quit button
		if(mouseOver(mx, my, 210, 350, 200, 64)) {
			System.exit(1);
		}
		}
		
		if (game.gameState == STATE.Select) {
		//normal button
		if(mouseOver(mx, my, 210, 150, 200, 64)) {
			game.gameState = STATE.Game;
			handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
			handler.clearEnemys();
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r. nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
			
			game.diff = 0;
			
			AudioPlayer.getSound("menu_sound").play();
		}
		
		//hard button
		if (mouseOver(mx, my, 210, 250, 200, 64)) {
			game.gameState = STATE.Game;
			handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
			handler.clearEnemys();
			handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r. nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
			
			game.diff = 1;
			
			
			AudioPlayer.getSound("menu_sound").play();
		}
		
	
		//back (menu) button
		if(mouseOver(mx, my, 210, 350, 200, 64)) {
			game.gameState = STATE.Menu;
			AudioPlayer.getSound("menu_sound").play();
			return;
		}
		
		}//back button for help
		if(game.gameState == STATE.Help) {
			if (mouseOver(mx, my, 210, 350, 200, 64)) {
				game.gameState = STATE.Menu;
				AudioPlayer.getSound("menu_sound").play();
				return;
			}
		}
		if(game.gameState == STATE.End) {
			if (mouseOver(mx, my, 130, 350, 130, 64)) {
				game.gameState = STATE.Menu;
				if (hud.getScore() >= hud.getHighScore()) {
					hud.setHighScore();
				}
				hud.setLevel(0);
				hud.setScore(0);
				hud.setCP(0);
				handler.spd = 5;
				hud.bounds = 0;
				
				
			}else if (mouseOver(mx, my, 390, 350, 130, 64)) {
				System.exit(1);
			}
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y+ height) {
				return true;
			}else return false;
		}else return false;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		if(game.gameState == STATE.Menu) {
			Font font = new Font("arial", 1, 50);
			Font font2 = new Font("arial", 1, 35);
			
			
			g.setFont(font);
			g.setColor(Color.white);
			g.drawString("Bounce!", 210, 70);
			
			g.setFont(font2);
			g.drawRect(210, 150, 200, 64);
			g.drawString("Start", 270, 195);
			
			g.drawRect(210, 250, 200, 64);
			g.drawString("Help", 270, 295);
			
			g.drawRect(210, 350, 200, 64);
			g.drawString("Quit", 270, 395);
		}
		else if(game.gameState == STATE.Help) {
			Font font = new Font("arial", 1, 50);
			Font font2 = new Font("arial", 1, 35);
			Font font3 = new Font("arial", 1, 17);
			Font font4 = new Font("arial", 1, 23);
			
			
			g.setFont(font);
			g.setColor(Color.white);
			g.drawString("Help", 260, 70);
			
			g.setFont(font3);
			g.drawString("* Use arrow keys to move player and dodge enemies", 90, 130);
			g.drawString("* Face different and unique enemies in higher levels", 95, 155);
			g.drawString("* Reach different levels and get the highest score!", 100, 180);
			g.setFont(font4);
			g.drawString("Designed by: Kevin Mooney", 155, 325);
			
			
			g.setFont(font2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 270, 395);
			}
			
			else if(game.gameState == STATE.End) {
				Font font = new Font("arial", 1, 50);
				Font font2 = new Font("arial", 1, 35);
				Font font3 = new Font("arial", 1, 20);
				
				g.setFont(font);
				g.setColor(Color.white);
				g.drawString("Game Over", 190, 70);
				
				g.setFont(font3);
				g.drawString("You died... ", 280, 190);
				
				
				g.setFont(font3);
				g.drawString("Your Score: " + hud.getScore(), 250, 230);
				
				g.drawString("High Score: " + hud.getHighScore(), 250, 270);
				
				
				g.setFont(font2);
				g.drawRect(130, 350, 130, 64);
				g.drawString("Menu", 150, 395);
				
				g.setFont(font2);
				g.drawRect(390, 350, 130, 64);
				g.drawString("Quit", 420, 395);
		}
			else if(game.gameState == STATE.Select) {
			Font font = new Font("arial", 1, 50);
			Font font2 = new Font("arial", 1, 35);
			
			
			g.setFont(font);
			g.setColor(Color.white);
			g.drawString("SELECT DIFFICULTY", 65, 70);
			
			g.setFont(font2);
			g.drawRect(210, 150, 200, 64);
			g.drawString("Normal", 252, 195);
			
			g.drawRect(210, 250, 200, 64);
			g.drawString("Hard", 270, 295);
			
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 270, 395);
		}
	}
}
