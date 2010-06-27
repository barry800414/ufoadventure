package game;

import java.util.*;

public class RandomEvent extends Event{

	public static final int RANDOM_EVENT_NUM =2;
	
	public RandomEvent(GameInfo ginfo, GraphicsEngine gengine, Computer com) {
		super(ginfo, gengine, com);
	}
	
	public void apply(GameObject origin , GameObject target){
		Random rnd = new Random();
		Player player = (Player)target;
		int n = rnd.nextInt(RANDOM_EVENT_NUM);
		switch (n){
			case 0 :
				gengine.Show_Random_Event_Msg("參加系卡獲得冠軍  獎金三萬!!!!!");
	    	    Event_Wait();
	    	    if(ginfo.get_Control_State() == 1){
	    	    	player.setCash(player.getCash() + 30000);
	    			gengine.Screen_Update(player);
	    	    }
	    	    break;
			case 1 :
				gengine.Show_Random_Event_Msg("提款卡被搶  存款失去三萬");
	    	    Event_Wait();
	    	    if(ginfo.get_Control_State() == 1){
	    	    	player.setDeposit(player.getDeposit() - 30000);
	    			gengine.Screen_Update(player);
	    	    }
	    	    break;
		}
		gengine.Remove_Random_Event_Msg();
	}
	
	
}
