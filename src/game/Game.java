package game;

public class Game {
    
    public static void main(String[] args){
    	GameInfo ginfo =  new GameInfo();
        GraphicsEngine gengine = new GraphicsEngine();
        Computer gcom;
        //Control control;
        //String[] itemlist, eventlist , landclassname ; 
    public static void main(String[] args){
	
    }
        
        while(gengine.MainMenu()){
        	ginfo.init();
        	MainLoop();        	
        }
  
    }
    public void MainLoop(){
    	for(int i=0;i<ginfo.players_num;i++){
    		gengine.Displaygame(ginfo.allplayers[i]);
    		control.PlayerControl(ginfo.allplayers[i]);
    		gengine.Displaygame(ginfo.allplayers[i]);
    	}
    }
    
}
