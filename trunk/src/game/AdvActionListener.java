package game;

import java.awt.event.*;

import javax.swing.JComponent;

public class AdvActionListener implements ActionListener{

    GG gengine;
    Object o;
    Player p;
    Road r;
    Land l;
    boolean remove;
    JComponent main_component;
    JComponent component;
    int tmp;
    String num;
    
    
    AdvActionListener(GG gengine, Object o, Player p, Road r, Land l, boolean remove, int tmp){
	this.gengine = gengine;
	this.o = o;
	this.p = p;
	this.r = r;
	this.l = l;
	this.remove = remove;
	this.tmp = tmp;
    }
    
    AdvActionListener(GG gengine, Object o, Player p, boolean remove, int tmp, String num){
	this.gengine = gengine;
	this.o = o;
	this.p = p;
	this.remove = remove;
	this.tmp = tmp;
	this.num = num;
    }
    
    AdvActionListener(GG gengine, Object o, Player p, Road r, Land l, boolean remove, JComponent main_component, JComponent component, int tmp){
	this.gengine = gengine;
	this.o = o;
	this.p = p;
	this.r = r;
	this.l = l;
	this.remove = remove;
	this.main_component = main_component;
	this.component = component;
	this.tmp = tmp;
    }
    public void actionPerformed(ActionEvent e) {
	gengine.tmp = tmp;
	if(remove == false) main_component.remove(component);
	else if(num!=null) ATM(num);
	synchronized (o){
	    o.notifyAll();
	    gengine.repaint();
	}
	    
	
    }
    
    private void ATM(String num){
	    if(num.toCharArray()[0] - '0' < 10) gengine.ATM_number  = gengine.ATM_number * 10 + (num.toCharArray()[0] - '0');
	    else if(num.toCharArray()[0] == 'm' && gengine.Out_In == true) gengine.ATM_number = p.getDeposit();
	    else if(num.toCharArray()[0] == 'm' && gengine.Out_In == false) gengine.ATM_number = p.getCash();
	    else if(num.toCharArray()[0] == 'c') gengine.ATM_number = 0;
	    else if(num.toCharArray()[0] == 'o') gengine.Out_In = true;
	    else if(num.toCharArray()[0] == 'i') gengine.Out_In = false;
	    
	    if(gengine.Out_In == true && gengine.ATM_number > p.getDeposit()) gengine.ATM_number = p.getDeposit();
	    else if(gengine.Out_In == false && gengine.ATM_number > p.getCash()) gengine.ATM_number = p.getCash();
	
    }
}
