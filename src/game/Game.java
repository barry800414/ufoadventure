package game;

public class Game {
    public GameInfo ginfo;
    public GraphicsEngine gengine;
    public Updater gupdater;
    public Control control;
    private String[] itemclassname, eventclassname , landclassname ; 
    
    public Game(){
	ginfo = new GameInfo(itemclassname,eventclassname,landclassname);
	gengine = new GraphicsEngine();
	gupdater = new Updater();
    }
    /**
     * display the mainmenu for the game
     */
    public void MainMenu(){
	
    }
    /**
     * Load the map infomation of the game , write into itemclassname,
     *  eventclassname , landclassname 
     */
    public void Loadmap(){
	
    }
    public MainLoop(){
	for(int i=0;i<ginfo.players_num;i++){
	    gengine.Displaygame(ginfo.allplayers[i]);
	    control.PlayerControl(ginfo.allplayers[i]);
	    gengine.Displaygame(ginfo.allplayers[i]);
	}
	
    }
    
}
