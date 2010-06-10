package game;


public class GameInfo {
    
    public final int  SCREEN_WIDTH = 800, SCREEN_HEIGHT = 600;
    public Player[] playerlist ;
    public Item[] itemlist;
    public Land[] landlist;
    public Event[] eventlist;
    public int items_num,events_num,lands_num,players_num;
    
    //construct  all the item classes , event classes , land classes , player classes
    public GameInfo(String[] itemclassname ,String[] eventclassname,String[] landclassname){
    	
    	playerlist = new Player[players_num];
    	items_num = itemclassname.length;
    	events_num = eventclassname.length;
    	lands_num = landclassname.length;
    	itemlist = new Item[items_num];
    	eventlist = new Event[events_num];
    	landlist = new Land[lands_num];
	
    	int i;
    	try {
    		for(i=0;i<items_num;i++)
    			itemlist[i] = (Item)(Class.forName(itemclassname[i]).newInstance());
    		for(i=0;i<events_num;i++)
    			eventlist[i] = (Event)(Class.forName(eventclassname[i]).newInstance());
    		for(i=0;i<lands_num;i++)
    			lands[i] = (Land) (Class.forName(landclassname[i]).newInstance());
    	}
    	catch (Exception e){
    		System.out.println("GameInfo constructed error");
    	}
    }
}
