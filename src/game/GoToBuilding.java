package game;

public class GoToBuilding extends Event{
    public void apply(GameInfo ginfo, GG gengine, Computer com, Player p){
	
	Building b = (Building) ginfo.roadlist[p.getLocation()].getLand();
	Player owner = b.getOwner();
	
    	if(owner==null){
    	    gengine.GoToBuilding(b, 1);
    	    if(gengine.tmp == 1){
    		p.setCash(p.getCash() - b.getLandPrice());
    		b.setOwner(owner);
    		System.out.println(p.getCash() + "    kkkkkkkkk    " + b.getLandPrice());
    	    }
    	}
    	else if(owner==p){
    	    gengine.GoToBuilding(b, 2);
    	    if(gengine.tmp == 1 && b.getFloor() <= Building.MAX_FLOOR){
    		p.setCash(p.getCash() - (int)(b.getLandPrice() * 0.2));
    		b.setFloor(b.getFloor() + 1);
    	    }
    	    
    	}
    	else{
    	    
		gengine.GoToBuilding(b, 3);
    		p.setCash(p.getCash() - b.getToll());
    		owner.setDeposit(owner.getDeposit() + b.getToll());
    	}
    }

    @Override
    public void apply(GameInfo ginfo, GraphicsEngine gengine, Computer com,
	    Player p) {
	// TODO Auto-generated method stub
	
    }
}
