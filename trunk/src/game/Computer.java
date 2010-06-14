package game;

import java.util.*;

public class Computer {
	
    private GameInfo ginfo ;
    private Player[] playerlist;
    public boolean[] playerRound;
    public int playercontrol;
    public Computer(GameInfo info){
	ginfo = info ;
	playerlist = ginfo.playerlist;
	playerRound = new boolean[ginfo.players_num];
	ResetPlayerRound();
    }
	
    /*
     * move the player by steps
     */
    public void MovePlayer(Player p){
	Random rnd = new Random();
	int step = 0;
	for(int i=0;i<p.dice_num;i++) step = step + rnd.nextInt(6) + 1;
	for(int i=step;i>0;i--) ginfo.Roadlist[p.location].road_trigger(p, i-1);
    }
    /*
     * 
     */
    public void UseItem(Player user, Player targetp ,Road targetr){
	Item.trigger(user, targetp, targetr);
    }
	
    public void BuyItem(Player p,int[] item_index){
	for(int i=0;i<item_index.length;i++) p.item.add(ginfo.itemlist[item_index[i]]);
    }
	
    public void ChangeCareer(Player p,int career){
	p.career = career;
    }
	
    public boolean GameContinue(){
	return ginfo.CheckMode();
    }
    
    public void Run(){
	Update();
	for(int i=0;i<ginfo.players_num;i++){
	    playerlist[i].Update();
	    while(playerRound[i]==true){
		
		
		
	    }
	    RoundEnd(playerlist[i]);
	}
    }
	
    public void Update(){
	ginfo.round++;
	AddDate();
	ResetPlayerRound();
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
