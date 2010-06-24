package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.font.TextAttribute;
import java.awt.image.*;
import java.io.File;
import java.text.AttributedString;
import java.awt.event.*;
import java.awt.*;



public class GG extends JFrame {

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
	public GG(GameInfo ginfo) {
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
	
	private void MapReset(Player p){
	    map.setBounds(GAME_SCREEN_WIDTH/2 - p.getPicCoor().x - p.getPicCoor().width/2, GAME_SCREEN_HEIGHT/2 - p.getPicCoor().y - p.getPicCoor().height/2 + 50,4000,4000);
	    this.repaint();
	}
		
	private JPanel getMap(){
			if(map == null){
				map = new JPanel();
				map.setLayout(null);
				map.setOpaque(false);
				map.setBounds(0,50,4000,4000);
				map.add(getBackMap());
				for(int i=0;i<GameInfo.MAX_ROAD;i++){
				    map.add(DrawRoad(i));
				}
				//JButton test = new JButton();
				//test.setBounds(2250,1250,100,100);
				//map.setComponentZOrder(test, 0);
				
				//map.add(test);
				//TODO : add button
			
		}
		return map;
	}
	
	private JLabel getBackMap(){
		if(back_map == null){
			back_map = new JLabel();
			back_map.setBounds(0,0,4000, 4000);
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
			jContentPane.add(get_ItemJButton());
			jContentPane.add(get_ExitJButton1());
			jContentPane.add(get_dice_jButton());
			jContentPane.add(getMap());/*
			jContentPane.setComponentZOrder(get_ItemJButton(), 0);
			jContentPane.setComponentZOrder(get_ExitJButton1(), 0);
			jContentPane.setComponentZOrder(get_dice_jButton(), 0);*/
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
					synchronized (ginfo){
						ginfo.notifyAll();
						    jContentPane.repaint();
					}
					System.out.println("Go"); // TODO Auto-generated Event stub actionPerformed()
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
	
	private boolean tmp;
	private JPanel building_jPanel = null;
	private JPanel move_jPanel = null;
	private JLabel buildingtxt_jLabel = null;
	private JLabel movetxt_jLabel = null;
	private JButton yes_jButton = null;
	private JButton no_jButton = null;
	private JButton ok_jButton = null;
	private LineBorder Border = null;
	public void GoToBuilding(Building b,int condition){
	    JPanel buf = get_building_jPanel();
	    JLabel buf_1 = get_buildingtxt_jLabel(b, condition);
	    buf.add(buf_1);
	    jContentPane.add(buf);
	    jContentPane.setComponentZOrder(buf, 0);
	    this.repaint();
	}
	
	private JPanel get_building_jPanel(){
	    if(building_jPanel == null){
		building_jPanel = new JPanel();
		building_jPanel.setBounds(new Rectangle(240, 370, 300, 160));
	    }
	    return building_jPanel;
	}
	private JLabel get_buildingtxt_jLabel(Building b, int condition){
		if(buildingtxt_jLabel == null){
		    buildingtxt_jLabel = new JLabel();
		    buildingtxt_jLabel.setBounds(new Rectangle(0, 0, 300, 160));
		    buildingtxt_jLabel.setBorder(getBoarder());
		}
		    Font newfont = new Font("標楷體",Font.BOLD,18);
		    AttributedString as1,as2;
		    if(condition == 1){
			as1 = new AttributedString(b.getName()+"  價格:"+b.getLandPrice());
			as2 = new AttributedString("   這是無人空地  要買嗎?");
			building_jPanel.add(get_yes_jButton());
			building_jPanel.add(get_no_jButton());
			get_yes_jButton().setBounds(new Rectangle(25, 100, 100, 50));
			get_no_jButton().setBounds(new Rectangle(175, 100, 100, 50));
			get_yes_jButton().addActionListener(remove_building_jPanel);
			get_no_jButton().addActionListener(remove_building_jPanel);
		    }
		    else if(condition == 2){
			as1 = new AttributedString("   "+b.getName()+"  "+b.getFloor()+" 層");
			as2 = new AttributedString("  升級費 "+(int)(b.getLandPrice()*0.1)+"  要升級嗎?");
			building_jPanel.add(get_yes_jButton());
			building_jPanel.add(get_no_jButton());
			get_yes_jButton().setBounds(new Rectangle(25, 100, 100, 50));
			get_no_jButton().setBounds(new Rectangle(175, 100, 100, 50));
			get_yes_jButton().addActionListener(remove_building_jPanel);
			get_no_jButton().addActionListener(remove_building_jPanel);
		    }
		    else{
			as1 = new AttributedString(b.getName()+"   擁有者 "+b.getOwner()+" ");
			as2 = new AttributedString("     "+b.getFloor()+" 層"+"\n  過路費  "+b.getToll());
			building_jPanel.add(get_ok_jButton());
			get_ok_jButton().setBounds(new Rectangle(100, 100, 100, 50));
			get_ok_jButton().addActionListener(remove_building_jPanel);
		    }
		
		    as1.addAttribute(TextAttribute.FONT, newfont);
		    as1.addAttribute(TextAttribute.FOREGROUND,Color.black);
		    as1.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
		    as2.addAttribute(TextAttribute.FONT, newfont);
		    as2.addAttribute(TextAttribute.FOREGROUND,Color.black);
		    as2.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
		    BufferedImage buf = new BufferedImage(300, 160, BufferedImage.TYPE_3BYTE_BGR);
		    Graphics2D g = (Graphics2D)buf.createGraphics();
		    g.setColor(new Color(255,253,183));
		    g.fillRect(0, 0, 300, 160);
		    g.drawString(as1.getIterator(), 14, 25);
		    g.drawString(as2.getIterator(), 14, 58);
		    buildingtxt_jLabel.setIcon(new ImageIcon(buf));
		return buildingtxt_jLabel;
	}
	
	public void MoveMsgPanel(int move){

	    JPanel buf = get_move_jPanel();
	    JLabel buf_1 = get_movetxt_jLabel(move);
	    buf.add(buf_1);
	    jContentPane.add(buf);
	    jContentPane.setComponentZOrder(buf, 0);
	    this.repaint();
	}
	
	private JPanel get_move_jPanel(){
	    if(move_jPanel == null){
		move_jPanel = new JPanel();
		move_jPanel.setBounds(new Rectangle(260, 370, 260, 160));
	    }
	    return move_jPanel;
	}
	

	private JLabel get_movetxt_jLabel(int move){
		if(movetxt_jLabel == null){
		    movetxt_jLabel = new JLabel();
		    movetxt_jLabel.setBounds(new Rectangle(0, 0, 260, 160));
		    movetxt_jLabel.setBorder(getBoarder());
		}
		    Font newfont = new Font("標楷體",Font.BOLD,28);
		    AttributedString as = new AttributedString("移動距離 : "+move);

		    move_jPanel.add(get_ok_jButton());
		    get_ok_jButton().setBounds(new Rectangle(80, 100, 100, 50));
		    get_ok_jButton().addActionListener(remove_move_jPanel);
		    as.addAttribute(TextAttribute.FONT, newfont);
		    as.addAttribute(TextAttribute.FOREGROUND,Color.black);
		    as.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
		    BufferedImage buf = new BufferedImage(260, 160, BufferedImage.TYPE_3BYTE_BGR);
		    Graphics2D g = (Graphics2D)buf.createGraphics();
		    g.setColor(new Color(255,253,183));
		    g.fillRect(0, 0, 260, 160);
		    g.drawString(as.getIterator(), 30, 45);
		    movetxt_jLabel.setIcon(new ImageIcon(buf));
		return movetxt_jLabel;
	}

	private JButton get_yes_jButton(){
	    if(yes_jButton == null){
		yes_jButton = new JButton();
		Font newfont = new Font("標楷體",Font.BOLD,22);
		AttributedString as = new AttributedString("   好   ");
		as.addAttribute(TextAttribute.FONT, newfont);
		as.addAttribute(TextAttribute.FOREGROUND,new Color(255,154,39));
		as.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
		
		BufferedImage buf1 = new BufferedImage(100, 50, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g1 = (Graphics2D)buf1.createGraphics();
		g1.setColor(new Color(255,253,183));
		g1.fillRect(0, 0, 100, 50);
		g1.drawString(as.getIterator(), 4, 30);
		yes_jButton.setIcon(new ImageIcon(buf1));
		
		as.addAttribute(TextAttribute.FOREGROUND,new Color(255,253,183));
		BufferedImage buf2 = new BufferedImage(100, 50, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g2 = (Graphics2D)buf2.createGraphics();
		g2.setColor(new Color(255,154,39));
		g2.fillRect(0, 0, 100, 50);
		g2.drawString(as.getIterator(), 4, 30);
		yes_jButton.setPressedIcon(new ImageIcon(buf2));
		yes_jButton.setBorder(getBoarder());
		
	    }
	    return yes_jButton;
	}
	
	private JButton get_no_jButton(){
	    if(no_jButton == null){
		no_jButton = new JButton();
		Font newfont = new Font("標楷體",Font.BOLD,22);
		AttributedString as = new AttributedString("  不好   ");
		
		as.addAttribute(TextAttribute.FONT, newfont);
		as.addAttribute(TextAttribute.FOREGROUND,new Color(255,154,39));
		as.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
		BufferedImage buf1 = new BufferedImage(100, 50, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g = (Graphics2D)buf1.createGraphics();
		g.setColor(new Color(255,253,183));
		g.fillRect(0, 0, 100, 50);
		g.drawString(as.getIterator(), 5, 30);
		no_jButton.setIcon(new ImageIcon(buf1));
		
		as.addAttribute(TextAttribute.FOREGROUND,new Color(255,253,183));
		BufferedImage buf2 = new BufferedImage(100, 50, BufferedImage.TYPE_3BYTE_BGR);
		g = (Graphics2D)buf2.createGraphics();
		g.setColor(new Color(255,154,39));
		g.fillRect(0, 0, 100, 50);
		g.drawString(as.getIterator(), 5, 30);
		no_jButton.setPressedIcon(new ImageIcon(buf2));
		no_jButton.setBorder(getBoarder());
	    }
	    return no_jButton;
	}
	
	private JButton get_ok_jButton(){
	    if(ok_jButton == null){
		ok_jButton = new JButton();
		Font newfont = new Font("標楷體",Font.BOLD,24);
		AttributedString as = new AttributedString("OK");
		
		as.addAttribute(TextAttribute.FONT, newfont);
		as.addAttribute(TextAttribute.FOREGROUND,new Color(255,154,39));
		as.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
		BufferedImage buf1 = new BufferedImage(100, 50, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g = (Graphics2D)buf1.createGraphics();
		g.setColor(new Color(255,253,183));
		g.fillRect(0, 0, 100, 50);
		g.drawString(as.getIterator(), 35, 30);
		ok_jButton.setIcon(new ImageIcon(buf1));
		
		as.addAttribute(TextAttribute.FOREGROUND,new Color(255,253,183));
		BufferedImage buf2 = new BufferedImage(100, 50, BufferedImage.TYPE_3BYTE_BGR);
		g = (Graphics2D)buf2.createGraphics();
		g.setColor(new Color(255,154,39));
		g.fillRect(0, 0, 100, 50);
		g.drawString(as.getIterator(), 35, 30);
		ok_jButton.setPressedIcon(new ImageIcon(buf2));
		ok_jButton.setBorder(getBoarder());
	    }
	    return ok_jButton;
	}
	
	private ActionListener remove_building_jPanel = new ActionListener(){
	    public void actionPerformed(ActionEvent e) {
		    jContentPane.remove(building_jPanel); // TODO Auto-generated Event stub actionPerformed()

			synchronized (ginfo){
				ginfo.notifyAll();
				    jContentPane.repaint();
			}
	    }
	};
	private ActionListener remove_move_jPanel = new ActionListener(){
	    public void actionPerformed(ActionEvent e) {
		    jContentPane.remove(move_jPanel); // TODO Auto-generated Event stub actionPerformed()
			synchronized (ginfo){
				ginfo.notifyAll();
				    jContentPane.repaint();
			}
	    }
	};
	private LineBorder getBoarder(){
	    if(Border == null){
		Border = new LineBorder(new Color(255,154,39), 2);
	    }
	    return Border;
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
	public  void GainControl(int player_index){
		status_col_jLabel.setIcon(new ImageIcon(status_col));
		JButton buf = DrawPlayer(ginfo.playerlist[player_index]);
		map.add(buf);
		map.setComponentZOrder(buf, 0);
		MapReset(ginfo.playerlist[player_index]);
		synchronized (ginfo){	
			try {
				ginfo.wait();
				this.repaint();
				//BuyHouse(ginfo.playerlist[player_index], ginfo.roadlist[ginfo.playerlist[player_index].getLocation()].getLand());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		MoveMsgPanel(1);
		//gamescreen_jLabel.setIcon(new ImageIcon(draw_game_screen(ginfo.playerlist[player_index])));
		synchronized (ginfo){	
				try {
					ginfo.wait();
					this.repaint();
					//BuyHouse(ginfo.playerlist[player_index], ginfo.roadlist[ginfo.playerlist[player_index].getLocation()].getLand());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		if(ginfo.roadlist[ginfo.playerlist[player_index].getLocation()].getLand() instanceof Building){
		    GoToBuilding(((Building)ginfo.roadlist[ginfo.playerlist[player_index].getLocation()].getLand()),3);

		    synchronized (ginfo){	
			try {
				ginfo.wait();
				this.repaint();
				//BuyHouse(ginfo.playerlist[player_index], ginfo.roadlist[ginfo.playerlist[player_index].getLocation()].getLand());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    }
		}
	}
}
