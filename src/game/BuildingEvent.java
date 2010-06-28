package game;

/*
 * this is the event when the player stand on the building
 */
public class BuildingEvent extends Event{
	
	
	public BuildingEvent(GameInfo ginfo , GraphicsEngine gengine , Computer com){
		super(ginfo,gengine,com);
	}
	
	public void apply(GameObject origin , GameObject target){
		Building building;
		Player player;
		if((origin instanceof Building)  && (target instanceof Player)){
			building = (Building)origin;
			player = (Player)target;
			if(building.getOwner() == null){
	    	    gengine.Show_Building_Msg(building, 1);
	    	    Event_Wait();
	    	    if(ginfo.get_Control_State() == GameInfo.YES_OK_STATE){
	    	    	player.setCash(player.getCash() - building.getLandPrice());
	    	    	building.setOwner(player);
	    	    	gengine.Build_House(building);
	    	    	gengine.Screen_Update(player);
	    	    }
	    	}
	    	else if(building.getOwner() == player){
	    		gengine.Show_Building_Msg(building, 2);
	    	    Event_Wait();
	    	    if(ginfo.get_Control_State() == GameInfo.YES_OK_STATE && building.getFloor() <= Building.MAX_FLOOR){
	    	    	player.setCash(player.getCash() - (int)(building.getLandPrice() * 0.2));
	    			building.setFloor(building.getFloor() + 1);
	    			gengine.Build_House(building);
	    			gengine.Screen_Update(player);
	    	    }
	    	}
	    	else{
	    		gengine.Show_Building_Msg(building, 3);
	    		Event_Wait();
	    		player.setCash(player.getCash() - building.getToll());
	    		building.getOwner().setDeposit(building.getOwner().getDeposit() + building.getToll());
	    		gengine.Screen_Update(player);
	    	}
			gengine.Remove_Building_Msg();
			Event_Sleep(1000);
		}
		else
			System.out.println("Building Event Applies failure");
	}
	
	
}	