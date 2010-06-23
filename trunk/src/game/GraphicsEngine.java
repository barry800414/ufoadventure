package game;

import javax.imageio.ImageIO;
import javax.swing.*;


import java.awt.font.TextAttribute;
import java.awt.image.*;
import java.io.File;
import java.text.AttributedString;


import java.awt.*;

public class GraphicsEngine extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private int WIDTH = 960 ,HEIGHT = 600;
	public static int GAME_SCREEN_WIDTH = 752 , GAME_SCREEN_HEIGHT = 516;
	private JLabel gamescreen_jLabel = null;
	private JLabel calendar_jLabel = null;
	private JLabel ntu_jLabel = null;
	private JLabel status_col_jLabel = null;
	private JLabel buy_house_jLabel = null;
	private JButton item_bar_jButton = null;
	private JButton exit_jButton = null;
	private JButton dice_jButton = null;
	private JButton item_jButton[] =  new JButton[Item.MAX_ITEMS];
	private JButton player_jButton[] = new JButton[GameInfo.MAX_PLAYER];
	private JButton road_jButton[] = new JButton[GameInfo.MAX_ROAD];
	//private Insets border = null ;
	
	private boolean pressedbutton = true;
	
	private BufferedImage test;
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
	private JPanel map,buffer_map;
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
			test = ImageIO.read(new File("test.png"));
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
			//map_scroll.setVerticalScrollBar(new );
			//map_scroll.setHorizontalScrollBar(map_scroll.createHorizontalScrollBar());
			//if(map_scroll.getVerticalScrollBar() == null)
		}
		return map_scroll;
	}
		
	private JPanel getMap(){
		if(buffer_map == null){
			if(map == null){
				map = new JPanel();
				map.setLayout(null);
				map.setOpaque(false);
				for(int i=0;i<GameInfo.MAX_ROAD;i++){
				    map.add(DrawRoad(i));
				}
				//JButton test = new JButton();
				//test.setBounds(2250,1250,100,100);
				//map.setComponentZOrder(test, 0);
				
				//map.add(test);
				//TODO : add button
			}
		
			buffer_map = new JPanel();
			
			buffer_map.setLayout(new OverlayLayout(buffer_map));
			buffer_map.add(map);
			buffer_map.add(getBackMap());
			
		}
		return buffer_map;
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
		    	jContentPane.add(BuyHouse());
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
		    	Font newfont = new Font("標楷體",Font.BOLD,22);
		    	AttributedString as = new AttributedString(" "+ginfo.year+" / "+ginfo.month + " / " + ginfo.day);
		    	as.addAttribute(TextAttribute.FONT, newfont);
		    	as.addAttribute(TextAttribute.FOREGROUND,Color.black);
		    	as.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
		    	BufferedImage buf = calendar_bar;
			Graphics2D g = (Graphics2D)buf.createGraphics();
		    	g.drawString(as.getIterator(), 0, 33);


			calendar_jLabel = new JLabel();
			calendar_jLabel.setBounds(new Rectangle(0, 0, 200, 50));
			//calendar_jLabel.setIcon(new ImageIcon(calendar_bar));
			calendar_jLabel.setIcon(new ImageIcon(buf));
			//calendar_jLabel.setBorder(new LineBorder(Color.BLACK,1));
		}
		return calendar_jLabel;
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
	
	public JButton DrawPlayer(Player p){
		if(player_jButton[p.getID()]==null){
		    player_jButton[p.getID()] = new JButton();
		}
		    player_jButton[p.getID()].setBounds(p.getPicCoor().x,p.getPicCoor().y,p.getPicCoor().width,p.getPicCoor().height);
		    player_jButton[p.getID()].setIcon(new ImageIcon(p.getImage(0)));
		return player_jButton[p.getID()];
	}
	
	public JButton DrawRoad(int road_index){
		if(road_jButton[road_index]==null){
		    road_jButton[road_index] = new JButton();
		    road_jButton[road_index].setBounds(ginfo.roadlist[road_index].getPicCoor());
		    road_jButton[road_index].setIcon(new ImageIcon(ginfo.roadlist[road_index].getImage(0)));
		    road_jButton[road_index].setPressedIcon(new ImageIcon(ginfo.roadlist[road_index].getImage(1)));
		}
		return road_jButton[road_index];
	}
	private JLabel BuyHouse(){
		if(buy_house_jLabel == null){
		    	buy_house_jLabel = new JLabel();
		    	buy_house_jLabel.setBounds(new Rectangle(550, 0, 100, 100));
			buy_house_jLabel.setIcon(new ImageIcon(test));
			jContentPane.setComponentZOrder(buy_house_jLabel, 0);
		    	jContentPane.repaint();
		    	/*
			try{
		    	    Thread.sleep(4000);
		    	}catch(InterruptedException e){
		    	    
		    	}
		    	*/
		    	//jContentPane.remove(get_dice_jButton());
		    	//jContentPane.repaint();
		}
		return buy_house_jLabel;
	}
	
	public  void GainControl(int player_index){
		status_col_jLabel.setIcon(new ImageIcon(status_col));
		map.add(DrawPlayer(ginfo.playerlist[player_index]));
		//gamescreen_jLabel.setIcon(new ImageIcon(draw_game_screen(ginfo.playerlist[player_index])));
		synchronized (ginfo){	
				try {
					ginfo.wait();
					//BuyHouse(ginfo.playerlist[player_index], ginfo.roadlist[ginfo.playerlist[player_index].getLocation()].getLand());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
