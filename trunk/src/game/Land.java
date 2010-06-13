package game;

public abstract class Land extends GameObject {
    
    //名字
    protected String name;
    
    //擁有者
    protected Player owner;

    //價格
    protected int price;
    
    //說明()
    protected String explanation;
    
    //編號
    protected int number;
    
    //X軸
    protected int X;
    
    //Y軸
    protected int Y;
}
