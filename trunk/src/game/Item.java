package game;

public class Item {

	public static int MAX_ITEMS = 20;
	
	public Item(String name, int point, String info) {
		this.name = name;
		this.point = point;
		this.info = info;
    }
    
    //名字
    protected String name;
    
    //點數
    protected int point;
    
    //說明
    protected String info;
    
    //事件
    protected Event event;
    
}
