package game;

public class Item {

    public Item(String name, int point, String info) {
	
	this.name = name;
	this.point = point;
	this.info = info;
	
    }
    
    //�W��
    protected String name;
    
    //�I��
    protected int point;
    
    //����
    protected String info;
    
    //�ƥ�
    protected Event event;
    
}
