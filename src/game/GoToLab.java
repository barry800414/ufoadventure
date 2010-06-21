package game;

public class GoToLab extends Event{
    public void apply(GameInfo ginfo, GraphicsEngine gengine, Computer com, Player p){
	
	Building b = (Building) ginfo.roadlist[p.getLocation()].getLand();
	Player owner = b.getOwner();
	
    	if(owner==null)
    		;
    	else if(owner==p)
    		;
    }
}
