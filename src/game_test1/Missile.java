package game_test1;

public class Missile extends Sprite {

    private final int BOARD_WIDTH = 390;
    private final int MISSILE_SPEED = 4;

    public Missile(int x, int y) {
        super(x, y);
        
        initMissile();
    }
    
    private void initMissile() {
        
        loadImage("C:\\Users\\Mario Mupo\\Documents\\NetBeansProjects\\Game_test1\\src\\game_test1\\images\\missile.png");  
        getImageDimensions();
    }

    public void move() {
        
        x += MISSILE_SPEED;
        
        if (x > BOARD_WIDTH) {
            visible = false;
        }
    }
}