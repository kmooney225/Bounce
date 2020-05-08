package FirstGame;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Writer;

public class HUD {

	public int bounds = 0;
	public static float HEALTH = 100;
	private float greenValue = 255;
	
	private int score = 0;
	private int level = 1;
	private int cp = 0;
	private int highScore = 0;
	
	private String saveDataPath;
	private String fileName = "SaveData";
		
	
	
	public void tick() {	
		HEALTH = Game.clamp(HEALTH, 0, 100+(bounds/2));
		greenValue = HEALTH*2;
		greenValue = Game.clamp(greenValue, 0, 255);

		
		loadHighScore();
		
		cp++;
		score++;
		
		try {
			saveDataPath = Game.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
			//saveDataPath = System.getProperty("HighScore.dat");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(score > highScore) {
			highScore = score;
		}
	}
	
	
	private void createSaveData() {
		try {
			File file = new File(saveDataPath, fileName);
			
			FileWriter output = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(output);
			writer.write(""+ 0);
			//create fastest time
			writer.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void loadHighScore() {
		try {
			File f = new File(saveDataPath, fileName);
			if(!f.isFile()) {
				createSaveData();
			}
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			highScore = Integer.parseInt(reader.readLine());
			//read fastest time
			reader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void setHighScore() {
		FileWriter output = null;
		
		try {
			File f= new File(saveDataPath, fileName);
			output = new FileWriter(f);
			BufferedWriter writer = new BufferedWriter(output);
			
			
			writer.write(""+ highScore);
			writer.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getHighScore() {return highScore;}
	
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200 + bounds, 32);
		g.setColor(new Color(75,(int)greenValue, 0));
		g.fillRect((int)15, (int)15, (int)HEALTH *2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200 + bounds, 32);
		
		g.drawString("score: " + score, 15, 64);
		g.drawString("level: " + level, 15, 80);
		g.drawString("cp: " + cp, 15, 94);
		g.drawString("Space for Shop", 15, 110);
		g.drawString("HighScore: " + highScore, 15, 300);
	}
	
	

	
	
	public void setScore(int score) {this.score = score;}
	
	public int getScore() {return score;}
	
	public void setCP(int cp) {this.cp = cp;}
		
	public int getCP() {return cp;}
	
	public void setLevel(int level) {this.level = level;}
	
	public int getLevel() {return level;}
}
