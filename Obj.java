import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.graphics.TextureCreationException;
import org.jsfml.system.Vector2f;

import java.io.IOException;

/**
 * Created by saahil claypool on 12/15/2015.
 */
public class Obj extends Sprite {

    Vector2f vel;
    Vector2f acc;
    float lastMove = 0;
    int height ;
    int width ;

    public Obj(Vector2f loc, Vector2f vel, Vector2f acc, int width, int height, String s) {

        this.vel = vel;
        this.acc = acc;
        this.setPosition(loc);
        Texture t = new Texture();
        try {
            t.loadFromStream(this.getClass().getResourceAsStream(s));
        } catch (IOException e) {
            System.out.println("FAILED TO LOAD " + s);
        } catch(Exception e){
            System.out.println("FAILED TO LOAD");
        }
        this.setTexture(t);


        this.width = width;
        this.height = height;
        float tW = getLocalBounds().width;
        float tH = getLocalBounds().height;

        setScale(width/tW, height / tH);


    }
    public Obj (int x, int y, int width, int height){
        vel = new Vector2f(0,0);
        acc = new Vector2f(0,0);
        this.setPosition(new Vector2f(x,y));
        Texture t = new Texture();
        try {
            t.loadFromStream(this.getClass().getResourceAsStream("soccerball.png"));
        } catch (IOException e) {
            System.out.println("FAILED TO LOAD " + "soccerball.png");
        }

        this.setTexture(t);

        float tW = getLocalBounds().width;
        float tH = getLocalBounds().height;

        setScale(width/tW, height / tH);

    }

    /**
     * determines if given object overlaps this object
     * @param b
     * @return
     */
    public void handleCollision(Obj b){

    }
    public boolean doesCollide(Obj b){
        return this.getGlobalBounds().intersection(b.getGlobalBounds()) != null;
    }
    public void move(float now){
        float deltaT = now - lastMove;
        setPosition( Vector2f.add(getPosition() , Vector2f.mul(vel, deltaT)));


    }
    public void accel(float now){

        float deltaT = now - lastMove;
        vel = Vector2f.add(vel , Vector2f.mul(acc, deltaT));
        lastMove = now;

    }


}
