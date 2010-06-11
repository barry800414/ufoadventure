package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.awt.font.TextAttribute;
import java.text.*;

public class GraphicsEngine{

	//the window screen size
	public final int WIDTH = 800;
	public final int HEIGHT = 600;
	
	//the drawing area size
	public final int DRAW_WIDTH ;
	public final int DRAW_HEIGHT ;
	
	
	private JFrame main_scr;
	//the BufferStrategy is to avoid screen flickering
	private BufferStrategy buffer;
	//the BufferedImage is to save the info of image
	private BufferedImage map;
	private BufferedImage test;
	
	//the border size of the Screen, which will depends on OS
	private Insets border ;
	
	int x = 2600,y = 600;
	
	public GraphicsEngine(){
		main_scr = new JFrame("NTU Monopoly!");
		//when you click the X of the window , the window will be closed
		main_scr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set the window screen size
		main_scr.setSize(WIDTH,HEIGHT);
		
		//You can use this method to remove the border of the window
		//main_scr.setUndecorated(true);
		
		
	}
	
	public boolean MainMenu(){
		
	}
	
	public void GameScreen_init(){
		//let the window visible on your computer
		main_scr.setVisible(true);
		//get the border information of the window
		border = main_scr.getInsets();
		
		//calculate the drawing area of the window
		DRAW_WIDTH = WIDTH - (border.left + border.right);
		DRAW_HEIGHT = HEIGHT - (border.top + border.bottom);
		
		//create the BufferedStrategy for the window
		main_scr.createBufferStrategy(2);
		
		//get the buffer of the BufferedStrategy
		buffer = main_scr.getBufferStrategy();
		
		//load the PNG image from files
		try{
			map = ImageIO.read(new File("NTUmap.png"));
			test = ImageIO.read(new File("test.png"));
		}catch(Exception e){
			System.out.println("picture load failure");
		}
	}
	public void DrawGameScreen(){
		//get the buffer's graphics
		Graphics2D g =(Graphics2D)buffer.getDrawGraphics();
		
		//clear the screen to a color
		g.clearRect(border.left, border.top,DRAW_WIDTH, DRAW_HEIGHT);
		
		//draw an area of image on an area of buffer (Image , draw area upleftx,draw area uplefty , draw area downrightx, draw area downrighty 
		//                                 image area upleftx,image area uplefty , image area downrightx,image area downrighty ,ImageObserver );
		g.drawImage(map,border.left,border.top,border.left + DRAW_WIDTH,border.top +DRAW_HEIGHT,x,y,x+DRAW_WIDTH,y+DRAW_HEIGHT,null);
		
		//draw the whole image on buffer
		g.drawImage(test,border.left,border.top,null);
		
		
		//
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//the output string
		String s = "測試測試測試";
		System.out.println(s.length());
		
		// load the font info from your system
		// (font name,?? , font size)
		Font font = new Font("Serif",Font.PLAIN,48);
		Font biakai = new Font("測試",Font.PLAIN,96);
		
		//g.setFont(font);
		// the more powerful class for drawing string
		AttributedString as = new AttributedString(s);
		as.addAttribute(TextAttribute.FONT,font);
		as.addAttribute(TextAttribute.FONT,biakai,0,2);
		as.addAttribute(TextAttribute.FOREGROUND,Color.red,1,3);
		as.addAttribute(TextAttribute.BACKGROUND,Color.blue,2,4);
		g.drawString(as.getIterator(), 200, 200);
		
		System.out.println("test!");
		//g.dispose();
		
		//show the 
		buffer.show();
		Toolkit.getDefaultToolkit().sync();
	}
	
}
