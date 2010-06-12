package game;

public class Game {
    
    public static void main(String[] args){
    	GameInfo ginfo =  new GameInfo();
        //GraphicsEngine gengine = new GraphicsEngine();
        Computer gcom = new Computer(ginfo);
        //Control control;
        //String[] itemlist, eventlist , landclassname ; 
        
        //gengine.GameScreen_init();
        //gengine.DrawGameScreen();
        GameMainMenu a = new GameMainMenu(ginfo);
        a.Display();
        
        ginfo.init();
        
        /*
        while(gengine.MainMenu()){
        	ginfo.init();
        	MainLoop();        	
        }*/
        while(gcom.GameContinue()){
            gcom.Run();
        }
    }
    
}
