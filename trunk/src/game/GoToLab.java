package game;

public class GoToLab extends Event{
    public void apply(GameInfo ginfo, GG gengine, Computer com, Player p){
	
	Lab l = (Lab) ginfo.roadlist[p.getLocation()].getLand();
	Player owner = l.getOwner();
	
    	if(owner==null){
    	    gengine.GoToLab(l, 1);

    	    synchronized (ginfo){	
    		try {
    		    ginfo.wait();
    		    gengine.ScreemUpdate(p);
    		} catch (InterruptedException e) {
    		    e.printStackTrace();
    		}
    	    }
    	    if(gengine.tmp == 1){
    		p.setCash(p.getCash() - l.getLandPrice());
    		l.setOwner(owner);
    	    }
    	}
    	else if(owner==p && l.getFloor() <= Lab.MAX_FLOOR){

    	    synchronized (ginfo){	
    		try {
    		    ginfo.wait();
    		    gengine.ScreemUpdate(p);
    		} catch (InterruptedException e) {
    		    e.printStackTrace();
    		}
    	    }
    	    gengine.GoToLab(l, 2);
    	    if(gengine.tmp == 1 && l.getFloor() <= Building.MAX_FLOOR){
    		p.setCash(p.getCash() - (int)(l.getLandPrice() * 0.2));
    		l.setFloor(l.getFloor() + 1);
    	    }
    	    
    	}
    	else{


    	    synchronized (ginfo){	
    		try {
    		    ginfo.wait();
    		    gengine.ScreemUpdate(p);
    		} catch (InterruptedException e) {
    		    e.printStackTrace();
    		}
    	    }
    	    gengine.GoToLab(l, 3);
    	}

    }

    @Override
    public void apply(GameInfo ginfo, GraphicsEngine gengine, Computer com,
	    Player p) {
	// TODO Auto-generated method stub
	
    }
}
