package game;

public class Building extends Land{
    
    //層數
    protected int MAX_FLOOR = 5;
    //價格
    protected int[] price = new int[MAX_FLOOR];
    
    //過路費
    protected int[] charge = new int[MAX_FLOOR];
    
    protected void trigger(Player player)
    {
	
    }
}
