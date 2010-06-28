package game;

public class Game {
    public static void main(String[] args){
    	
    	GameInfo ginfo =  new GameInfo();
    	GraphicsEngine gengine = new GraphicsEngine(ginfo);
    	GameMainMenu menu = new GameMainMenu(ginfo);
    	menu.Display();
    	ginfo.GameInfo_Init();
    	gengine.initialize();
    	Computer gcom = new Computer(ginfo,gengine);
    	gengine.setVisible(true);
    	
    	GameBackGroundAudio audio = new GameBackGroundAudio();
    	audio.start();
    	
    	boolean gameflag = true;
		
    	while(gameflag){
    		gameflag = gcom.Main_Loop();
    	}
    }
}
