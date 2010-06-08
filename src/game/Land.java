package game;

import java.awt.image.*;

public abstract class Land {
    
    //使用者
    protected Player player;
    
    //名稱
    protected String name;
    
    //位置
    protected int location;
    
    //擁有者
    protected Player owner;
    
    //圖片資訊(未完成)
    protected String picture_name;
    protected int centerx , centery;
    protected int upleftx , uplefty;
    
    //說明(未完成)
    protected String[] explanation = new String[0];
    
    //觸發
    protected abstract void trigger();
    
}
