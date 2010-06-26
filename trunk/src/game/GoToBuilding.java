package game;

public class GoToBuilding extends Event{
    public void apply(GameInfo ginfo, GG gengine, Computer com, Player p){
	
	Building b = (Building) ginfo.roadlist[p.getLocation()].getLand();
	Player owner = b.getOwner();
	
    	if(owner==null){
    	    gengine.GoToBuilding(b, 1);

    	    synchronized (ginfo){	
    		try {
    		    ginfo.wait();
    		    gengine.ScreemUpdate(p);
    		} catch (InterruptedException e) {
    		    e.printStackTrace();
    		}
    	    }
    	    if(gengine.tmp == 1){
    		p.setCash(p.getCash() - b.getLandPrice());
    		b.setOwner(p);
    	    }
    	}
    	else if(owner==p){

    	    gengine.GoToBuilding(b, 2);
    	    synchronized (ginfo){	
    		try {
    		    ginfo.wait();
    		    gengine.ScreemUpdate(p);
    		} catch (InterruptedException e) {
    		    e.printStackTrace();
    		}
    	    }
    	    if(gengine.tmp == 1 && b.getFloor() <= Building.MAX_FLOOR){
    		p.setCash(p.getCash() - (int)(b.getLandPrice() * 0.2));
    		b.setFloor(b.getFloor() + 1);
    	    }
    	    
    	}
    	else{

		gengine.GoToBuilding(b, 3);

    	    synchronized (ginfo){	
    		try {
    		    ginfo.wait();
    		    gengine.ScreemUpdate(p);
    		} catch (InterruptedException e) {
    		    e.printStackTrace();
    		}
    	    }
    		p.setCash(p.getCash() - b.getToll());
    		owner.setDeposit(owner.getDeposit() + b.getToll());
    	}

    }

    @Override
    public void apply(GameInfo ginfo, GraphicsEngine gengine, Computer com, Player p) {
	// TODO Auto-generated method stub
	
    }
}
