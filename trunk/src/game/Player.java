package game;

public class Player {
    
    //現金
    protected int cash;
    
    //存款
    protected int deposit;
    
    //最多20個道具
    protected Item[] item = new Item[20];
    
    //名字
    protected String name;
    
    //擁有房屋
    protected int[] house = new int[100];
    
    //職業
    protected int career;
    
    //狀態
    protected Event[] state;
    
    //位置
    protected int location;
    
    //點數
    protected int credit;
    
    //圖片資訊(未完成)
    protected GraphicsEngine graph;
    
}
