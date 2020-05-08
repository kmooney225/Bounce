package FirstGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

public class Game extends Canvas implements Runnable{
	
	/*
	 * different function of the game for private methods
	 */
	private static final long serialVersionUID = -4975223484964310751L;

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	
	
	private Thread thread;
	private boolean running = false;  //is the thread running or not?
	
	public static boolean paused = false;
	public int diff = 0;
	
	// 0 = normal
	// 1 = hard
	
	
	private Handler handler;
	private Random r;
	private HUD hud;
	private Spawn spawner;
	private Menu menu;
	private Shop shop;
	
	
	
	public enum STATE{
		Menu,
		Select,
		Help,
		Shop,
		Game,
		End
	}
	/*Starts with menu. Can be changed to another state in
	 * reference to the state.
	 */
	public static STATE gameState = STATE.Menu;
	
	
	/**
	 * Main function for the elements of the game.
	 */
	public Game(){
		handler = new Handler();
		
		hud = new HUD();
		shop = new Shop(handler, hud);
		
		menu = new Menu(this, handler, hud);
		this.addKeyListener(new KeyInput(handler, this));
		this.addMouseListener(menu);
		this.addMouseListener(shop);
		
		AudioPlayer.Load();
		AudioPlayer.getMusic("music").loop();
		
		new Window(WIDTH, HEIGHT, "First Game Boi!", this);
		
		r = new Random();
		
		spawner = new Spawn(handler, hud, this);
		
		if (gameState== STATE.Game) {
		
			handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r. nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
		}
		else {
			for(int i = 0; i < 10; i++) {
				handler.addObject(new MenuParticle(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuParticle, handler));
			}
			
		}
	}
	
	
	/**
	 * creates thread. Process groups of functions into 
	 * one stream of execute code
	 */
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	
	/**
	 * catches thread and throws exception if theres and error
	 */
	public synchronized void stop() {
		try {
			thread.join();  //killing off the thread and stopping
			running= false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * runs game. uses an algorithm to calculate time passed
	 * in the game
	 */
	public void run() {
		//A popular game loop found on the internet
		
		this.requestFocus();
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ ns;
			lastTime = now;
			
			
			while(delta >= 1) 
			{
				tick();
				delta--;
			}
			if(running){
				
				
				render();
				frames++;
				
				if(System.currentTimeMillis() - timer > 1000) 
				{
					timer += 1000;
					System.out.println("FPS: " + frames);
					frames = 0;
				}
			}else {
			stop();
			}
		}
	}
	
	
	/**
	 * updates the game logic 
	 */
	private void tick() {
		
		
		if (gameState == STATE.Game) 
		{
			if(!paused)
			{	
				hud.tick();
				spawner.tick();
				handler.tick();
				
				//Ending screen after player lose all his health
				if (HUD.HEALTH <= 0) {
					HUD.HEALTH = 100;
					gameState = STATE.End;
					handler.clearEnemys();
					for(int i = 0; i < 10; i++) {
						handler.addObject(new MenuParticle(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuParticle, handler));
					}
				}
			}
				
		}else if(gameState == STATE.Menu || gameState == STATE.End || gameState == STATE.Help  || gameState == STATE.Select) {
			menu.tick();
			handler.tick();
		}
	}
	
	
	/**
	 * the render method for the game. Generates
	 * the images for the game
	 */
	private void render() {
		
		//buffer method
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		if(paused) {
			g.setColor(Color.white);
			g.drawString("PAUSED", 100, 100);
		}
		
		//different game states in the main render method
		if (gameState == STATE.Game) {
			hud.render(g);
			handler.render(g);
		}
		else if(gameState == STATE.Shop) {
			shop.render(g);
		}
		else if(gameState == STATE.Menu || gameState == STATE.Help|| gameState == STATE.End || gameState == STATE.Select || gameState == STATE.Shop) {
			menu.render(g);
			handler.render(g);
		}
		
		
		g.dispose();
		bs.show();
	}
	
	/**
	 * this is the clamp method. used for setting
	 * bounds to other functions.
	 * 
	 * @param var
	 * @param min
	 * @param max
	 * @return bound of function
	 */
	public static float clamp(float var, float min, float max) {
		if (var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else
			return var;
	}
	
	
	/**
	 * this is the main method for the game
	 * @param args
	 */
	public static void main(String args[]) {
		new Game();
		
	}
}
