package game;

public class Player extends GameObject{
	//現金
    protected int cash;
    //存款
    protected int deposit;
    //道具
    protected Item[] item = new Item[20];
    //名字
    protected String name;
    //房屋   to be repaired
    protected int[] house = new int[100];
    //職業
    protected int career;
    //骰子數
    protected int dice_num;
    //狀態
    protected int[] state;
    //位置
    protected Land location;
    //點數
    protected int point;
 
	public Player(int cash,int deposit,Item item[],String name,int[] house,
			int career,int dice_num,Land start_loc,int credit){
    	this.cash = cash ;
    	this.deposit = deposit;
    	for(int i=0;i<item.length;i++)
    		this.item[i] = item[i];
    	this.name = name ;
    	this.career = career ;
    	this.dice_num = dice_num;
    	location = start_loc;
    	this.point = point;
    }
	   
}
