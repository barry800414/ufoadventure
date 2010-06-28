package game;

public class ATM_Event extends Event{
	
	private int money = 0 ;
	private boolean withdraw_save = true;
	
	public ATM_Event(GameInfo ginfo , GraphicsEngine gengine , Computer com){
		super(ginfo,gengine,com);
	}
	
	public void apply(GameObject origin , GameObject target){
		Player player;
		money = 0;
		if((origin instanceof SpecialLocation)  && (target instanceof Player)){
			player = (Player)target;
	    	gengine.Show_ATM();
	    	Event_Wait();
	    	while(true){
	    		int state = ginfo.get_Control_State();
	    		if(state == GameInfo.ATM_enter){
	    			if(withdraw_save == true){
	    				player.setCash(player.getCash() + money);
	    				player.setDeposit(player.getDeposit() - money);
	    			}
	    			else{
	    				player.setCash(player.getCash() - money);
	    				player.setDeposit(player.getDeposit() + money);
	    			}
	    			break;
	    		}
	    		else if(state == GameInfo.ATM_clear){
	    			money = 0;
	    			gengine.Reset_ATM_Label(money,withdraw_save);
	    		}
	    		else if(state == GameInfo.ATM_max){
	    			if(withdraw_save == true)
	    				money = player.getDeposit();
	    			else
	    				money = player.getCash();
	    			gengine.Reset_ATM_Label(money,withdraw_save);
	    		}
	    		else if(state == GameInfo.ATM_save){
	    			money = 0;
	    			withdraw_save = false;
	    			gengine.Reset_ATM_Label(money, withdraw_save);
	    		}
	    		else if(state == GameInfo.ATM_withdraw){
	    			money = 0;
	    			withdraw_save = true;
	    			gengine.Reset_ATM_Label(money, withdraw_save);
	    		}
	    		else if(state == GameInfo.ATM_NUM[0]){
	    			money = money * 10 ;
	    			money = check_limit(money,player,withdraw_save);
	    			gengine.Reset_ATM_Label(money, withdraw_save);
	    		}
	    		else if(state == GameInfo.ATM_NUM[1]){
	    			money = money * 10 +1;
	    			money = check_limit(money,player,withdraw_save);
	    			gengine.Reset_ATM_Label(money, withdraw_save);
	    		}
	    		else if(state == GameInfo.ATM_NUM[2]){
	    			money = money * 10 +2;
	    			money = check_limit(money,player,withdraw_save);
	    			gengine.Reset_ATM_Label(money, withdraw_save);
	    		}
	    		else if(state == GameInfo.ATM_NUM[3]){
	    			money = money * 10 +3;
	    			money = check_limit(money,player,withdraw_save);
	    			gengine.Reset_ATM_Label(money, withdraw_save);
	    		}
	    		else if(state == GameInfo.ATM_NUM[4]){
	    			money = money * 10 +4;
	    			money = check_limit(money,player,withdraw_save);
	    			gengine.Reset_ATM_Label(money, withdraw_save);
	    		}
	    		else if(state == GameInfo.ATM_NUM[5]){
	    			money = money * 10 +5;
	    			money = check_limit(money,player,withdraw_save);
	    			gengine.Reset_ATM_Label(money, withdraw_save);
	    		}
	    		else if(state == GameInfo.ATM_NUM[6]){
	    			money = money * 10 +6;
	    			money = check_limit(money,player,withdraw_save);
	    			gengine.Reset_ATM_Label(money, withdraw_save);
	    		}
	    		else if(state == GameInfo.ATM_NUM[7]){
	    			money = money * 10 +7;
	    			money = check_limit(money,player,withdraw_save);
	    			gengine.Reset_ATM_Label(money, withdraw_save);
	    		}
	    		else if(state == GameInfo.ATM_NUM[8]){
	    			money = money * 10 +8;
	    			money = check_limit(money,player,withdraw_save);
	    			gengine.Reset_ATM_Label(money, withdraw_save);
	    		}
	    		else if(state == GameInfo.ATM_NUM[9]){
	    			money = money * 10 +9;
	    			money = check_limit(money,player,withdraw_save);
	    			gengine.Reset_ATM_Label(money, withdraw_save);
	    		}
	    		Event_Wait();
	    	}
	    	
			gengine.Remove_ATM();
			gengine.Screen_Update(player);
			Event_Sleep(1000);
		}
		else
			System.out.println("ATM Event Applies failure");
	}
	private int check_limit(int money,Player player,boolean withdraw_save){
		if(withdraw_save){
			return money > player.getDeposit() ? player.getDeposit() : money;
		}
		else{
			return money > player.getCash() ? player.getCash() : money;
		}
	}
}
