import org.jsfml.graphics.*;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Created by saahil claypool on 12/13/2015.
 */
public class MovingCircle extends Sprite {
    public final double xMove = 1;
    public final double yMove = 1;
    public MovingCircle () {
        try {
            Texture t = new Texture();

            t.loadFromFile( FileSystems.getDefault().getPath("C:\\Users\\saahil claypool\\Documents\\Coding\\GameGraphics\\src\\GraphicsSrc\\soccerball.png"));

            this.setTexture(t);
        }
        catch (IOException e) {
            System.out.println("COULNDT LOAD FILE");
        }
        this.setScale(.1f,.1f);
    }

    public void move(){
        this.setPosition((int)(this.getPosition().x + xMove), (int)(this.getPosition().y + yMove));
    }



}
