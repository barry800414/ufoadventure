package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.text.AttributedString;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class BuildingEvent extends Event{
	
	
	public BuildingEvent(GameInfo ginfo , GraphicsEngine gengine , Computer com){
		super(ginfo,gengine,com);
	}
	
	public void apply(GameObject origin , GameObject target){
		Building b;
		Player p;
		if((origin instanceof Building)  && (target instanceof Player)){
			b = (Building)origin;
			p = (Player)target;
			gengine.Show_Building_Msg(b, p);
			synchronized(ginfo){
				try {
					ginfo.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			//TODO action listener
		}
		else
			System.out.println("Building Event Applies failure");
	}
	
}	