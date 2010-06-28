package game;

/*
 * this is the event when the player stand on the laboratory
 */

public class LabEvent extends Event{
	
	public LabEvent(GameInfo ginfo , GraphicsEngine gengine , Computer com){
		super(ginfo,gengine,com);
	}
	
	public void apply(GameObject origin,GameObject target){
		Lab lab;
		Player player;
		if((origin instanceof Lab)  && (target instanceof Player)){
			lab = (Lab)origin;
			player = (Player)target;
			if(lab.getOwner() == null){
	    	    gengine.Show_Lab_Msg(lab, 1);
	    	    Event_Wait();
	    	    if(ginfo.get_Control_State() == GameInfo.YES_OK_STATE){
	    	    	player.setCash(player.getCash() - lab.getLandPrice());
	    	    	lab.setOwner(player);
	    	    	gengine.Build_Lab(lab);
	    	    	gengine.Screen_Update(player);
	    	    }
	    	}
	    	else if(lab.getOwner() == player){
	    		gengine.Show_Lab_Msg(lab, 2);
	    	    Event_Wait();
	    	    if(ginfo.get_Control_State() == GameInfo.YES_OK_STATE && lab.getFloor() <= Building.MAX_FLOOR){
	    	    	player.setCash(player.getCash() - (int)(lab.getLandPrice() * 0.2));
	    			lab.setFloor(lab.getFloor() + 1);
	    			gengine.Build_Lab(lab);
	    			gengine.Screen_Update(player);
	    	    }
	    	    // TODO : research the items
	    	}
	    	/*else{
	    		// TODO : remove it ?
	    		gengine.Show_Lab_Msg(lab, 3);
	    		Event_Wait();
	    	}*/
			gengine.Remove_Lab_Msg();
			Event_Sleep(1000);
		}
		else
			System.out.println("Lab Event Applies failure");
	}
}
