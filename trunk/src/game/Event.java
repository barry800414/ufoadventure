package game;

public abstract class Event {
    
    public abstract void apply(Player user, Player target, Land location);
    
}
