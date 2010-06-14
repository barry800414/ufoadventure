package game;

public class Road extends GameObject{
    
    protected Event event;
    protected Land land;
    
    public Road(Event event,Land land){
    	this.event = event ;
    	this.land = land ;
    }
    
    public void road_trigger(Player p, int rest_steps) {
    	(RoadEvent)event.run(p,rest_steps);	
    }
    
    
    
}
