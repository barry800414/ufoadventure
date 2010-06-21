package game;

public abstract class Event {
    
    public abstract void apply(GameInfo ginfo ,GraphicsEngine gengine ,Computer com, Player p);
    
}
