package game;

public class Player {
    
    //�{��
    protected int cash;
    
    //�s��
    protected int deposit;
    
    //�̦h20�ӹD��
    protected Item[] item = new Item[20];
    
    //�W�r
    protected String name;
    
    //�֦��Ы�
    protected int[] house = new int[100];
    
    //¾�~
    protected int career;
    
    //��l
    protected int dice;
    
    //���A
    protected Event[] state;
    
    //��m
    protected Land location;
    
    //�I��
    protected int credit;
    
    //�Ϥ���T(������)
    protected String picturename;
    protected int centerx , centery;
    protected int upleftx , uplefty;
    
}
