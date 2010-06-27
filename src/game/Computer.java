package game;

import java.util.*;

public class Computer {
	
    
    public BuildingEvent building_event;
    public LabEvent lab_event;
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
    	for(int i=0;i<ginfo.players_num;i++)
    		player_mobility[i] = true;
    }
    private void Event_Init(){
    	building_event = new BuildingEvent(ginfo,gengine,this);
    	lab_event = new LabEvent(ginfo,gengine,this);
    	Land buf;
    	for(int i=0;i<ginfo.landlist.length;i++){
    		buf = ginfo.landlist[i];
    		if(buf instanceof Building)
    			buf.setEvent(building_event);
    		else if(buf instanceof Lab)
    			buf.setEvent(lab_event);
    		
    		//TODO : SpecialLocation
    	}
    }
    
    
    public boolean Main_Loop(){
	
    	Round_Update();
    	for(int i=0;i<ginfo.players_num;i++){
    		while(player_mobility[i]==true){
    			Gain_Control(i);
    		}
    	}
    	return true;
    }
    
    public void Round_Update(){
    	ginfo.round++;
    	AddDate();
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
				if(state == 0){
					Move_Player(player);
				}
				else if(state == 1){
					//TODO : use item
				}
				//Show_Building_Msg((Building)ginfo.roadlist[3].getLand(),ginfo.playerlist[player_index]);
				//Show_Lab_Msg((Lab)ginfo.roadlist[2].getLand(), ginfo.playerlist[player_index]);
				//Show_Move_Msg(10);
				//Show_ATM();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
    
    /*
     * move the player by steps
     */
    public void Move_Player(Player player){
    	steps = 0;
    	for(int i=0;i<player.getDicenum();i++) 
    		steps = (steps + rnd.nextInt(6) + 1);
    	Display_Steps(steps);
    	for(int i=0;i<steps;i++){
    	    //ginfo.roadlist[p.getLocation()].road_trigger(this, ginfo, gengine, p, i-1);
    		player.setLocation(player.getLocation() + 1);
        	player.setPicCoor();
        	gengine.Screen_Update(player);
        	
    	}
    	//ginfo.landlist[p.getLocation()].road_trigger(this, ginfo, gengine, p, i-1);
    	if(ginfo.roadlist[player.getLocation()].getLand() instanceof Building){
    		GoToBuilding a = new GoToBuilding();
    		a.apply(ginfo, gengine, this, player);
    	}
    	else if(ginfo.roadlist[player.getLocation()].getLand() instanceof Lab){
    		GoToLab a = new GoToLab();
    		a.apply(ginfo, gengine, this, player);
    	}
    }
    
    
    private void Display_Steps(int move){
    	gengine.Show_Move_Msg(steps);
	    synchronized (ginfo){	
	    	try {
	    		ginfo.wait();
	    		//gengine.ScreemUpdate(playercontrol);
	    	} catch (InterruptedException e) {
	    		e.printStackTrace();
	    	}
	    }
    }
    
    /*
    public void UseItem(Player user, Player targetp ,Road targetr){
    	Item.trigger(user, targetp, targetr);
    }
    */
	
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
