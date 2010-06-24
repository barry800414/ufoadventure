package game;

public class Game {
    
    public static void main(String[] args){
    	
    	GameInfo ginfo =  new GameInfo();
    	GraphicsEngine gengine = new GraphicsEngine(ginfo);
    	GameMainMenu menu = new GameMainMenu(ginfo);
    	menu.Display();
    	ginfo.Game_Init();
    	
    	
    	gengine.initialize();
    	gengine.setVisible(true);
    	int[] count = {0,0,0,0};
    	
    	while(true){
    		for(int i=0 ;i < ginfo.players_num ;i++){
    			//ginfo.playerlist[i].setLocation(count[i]++);
    			gengine.GainControl(i);
    		}
    	}
    	
        
        //Computer gcom = new Computer(ginfo);
        
        //GameMainMenu a = new GameMainMenu(ginfo);
        //a.Display();
        //gengine.setVisible(true);
        
        //ginfo.init();
        
        
        /*
        while(gengine.MainMenu()){
        	ginfo.init();
        	MainLoop();        	
        }*/
        /*
        while(gcom.GameContinue()){
            gcom.Run();
        }*/
    }
    
}
