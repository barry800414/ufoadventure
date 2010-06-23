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
	private JLabel status_col_label = null;
	private JLabel buy_house_jLabel = null;
	private JButton item_bar_jButton = null;
	private JButton exit_jButton = null;
	private JButton dice_jButton = null;
	private JButton item_jButton[] =  new JButton[Item.MAX_ITEMS];
	private JButton player_button[] ;
	private JButton road_button[] ;
	private JButton land_button[] ;
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
	
	private BufferedImage status_col_buf;
	
	GameInfo ginfo = null;
	
	private JLabel back_map;
	private JPanel map,buffer_map;
	private JScrollPane map_scroll;
	
	boolean flag  = true;
	
	/**
	 * This is the default constructor
	 */
	public GraphicsEngine(GameInfo ginfo) {
		super();
		this.ginfo = ginfo;
		
		
	}

	/**
	 * This method initializes this graphics engine
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
		Load_Pic(); 
		All_Panel_Init();
		All_Label_Init();
		All_Button_Init();
		Add_All_GameObject();
		
		MainScreen_Panel_Init();
		this.setContentPane(jContentPane);
		
	}
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private void MainScreen_Panel_Init() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(ntu_jLabel);
			jContentPane.add(calendar_jLabel);
			jContentPane.add(status_col_label);
			jContentPane.add(map_scroll);
			jContentPane.add(get_ItemJButton());
			jContentPane.add(get_ExitJButton1());
			jContentPane.add(get_dice_jButton());
		}
	}
	
	/*
	 * load all picture
	 */
	private void Load_Pic(){
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
	}
	
	/*
	 * Initialize all buttons
	 */
	private void All_Button_Init(){
		player_button = new JButton[ginfo.players_num];
		road_button = new JButton[ginfo.roadlist.length];
		land_button = new JButton[ginfo.landlist.length];
	}
	
	/*
	 * Initialize all panels
	 */
	private void All_Panel_Init(){
		MapScroll_Init();
	}
	
	private void MapScroll_Init(){
		if(map_scroll == null){
			Map_Init();
			map_scroll = new JScrollPane(buffer_map);
			map_scroll.setBounds(0,50,GAME_SCREEN_WIDTH,GAME_SCREEN_HEIGHT);
		}
	}
		
	private void Map_Init(){
		if(buffer_map == null){
			if(map == null){
				map = new JPanel();
				map.setLayout(null);
				map.setOpaque(false);
			}
			buffer_map = new JPanel();
			buffer_map.setLayout(new OverlayLayout(buffer_map));
			buffer_map.add(map);
			buffer_map.add(getBackMap());
		}
	}
	
	/*
	 * Initialize all labels
	 */
	private void All_Label_Init(){
		Ntu_Label_Init();
		Calendar_Label_Init();
		Status_col_Label_Init();
	}
	
	private void Ntu_Label_Init(){
		if(ntu_jLabel == null){
			ntu_jLabel = new JLabel();
			ntu_jLabel.setBounds(new Rectangle(200, 0, 350, 50));
			ntu_jLabel.setText("NTU Monopoly");
			//ntu_jLabel.setBorder(new LineBorder(Color.BLACK,1));
			ntu_jLabel.setIcon(new ImageIcon(top_bar));
		}
	}
	
	private void Calendar_Label_Init(){
		if(calendar_jLabel == null){
		    Font newfont = new Font("Cooper Black",Font.BOLD,22);
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
	}
	
	private void Status_col_Label_Init(){
		if(status_col_label == null){
			status_col_label = new JLabel();
			status_col_label.setBounds(new Rectangle(752,50,200,466));
			status_col_label.setIcon(new ImageIcon(Draw_Status_Bar_Image(ginfo.playerlist[0])));
			//status_col_jLabel.setBorder(new LineBorder(Color.BLACK,1));
		}
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
					if(flag){
						flag = false;
						synchronized (ginfo){
							ginfo.notifyAll();
						}
					}
					else
						System.out.println("!!!!!!!!!!!!!!!!!!!!!");
				}
			});
		}
		return dice_jButton ;
	}
	
	private Image Draw_Status_Bar_Image(Player p){
		if(status_col_buf == null)
			status_col_buf = new BufferedImage(200,466,5);
		Graphics g = status_col_buf.getGraphics();
		g.drawImage(status_col,0,0,null);
		
		//name cash deposit point property house_num location
		String str[] = new String[7];
		str[0] = p.getName();
		str[1] = "金錢 : " + p.getCash();
		str[2] = "存款 : " + p.getDeposit();
		str[3] = "點數 : " + p.getPoint();
		str[4] = "總財產 : " + p.getProperty();
		str[5] = "房屋數 : " + p.getHouseList().length;
		str[6] = "位置 : " + ginfo.roadlist[p.getLocation()].getLand().getName();
		Font cooper_black = new Font("標楷體",Font.BOLD,20);
		
		for(int i=0;i<str.length;i++){
			AttributedString as = new AttributedString(str[i]);
			as.addAttribute(TextAttribute.FONT,cooper_black);
			as.addAttribute(TextAttribute.FOREGROUND, new Color(255,154,39));
			g.drawString(as.getIterator(), 20 ,180 + 40*i);
		}
		return status_col_buf;
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
		Player p = ginfo.playerlist[player_index];
		
		int center_x,center_y;
		
		
		synchronized (ginfo){	
				try {
					ginfo.wait();
					p.setLocation(p.getLocation()+1);
					Repaint_Status_Col(player_index);
					Repaint_Player_Icon(player_index);
					center_x = p.getPicCoor().x + p.getPicCoor().width/2;
					center_y = p.getPicCoor().y + p.getPicCoor().height/2;
					
					System.out.println(" " + center_x + " " + center_y + " " + (center_x - GAME_SCREEN_WIDTH/2) + " " + (center_y - GAME_SCREEN_HEIGHT/2));
					map_scroll.getHorizontalScrollBar().setValue(center_x - GAME_SCREEN_WIDTH/2);
					map_scroll.getVerticalScrollBar().setValue(center_y - GAME_SCREEN_HEIGHT/2);
					//BuyHouse(ginfo.playerlist[player_index], ginfo.roadlist[ginfo.playerlist[player_index].getLocation()].getLand());
					repaint();
					flag = true;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	public void Repaint_Status_Col(int player_index){
		Player p = ginfo.playerlist[player_index];
		status_col_label.setIcon(new ImageIcon(Draw_Status_Bar_Image(p)));
	}
	
	public void Repaint_Player_Icon(int player_index){
		Player p = ginfo.playerlist[player_index];
		player_button[player_index].setBounds(p.getPicCoor().x,p.getPicCoor().y,p.getPicCoor().width,p.getPicCoor().height);
	}
	
	/*
	 * add all gameobject on the map, map should be initialized first
	 */
	public void Add_All_GameObject(){  
		Player p;
		Road r;
		Land l;
		for(int i=0;i<ginfo.players_num;i++){
			if(player_button[i]==null)
				player_button[i] = new JButton();
			p = ginfo.playerlist[i];
			player_button[i].setBounds(p.getPicCoor().x,p.getPicCoor().y,p.getPicCoor().width,p.getPicCoor().height);
		    player_button[i].setIcon(new ImageIcon(p.getImage(0)));
		    //player_button[i].setContentAreaFilled(false);
		    map.add(player_button[i]);
		}
		for(int i=0;i<ginfo.roadlist.length;i++){
			if(road_button[i] == null)
				road_button[i] = new JButton();
			r = ginfo.roadlist[i];
			road_button[i].setBounds(r.getPicCoor().x,r.getPicCoor().y,r.getPicCoor().width,r.getPicCoor().height);
			road_button[i].setContentAreaFilled(false);
			map.add(road_button[i]);
		}
		for(int i=0;i<ginfo.landlist.length;i++){
			if(land_button[i] == null )
				land_button[i] = new JButton();
			l = ginfo.landlist[i];
			land_button[i].setBounds(l.getPicCoor().x,l.getPicCoor().y,l.getPicCoor().width,l.getPicCoor().height);
			land_button[i].setContentAreaFilled(false);
			map.add(land_button[i]);
		}
	}
	
	
	
}
