package game;

public class Player {
    
    protected int cash;
    
    protected int deposit;
    
    //最多20個道具
    protected int[] item = new int[20];
    
    protected String name;
    
    protected int[] house = new int[100];
    
    protected Career career;
    
    protected Event[] state;
    
    protected int location;
    
    protected GraphicsEngine graph;
    
}
