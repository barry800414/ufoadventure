package game;

public class Demo {
    
    public static void main(String[] args){
    	
    	GameInfo ginfo =  new GameInfo();
    	GG gengine = new GG(ginfo);
    	GameMainMenu menu = new GameMainMenu(ginfo);
    	menu.Display();
    	ginfo.Game_Init();
    	gengine.initialize();
    	gengine.setVisible(true);
        Computer gcom = new Computer(ginfo, gengine);
    	
    	while(gcom.Run());
    	
        
        
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
