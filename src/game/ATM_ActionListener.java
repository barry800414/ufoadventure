package game;

import java.awt.event.*;


public class ATM_ActionListener implements ActionListener{

	private int num;
	private GameInfo ginfo;
	
	public ATM_ActionListener(GameInfo ginfo,int num){
		this.ginfo = ginfo;
		this.num = num;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		//new GameBackGroundAudio("InstOK.wav").start();
		synchronized(ginfo){
			ginfo.set_Control_State(GameInfo.ATM_NUM[num]);
			ginfo.notifyAll();
		}
	}
}
