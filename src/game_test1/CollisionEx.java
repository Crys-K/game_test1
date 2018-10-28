package game_test1;
//"src\\game_test1\\images\\deadpool.wav"
import java.awt.EventQueue;
import java.io.File;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class CollisionEx extends JFrame {

    public CollisionEx() {
        try {
            BackgroundMusic mu = new BackgroundMusic(new File("src\\game_test1\\images\\deadpool.wav").toURI().toURL());
             mu.start();
        } catch (MalformedURLException ex) {
            Logger.getLogger(CollisionEx.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        initUI();
    }
    
    private void initUI() {
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