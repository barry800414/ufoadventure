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
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JScrollPane;



public class GraphicsEngine extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private int WIDTH = 960 ,HEIGHT = 600;
	public static int GAME_SCREEN_WIDTH = 752 , GAME_SCREEN_HEIGHT = 516;
	private JLabel gamescreen_jLabel = null;
	private JLabel calendar_jLabel = null;
	private JLabel ntu_jLabel = null;
	private JLabel status_col_jLabel = null;
	private JButton item_bar_jButton = null;
	private JButton exit_jButton = null;
	private JButton dice_jButton = null;
	private JButton item_jButton[] =  new JButton[Item.MAX_ITEMS];
	//private Insets border = null ;
	
	private boolean pressedbutton = true;
	
	private BufferedImage status_col;
	private BufferedImage top_bar;
	private BufferedImage dice_button[] = new BufferedImage[2];
	private BufferedImage calendar_bar;
	private BufferedImage item_bar_button[] = new BufferedImage[2];
	private BufferedImage exit_button[] = new BufferedImage[2];
	private BufferedImage ntu_map_img;
	private BufferedImage houses[] = new BufferedImage[Building.MAX_FLOOR];
	private BufferedImage labs[] = new BufferedImage[Lab.MAX_FLOOR];
	private BufferedImage player[] = new BufferedImage[Player.MAX_TYPE];
	private BufferedImage items[] =  new BufferedImage[Item.MAX_ITEMS];
	private BufferedImage item_buttom[] = new BufferedImage[2] ;
	
	GameInfo ginfo = null;
	
	private JLabel back_map;
	private JPanel map;
	private JScrollPane map_scroll;
	
	/**
	 * This is the default constructor
	 */
	public GraphicsEngine(GameInfo ginfo) {
		super();
		this.ginfo = ginfo;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	public void initialize() {
		this.setSize(WIDTH, HEIGHT);
		this.setMaximumSize(new Dimension(WIDTH,HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH,HEIGHT));
		//this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("NTU Monopoly");
		
		//load picture
		try{
			status_col = ImageIO.read(new File("status_col.png"));
			ntu_map_img = ImageIO.read(new File("NTUmap.png"));
			calendar_bar = ImageIO.read(new File("calendar_bar.png"));
			top_bar = ImageIO.read(new File("top_bar.png"));
			dice_button[0] = ImageIO.read(new File("dice_button.png"));
			dice_button[1] = ImageIO.read(new File("dice_button2.png"));
			exit_button[0] = ImageIO.read(new File("exit_button.png"));
			exit_button[1] = ImageIO.read(new File("exit_button2.png"));
			item_bar_button[0] = ImageIO.read(new File("item_button.png"));
			item_bar_button[1] = ImageIO.read(new File("item_button2.png"));
			item_buttom[0] = ImageIO.read(new File("item_buttom.png"));
			item_buttom[1] = ImageIO.read(new File("item_buttom2.png"));
		}
		catch (Exception e){
			System.out.println("test!");
		}
		
		this.setContentPane(getMainScreenPane());
		
	}
	
	private JScrollPane getMapScroll(){
		if(map_scroll == null){
			map_scroll = new JScrollPane(getMap());
			map_scroll.setBounds(0,50,GAME_SCREEN_WIDTH,GAME_SCREEN_HEIGHT);
			map_scroll.setVerticalScrollBar(map_scroll.createVerticalScrollBar());
			map_scroll.setHorizontalScrollBar(map_scroll.createHorizontalScrollBar());
		}
		return map_scroll;
	}
		
	private JPanel getMap(){
		if(map == null){
			map = new JPanel();
			map.setLayout(null);
			//TODO : add button
			
			map.add(getBackMap());
		}
		return map;
	}
	
	private JLabel getBackMap(){
		if(back_map == null){
			back_map = new JLabel();
			back_map.setSize(4000, 4000);
			back_map.setIcon(new ImageIcon(ntu_map_img));
		}
		return back_map;
	}
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getMainScreenPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(get_ntu_jLabel());
			jContentPane.add(get_calendar_jLabel());
			jContentPane.add(get_status_col_jLabel());
			//jContentPane.add(get_gamescreen_jLabel());
			jContentPane.add(getMapScroll());
			jContentPane.add(get_ItemJButton());
			jContentPane.add(get_ExitJButton1());
			jContentPane.add(get_dice_jButton());
		}
		return jContentPane;
	}

	private JLabel get_ntu_jLabel(){
		if(ntu_jLabel == null){
			ntu_jLabel = new JLabel();
			ntu_jLabel.setBounds(new Rectangle(200, 0, 350, 50));
			ntu_jLabel.setText("NTU Monopoly");
			//ntu_jLabel.setBorder(new LineBorder(Color.BLACK,1));
			ntu_jLabel.setIcon(new ImageIcon(top_bar));
		}
		return ntu_jLabel;
	}
	
	private JLabel get_calendar_jLabel(){
		if(calendar_jLabel == null){
			calendar_jLabel = new JLabel();
			calendar_jLabel.setBounds(new Rectangle(0, 0, 200, 50));
			calendar_jLabel.setText("calendar");
			calendar_jLabel.setIcon(new ImageIcon(calendar_bar));
			//calendar_jLabel.setBorder(new LineBorder(Color.BLACK,1));
		}
		return calendar_jLabel;
	}
	private JLabel get_gamescreen_jLabel(){
		if(gamescreen_jLabel == null){
			gamescreen_jLabel = new JLabel();
			gamescreen_jLabel.setBounds(new Rectangle(0,50,GAME_SCREEN_WIDTH,GAME_SCREEN_HEIGHT));
			gamescreen_jLabel.setIcon(new ImageIcon(draw_game_screen(ginfo.playerlist[0])));
		}
		return gamescreen_jLabel;
	}
	
	private JLabel get_status_col_jLabel(){
		if(status_col_jLabel == null){
			status_col_jLabel = new JLabel();
			status_col_jLabel.setBounds(new Rectangle(752,50,200,466));
			status_col_jLabel.setIcon(new ImageIcon(status_col));
			//status_col_jLabel.setBorder(new LineBorder(Color.BLACK,1));
		}
		return status_col_jLabel;
	}
	
	private BufferedImage draw_game_screen(Player p){
		int scr_w = GAME_SCREEN_WIDTH, scr_h = GAME_SCREEN_HEIGHT;
		Rectangle player_pic_coor = p.getPicCoor();
		Rectangle road_pic_coor = ginfo.roadlist[p.getLocation()].getPicCoor();
		int center_x , center_y;
		center_x = road_pic_coor.x + road_pic_coor.width/2;
		center_y = road_pic_coor.y + road_pic_coor.height/2;
		int x,y,w,h;
		x = scr_w/2 + (player_pic_coor.x - center_x) ;
		y = scr_h/2 + (player_pic_coor.y - center_y) ;
		w = player_pic_coor.width;
		h = player_pic_coor.height;
		
		BufferedImage buf = new BufferedImage(scr_w,scr_h,BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g = buf.createGraphics();
		g.drawImage(ntu_map_img,0,0,scr_w,scr_h,center_x - scr_w/2 ,center_y - scr_h/2, center_x + scr_w/2 , center_y + scr_h/2,null);
		g.drawImage(p.getImage(), x , y , x+w  , y+h , 0 , 0 , w , h ,null);
		return buf;
	}
	
	
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton get_ItemJButton() {
		if (item_bar_jButton == null) {
			item_bar_jButton = new JButton();
			item_bar_jButton.setBounds(new Rectangle(702, 0,150, 50));
			item_bar_jButton.setBorderPainted(false);
			item_bar_jButton.setContentAreaFilled(false);
			item_bar_jButton.setIcon(new ImageIcon(item_bar_button[0]));
			item_bar_jButton.setPressedIcon(new ImageIcon(item_bar_button[1]));
			item_bar_jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("open button column"); // TODO Auto-generated Event stub actionPerformed()
					OpenItemColumn();
				}
			});
		}
		return item_bar_jButton;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton get_ExitJButton1() {
		if (exit_jButton == null) {
			exit_jButton = new JButton();
			exit_jButton.setBounds(new Rectangle(852,0,100,50));
			exit_jButton.setBorderPainted(false);
			exit_jButton.setContentAreaFilled(false);
			exit_jButton.setIcon(new ImageIcon(exit_button[0]));
			exit_jButton.setPressedIcon(new ImageIcon(exit_button[1]));
			exit_jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Exit"); // TODO Auto-generated Event stub actionPerformed()
					System.exit(0);
				}
			});
		}
		return exit_jButton;
	}

	private JButton get_dice_jButton(){
		if(dice_jButton == null){
			dice_jButton = new JButton();
			dice_jButton.setBounds(new Rectangle(752,515,198,50));
			dice_jButton.setBorderPainted(false);
			dice_jButton.setContentAreaFilled(false);
			dice_jButton.setIcon(new ImageIcon(dice_button[0]));
			dice_jButton.setPressedIcon(new ImageIcon(dice_button[1]));
			dice_jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Go"); // TODO Auto-generated Event stub actionPerformed()
					synchronized (ginfo){
						ginfo.notifyAll();
					}
				}
			});
		}
		return dice_jButton ;
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
	
	private JButton create_item_jButton(int x,int y,String item_name){
		int index = x*5+y;
		if(item_jButton[index]==null){
			item_jButton[index] = new JButton();
			item_jButton[index].setBounds(new Rectangle(184+80*y, 446+ 30*x,80,30));
			item_jButton[index].setBorderPainted(false);
			item_jButton[index].setContentAreaFilled(false);
			item_jButton[index].setIcon(new ImageIcon(item_buttom[0]));
			item_jButton[index].setPressedIcon(new ImageIcon(item_buttom[1]));
			item_jButton[index].addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("xdd"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return item_jButton[index];
	}
	
	public void OpenItemColumn(){
		for(int i=0;i<4;i++){
			for(int j=0;j<5;j++){
				System.out.println("test" + i + " " + j);
				JButton buf = create_item_jButton(i,j,"test "+ i + " " + j);
				jContentPane.add(buf);
				jContentPane.setComponentZOrder(buf, 0);
			}
		}
		this.repaint();
	}
	
	public  void GainControl(int player_index){
		status_col_jLabel.setIcon(new ImageIcon(status_col));
		//gamescreen_jLabel.setIcon(new ImageIcon(draw_game_screen(ginfo.playerlist[player_index])));
		synchronized (ginfo){	
				try {
					ginfo.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
