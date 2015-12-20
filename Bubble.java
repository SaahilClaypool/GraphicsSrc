import org.jsfml.graphics.Color;
import org.jsfml.graphics.Texture;
import org.jsfml.graphics.TextureCreationException;
import org.jsfml.system.Vector2f;

import java.io.IOException;

/**
 * Created by saahil claypool on 12/18/2015.
 */
public class Bubble extends Obj {


    public Bubble(int x, int y, int height, int width, String color){
        super(new Vector2f(x,y), new Vector2f(0,0), new Vector2f(0,0), width, height, color+"-circ.png");
        this.setOrigin(width/2, height/2);



    }
    public Bubble(int x, int y, int xV, int yV, int xA, int yA, int width, int height){
        super(x,y, width , height );
        this.vel = new Vector2f(xV, yV);
        this.acc = new Vector2f(xA, yA);
        this.setOrigin(width/2, height/2);

    }
}
