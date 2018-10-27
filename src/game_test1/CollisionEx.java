package game_test1;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JFrame;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class CollisionEx extends JFrame {

    public CollisionEx() {
        
        initUI();
    }
    
    private void initUI() {
//                AudioPlayer MGP = AudioPlayer.player;
//        AudioStream BGM;
//        AudioData MD;
//
//        ContinuousAudioDataStream loop = null;
//
//        try
//        {
//            BGM = new AudioStream(new FileInputStream("src\\game_test1\\images\\deadpool.mp3"));
//            MD = BGM.getData();
//            loop = new ContinuousAudioDataStream(MD);
//        }
//        catch(IOException e)
//        {
//            System.out.println("cant find the file");
//        }
//
//        MGP.start(loop);
        add(new Board());
        
        setSize(400, 300);
        setResizable(false);
        
        setTitle("THE BEST GAME EVER");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            CollisionEx ex = new CollisionEx();
            ex.setVisible(true);
        });
    }
}