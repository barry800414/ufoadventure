package game;

public abstract class Land extends GameObject {
    
    
    protected String name;  //名字
    protected Player owner;  //擁有者
    protected int price;  //價格
    protected String explanation; //說明()
    //protected int ID;  //編號
    protected Event event;
    
    public Land(String name,String explanation,Player owner,int price,Event event){
    	this.name = name ;
    	this.explanation = explanation ;
    	this.owner = owner ;
    	this.price = price ; 
    	this.event = event ;
    }
    
    public abstract void land_trigger(GraphicsEngine gengine,Player p);
}
