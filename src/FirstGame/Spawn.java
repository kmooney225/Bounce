package FirstGame;

import java.util.Random;

public class Spawn {

	private Handler handler;
	private HUD hud;
	private Game game;
	private Random r = new Random();
	
	private int scoreKeep = 0;
	
	public Spawn(Handler handler, HUD hud, Game game) {
		this.handler = handler;
		this.hud = hud;
		this.game = game;
	}
	
	public void tick() {
		scoreKeep++;
		
		if(scoreKeep >= hud.getLevel()*100) {
			
			scoreKeep = 0;
			hud.setLevel(hud.getLevel()+1);}
		
			if(game.diff == 0)
			{
			
			if (hud.getScore() == 300 ) {
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r. nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
			
			}else if(hud.getScore() == 600) {
			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r. nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
			
			}else if(hud.getScore() == 1100) {
			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r. nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
			
			}else if(hud.getScore() == 2100) {
			handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-50), r. nextInt(Game.HEIGHT-50), ID.SmartEnemy, handler));
			
			}else if (hud.getScore() == 2700 ) {
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r. nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
				
			}else if(hud.getScore() == 3600) {
			handler.clearEnemys();
			handler.addObject(new EnemyBoss(300, 50, ID.EnemyBoss, handler));
			
			}else if(hud.getScore() == 4800) {
				handler.clearEnemys();
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r. nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r. nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r. nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
				
				

			}else if(hud.getScore() == 6000) {
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r. nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r. nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r. nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
				
			}else if(hud.getScore() == 7200)
			{
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-50), r. nextInt(Game.HEIGHT-50), ID.SmartEnemy, handler)); 
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-50), r. nextInt(Game.HEIGHT-50), ID.SmartEnemy, handler));
			}else if(hud.getScore() == 8800)
			{
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r. nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r. nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
			}
			else if(hud.getScore() == 10000)
			{
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r. nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r. nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
			}
			}
			
			else if(game.diff == 1)
			{
			
			if (hud.getScore() == 300 ) {
			handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r. nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
			
			}else if(hud.getScore() == 600) {
			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r. nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
			
			}else if(hud.getScore() == 1100) {
			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r. nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
			
			}else if(hud.getScore() == 2100) {
			handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-50), r. nextInt(Game.HEIGHT-50), ID.SmartEnemy, handler));
			
			}else if (hud.getScore() == 2700 ) {
			handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r. nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
				
			}else if(hud.getScore() == 3600) {
			handler.clearEnemys();
			handler.addObject(new EnemyBoss(300, 50, ID.EnemyBoss, handler));
			
			}else if(hud.getScore() == 4800) {
				handler.clearEnemys();
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r. nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r. nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r. nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
				
				

			}else if(hud.getScore() == 6000) {
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r. nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r. nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r. nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
				
			}else if(hud.getScore() == 7200)
			{
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-50), r. nextInt(Game.HEIGHT-50), ID.SmartEnemy, handler));
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-50), r. nextInt(Game.HEIGHT-50), ID.SmartEnemy, handler));
			}
			
			else if(hud.getScore() == 8800)
			{
				handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r. nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
				handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r. nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
			}
			else if(hud.getScore() == 10000)
			{
				handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r. nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
				handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r. nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
			}
			}
	}
}
