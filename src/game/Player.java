package game;

public class Player extends GameObject{
	//�{��
    protected int cash;
    //�s��
    protected int deposit;
    //�̦h20�ӹD��
    protected Item[] item = new Item[20];
    //�W�r
    protected String name;
    //�֦��Ы�   to be repaired
    protected int[] house = new int[100];
    //¾�~
    protected int career;
    //��l
    protected int dicenum;
    //���A
    protected Event[] state;
    //��m
    protected Land location;
    //�I��
    protected int credit;
 
	public Player(int cash,int deposit,Item item[],String name,int[] house,
			int career,int dicenum,Land start_loc,int credit){
    	this.cash = cash ;
    	this.deposit = deposit;
    	for(int i=0;i<item.length;i++)
    		this.item[i] = item[i];
    	this.name = name ;
    	this.career = career ;
    	this.dicenum = dicenum;
    	location = start_loc;
    	this.credit = credit;
    }
	   
}
