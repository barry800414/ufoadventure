package game;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.io.File;
import javax.imageio.ImageIO;
	
public class GraphicsEngine {
	
	private Game game;
	private GameInfo ginfo;
	
	private JFrame main_scr;
	private BufferStrategy buffer;
	
	private BufferedImage[] playerimage;
	private BufferedImage[] landimage;
	
	public GraphicsEngine(Game game) {
	    this.game = game;
	    this.ginfo = game.ginfo;
	}
	
	public void init() {
	    main_scr = new JFrame();
	    main_scr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    main_scr.setSize(ginfo.SCREEN_WIDTH, ginfo.SCREEN_HEIGHT);
	    main_scr.setVisible(true);
	    
	    try{
		for(int i=0;i<ginfo.players_num;i++)
		    playerimage[i] = ImageIO.read(getClass().getResourceAsStream(ginfo.playerlist[i].picturename));
		for(int i=0;i<ginfo.lands_num;i++)
		    landimage[i] = ImageIO.read(getClass().getResourceAsStream(ginfo.landlist[i].picture_name));
		catch(Exception e){
			System.out.println(e);
		}
		
		//draw();
	}
	public void DrawGameScreen(Player p){
	    int upleftx = p.centerx - ginfo.SCREEN_WIDTH/2 ;
	    int uplefty = p.centery - ginfo.SCREEN_HEIGHT/2;
	    
	    
	    
	}
	
	public void draw() {
		
		/* We cannot create BufferStrategy if it is not diaplayable
		 * (will result in a exception), and it is not necessary to
		 * draw screen if it is not displayable.
		 */
		if(main_scr.isDisplayable()) {
			// Create BufferStrategy on first draw.
			if(buffer == null) {
				main_scr.createBufferStrategy(2);
				buffer = main_scr.getBufferStrategy();
			}
			
			// Get the graphics buffer
			Graphics g = buffer.getDrawGraphics();
			Graphics2D g2d = (Graphics2D)g;
			
			// Clean buffer
			g2d.clearRect(0, 0, (int)info.getWidth(), (int)info.getHeight());
			
			// Draw all components
			drawBullets(g2d);
			drawPlayers(g2d);
			
			// Cleanup
			g.dispose();
			buffer.show();
			
			// Calculate fps
			long since_last_update = time_now - last_fps_update;
			frames_drew++;
			if(since_last_update >= UPDATE_FPS_PERIOD) {
				fps = frames_drew * 1000.0 / since_last_update;
				main_scr.setTitle(String.format("FPS: %.2f", fps));
				frames_drew = 0;
				last_fps_update = time_now;
			}
			
			// Force to update
			Toolkit.getDefaultToolkit().sync();
		}
		
		// Generate next draw event
		last_draw = time_now;
		enqueueNextDraw();
	}
	
	private void drawBullets(Graphics2D g) {
		for(Bullet b : info.getAllBullets()) {
			g.drawImage(bullet,(int)(b.locX-BULLET_SIZE/2),(int)(b.locY-BULLET_SIZE/2),null);
		}
	}
	
	private void drawPlayers(Graphics2D g) {
		for(Player p : info.getAllPlayers()) {
			if(p.isAlive()) {
				g.drawImage(ufo,(int)(p.locX-PLAYER_SIZE/2),(int)(p.locY-PLAYER_SIZE/2),null);
			}
		}
	}
	
	private void enqueueNextDraw() {
		final GraphicsEngine ge = this;
		final long time_next_draw = last_draw + 1000 / TARGET_FPS;
		
		game.getGameQueue().addEvent(new Event() {
			public long getTime() { return time_next_draw; }
			public void action() { ge.draw(); }
		});
	}
	
	public JFrame getMainFrame() {
		return main_scr;
	}
}
