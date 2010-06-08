package game;

import java.awt.image.*;

public abstract class Land {
    
    //�ϥΪ�
    protected Player player;
    
    //�W��
    protected String name;
    
    //��m
    protected int location;
    
    //�֦���
    protected Player owner;
    
    //�Ϥ���T(������)
    protected String picture_name;
    protected int centerx , centery;
    protected int upleftx , uplefty;
    
    //����(������)
    protected String[] explanation = new String[0];
    
    //Ĳ�o
    protected abstract void trigger();
    
}
