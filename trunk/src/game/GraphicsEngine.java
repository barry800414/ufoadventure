package game;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.font.TextAttribute;
import java.awt.image.*;
import java.io.File;
import java.text.AttributedString;
import java.awt.*;



public class GraphicsEngine extends JFrame {


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
	private JPanel buttom_panel = null;
	private JPanel building_msg_panel = null;
	private JPanel lab_msg_panel = null;
	//private JPanel move_jPanel = null;
	private JPanel atm_jpanel = null;
	
	
	private JLabel calendar_label = null;
	private JLabel ntu_label = null;
	private JLabel status_col_label = null;
	private JLabel map_label = null;
	private JLabel building_msg_label = null;
	private JLabel lab_msg_label = null;
	//private JLabel movetxt_jLabel = null;
	//private JLabel ATMtxt_jLabel = null;
	
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
	private Font biakai_24 = new Font("標楷體",Font.BOLD,24);
	private Font biakai_22 = new Font("標楷體",Font.BOLD,22);
	private Font biakai_18 = new Font("標楷體",Font.BOLD,18);
	private Font biakai_16 = new Font("標楷體",Font.BOLD,16);
	
	
	private GameInfo ginfo = null;
	
	
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
			
			content_panel.add(buttom_panel);
			content_panel.add(top_col_panel);
			content_panel.add(right_col_panel);
			//System.out.println("content panel test");
		}
	}
	
	/*
	 * Initialize the buttom_panel & map_panel  and its components  
	 */
	private void Map_Panel_Init(){
		if(buttom_panel == null){
			buttom_panel = new JPanel();
			buttom_panel.setLayout(null);
			buttom_panel.setBounds(MAP);
		}
		if(map_panel == null){
			map_panel = new JPanel();
			map_panel.setLayout(null);
			map_panel.setBounds(0,0,4000,4000);  // set the map to up_left
		}
		Map_Label_Init();
		Map_Button_Init();
		map_panel.add(map_label);
		buttom_panel.add(map_panel);
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
		    //player_button[i].setContentAreaFilled(false);
		    map_panel.add(player_button[i]);
		}
		for(int i=0;i<ginfo.roadlist.length;i++){
			if(road_button[i] == null)
				road_button[i] = new JButton();
			r = ginfo.roadlist[i];
			road_button[i].setBounds(r.getPicCoor().x,r.getPicCoor().y,r.getPicCoor().width,r.getPicCoor().height);
			road_button[i].setContentAreaFilled(false);
			map_panel.add(road_button[i]);
		}
		for(int i=0;i<ginfo.landlist.length;i++){
			if(land_button[i] == null )
				land_button[i] = new JButton();
			l = ginfo.landlist[i];
			land_button[i].setBounds(l.getPicCoor().x,l.getPicCoor().y,l.getPicCoor().width,l.getPicCoor().height);
			land_button[i].setContentAreaFilled(false);
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
	
	
	public  void GainControl(int player_index){
		Player p = ginfo.playerlist[player_index];
		
		int center_x,center_y;
		
		//repaint();
		synchronized (ginfo){	
				try {
					ginfo.wait();
					p.setLocation(p.getLocation()+1);
					Repaint_Status_Col(player_index);
					Repaint_Player_Icon(player_index);
					center_x = p.getPicCoor().x + p.getPicCoor().width/2;
					center_y = p.getPicCoor().y + p.getPicCoor().height/2;
					Focus_Player(player_index);
					System.out.println(" " + center_x + " " + center_y + " " + (center_x - SCREEN.width/2) + " " + (center_y - SCREEN.height/2));
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	public void Repaint_Status_Col(int player_index){
		Player p = ginfo.playerlist[player_index];
		status_col_label.setIcon(new ImageIcon(Draw_Status_Col_Image(p)));
	}
	
	public void Repaint_Player_Icon(int player_index){
		Player p = ginfo.playerlist[player_index];
		player_button[player_index].setBounds(p.getPicCoor().x,p.getPicCoor().y,p.getPicCoor().width,p.getPicCoor().height);
	}
	
	public void Focus_Player(int player_index){
		int x , y;
		Player p = ginfo.playerlist[player_index];
		x = MAP.width/2 - p.getPicCoor().x - p.getPicCoor().width/2;
		y = MAP.height/2 - p.getPicCoor().y - p.getPicCoor().height/2;
		
		map_panel.setLocation(x, y);
		map_panel.setComponentZOrder(player_button[player_index], 0);
		
	}
	
	//update the screen each turn 
	public void Screen_Update(int player_index){
	    Focus_Player(player_index);
	    this.repaint();
	}
	
	
	
	public void Show_Building_Msg(Building origin,Player target){
		Construct_Building_Msg_Panel(origin,target);
	    map_panel.add(building_msg_panel);
	    map_panel.setComponentZOrder(building_msg_panel, 0);
	    //map_panel.repaint();
	    synchronized (ginfo){
	    	ginfo.notifyAll();
	    }
	}
	private void Construct_Building_Msg_Panel(Building b, Player target){
		if(building_msg_panel == null){
	    	building_msg_panel = new JPanel();
	    	building_msg_panel.setLayout(null);
	    	building_msg_panel.setBounds(new Rectangle(240, 370, 300, 160));
	    }
	    building_msg_panel.removeAll();
	    if(b.getOwner() == null){
	    	building_msg_panel.add(get_Building_Msg_Label(b,1));
	    	get_Yes_Button().setLocation(25, 100);
			get_No_Button().setLocation(175, 100);
	    	building_msg_panel.add(get_Yes_Button());
			building_msg_panel.add(get_No_Button());
	    }
	    else if(b.getOwner() == target){
	    	building_msg_panel.add(get_Building_Msg_Label(b,2));
	    	get_Yes_Button().setLocation(25,100);
	    	get_No_Button().setLocation(175,100);
	    	building_msg_panel.add(get_Yes_Button());
	    	building_msg_panel.add(get_No_Button());
	    }
	    else{
	    	building_msg_panel.add(get_Building_Msg_Label(b,3));
	    	ok_button.setLocation(100,100);
	    	building_msg_panel.add(ok_button);
	    }
	}
	private JLabel get_Building_Msg_Label(Building b, int condition){
		AttributedString as1,as2;
		BufferedImage buf = new BufferedImage(300, 160, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g = (Graphics2D)buf.createGraphics();
		if(building_msg_label == null){
		    building_msg_label = new JLabel();
		    building_msg_label.setBounds(new Rectangle(0, 0, 300, 160));
		    //building_msg_label.setBorder(getBoarder());
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
	
	public void Show_Lab_Msg(Lab lab,Player target){
	    Construct_Lab_Msg_Panel(lab,target);
		map_panel.add(lab_msg_panel);
	    map_panel.setComponentZOrder(lab_msg_panel, 0);
	    //this.repaint();
	    synchronized(ginfo){
	    	try {
				ginfo.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
	}
	
	private void Construct_Lab_Msg_Panel(Lab lab , Player target){
	    if(lab_msg_panel == null){
	    	lab_msg_panel = new JPanel();
	    	lab_msg_panel.setLayout(null);
	    	lab_msg_panel.setBounds(new Rectangle(240, 370, 300, 160));
	    }
	    if(lab.getOwner() == null){
	    	lab_msg_panel.add(get_Lab_Msg_Label(lab,1));
	    	get_Yes_Button().setLocation(25, 100);
			get_No_Button().setLocation(175, 100);
	    	lab_msg_panel.add(get_Yes_Button());
			lab_msg_panel.add(get_No_Button());
			//get_Yes_Button().addActionListener(new AdvActionListener(this,ginfo,null,null,null,false,map_panel,lab_msg_panel,1));
			//get_No_Button().addActionListener(new AdvActionListener(this,ginfo,null,null,null,false,map_panel,lab_msg_panel,2));
	    }
	    else if(lab.getOwner() == target){
	    	lab_msg_panel.add(get_Lab_Msg_Label(lab,2));
	    	get_Yes_Button().setLocation(25, 100);
			get_No_Button().setLocation(175, 100);
	    	lab_msg_panel.add(get_Yes_Button());
			lab_msg_panel.add(get_No_Button());
			//get_Yes_Button().addActionListener(new AdvActionListener(this,ginfo,null,null,null,false,map_panel,lab_msg_panel,1));
			//get_No_Button().addActionListener(new AdvActionListener(this,ginfo,null,null,null,false,map_panel,lab_msg_panel,2));
	    }
	    else{
	    	lab_msg_panel.add(get_Lab_Msg_Label(lab,3));
	    	get_Ok_Button().setLocation(100, 100);
	    	lab_msg_panel.add(ok_button);
			//get_ok_jButton().addActionListener(new AdvActionListener(this,ginfo,null,null,null,false,map_panel,lab_msg_panel,1));
	    }
	    lab_msg_panel.removeAll();
	}
	
	private JLabel get_Lab_Msg_Label(Lab lab, int condition){
		AttributedString as1,as2;
		BufferedImage buf = new BufferedImage(300, 160, BufferedImage.TYPE_3BYTE_BGR);
	    Graphics2D g = (Graphics2D)buf.createGraphics();
		if(lab_msg_label == null){
		    lab_msg_label = new JLabel();
		    lab_msg_label.setBounds(new Rectangle(0, 0, 300, 160));
		    //lab_msg_label.setBorder(getBoarder());
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
			g.setColor(yellow);
			g.fillRect(0, 0, 100, 50);
			g.drawString(as.getIterator(), 5, 30);
			no_button.setIcon(new ImageIcon(buf1));
			
			as.addAttribute(TextAttribute.FOREGROUND,yellow);
			BufferedImage buf2 = new BufferedImage(100, 50, BufferedImage.TYPE_3BYTE_BGR);
			g = (Graphics2D)buf2.createGraphics();
			g.setColor(orange);
			g.fillRect(0, 0, 100, 50);
			g.drawString(as.getIterator(), 5, 30);
			no_button.setPressedIcon(new ImageIcon(buf2));
			//no_button.setBorder(getBoarder());
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
			Graphics2D g1 = (Graphics2D)buf1.createGraphics();
			g1.setColor(yellow);
			g1.fillRect(0, 0, 100, 50);
			g1.drawString(as.getIterator(), 4, 30);
			yes_button.setIcon(new ImageIcon(buf1));
				
			as.addAttribute(TextAttribute.FOREGROUND,yellow);
			BufferedImage buf2 = new BufferedImage(100, 50, BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D g2 = (Graphics2D)buf2.createGraphics();
			g2.setColor(orange);
			g2.fillRect(0, 0, 100, 50);
			g2.drawString(as.getIterator(), 4, 30);
			yes_button.setPressedIcon(new ImageIcon(buf2));
			//yes_button.setBorder(getBoarder());
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
			g.setColor(yellow);
			g.fillRect(0, 0, 100, 50);
			g.drawString(as.getIterator(), 35, 30);
			ok_button.setIcon(new ImageIcon(buf));
			
			as.addAttribute(TextAttribute.FOREGROUND,yellow);
			BufferedImage buf2 = new BufferedImage(100, 50, BufferedImage.TYPE_3BYTE_BGR);
			g = (Graphics2D)buf2.createGraphics();
			g.setColor(orange);
			g.fillRect(0, 0, 100, 50);
			g.drawString(as.getIterator(), 35, 30);
			ok_button.setPressedIcon(new ImageIcon(buf2));
			//get_Ok_Button().setBorder(getBoarder());
		}
		    return ok_button;
	}
}
