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
	    tmp_p = ginfo.playerlist[0];
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
		tmp=1;
		while(tmp !=0){
			GoToATM();
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
	
	 
	public int tmp;
	public int ATM_number = 0;
	public boolean Out_In = true;
	Player tmp_p;
	Road tmp_r;
	Land tmp_l;
	private JPanel building_jPanel = null;
	private JPanel move_jPanel = null;
	private JPanel ATM_jPanel = null;
	private JLabel buildingtxt_jLabel = null;
	private JLabel movetxt_jLabel = null;
	private JLabel ATMtxt_jLabel = null;
	private JButton yes_jButton = null;
	private JButton no_jButton = null;
	private JButton ok_jButton = null;
	private JButton[] num_jButton = new JButton[10];
	private JButton max_jButton = null;
	private JButton clean_jButton = null;
	private JButton enter_jButton = null;
	private JButton savemoney_jButton = null;
	private JButton withdrawn_jButton = null;
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
		building_jPanel.setLayout(null);
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
			get_yes_jButton().setLocation(25, 100);
			get_no_jButton().setLocation(175, 100);
			get_yes_jButton().addActionListener(new AdvActionListener(this,ginfo,null,null,null,false,jContentPane,building_jPanel,0));
			get_no_jButton().addActionListener(new AdvActionListener(this,ginfo,null,null,null,false,jContentPane,building_jPanel,0));
		    }
		    else if(condition == 2){
			as1 = new AttributedString("   "+b.getName()+"  "+b.getFloor()+" 層");
			as2 = new AttributedString("  升級費 "+(int)(b.getLandPrice()*0.1)+"  要升級嗎?");
			building_jPanel.add(get_yes_jButton());
			building_jPanel.add(get_no_jButton());
			get_yes_jButton().setLocation(25, 100);
			get_no_jButton().setLocation(175, 100);
			get_yes_jButton().addActionListener(new AdvActionListener(this,ginfo,null,null,null,false,jContentPane,building_jPanel,0));
			get_no_jButton().addActionListener(new AdvActionListener(this,ginfo,null,null,null,false,jContentPane,building_jPanel,0));
		    }
		    else{
			as1 = new AttributedString(b.getName()+"   擁有者 "+b.getOwner()+" ");
			as2 = new AttributedString("     "+b.getFloor()+" 層"+"\n  過路費  "+b.getToll());
			building_jPanel.add(get_ok_jButton());
			get_ok_jButton().setLocation(100, 100);
			get_ok_jButton().addActionListener(new AdvActionListener(this,ginfo,null,null,null,false,jContentPane,building_jPanel,0));
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
	public void tmp(){

	    JPanel buf = new JPanel();
	    JLabel buf_1 = new JLabel();
	    buf.add(buf_1);
	    jContentPane.add(buf);
	    jContentPane.setComponentZOrder(buf, 0);
	    this.repaint();
	}
	public void MoveMsgPanel(int move){

	    JPanel buf = get_move_jPanel(move);
	    JLabel buf_1 = get_movetxt_jLabel(move);
	    buf.add(buf_1);
	    jContentPane.add(buf);
	    jContentPane.setComponentZOrder(buf, 0);
	    this.repaint();
	}
	
	private JPanel get_move_jPanel(int move){
	    if(move_jPanel == null){
		move_jPanel = new JPanel();
		move_jPanel.setLayout(null);
		move_jPanel.setBounds(new Rectangle(260, 370, 260, 160));
	    }
	    move_jPanel.add(get_ok_jButton());
	    get_ok_jButton().setLocation(80, 100);
	    get_ok_jButton().addActionListener(new AdvActionListener(this,ginfo,null,null,null,false,jContentPane,move_jPanel,0));
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

	public void GoToATM(){
	    tmp = 1;
	    JPanel buf = get_ATM_jPanel();
	    buf.add(get_ATMtxt_jLabel());
	    jContentPane.add(buf);
	    jContentPane.setComponentZOrder(buf, 0);
	    this.repaint();
	}
	private JPanel get_ATM_jPanel(){
	    if(ATM_jPanel == null){
		ATM_jPanel = new JPanel();
		ATM_jPanel.setLayout(null);
		ATM_jPanel.setBounds(new Rectangle(250, 120, 280, 350));
		for(int i=0;i<10;i++) ATM_jPanel.add(get_number_jButton(i));
		ATM_jPanel.add(get_max_jButton());
		ATM_jPanel.add(get_clean_jButton());
		ATM_jPanel.add(get_enter_jButton());
		ATM_jPanel.add(get_savemoney_jButton());
		ATM_jPanel.add(get_withdrawn_jButton());
		get_savemoney_jButton().setLocation(25,100);
		get_withdrawn_jButton().setLocation(85,100);
		get_enter_jButton().setLocation(145,100);
		get_number_jButton(1).setLocation(25,160);
		get_number_jButton(2).setLocation(85,160);
		get_number_jButton(3).setLocation(145,160);
		get_number_jButton(0).setLocation(205,160);
		get_number_jButton(4).setLocation(25,220);
		get_number_jButton(5).setLocation(85,220);
		get_number_jButton(6).setLocation(145,220);
		get_max_jButton().setLocation(205,220);
		get_number_jButton(7).setLocation(25,280);
		get_number_jButton(8).setLocation(85,280);
		get_number_jButton(9).setLocation(145,280);
		get_clean_jButton().setLocation(205,280);
		get_enter_jButton().addActionListener(new AdvActionListener(this,ginfo,null,null,null,false,jContentPane,ATM_jPanel,0));
		get_savemoney_jButton().addActionListener(new AdvActionListener(this, ginfo, tmp_p, true, 1, "i"));
		get_withdrawn_jButton().addActionListener(new AdvActionListener(this, ginfo, tmp_p, true, 1, "o"));
		get_max_jButton().addActionListener(new AdvActionListener(this, ginfo, tmp_p, true, 1, "m"));
		get_clean_jButton().addActionListener(new AdvActionListener(this, ginfo, tmp_p, true, 1, "c"));
		for(int i=0;i<10;i++) get_number_jButton(i).addActionListener(new AdvActionListener(this, ginfo, tmp_p, true, 1, ""+i));;
	    }
	    return ATM_jPanel;
	}
	private JLabel get_ATMtxt_jLabel(){
		if(ATMtxt_jLabel == null){
		    ATMtxt_jLabel = new JLabel();
		    ATMtxt_jLabel.setBounds(new Rectangle(0, 0, 280, 350));
		    ATMtxt_jLabel.setBorder(getBoarder());
		}
		    Font newfont = new Font("標楷體",Font.BOLD,30);
		    AttributedString as;
		    if(Out_In == true)
			as = new AttributedString("提款 : " + ATM_number);
		    else
			as = new AttributedString("存款 : " + ATM_number);
		    as.addAttribute(TextAttribute.FONT, newfont);
		    as.addAttribute(TextAttribute.FOREGROUND,Color.black);
		    as.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
		    BufferedImage buf = new BufferedImage(280, 350, BufferedImage.TYPE_3BYTE_BGR);
		    Graphics2D g = (Graphics2D)buf.createGraphics();
		    g.setColor(new Color(255,253,183));
		    g.fillRect(0, 0, 280, 350);
		    g.drawString(as.getIterator(), 30, 60);
		    ATMtxt_jLabel.setIcon(new ImageIcon(buf));
		return ATMtxt_jLabel;
	}
	private JButton get_yes_jButton(){
	    if(yes_jButton == null){
		yes_jButton = new JButton();
		yes_jButton.setSize(100, 50);
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
		no_jButton.setSize(100, 50);
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
		ok_jButton.setSize(100, 50);
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
	
	private JButton get_number_jButton(int num){
	    if(num_jButton[num] == null){
		num_jButton[num] = new JButton();
		num_jButton[num].setSize(50, 50);
		Font newfont = new Font("標楷體",Font.BOLD,16);
		AttributedString as = new AttributedString(""+num);
		as.addAttribute(TextAttribute.FONT, newfont);
		as.addAttribute(TextAttribute.FOREGROUND,new Color(255,154,39));
		as.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
		
		BufferedImage buf1 = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g1 = (Graphics2D)buf1.createGraphics();
		g1.setColor(new Color(255,253,183));
		g1.fillRect(0, 0, 50, 50);
		g1.drawString(as.getIterator(), 20, 28);
		num_jButton[num].setIcon(new ImageIcon(buf1));
		
		as.addAttribute(TextAttribute.FOREGROUND,new Color(255,253,183));
		BufferedImage buf2 = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g2 = (Graphics2D)buf2.createGraphics();
		g2.setColor(new Color(255,154,39));
		g2.fillRect(0, 0, 50, 50);
		g2.drawString(as.getIterator(), 20, 28);
		num_jButton[num].setPressedIcon(new ImageIcon(buf2));
		num_jButton[num].setBorder(getBoarder());
		
	    }
	    return num_jButton[num];
	}
	
	private JButton get_max_jButton(){
	    if(max_jButton == null){
		max_jButton = new JButton();
		max_jButton.setSize(50, 50);
		Font newfont = new Font("標楷體",Font.BOLD,16);
		AttributedString as = new AttributedString("Max");
		as.addAttribute(TextAttribute.FONT, newfont);
		as.addAttribute(TextAttribute.FOREGROUND,new Color(255,154,39));
		as.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
		
		BufferedImage buf1 = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g1 = (Graphics2D)buf1.createGraphics();
		g1.setColor(new Color(255,253,183));
		g1.fillRect(0, 0, 50, 50);
		g1.drawString(as.getIterator(), 11, 28);
		max_jButton.setIcon(new ImageIcon(buf1));
		
		as.addAttribute(TextAttribute.FOREGROUND,new Color(255,253,183));
		BufferedImage buf2 = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g2 = (Graphics2D)buf2.createGraphics();
		g2.setColor(new Color(255,154,39));
		g2.fillRect(0, 0, 50, 50);
		g2.drawString(as.getIterator(), 11, 28);
		max_jButton.setPressedIcon(new ImageIcon(buf2));
		max_jButton.setBorder(getBoarder());
		
	    }
	    return max_jButton;
	}
	
	private JButton get_clean_jButton(){
	    if(clean_jButton == null){
		clean_jButton = new JButton();
		clean_jButton.setSize(50, 50);
		Font newfont = new Font("標楷體",Font.BOLD,16);
		AttributedString as = new AttributedString("清除");
		as.addAttribute(TextAttribute.FONT, newfont);
		as.addAttribute(TextAttribute.FOREGROUND,new Color(255,154,39));
		as.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
		
		BufferedImage buf1 = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g1 = (Graphics2D)buf1.createGraphics();
		g1.setColor(new Color(255,253,183));
		g1.fillRect(0, 0, 50, 50);
		g1.drawString(as.getIterator(), 8, 28);
		clean_jButton.setIcon(new ImageIcon(buf1));
		
		as.addAttribute(TextAttribute.FOREGROUND,new Color(255,253,183));
		BufferedImage buf2 = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g2 = (Graphics2D)buf2.createGraphics();
		g2.setColor(new Color(255,154,39));
		g2.fillRect(0, 0, 50, 50);
		g2.drawString(as.getIterator(), 8, 28);
		clean_jButton.setPressedIcon(new ImageIcon(buf2));
		clean_jButton.setBorder(getBoarder());
		
	    }
	    return clean_jButton;
	}
	
	private JButton get_enter_jButton(){
	    if(enter_jButton == null){
		enter_jButton = new JButton();
		enter_jButton.setSize(110, 50);
		Font newfont = new Font("標楷體",Font.BOLD,16);
		AttributedString as = new AttributedString("Enter");
		as.addAttribute(TextAttribute.FONT, newfont);
		as.addAttribute(TextAttribute.FOREGROUND,new Color(255,154,39));
		as.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
		
		BufferedImage buf1 = new BufferedImage(110, 50, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g1 = (Graphics2D)buf1.createGraphics();
		g1.setColor(new Color(255,253,183));
		g1.fillRect(0, 0, 110, 50);
		g1.drawString(as.getIterator(), 32, 28);
		enter_jButton.setIcon(new ImageIcon(buf1));
		
		as.addAttribute(TextAttribute.FOREGROUND,new Color(255,253,183));
		BufferedImage buf2 = new BufferedImage(110, 50, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g2 = (Graphics2D)buf2.createGraphics();
		g2.setColor(new Color(255,154,39));
		g2.fillRect(0, 0, 110, 50);
		g2.drawString(as.getIterator(), 32, 28);
		enter_jButton.setPressedIcon(new ImageIcon(buf2));
		enter_jButton.setBorder(getBoarder());
		
	    }
	    return enter_jButton;
	}
	
	private JButton get_savemoney_jButton(){
	    if(savemoney_jButton == null){
		savemoney_jButton = new JButton();
		savemoney_jButton.setSize(50, 50);
		Font newfont = new Font("標楷體",Font.BOLD,16);
		AttributedString as = new AttributedString("存款");
		as.addAttribute(TextAttribute.FONT, newfont);
		as.addAttribute(TextAttribute.FOREGROUND,new Color(255,154,39));
		as.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
		
		BufferedImage buf1 = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g1 = (Graphics2D)buf1.createGraphics();
		g1.setColor(new Color(255,253,183));
		g1.fillRect(0, 0, 50, 50);
		g1.drawString(as.getIterator(), 8, 28);
		savemoney_jButton.setIcon(new ImageIcon(buf1));
		
		as.addAttribute(TextAttribute.FOREGROUND,new Color(255,253,183));
		BufferedImage buf2 = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g2 = (Graphics2D)buf2.createGraphics();
		g2.setColor(new Color(255,154,39));
		g2.fillRect(0, 0, 50, 50);
		g2.drawString(as.getIterator(), 8, 28);
		savemoney_jButton.setPressedIcon(new ImageIcon(buf2));
		savemoney_jButton.setBorder(getBoarder());
		
	    }
	    return savemoney_jButton;
	}
	
	private JButton get_withdrawn_jButton(){
	    if(withdrawn_jButton == null){
		withdrawn_jButton = new JButton();
		withdrawn_jButton.setSize(50, 50);
		Font newfont = new Font("標楷體",Font.BOLD,16);
		AttributedString as = new AttributedString("提款");
		as.addAttribute(TextAttribute.FONT, newfont);
		as.addAttribute(TextAttribute.FOREGROUND,new Color(255,154,39));
		as.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
		
		BufferedImage buf1 = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g1 = (Graphics2D)buf1.createGraphics();
		g1.setColor(new Color(255,253,183));
		g1.fillRect(0, 0, 50, 50);
		g1.drawString(as.getIterator(), 8, 28);
		withdrawn_jButton.setIcon(new ImageIcon(buf1));
		
		as.addAttribute(TextAttribute.FOREGROUND,new Color(255,253,183));
		BufferedImage buf2 = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g2 = (Graphics2D)buf2.createGraphics();
		g2.setColor(new Color(255,154,39));
		g2.fillRect(0, 0, 50, 50);
		g2.drawString(as.getIterator(), 8, 28);
		withdrawn_jButton.setPressedIcon(new ImageIcon(buf2));
		withdrawn_jButton.setBorder(getBoarder());
		
	    }
	    return withdrawn_jButton;
	}
	
	
	
	
	
	
	private LineBorder getBoarder(){
	    if(Border == null){
		Border = new LineBorder(new Color(255,154,39), 2);
	    }
	    return Border;
	}
	
}
