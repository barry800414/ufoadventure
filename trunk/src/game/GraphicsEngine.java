package game;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.AttributedString;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics2D;
import java.awt.Dimension;
import javax.swing.border.LineBorder;





public class GraphicsEngine extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private int WIDTH = 960 ,HEIGHT = 600;
	private int GAME_SCREEN_WIDTH = 760 , GAME_SCREEN_HEIGHT = 550;
	private JLabel gamescreen_jLabel = null;
	private JLabel calendar_jLabel = null;
	private JLabel ntu_jLabel = null;
	private JLabel status_col_jLabel = null;
	private JButton jButton = null;
	private JButton jButton1 = null;

	private BufferedImage status_col;
	private BufferedImage top_bar;
	private BufferedImage calendar_bar;
	private BufferedImage item_bar;
	private BufferedImage exit_button;
	private BufferedImage ntu_map;
	private BufferedImage houses[] = new BufferedImage[Building.MAX_FLOOR];
	private BufferedImage labs[] = new BufferedImage[Lab.MAX_FLOOR];
	private BufferedImage players[] = new BufferedImage[Player.MAX_TYPE];
	private BufferedImage items[] =  new BufferedImage[Item.MAX_ITEMS];
	
	
	
	/**
	 * This is the default constructor
	 */
	public GraphicsEngine() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(WIDTH, HEIGHT);
		this.setMaximumSize(new Dimension(WIDTH,HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH,HEIGHT));
		//this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("NTU Monopoly");
		
		//load picture
		try{
			status_col = ImageIO.read(new File("status_col.png"));
			ntu_map = ImageIO.read(new File("NTUmap.png"));
			calendar_bar = ImageIO.read(new File("calendar_bar.png"));
		}
		catch (Exception e){
			System.out.println("test!");
		}
		
		this.setContentPane(getJContentPane());
		
		
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			
			jContentPane.add(get_ntu_jLabel(), null);
			jContentPane.add(get_calendar_jLabel(),null);
			jContentPane.add(get_status_col_jLabel(),null);
			jContentPane.add(get_gamescreen_jLabel(), null);
			jContentPane.add(get_ItemJButton(), null);
			jContentPane.add(get_ExitJButton1(), null);
		}
		return jContentPane;
	}

	private JLabel get_ntu_jLabel(){
		if(ntu_jLabel == null){
			ntu_jLabel = new JLabel();
			ntu_jLabel.setBounds(new Rectangle(200, 0, 350, 50));
			ntu_jLabel.setText("NTU Monopoly");
			ntu_jLabel.setBorder(new LineBorder(Color.BLACK,1));
		}
		return ntu_jLabel;
	}
	
	private JLabel get_calendar_jLabel(){
		if(calendar_jLabel == null){
			calendar_jLabel = new JLabel();
			calendar_jLabel.setBounds(new Rectangle(0, 0, 200, 50));
			calendar_jLabel.setText("calendar");
			calendar_jLabel.setIcon(new ImageIcon(calendar_bar));
			calendar_jLabel.setBorder(new LineBorder(Color.BLACK,1));
		}
		return calendar_jLabel;
	}
	private JLabel get_gamescreen_jLabel(){
		if(gamescreen_jLabel == null){
			gamescreen_jLabel = new JLabel();
			gamescreen_jLabel.setBounds(new Rectangle(0,50,GAME_SCREEN_WIDTH,GAME_SCREEN_HEIGHT));
			gamescreen_jLabel.setIcon(new ImageIcon(draw_game_screen(1800,1450)));
		}
		return gamescreen_jLabel;
	}
	
	private JLabel get_status_col_jLabel(){
		if(status_col_jLabel == null){
			status_col_jLabel = new JLabel();
			status_col_jLabel.setBounds(new Rectangle(760,50,200,550));
			status_col_jLabel.setIcon(new ImageIcon(status_col));
			status_col_jLabel.setBorder(new LineBorder(Color.BLACK,1));
		}
		return status_col_jLabel;
	}
	
	private BufferedImage draw_game_screen(int center_x,int center_y){
		int w = GAME_SCREEN_WIDTH, h = GAME_SCREEN_HEIGHT;
		BufferedImage buf = new BufferedImage(GAME_SCREEN_WIDTH,GAME_SCREEN_HEIGHT,BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g = buf.createGraphics();
		g.drawImage(ntu_map,0,0,w,h,center_x - w/2 ,center_y - h/2, center_x + w/2 , center_y + h/2,null);
		
		
		return buf;
	}
	
	
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton get_ItemJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(710, 0,150, 50));
			jButton.setText("items");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton get_ExitJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(860,0,100,50));
			jButton1.setText("exit");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton1;
	}

	private Image DrawStatusBar(){
		BufferedImage buf = new BufferedImage(200,550,5);
		Graphics g = buf.getGraphics();
		g.drawImage(status_col,0,0,null);
		String s = "測試測試" ;
		Font biakai = new Font("標楷體",Font.PLAIN,16);
		AttributedString as = new AttributedString(s);
		as.addAttribute(TextAttribute.FONT,biakai);
		g.drawString(as.getIterator(),100,100);
		
		return buf;
	}
	
}
