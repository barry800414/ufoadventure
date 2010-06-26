package game;

import java.util.*;

public class Computer {
	
    private GameInfo ginfo ;
    //private GraphicsEngine gengine;
    private GG gengine;
    private Player[] playerlist;
    public boolean[] playerRound;
    public Player playercontrol;
    public int step = 0;
    public Computer(GameInfo info, GG engine){
    	ginfo = info ;
    	gengine = engine;
    	playerlist = ginfo.playerlist;
    	playerRound = new boolean[ginfo.players_num];
    	ResetPlayerRound();
    }

    public boolean Run(){
	
    	Update();
	for(int i=0;i<ginfo.players_num;i++){
	    playercontrol = playerlist[i];

	    gengine.ScreemUpdate(playercontrol);
	    PlayerUpdate(playercontrol);
	    while(playerRound[i]==true){
		synchronized (ginfo){	
		    try {
			ginfo.wait();
			gengine.ScreemUpdate(playercontrol);
		    } catch (InterruptedException e) {
			e.printStackTrace();
		    }
		}
		//骰骰子
		if(gengine.tmp == 1){
		    MovePlayer(playerlist[i]);
		    break;
		}
		
		
	    }
	    //RoundEnd(playerlist[i]);
	}
	return true;
	
	
    }
    public void PlayerRound(Player p){
    }
    
    /*
     * move the player by steps
     */
    public void MovePlayer(Player p){
    	Random rnd = new Random();
    	step = 0;
    	for(int i=0;i<p.getDicenum();i++) step = step + rnd.nextInt(6) + 1;
    	displaySteps(step);
    	for(int i=step;i>0;i--){
    	    //ginfo.roadlist[p.getLocation()].road_trigger(this, ginfo, gengine, p, i-1);
    	}
    	p.setLocation(p.getLocation() + step);
    	p.setPicCoor();
	gengine.ScreemUpdate(p);
    	//ginfo.landlist[p.getLocation()].road_trigger(this, ginfo, gengine, p, i-1);
	if(ginfo.roadlist[p.getLocation()].getLand() instanceof Building){
	    GoToBuilding a = new GoToBuilding();
	    a.apply(ginfo, gengine, this, p);
	}

	else if(ginfo.roadlist[p.getLocation()].getLand() instanceof Lab){
	    GoToLab a = new GoToLab();
	    a.apply(ginfo, gengine, this, p);
	}
    	
    }
    
    
    public void displaySteps(int move){
	gengine.MoveMsgPanel(move);

	    synchronized (ginfo){	
		try {
		    ginfo.wait();
		    gengine.ScreemUpdate(playercontrol);
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
    
    
	
    
    public void Update(){
    	ginfo.round++;
    	AddDate();
    	ResetPlayerRound();
    }
    public void PlayerUpdate(Player p){
	gengine.MapReset(p);
    }
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
    public void ResetPlayerRound(){
    	for(int i=0;i<ginfo.players_num;i++) playerRound[i]=true;
    }
	
}
