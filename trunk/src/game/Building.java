package game;

public class Building extends Land{
    
    //�h��
    protected int MAX_FLOOR = 5;
    //����
    protected int[] price = new int[MAX_FLOOR];
    
    //�L���O
    protected int[] charge = new int[MAX_FLOOR];
    
    protected void trigger(Player player)
    {
	
    }
}
