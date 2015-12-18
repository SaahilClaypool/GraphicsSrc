import org.jsfml.graphics.*;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Created by saahil claypool on 12/13/2015.
 */
public class MovingCircle extends Sprite {
    ArrayList<Integer> x,y;
    int time;

    /**
     *
     * @param x min 2 elemetns
     * @param y min 2 elements
     * @param time
     */
    public MovingCircle (ArrayList<Integer>x, ArrayList<Integer> y, int time) {
        try {
           Texture t = new Texture();
            t.loadFromStream(this.getClass().getResourceAsStream("soccerball.png"));


            this.setTexture(t);
        }
        catch (IOException e) {
            System.out.println("");
        }

        this.x = x;
        this.y = y;
        this.time = time;
        double width = this.getLocalBounds().width;
        double height = this.getLocalBounds().height;
        this.setScale((float) (100 / width),(float)(100/ height));
        System.out.println("M SCALE "+ this.getScale());
        System.out.println("MY LOCAL BOUND "+ this.getLocalBounds());
    }

    public void move(int t){
        int dt =t- this.time ;
        double xLoc = 0;
        double yLoc = 0;
        for (int i = 0; i < x.size(); i++) {
            xLoc += x.get(i) * Math.pow(dt, i) /(i > 0 ? i:1)  ;

        }
        for (int i = 0; i < y.size(); i++) {
            yLoc += y.get(i) * Math.pow(dt, i) /(i > 0 ? i:1)  ;

        }
        System.out.printf("xLoc %f, yLoc%f\n", xLoc, yLoc);
        this.setPosition((int)xLoc, (int)yLoc);
        reformat(t);
    }
    public void flipX(int t){
        System.out.println(this.x.get(1));
        this.x.set(1 , -1 * this.x.get(1));
        System.out.println(this.x.get(1));
        reformat(t);
    }
    private void reformat(int t){
        for (int i = 0; i <x.size()-1 ; i++) {
            x.set(i, x.get(i) +  x.get(i+1)*(t-time));
        }
        time = t;
    }


}
