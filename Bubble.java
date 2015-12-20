import org.jsfml.system.Vector2f;

/**
 * Created by saahil claypool on 12/18/2015.
 */
public class Bubble extends Obj {

    boolean free = true;
    World w;
    public Bubble(float x, float y, int height, int width, String color, World w){
        super(new Vector2f(x,y), new Vector2f(0,0), new Vector2f(0,0), width, height, color+"-circ.png");
        this.setOrigin(width/2, height/2);
        this.w = w;


    }
    public Bubble(int x, int y, int xV, int yV, int xA, int yA, int width, int height, World w){
        super(x,y, width , height );
        this.vel = new Vector2f(xV, yV);
        this.acc = new Vector2f(xA, yA);
        this.setOrigin(width/2, height/2);
        this.w = w;
    }

    /**
     * gives back the old velocity
     * @return
     */
    public Vector2f stop(){
        Vector2f temp = this.vel;
        this.vel = new Vector2f(0,0);
        return temp;
    }

    @Override
    public void handleCollision(Obj b) {
        this.stop();
        if(free){
            w.circleSystem.add(this);
            free = false;
        }

    }
}
