package game;

import java.util.*;

public class Computer {
	
    
    public BuildingEvent building_event;
    public LabEvent lab_event;
    public RandomEvent random_event;
    public ATM_Event atm_event;
    public Event[] eventlist;
    
    private GameInfo ginfo ;
    private GraphicsEngine gengine;
    private boolean[] player_mobility;   // true  the player can go 
    
    
    private int state;
    private int steps = 0;
    private Random rnd = new Random();
    
    public Computer(GameInfo ginfo, GraphicsEngine gengine){
    	this.ginfo = ginfo ;
    	this.gengine = gengine;
    	Event_Init();
    	player_mobility = new boolean[ginfo.players_num];
    	for(int i=0;i<ginfo.players_num;i++){
    		player_mobility[i] = true;
    	}
    }
    private void Event_Init(){
    	building_event = new BuildingEvent(ginfo,gengine,this);
    	lab_event = new LabEvent(ginfo,gengine,this);
    	random_event = new RandomEvent(ginfo,gengine,this);
    	atm_event = new ATM_Event(ginfo,gengine,this);
    	
    	Land buf;
    	for(int i=0;i<ginfo.landlist.length;i++){
    		buf = ginfo.landlist[i];
    		if(i == 37 || i== 60)
    			buf.setEvent(atm_event);
    		else if(buf instanceof Building){
    			buf.setEvent(building_event);
    		}
    		else if(buf instanceof Lab){
    			buf.setEvent(lab_event);
    		}
    		else{
    			buf.setEvent(random_event);
    		}
    	}
    	
    }
    
    
    public boolean Main_Loop(){
	
    	Round_Update();
    	for(int i=0;i<ginfo.players_num;i++){
    		while(player_mobility[i]){
    			Gain_Control(i);
    		}
    	}
    	return true;
    }
    
    public void Round_Update(){
    	ginfo.round++;
    	AddDate();
    	gengine.Refresh_Calendar(ginfo);
    	for(int i=0;i<ginfo.players_num;i++)
    		player_mobility[i] = true;
    }
    public void Gain_Control(int player_index){
		Player player = ginfo.playerlist[player_index];
		//repaint();
		synchronized (ginfo){	
			try {
				gengine.Screen_Update(player);
				ginfo.wait();   // wait for player to click button
				state = ginfo.get_Control_State();
				if(state == GameInfo.THROW_DICE_STATE){
					Move_Player(player);
					player_mobility[player_index] = false;
					ginfo.set_Control_State(GameInfo.DEFAULT_STATE);
				}
				else if(state == GameInfo.ITEM_COLUMN){
					gengine.Open_Item_Column(player);
					ginfo.set_Control_State(GameInfo.DEFAULT_STATE);
				}
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
    
    /*
     * move the player by steps
     */
    public void Move_Player(Player player){
    	if(player.getID()==0)
    		steps = 41;
    	else if (player.getID()==1 || player.getID()==2)
    		steps = 15;
    	else{	
    		steps = 0;
    		for(int i=0;i<player.getDicenum();i++) 
    			steps = (steps + rnd.nextInt(6) + 10);
    	}
    	Display_Steps(steps);
    	System.out.println("move test!");
    	for(int i=0;i<steps;i++){
    	    //ginfo.roadlist[p.getLocation()].road_trigger(this, ginfo, gengine, p, i-1);
    		player.setLocation(player.getLocation() + 1);
        	player.setPicCoor();
        	gengine.Screen_Update(player);
        	try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    	Land land = ginfo.roadlist[player.getLocation()].getLand();
    	land.land_trigger(land,player);
    }
    
    
    private void Display_Steps(int move){
    	gengine.Show_Move_Msg(steps);
	    try {
	    	ginfo.wait();
	    	//gengine.ScreemUpdate(playercontrol);
	    } catch (InterruptedException e) {
	    	e.printStackTrace();
	    }
	    gengine.Remove_Move_Msg();
    }
    
    
	
    /*
    public void BuyItem(Player p,int[] item_index){
    	for(int i=0;i<item_index.length;i++) p.item.add(ginfo.itemlist[item_index[i]]);
    }
    */
    
    public void ChangeCareer(Player p,int career){
    	p.setCareer(career);
    }
	
    /*
    public boolean GameContinue(){
    	return ginfo.CheckMode();
    }
    */
    public void AddDate(){
    	ginfo.day++;
    	if(ginfo.day==32||
		((ginfo.month==4||ginfo.month==6||ginfo.month==9||ginfo.month==11)&&ginfo.day==31)||
			(ginfo.month==2&&(ginfo.year%400==0||(ginfo.year%4==0&&ginfo.year%100!=0))&&ginfo.day>29)||
		(ginfo.month==2&&(ginfo.year%4!=0||(ginfo.year%400!=0&&ginfo.year%100==0))&&ginfo.day>28)){
    		ginfo.month++;
    		ginfo.day=1;
    	}
    	if(ginfo.month==13){
    		ginfo.year++;
    		ginfo.month=1;
    	}
    }
    
	
}
