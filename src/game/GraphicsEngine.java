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
	
	private JLabel calendar_label = null;
	private JLabel ntu_label = null;
	private JLabel status_col_label = null;
	private JLabel map_label = null;
	
	
	private JButton item_col_button = null;
	private JButton exit_button = null;
	private JButton go_button = null;
	private JButton player_button[] = null;
	private JButton road_button[] = null; 
	private JButton land_button[] = null ;
	private JButton item_button[] = null ;
	
	
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
	private Font biakai = new Font("標楷體",Font.BOLD,22);
	private Font biakai_small = new Font("標楷體",Font.BOLD,16);
	
	
	
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
		    as.addAttribute(TextAttribute.FONT, biakai);
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
			as.addAttribute(TextAttribute.FONT,biakai);
			as.addAttribute(TextAttribute.FOREGROUND,orange);
			if(i==6)
				as.addAttribute(TextAttribute.FONT,biakai_small);
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
	
	
}
