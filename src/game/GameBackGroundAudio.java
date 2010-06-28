package game;

import javax.sound.midi.*;
import java.io.*;
import java.util.Random;


public class GameBackGroundAudio<Randon>  extends Thread{
 
	private String[] file_name;
    private int this_time;
    
    public GameBackGroundAudio() {
    	file_name = new String[25];
    	file_name[0] = "midi01.mid" ;
    	file_name[1] = "midi02.mid" ; 
    	file_name[2] = "midi03.mid" ; 
    	file_name[3] = "midi04.mid" ;
    	file_name[4] = "midi05.mid" ;
    	file_name[5] = "midi06.mid" ; 
    	file_name[6] = "midi07.mid" ;
    	file_name[7] = "midi08.mid" ;
    	file_name[8] = "midi09.mid" ;
    	file_name[9] = "midi10.mid" ;
    	file_name[10] = "midi11.mid" ;
    	file_name[11] = "midi12.mid" ;
    	file_name[12] = "midi13.mid" ; 
    	file_name[13] = "midi14-1.mid";
    	file_name[14] = "midi14-2.mid";
    	file_name[15] = "midi15.mid" ;
    	file_name[16] = "midi16.mid";
    	file_name[17] = "Rich08.mid";
    	file_name[18] = "Rich16.mid";
    	file_name[19] = "Rich17.mid";
    	file_name[20] = "Rich18.mid";
    	file_name[21] = "Rich19.mid";
    	file_name[22] = "Rich20.mid";
    	file_name[23] = "Rich21.mid";
    	file_name[24] = "Rich22.mid";
    
    }
    
    public void run(){
    	File[] midiFile = new File[file_name.length];
    	for(int i=0;i<file_name.length;i++)
    		midiFile[i] = new File(file_name[i]);
    	try {
            while(true){ 
            	Random rnd = new Random();
            	this_time = rnd.nextInt(file_name.length);
            	Sequencer sequencer = MidiSystem.getSequencer();
            	sequencer.setSequence(MidiSystem.getSequence(midiFile[this_time]));
            	sequencer.open();
            	sequencer.start();
            	while(true) {
            		if(sequencer.isRunning()) {
            			try {
            				Thread.sleep(1000); // Check every second
            			} catch(InterruptedException ignore) {
            				break;
            			}
            		} else {
            			break;
            		}
            	}
             // Close the MidiDevice & free resources
             sequencer.stop();
             sequencer.close();
            }
         } catch(MidiUnavailableException mue) {
             mue.printStackTrace();
         } catch(InvalidMidiDataException imde) {
             imde.printStackTrace();
         } catch(IOException ioe) {
             ioe.printStackTrace();
         } 
    }
    
}
