package game;

public class Road extends GameObject{
    
    protected Event event;
    protected Land land;
    
    public Road(Event event,Land land){
    	this.event = event ;
    	this.land = land ;
    }
    
    public void road_trigger(GameInfo ginfo,GraphicsEngine gengine,Player p,int rest_steps) {
    	(RoadEvent)event.apply(ginfo,gengine,p,rest_steps);	
    }
    
    
    
}
