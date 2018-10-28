/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_test1;

/**
 *
 * @author Mario Mupo
 */
import java.net.URL;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;

/**
 * Class to play background music
 */
public class BackgroundMusic implements LineListener {
	private URL music; //!< music url
	private Clip clip; //!< the clip
	private boolean stopped; //!< music currently stopped?
	
	/**
	 * create new backgrounds music
	 * @param music_ the url to play music from (wav)
	 */
	public BackgroundMusic(URL music_)
	{
		music = music_;
		stopped = true;
		
		// get line and clip
		try {
			clip = (Clip)AudioSystem.getLine(new Line.Info(Clip.class));
			clip.addLineListener(this);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
    
	/**
	 * handles line events (loop)
	 */
	@Override
    public void update(LineEvent event)
    {
		// restart as long as not stopped
		if(!stopped)
		{
			if (event.getType() == LineEvent.Type.STOP)
				start();
		}
    }
    
	/**
	 * start the music
	 */
	@SuppressWarnings("static-access")
	public void start()
	{
		stopped = false;
	    try
	    {
	    	// open
	    	if(!clip.isOpen())
	    	{
	    		clip.open(AudioSystem.getAudioInputStream(music));
	    	}
	    	
	    	// start and loop
	    	if(!clip.isRunning())
	    	{
	    		clip.loop(clip.LOOP_CONTINUOUSLY);
	    		clip.start();
	    	}
	    }
	    catch (Exception exc)
	    {
	        exc.printStackTrace(System.out);
	    }
	}
	
	/**
	 * stop the music
	 */
	public void stop()
	{
		stopped = true;
		clip.stop();
		clip.close(); // stop alone doesn't work
	}
}
