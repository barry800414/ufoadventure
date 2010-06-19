package game;

public class Game {
    
    public static void main(String[] args){
    	//GameInfo ginfo =  new GameInfo();
        GraphicsEngine gengine = new GraphicsEngine();
        //Computer gcom = new Computer(ginfo);
        
        //GameMainMenu a = new GameMainMenu(ginfo);
        //a.Display();
        gengine.setVisible(true);
        
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
