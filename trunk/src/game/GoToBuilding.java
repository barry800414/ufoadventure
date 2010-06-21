package game;

public class GoToBuilding extends Event{
    public void apply(GameInfo ginfo, GraphicsEngine gengine, Computer com, Player p){
	
	Building b = (Building) ginfo.roadlist[p.getLocation()].getLand();
	Player owner = b.getOwner();
	
    	if(owner==null)
    		;
    	else if(owner==p)
    		;
    	else{
	    
    		p.setCash(p.getCash() - b.getToll());
    		owner.setDeposit(owner.getDeposit() + b.getToll());
    	}
    }
}
