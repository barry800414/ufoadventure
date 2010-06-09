package game;

public class Launcher {
	public static void main(String[] args){
		GraphicsEngine ge = new GraphicsEngine();
		ge.GameScreen_init();
		ge.DrawGameScreen();
		
		//Game game = new Game();
		//game.MainMenu();
		//game.Init();
		//game.MainLoop();
		
	}
}
