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
 
    //to do : Item[] item  , int[] house , Career , Road start
    public Player(String name,int cash,int deposit,int dice_num,int point){
    	this.cash = cash ;
    	this.deposit = deposit;
    	this.name = name ;
    	this.dice_num = dice_num;
    	this.point = point;
    }
    public void Update(){
	
    }
	   
}
