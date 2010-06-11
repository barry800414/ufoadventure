package game;

public class Game {
    
    public GameInfo ginfo;
    public GraphicsEngine gengine;
    public Updater gupdater;
    public Control control;
    private String[] itemlist, eventlist , landclassname ; 
    
    public Game(){
    	gengine = new GraphicsEngine();
    	
    }
    /**
     * display the mainmenu for the game
     */
    public void MainMenu(){
    	gengine.DisplayMainMenu();
    }
    /**
     * Load the map infomation of the game , write into itemclassname,
     *  eventclassname , landclassname 
     */
    public void Init(){
    	
    	ginfo = new GameInfo();
    }
    public void MainLoop(){
    	for(int i=0;i<ginfo.players_num;i++){
    		gengine.Displaygame(ginfo.allplayers[i]);
    		control.PlayerControl(ginfo.allplayers[i]);
    		gengine.Displaygame(ginfo.allplayers[i]);
    	}
    }
    
}
