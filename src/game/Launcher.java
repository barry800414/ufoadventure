package game;

import java.util.*;
import java.io.*;

public class Launcher {
	public static void main(String[] args){
		/*
		GraphicsEngine ge = new GraphicsEngine();
		ge.GameScreen_init();
		ge.DrawGameScreen();
		*/
		String buf;
		
		
		try{
			Scanner input = new Scanner(new File("test.txt"));
			
			buf = input.next();
			System.out.println("test");
			System.out.println(buf);
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		//Game game = new Game();
		//game.MainMenu();
		//game.Init();
		//game.MainLoop();
		
		
	}
}
