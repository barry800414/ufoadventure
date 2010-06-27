package game;

//import AdvActionListener;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.font.TextAttribute;
import java.awt.image.*;
import java.io.File;
import java.text.AttributedString;
import java.awt.*;



public class GraphicsEngine extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final Rectangle SCREEN = new Rectangle(0,0,960,600);
	public static final Rectangle MAP =  new Rectangle(0,50,752 ,516);
	public static final Rectangle TOP_COL = new Rectangle(0,0,952,50);
	public static final Rectangle CALENDAR = new Rectangle(0,0,200,50);
	public static final Rectangle NTU_MONOPOLY = new Rectangle(200, 0, 350, 50);
	public static final Rectangle ITEM_COL_BUTTON = new Rectangle(702, 0,150, 50);
	public static final Rectangle EXIT_BUTTON = new Rectangle(852,0,100,50);
	public static final Rectangle RIGHT_COL =  new Rectangle(752,50,200,516);
	public static final Rectangle STATUS_COL = new Rectangle(0,0,200,466);
	public static final Rectangle GO_BUTTON = new Rectangle(0,466,200,50);
	public static final Rectangle BUTTOM = new Rectangle(0,50,752,516);
	
	private JPanel content_panel = null;
	private JPanel map_panel = null;
	private JPanel top_col_panel = null;
	private JPanel right_col_panel = null;
	private JPanel buttom_map_panel = null;
	private JPanel building_msg_panel = null;
	private JPanel lab_msg_panel = null;
	private JPanel move_msg_panel = null;
	private JPanel atm_msg_panel = null;
	
	
	private JLabel calendar_label = null;
	private JLabel ntu_label = null;
	private JLabel status_col_label = null;
	private JLabel map_label = null;
	private JLabel building_msg_label = null;
	private JLabel lab_msg_label = null;
	private JLabel move_msg_label = null;
	private JLabel atm_msg_label = null;
	
	private JButton item_col_button = null;
	private JButton exit_button = null;
	private JButton go_button = null;
	private JButton player_button[] = null;
	private JButton road_button[] = null; 
	private JButton land_button[] = null ;
	private JButton item_button[] = null ;
	private JButton yes_button = null;
	private JButton no_button = null;
	private JButton ok_button = null;
	private JButton[] atm_num_button = new JButton[10];
	private JButton atm_max_button = null;
	private JButton atm_clean_button = null;
	private JButton atm_enter_button = null;
	private JButton atm_savemoney_button = null;
	private JButton atm_withdraw_button = null;
	
	
	private BufferedImage calendar_image = null; 
	private BufferedImage ntu_monopoly_image = null;
	private BufferedImage status_col_image = null;
	private BufferedImage status_col_label_image = null;
	private BufferedImage calendar_label_image = null;
	private BufferedImage map_image = null;
	private BufferedImage item_col_button_image[] = null ;
	private BufferedImage go_button_image[] = null;
	private BufferedImage exit_button_image[] = null;
	private BufferedImage player_button_image[] = null;
	private BufferedImage land_button_image[][] = null;
	private BufferedImage road_button_image[] = null;
	private BufferedImage item_button_image[] = null;
	
	
	private Color orange = new Color(255,154,39);
	private Color yellow = new Color(255,253,183);
	private Font biakai_28 = new Font("標楷體",Font.BOLD,28);
	private Font biakai_24 = new Font("標楷體",Font.BOLD,24);
	private Font biakai_22 = new Font("標楷體",Font.BOLD,22);
	private Font biakai_18 = new Font("標楷體",Font.BOLD,18);
	private Font biakai_16 = new Font("標楷體",Font.BOLD,16);
	private LineBorder border1 = new LineBorder(orange, 2);
	
	private GameInfo ginfo = null;
	private int button_state;
	public int ATM_number = 0;
	public boolean Withdraw_Save = true;  // true Withdraw   false Save
	
	
	/*button state :    if button state = 0 , then when player click the 
	 * 					button , it will fire the action perform 
	 * 					0  Go Button, Item Column Button
	 * 					1  Yes No Ok Button
	 * 					2  ATM Button
	 */
						
	
	
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
		this.setSize(SCREEN.width,SCREEN.height);
		//this.setMaximumSize(new Dimension(WIDTH,HEIGHT));
		this.setMinimumSize(new Dimension(SCREEN.width,SCREEN.height));
		//this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("NTU Monopoly");
		//load picture
		Load_Pic(); 
		Content_Panel_Init();
		this.setContentPane(content_panel);
		
	}
	
	public JPanel get_Map_Panel(){
		return map_panel;
	}
	
	/*
	 * load all picture
	 */
	private void Load_Pic(){
		try{
			calendar_image = ImageIO.read(new File("calendar_bar.png")); 
			ntu_monopoly_image = ImageIO.read(new File("top_bar.png"));
			status_col_image = ImageIO.read(new File("status_col.png"));
			map_image = ImageIO.read(new File("NTUmap.png"));
			item_col_button_image = new BufferedImage[3];
			item_col_button_image[0] = ImageIO.read(new File("item_button.png"));
			item_col_button_image[1] = ImageIO.read(new File("item_button2.png"));
			go_button_image = new BufferedImage[3];
			go_button_image[0] = ImageIO.read(new File("dice_button.png"));
			go_button_image[1] = ImageIO.read(new File("dice_button2.png"));
			exit_button_image = new BufferedImage[3];
			exit_button_image[0] = ImageIO.read(new File("exit_button.png"));
			exit_button_image[1] = ImageIO.read(new File("exit_button2.png"));
			player_button_image = new BufferedImage[ginfo.players_num];
			for(int i=0;i<ginfo.players_num;i++)
				player_button_image[i] = ginfo.playerlist[i].getImage(0);
			    
			land_button_image = new BufferedImage[ginfo.landlist.length][];
			for(int i=0;i<ginfo.landlist.length;i++){
				land_button_image[i] = new BufferedImage[Building.MAX_FLOOR+1];
				for(int j=0;j<Building.MAX_FLOOR+1;j++){
					land_button_image[i][j] = ImageIO.read(new File("building.png"));
				}
			}
			//TODO add road button picture  (road_button_image) 
			item_button_image = new BufferedImage[3];
			item_button_image[0] = ImageIO.read(new File("item_buttom.png"));
			item_button_image[1] = ImageIO.read(new File("item_buttom2.png"));
		}
		catch (Exception e){
			System.out.println("Load picture failure!");
			e.printStackTrace();
		}
	}
	
	/*
	 * This method initializes content_panel
	 */
	private void Content_Panel_Init() {
		if (content_panel == null) {
			content_panel = new JPanel();
			content_panel.setLayout(null);
			
			Map_Panel_Init();
			Top_Col_Panel_Init();
			Right_Col_Panel_Init();
			
			content_panel.add(buttom_map_panel);
			content_panel.add(top_col_panel);
			content_panel.add(right_col_panel);
			//System.out.println("content panel test");
		}
	}
	
	/*
	 * Initialize the buttom_panel & map_panel  and its components  
	 */
	private void Map_Panel_Init(){
		if(buttom_map_panel == null){
			buttom_map_panel = new JPanel();
			buttom_map_panel.setLayout(null);
			buttom_map_panel.setBounds(MAP);
		}
		if(map_panel == null){
			map_panel = new JPanel();
			map_panel.setLayout(null);
			map_panel.setBounds(0,0,4000,4000);  // set the map to up_left
		}
		Map_Label_Init();
		Map_Button_Init();
		map_panel.add(map_label);
		buttom_map_panel.add(map_panel);
	}
	
	private void Map_Label_Init(){
		if(map_label == null){
			map_label = new JLabel();
			map_label.setSize(4000,4000);
			map_label.setIcon(new ImageIcon(map_image));
		}
	}
	
	/*
	 * Initialize and add land,road,player buttons on map_panel
	 */
	private void Map_Button_Init(){
		Player p;
		Road r;
		Land l;
		player_button = new JButton[ginfo.players_num];
		road_button = new JButton[ginfo.roadlist.length];
		land_button = new JButton[ginfo.landlist.length];
		for(int i=0;i<ginfo.players_num;i++){
			if(player_button[i]==null)
				player_button[i] = new JButton();
			p = ginfo.playerlist[i];
			player_button[i].setBounds(p.getPicCoor().x,p.getPicCoor().y,p.getPicCoor().width,p.getPicCoor().height);
		    player_button[i].setIcon(new ImageIcon(p.getImage(0)));
		    player_button[i].setDisabledIcon(new ImageIcon(p.getImage(0)));
		    player_button[i].setBorderPainted(false);
		    player_button[i].setContentAreaFilled(false);
		    player_button[i].setEnabled(false);
		    map_panel.add(player_button[i]);
		}
		for(int i=0;i<ginfo.roadlist.length;i++){
			if(road_button[i] == null)
				road_button[i] = new JButton();
			r = ginfo.roadlist[i];
			road_button[i].setBounds(r.getPicCoor().x,r.getPicCoor().y,r.getPicCoor().width,r.getPicCoor().height);
			road_button[i].setContentAreaFilled(false);
			road_button[i].setEnabled(false);
			map_panel.add(road_button[i]);
		}
		for(int i=0;i<ginfo.landlist.length;i++){
			if(land_button[i] == null )
				land_button[i] = new JButton();
			l = ginfo.landlist[i];
			land_button[i].setBounds(l.getPicCoor().x,l.getPicCoor().y,l.getPicCoor().width,l.getPicCoor().height);
			land_button[i].setContentAreaFilled(false);
			land_button[i].setEnabled(false);
			map_panel.add(land_button[i]);
		}
	}
	
	/*
	 * Initialize the top_col_panel and its components 
	 */
	private void Top_Col_Panel_Init(){
		if(top_col_panel == null){
			top_col_panel = new JPanel();
			top_col_panel.setLayout(null);
			top_col_panel.setBounds(TOP_COL);
			
			Ntu_Label_Init();
			Calendar_Label_Init();
			Item_Col_Button_Init();
			Exit_Button_Init();
			
			top_col_panel.add(ntu_label);
			top_col_panel.add(calendar_label);
			top_col_panel.add(item_col_button);
			top_col_panel.add(exit_button);
		}
	}
	
	private void Ntu_Label_Init(){
		if(ntu_label == null){
			ntu_label = new JLabel();
			ntu_label.setBounds(new Rectangle(NTU_MONOPOLY));
			ntu_label.setIcon(new ImageIcon(ntu_monopoly_image));
		}
	}
	
	private void Calendar_Label_Init(){
		if(calendar_label == null){
		    if(calendar_label_image == null)
				calendar_label_image = new BufferedImage(CALENDAR.width,CALENDAR.height,BufferedImage.TYPE_3BYTE_BGR);
		    
		    Graphics2D g = (Graphics2D)calendar_label_image.getGraphics();
		    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		    g.drawImage(calendar_image,0,0,null);
		    
		    
		    AttributedString as = new AttributedString(" "+ginfo.year+" / "+ginfo.month + " / " + ginfo.day);
		    as.addAttribute(TextAttribute.FONT, biakai_22);
		    as.addAttribute(TextAttribute.FOREGROUND,Color.BLACK);
		    as.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
		    g.drawString(as.getIterator(), 0, 33);
		    
		    calendar_label = new JLabel();
			calendar_label.setBounds(new Rectangle(CALENDAR));
			calendar_label.setIcon(new ImageIcon(calendar_label_image));
		}
	}
	
	private void Item_Col_Button_Init() {
		if (item_col_button == null) {
			item_col_button = new JButton();
			item_col_button.setBounds(ITEM_COL_BUTTON);
			item_col_button.setBorderPainted(false);
			item_col_button.setContentAreaFilled(false);
			item_col_button.setIcon(new ImageIcon(item_col_button_image[0]));
			item_col_button.setPressedIcon(new ImageIcon(item_col_button_image[1]));
			item_col_button.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("open button column"); // TODO Auto-generated Event stub actionPerformed()
					//OpenItemColumn();
				}
			});
		}
	}

	private void Exit_Button_Init() {
		if (exit_button == null) {
			exit_button = new JButton();
			exit_button.setBounds(EXIT_BUTTON);
			exit_button.setBorderPainted(false);
			exit_button.setContentAreaFilled(false);
			exit_button.setIcon(new ImageIcon(exit_button_image[0]));
			exit_button.setPressedIcon(new ImageIcon(exit_button_image[1]));
			exit_button.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Exit"); // TODO Auto-generated Event stub actionPerformed()
					System.exit(0);
				}
			});
		}
	}
	
	
	/*
	 * Initialize the right_col_panel and its components
	 */
	private void Right_Col_Panel_Init(){
		if(right_col_panel == null){
			right_col_panel = new JPanel();
			right_col_panel.setLayout(null);
			right_col_panel.setBounds(RIGHT_COL);
			Status_Label_Init();
			Go_Button_Init();
			
			right_col_panel.add(status_col_label);
			right_col_panel.add(go_button);
		}
	}
	private void Status_Label_Init(){
		if(status_col_label == null){
			status_col_label = new JLabel();
			status_col_label.setBounds(STATUS_COL);
			status_col_label.setIcon(new ImageIcon(Draw_Status_Col_Image(ginfo.playerlist[0])));
		}
	}
	
	private void Go_Button_Init(){
		if(go_button == null){
			go_button = new JButton();
			go_button.setBounds(GO_BUTTON);
			go_button.setBorderPainted(false);
			go_button.setContentAreaFilled(false);
			go_button.setIcon(new ImageIcon(go_button_image[0]));
			go_button.setPressedIcon(new ImageIcon(go_button_image[1]));
			go_button.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Go"); // TODO Auto-generated Event stub actionPerformed()
					synchronized (ginfo){
						ginfo.notifyAll();
					}
				}
			});
		}
	}
	private Image Draw_Status_Col_Image(Player p){
		if(status_col_label_image == null)
			status_col_label_image = new BufferedImage(STATUS_COL.width,STATUS_COL.height,BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g =(Graphics2D) status_col_label_image.getGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.clearRect(0, 0, STATUS_COL.width, STATUS_COL.height);
		g.drawImage(status_col_image,0,0,null);
		
		//name cash deposit point property house_num location
		String str[] = new String[7];
		str[0] = p.getName();
		str[1] = "金錢 : " + p.getCash();
		str[2] = "存款 : " + p.getDeposit();
		str[3] = "點數 : " + p.getPoint();
		str[4] = "總財產 : " + p.getProperty();
		str[5] = "房屋數 : " + p.getHouseList().length;
		str[6] = "位置 : " + ginfo.roadlist[p.getLocation()].getLand().getName();
		
		for(int i=0;i<str.length;i++){
			AttributedString as = new AttributedString(str[i]);
			as.addAttribute(TextAttribute.FONT,biakai_22);
			as.addAttribute(TextAttribute.FOREGROUND,orange);
			if(i==6)
				as.addAttribute(TextAttribute.FONT,biakai_16);
			g.drawString(as.getIterator(), 20 ,180 + 30*i);
		}
		return status_col_label_image;
	}
	
	/*
	private JButton create_item_jButton(int x,int y,String item_name){
		int index = x*5+y;
		if( item_button[index]==null){
			item_button[index] = new JButton();
			item_button[index].setBounds(new Rectangle(184+80*y, 446+ 30*x,80,30));
			item_button[index].setBorderPainted(false);
			item_button[index].setContentAreaFilled(false);
			item_button[index].setIcon(new ImageIcon(item_buttom[0]));
			item_button[index].setPressedIcon(new ImageIcon(item_buttom[1]));
			item_button[index].addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("xdd"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return item_button[index];
	}
	
	public void OpenItemColumn(){
		for(int i=0;i<4;i++){
			for(int j=0;j<5;j++){
				System.out.println("test" + i + " " + j);
				JButton buf = create_item_button(i,j,"test "+ i + " " + j);
				jContentPane.add(buf);
				jContentPane.setComponentZOrder(buf, 0);
			}
		}
		this.repaint();
	}*/
	
	
	
	
	public void Repaint_Status_Col(Player player){
		status_col_label.setIcon(new ImageIcon(Draw_Status_Col_Image(player)));
	}
	
	public void Repaint_Player_Icon(Player player){
		player_button[player.getID()].setBounds(player.getPicCoor().x,player.getPicCoor().y,player.getPicCoor().width,player.getPicCoor().height);
	}
	
	public void Focus_Player(Player player){
		int x , y;
	
		x = MAP.width/2 - player.getPicCoor().x - player.getPicCoor().width/2;
		y = MAP.height/2 - player.getPicCoor().y - player.getPicCoor().height/2;
		
		map_panel.setLocation(x, y);
		map_panel.setComponentZOrder(player_button[player.getID()], 0);
		
	}
	
	//update the screen each turn 
	public void Screen_Update(Player player){
		Repaint_Status_Col(player);
		Repaint_Player_Icon(player);
		Focus_Player(player);
	    this.repaint();
	}
	
	
	
	public void Show_Building_Msg(Building origin,int condition){
		JPanel buf = Construct_Building_Msg_Panel(origin,condition);
	    buttom_map_panel.add(buf);
	    buttom_map_panel.setComponentZOrder(buf, 0);
	    buf.repaint();
	}
	private JPanel Construct_Building_Msg_Panel(Building b,int condition){
		if(building_msg_panel == null){
	    	building_msg_panel = new JPanel();
	    	building_msg_panel.setLayout(null);
	    	building_msg_panel.setBounds(new Rectangle(240, 300, 300, 160));
	    }
	    building_msg_panel.removeAll();
	    // vacant land
	    if(condition == 1){
	    	get_Yes_Button().setLocation(25, 100);
			get_No_Button().setLocation(175, 100);
	    	building_msg_panel.add(get_Yes_Button());
			building_msg_panel.add(get_No_Button());
			building_msg_panel.add(get_Building_Msg_Label(b,1));
	    }
	    // building's owner
	    else if(condition == 2){
	    	get_Yes_Button().setLocation(25,100);
	    	get_No_Button().setLocation(175,100);
	    	building_msg_panel.add(get_Yes_Button());
	    	building_msg_panel.add(get_No_Button());
	    	building_msg_panel.add(get_Building_Msg_Label(b,2));
	    }
	    //other player's building
	    else{
	    	ok_button.setLocation(100,100);
	    	building_msg_panel.add(ok_button);
	    	building_msg_panel.add(get_Building_Msg_Label(b,3));
	    }
	    return building_msg_panel;
	}
	private JLabel get_Building_Msg_Label(Building b, int condition){
		AttributedString as1,as2;
		BufferedImage buf = new BufferedImage(300, 160, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g = (Graphics2D)buf.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(building_msg_label == null){
		    building_msg_label = new JLabel();
		    building_msg_label.setBounds(new Rectangle(0, 0, 300, 160));
		    building_msg_label.setBorder(border1);
		}
		if(condition == 1){                 //vacant land
			as1 = new AttributedString(b.getName()+"  價格:"+b.getLandPrice());
			as2 = new AttributedString("   這是無人空地  要買嗎?");
			//get_yes_jButton().addActionListener(new AdvActionListener(this,ginfo,null,null,null,false,map_panel,building_msg_panel,1));
			//get_no_jButton().addActionListener(new AdvActionListener(this,ginfo,null,null,null,false,map_panel,building_msg_panel,2));
		}
		else if(condition == 2){            //the building's owner
			as1 = new AttributedString("   "+b.getName()+"  "+b.getFloor()+" 層");
			as2 = new AttributedString("  升級費 "+(int)(b.getLandPrice()*0.1)+"  要升級嗎?");
			//get_yes_jButton().addActionListener(new AdvActionListener(this,ginfo,null,null,null,false,map_panel,building_msg_panel,1));
			//get_no_jButton().addActionListener(new AdvActionListener(this,ginfo,null,null,null,false,map_panel,building_msg_panel,2));
		}
		else{                               //belongs to other player
			as1 = new AttributedString(b.getName()+"   擁有者 :  遊戲者"+(b.getOwner().getID()+1)+" ");
			as2 = new AttributedString("     "+b.getFloor()+" 層"+"\n  過路費  "+b.getToll());
			//get_ok_jButton().addActionListener(new AdvActionListener(this,ginfo,null,null,null,false,map_panel,building_msg_panel,1));
		}
		as1.addAttribute(TextAttribute.FONT, biakai_18);
		as1.addAttribute(TextAttribute.FOREGROUND,Color.black);
		as1.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
		as2.addAttribute(TextAttribute.FONT, biakai_18);
		as2.addAttribute(TextAttribute.FOREGROUND,Color.black);
		as2.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
		
		g.setColor(yellow);
		g.fillRect(0, 0, 300, 160);
		g.drawString(as1.getIterator(), 14, 25);
		g.drawString(as2.getIterator(), 14, 58);
		building_msg_label.setIcon(new ImageIcon(buf));
			
		return building_msg_label;
	}
	
	public void Show_Lab_Msg(Lab lab,int condition){
	    JPanel buf = Construct_Lab_Msg_Panel(lab,condition);
		buttom_map_panel.add(buf);
	    buttom_map_panel.setComponentZOrder(buf, 0);
	    buf.repaint();
	    synchronized(ginfo){
	    	try {
				ginfo.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
	}
	
	private JPanel Construct_Lab_Msg_Panel(Lab lab , int condition){
	    if(lab_msg_panel == null){
	    	lab_msg_panel = new JPanel();
	    	lab_msg_panel.setLayout(null);
	    	lab_msg_panel.setBounds(new Rectangle(240, 300, 300, 160));
	    }
	    lab_msg_panel.removeAll();
	    //vacant lab land
	    if(condition == 1){
	    	get_Yes_Button().setLocation(25, 100);
			get_No_Button().setLocation(175, 100);
	    	lab_msg_panel.add(get_Yes_Button());
			lab_msg_panel.add(get_No_Button());
			lab_msg_panel.add(get_Lab_Msg_Label(lab,1));
			//get_Yes_Button().addActionListener(new AdvActionListener(this,ginfo,null,null,null,false,map_panel,lab_msg_panel,1));
			//get_No_Button().addActionListener(new AdvActionListener(this,ginfo,null,null,null,false,map_panel,lab_msg_panel,2));
	    }
	    //lab's owner
	    else if(condition == 2){
	    	get_Yes_Button().setLocation(25, 100);
			get_No_Button().setLocation(175, 100);
	    	lab_msg_panel.add(get_Yes_Button());
			lab_msg_panel.add(get_No_Button());
			lab_msg_panel.add(get_Lab_Msg_Label(lab,2));
			//get_Yes_Button().addActionListener(new AdvActionListener(this,ginfo,null,null,null,false,map_panel,lab_msg_panel,1));
			//get_No_Button().addActionListener(new AdvActionListener(this,ginfo,null,null,null,false,map_panel,lab_msg_panel,2));
	    }
	    else{
	    	get_Ok_Button().setLocation(100, 100);
	    	lab_msg_panel.add(ok_button);
	    	lab_msg_panel.add(get_Lab_Msg_Label(lab,3));
			//get_ok_jButton().addActionListener(new AdvActionListener(this,ginfo,null,null,null,false,map_panel,lab_msg_panel,1));
	    }
	    return lab_msg_panel;
	}
	
	private JLabel get_Lab_Msg_Label(Lab lab, int condition){
		AttributedString as1,as2;
		BufferedImage buf = new BufferedImage(300, 160, BufferedImage.TYPE_3BYTE_BGR);
	    Graphics2D g = (Graphics2D)buf.createGraphics();
	    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    if(lab_msg_label == null){
		    lab_msg_label = new JLabel();
		    lab_msg_label.setBounds(new Rectangle(0, 0, 300, 160));
		    lab_msg_label.setBorder(border1);
		}
		if(condition == 1){
			as1 = new AttributedString(lab.getName()+"  價格:"+lab.getLandPrice());
			as2 = new AttributedString("這是無人研究所空地  要買嗎?");
		}
		else if(condition == 2){
			as1 = new AttributedString("   "+lab.getName()+"  "+lab.getFloor()+" 層");
			as2 = new AttributedString("  升級費 "+(int)(lab.getLandPrice()*0.1)+"  要升級嗎?");
		}
		else{
			as1 = new AttributedString(lab.getName()+"   研發物  : "+lab.getResearch()+" ");
			as2 = new AttributedString("     要研發嗎?");
		}
		as1.addAttribute(TextAttribute.FONT, biakai_18);
		as1.addAttribute(TextAttribute.FOREGROUND,Color.black);
		as1.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
		as2.addAttribute(TextAttribute.FONT, biakai_18);
		as2.addAttribute(TextAttribute.FOREGROUND,Color.black);
		as2.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
		    
		g.setColor(yellow);
		g.fillRect(0, 0, 300, 160);
		g.drawString(as1.getIterator(), 14, 25);
		g.drawString(as2.getIterator(), 14, 58);
		lab_msg_label.setIcon(new ImageIcon(buf));
		
		return lab_msg_label;
	}
	
	private JButton get_No_Button(){
		if(no_button == null){
			no_button = new JButton();
			no_button.setSize(100, 50);
			AttributedString as = new AttributedString("  不好   ");
			
			as.addAttribute(TextAttribute.FONT, biakai_22);
			as.addAttribute(TextAttribute.FOREGROUND,orange);
			as.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
			BufferedImage buf1 = new BufferedImage(100, 50, BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D g = (Graphics2D)buf1.createGraphics();
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.setColor(yellow);
			g.fillRect(0, 0, 100, 50);
			g.drawString(as.getIterator(), 5, 30);
			no_button.setIcon(new ImageIcon(buf1));
			
			as.addAttribute(TextAttribute.FOREGROUND,yellow);
			BufferedImage buf2 = new BufferedImage(100, 50, BufferedImage.TYPE_3BYTE_BGR);
			g = (Graphics2D)buf2.createGraphics();
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.setColor(orange);
			g.fillRect(0, 0, 100, 50);
			g.drawString(as.getIterator(), 5, 30);
			no_button.setPressedIcon(new ImageIcon(buf2));
			no_button.setBorder(border1);
		}
		return no_button;
	}
	private JButton get_Yes_Button(){
		 if(yes_button == null){
			yes_button = new JButton();
			yes_button.setSize(100, 50);
			Font newfont = new Font("標楷體",Font.BOLD,22);
			AttributedString as = new AttributedString("   好   ");
			as.addAttribute(TextAttribute.FONT, newfont);
			as.addAttribute(TextAttribute.FOREGROUND,orange);
			as.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
				
			BufferedImage buf1 = new BufferedImage(100, 50, BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D g = (Graphics2D)buf1.createGraphics();
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.setColor(yellow);
			g.fillRect(0, 0, 100, 50);
			g.drawString(as.getIterator(), 4, 30);
			yes_button.setIcon(new ImageIcon(buf1));
				
			as.addAttribute(TextAttribute.FOREGROUND,yellow);
			BufferedImage buf2 = new BufferedImage(100, 50, BufferedImage.TYPE_3BYTE_BGR);
			g = (Graphics2D)buf2.createGraphics();
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.setColor(orange);
			g.fillRect(0, 0, 100, 50);
			g.drawString(as.getIterator(), 4, 30);
			yes_button.setPressedIcon(new ImageIcon(buf2));
			yes_button.setBorder(border1);
		}
		 return yes_button;
	}
	private JButton get_Ok_Button(){
		if( ok_button == null){
			ok_button = new JButton();
			ok_button.setSize(100, 50);
			
			AttributedString as = new AttributedString("OK");
			as.addAttribute(TextAttribute.FONT, biakai_24);
			as.addAttribute(TextAttribute.FOREGROUND,orange);
			as.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
			BufferedImage buf = new BufferedImage(100, 50, BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D g = (Graphics2D)buf.createGraphics();
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.setColor(yellow);
			g.fillRect(0, 0, 100, 50);
			g.drawString(as.getIterator(), 35, 30);
			ok_button.setIcon(new ImageIcon(buf));
			
			as.addAttribute(TextAttribute.FOREGROUND,yellow);
			BufferedImage buf2 = new BufferedImage(100, 50, BufferedImage.TYPE_3BYTE_BGR);
			g = (Graphics2D)buf2.createGraphics();
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.setColor(orange);
			g.fillRect(0, 0, 100, 50);
			g.drawString(as.getIterator(), 35, 30);
			ok_button.setPressedIcon(new ImageIcon(buf2));
			get_Ok_Button().setBorder(border1);
		}
		return ok_button;
	}
	
	public void Show_Move_Msg(int steps){
		JPanel buf = Construct_Move_Msg_Panel(steps);
	    buttom_map_panel.add(buf);
	    buttom_map_panel.setComponentZOrder(buf, 0);
	    buttom_map_panel.repaint();
	    synchronized(ginfo){
	    	try {
				ginfo.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
	}
	
	private JPanel Construct_Move_Msg_Panel(int move){
	    if(move_msg_panel == null){
	    	move_msg_panel = new JPanel();
	    	move_msg_panel.setLayout(null);
	    	move_msg_panel.setBounds(new Rectangle(260, 320, 260, 160));
	    }
	    move_msg_panel.removeAll();
	    move_msg_panel.add(get_Move_Msg_Label(move));
	    move_msg_panel.add(get_Ok_Button());
	    move_msg_panel.setComponentZOrder(get_Ok_Button(), 0);
	    get_Ok_Button().setLocation(80, 100);
	    //get_Ok_Button().addActionListener(new AdvActionListener(this,ginfo,null,null,null,false,map_panel,move_msg_panel,0));
	    return move_msg_panel;
	}
	

	private JLabel get_Move_Msg_Label(int move){
		if(move_msg_label == null){
		    move_msg_label = new JLabel();
		    move_msg_label.setBounds(new Rectangle(0, 0, 260, 160));
		    move_msg_label.setBorder(border1);
		}
		AttributedString as = new AttributedString("移動距離 : "+move);
		as.addAttribute(TextAttribute.FONT, biakai_28);
		as.addAttribute(TextAttribute.FOREGROUND,Color.black);
		as.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
		BufferedImage buf = new BufferedImage(260, 160, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g = (Graphics2D)buf.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(yellow);
		g.fillRect(0, 0, 260, 160);
		g.drawString(as.getIterator(), 30, 45);
		move_msg_label.setIcon(new ImageIcon(buf));
		return move_msg_label;
	}
	
	
	public void Show_ATM(){
	    //tmp = 1;
	    JPanel buf = Construct_ATM_Panel();
	    buttom_map_panel.add(buf);
	    buttom_map_panel.setComponentZOrder(buf, 0);
	    this.repaint();
	    synchronized(ginfo){
	    	try {
				ginfo.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}                
	    }
	}
	private JPanel Construct_ATM_Panel(){
	    if(atm_msg_panel == null){
	    	atm_msg_panel = new JPanel();
	    	atm_msg_panel.setLayout(null);
	    	atm_msg_panel.setBounds(new Rectangle(250, 120, 280, 350));
	    	get_ATM_Savemoney_Button().setLocation(25,100);
	    	get_ATM_Withdraw_Button().setLocation(85,100);
	    	get_ATM_Enter_Button().setLocation(145,100);
	    	get_ATM_Clean_Button().setLocation(205,280);
	    	get_ATM_Max_Button().setLocation(205,220);
	    	get_ATM_Number_Button(0).setLocation(205,160);
	    	get_ATM_Number_Button(1).setLocation(25,160);
	    	get_ATM_Number_Button(2).setLocation(85,160);
	    	get_ATM_Number_Button(3).setLocation(145,160);
	    	get_ATM_Number_Button(4).setLocation(25,220);
	    	get_ATM_Number_Button(5).setLocation(85,220);
	    	get_ATM_Number_Button(6).setLocation(145,220);
	    	get_ATM_Number_Button(7).setLocation(25,280);
	    	get_ATM_Number_Button(8).setLocation(85,280);
	    	get_ATM_Number_Button(9).setLocation(145,280);
	    	for(int i=0;i<10;i++) atm_msg_panel.add(get_ATM_Number_Button(i));
	    	atm_msg_panel.add(get_ATM_Max_Button());
	    	atm_msg_panel.add(get_ATM_Clean_Button());
	    	atm_msg_panel.add(get_ATM_Enter_Button());
	    	atm_msg_panel.add(get_ATM_Savemoney_Button());
	    	atm_msg_panel.add(get_ATM_Withdraw_Button());
	    	atm_msg_panel.add(get_ATM_Msg_Label());
	    }
	    
    	
    	//get_ATM_Enter_Button().addActionListener(new AdvActionListener(this,ginfo,null,null,null,false,map_panel,atm_msg_panel,0));
    	//get_ATM_Savemoney_Button().addActionListener(new AdvActionListener(this, ginfo, tmp_p, true, 1, "i"));
    	//get_ATM_Withdraw_Button().addActionListener(new AdvActionListener(this, ginfo, tmp_p, true, 1, "o"));
    	//get_ATM_Number_Button().addActionListener(new AdvActionListener(this, ginfo, tmp_p, true, 1, "m"));
    	//get_clean_jButton().addActionListener(new AdvActionListener(this, ginfo, tmp_p, true, 1, "c"));
    	//for(int i=0;i<10;i++) get_ATM_Number_Button(i).addActionListener(new AdvActionListener(this, ginfo, tmp_p, true, 1, ""+i));;
	    return atm_msg_panel;
	}
	private JLabel get_ATM_Msg_Label(){
		if(atm_msg_label == null){
		    atm_msg_label = new JLabel();
		    atm_msg_label.setBounds(new Rectangle(0, 0, 280, 350));
		    atm_msg_label.setBorder(border1);
		}
		AttributedString as;
		if(Withdraw_Save == true)
		    as = new AttributedString("提款 : " + ATM_number);
		else
		    as = new AttributedString("存款 : " + ATM_number);
		as.addAttribute(TextAttribute.FONT, biakai_28);
		as.addAttribute(TextAttribute.FOREGROUND,Color.black);
		as.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
		BufferedImage buf = new BufferedImage(280, 350, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g = (Graphics2D)buf.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(yellow);
		g.fillRect(0, 0, 280, 350);
		g.drawString(as.getIterator(), 22, 60);
		atm_msg_label.setIcon(new ImageIcon(buf));
		return atm_msg_label;
	}
	
	private JButton get_ATM_Number_Button(int num){
	    if(atm_num_button[num] == null){
	    	atm_num_button[num] = new JButton();
	    	atm_num_button[num].setSize(50, 50);
	    	AttributedString as = new AttributedString(""+num);
	    	as.addAttribute(TextAttribute.FONT, biakai_16);
	    	as.addAttribute(TextAttribute.FOREGROUND,orange);
	    	as.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
	    	BufferedImage buf1 = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
	    	Graphics2D g = (Graphics2D)buf1.createGraphics();
	    	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    	g.setColor(yellow);
	    	g.fillRect(0, 0, 50, 50);
	    	g.drawString(as.getIterator(), 20, 28);
	    	atm_num_button[num].setIcon(new ImageIcon(buf1));
	    	as.addAttribute(TextAttribute.FOREGROUND,yellow);
	    	BufferedImage buf2 = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
	    	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    	g = (Graphics2D)buf2.createGraphics();
	    	g.setColor(orange);
	    	g.fillRect(0, 0, 50, 50);
	    	g.drawString(as.getIterator(), 20, 28);
	    	atm_num_button[num].setPressedIcon(new ImageIcon(buf2));
	    	atm_num_button[num].setBorder(border1);
	    }
	    return atm_num_button[num];
	}
	
	private JButton get_ATM_Max_Button(){
	    if(atm_max_button == null){
	    	atm_max_button = new JButton();
	    	atm_max_button.setSize(50, 50);
	    	AttributedString as = new AttributedString("Max");
	    	as.addAttribute(TextAttribute.FONT, biakai_16);
	    	as.addAttribute(TextAttribute.FOREGROUND,orange);
	    	as.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
	    	BufferedImage buf1 = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
	    	Graphics2D g = (Graphics2D)buf1.createGraphics();
	    	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    	g.setColor(yellow);
	    	g.fillRect(0, 0, 50, 50);
	    	g.drawString(as.getIterator(), 11, 28);
	    	atm_max_button.setIcon(new ImageIcon(buf1));
	    	as.addAttribute(TextAttribute.FOREGROUND,yellow);
	    	BufferedImage buf2 = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
	    	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    	g = (Graphics2D)buf2.createGraphics();
	    	g.setColor(orange);
	    	g.fillRect(0, 0, 50, 50);
	    	g.drawString(as.getIterator(), 11, 28);
	    	atm_max_button.setPressedIcon(new ImageIcon(buf2));
	    	atm_max_button.setBorder(border1);
	    }
	    return atm_max_button;
	}
	
	private JButton get_ATM_Clean_Button(){
	    if(atm_clean_button == null){
	    	atm_clean_button = new JButton();
	    	atm_clean_button.setSize(50, 50);
	    	AttributedString as = new AttributedString("清除");
	    	as.addAttribute(TextAttribute.FONT, biakai_16);
	    	as.addAttribute(TextAttribute.FOREGROUND,orange);
	    	as.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
	    	BufferedImage buf1 = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
	    	Graphics2D g = (Graphics2D)buf1.createGraphics();
	    	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    	g.setColor(yellow);
	    	g.fillRect(0, 0, 50, 50);
	    	g.drawString(as.getIterator(), 8, 28);
	    	atm_clean_button.setIcon(new ImageIcon(buf1));
	    	as.addAttribute(TextAttribute.FOREGROUND,yellow);
	    	BufferedImage buf2 = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
	    	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    	g = (Graphics2D)buf2.createGraphics();
	    	g.setColor(orange);
	    	g.fillRect(0, 0, 50, 50);
	    	g.drawString(as.getIterator(), 8, 28);
	    	atm_clean_button.setPressedIcon(new ImageIcon(buf2));
	    	atm_clean_button.setBorder(border1);
	    }
	    return atm_clean_button;
	}
	
	private JButton get_ATM_Enter_Button(){
	    if(atm_enter_button == null){
	    	atm_enter_button = new JButton();
	    	atm_enter_button.setSize(110, 50);
	    	Font newfont = new Font("標楷體",Font.BOLD,16);
	    	AttributedString as = new AttributedString("Enter");
	    	as.addAttribute(TextAttribute.FONT, newfont);
	    	as.addAttribute(TextAttribute.FOREGROUND,orange);
	    	as.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
	    	BufferedImage buf1 = new BufferedImage(110, 50, BufferedImage.TYPE_3BYTE_BGR);
	    	Graphics2D g = (Graphics2D)buf1.createGraphics();
	    	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    	g.setColor(yellow);
	    	g.fillRect(0, 0, 110, 50);
	    	g.drawString(as.getIterator(), 32, 28);
	    	atm_enter_button.setIcon(new ImageIcon(buf1));
	    	as.addAttribute(TextAttribute.FOREGROUND,yellow);
	    	BufferedImage buf2 = new BufferedImage(110, 50, BufferedImage.TYPE_3BYTE_BGR);
	    	g = (Graphics2D)buf2.createGraphics();
	    	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    	g.setColor(orange);
	    	g.fillRect(0, 0, 110, 50);
	    	g.drawString(as.getIterator(), 32, 28);
	    	atm_enter_button.setPressedIcon(new ImageIcon(buf2));
	    	atm_enter_button.setBorder(border1);
	    }
	    return atm_enter_button;
	}
	
	private JButton get_ATM_Savemoney_Button(){
	    if(atm_savemoney_button == null){
	    	atm_savemoney_button = new JButton();
	    	atm_savemoney_button.setSize(50, 50);
	    	AttributedString as = new AttributedString("存款");
	    	as.addAttribute(TextAttribute.FONT, biakai_16);
	    	as.addAttribute(TextAttribute.FOREGROUND,orange);
	    	as.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
	    	BufferedImage buf1 = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
	    	Graphics2D g = (Graphics2D)buf1.createGraphics();
	    	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    	g.setColor(yellow);
	    	g.fillRect(0, 0, 50, 50);
	    	g.drawString(as.getIterator(), 8, 28);
	    	atm_savemoney_button.setIcon(new ImageIcon(buf1));
	    	as.addAttribute(TextAttribute.FOREGROUND,yellow);
	    	BufferedImage buf2 = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
	    	g = (Graphics2D)buf2.createGraphics();
	    	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    	g.setColor(orange);
	    	g.fillRect(0, 0, 50, 50);
	    	g.drawString(as.getIterator(), 8, 28);
	    	atm_savemoney_button.setPressedIcon(new ImageIcon(buf2));
	    	atm_savemoney_button.setBorder(border1);
	    }
	    return atm_savemoney_button;
	}
	
	private JButton get_ATM_Withdraw_Button(){
	    if(atm_withdraw_button == null){
	    	atm_withdraw_button = new JButton();
	    	atm_withdraw_button.setSize(50, 50);
	    	AttributedString as = new AttributedString("提款");
	    	as.addAttribute(TextAttribute.FONT, biakai_16);
	    	as.addAttribute(TextAttribute.FOREGROUND,orange);
	    	as.addAttribute(TextAttribute.BACKGROUND,Color.OPAQUE);
	    	BufferedImage buf1 = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
	    	Graphics2D g = (Graphics2D)buf1.createGraphics();
	    	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    	g.setColor(yellow);
	    	g.fillRect(0, 0, 50, 50);
	    	g.drawString(as.getIterator(), 8, 28);
	    	atm_withdraw_button.setIcon(new ImageIcon(buf1));
	    	as.addAttribute(TextAttribute.FOREGROUND,yellow);
	    	BufferedImage buf2 = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
	    	g = (Graphics2D)buf2.createGraphics();
	    	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    	g.setColor(orange);
	    	g.fillRect(0, 0, 50, 50);
			g.drawString(as.getIterator(), 8, 28);
			atm_withdraw_button.setPressedIcon(new ImageIcon(buf2));
			atm_withdraw_button.setBorder(border1);
	    }
	    return atm_withdraw_button;
	}
	

}
