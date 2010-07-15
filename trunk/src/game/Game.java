package game;

public class Game {
    public static void main(String[] args){
    	
    	GameInfo ginfo =  new GameInfo();
    	GraphicsEngine gengine = new GraphicsEngine(ginfo);
    	//GameMainMenu menu = new GameMainMenu(ginfo);
    	//menu.Display();
    	gengine.initialize();
    	gengine.setVisible(true);
    	gengine.Display_MainMenu();
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	ginfo.GameInfo_Init();
    	
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
