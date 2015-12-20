import org.jsfml.system.Vector2f;

import java.util.ArrayList;

/**
 * Created by saahil claypool on 12/19/2015.
 */
public class CircleSystem {
    float posX;
    float posY;
    ArrayList<Obj> bubbles;
    World w;
    double inertia = 0;

    /**
     *
     * @param x    X Location
     * @param y    Y Location
     */
    public CircleSystem (float x, float y, World w){
        this.w = w;
        this.posX = x;
        this.posY = y;

        bubbles = new ArrayList<>();
        this.add(new Bubble(x ,y,100,100,"black", w));
        System.out.println(this.bubbles.get(0).getOrigin());
        w.add(bubbles.get(0));
    }
    public void rotateWithBall(Vector2f ball){
        System.out.println( (ball.x - posX) / 100.);
        this.giveInertia( -1 * (ball.x - posX) / 100);
    }
    public void rotate(){
        if(inertia <= .0005 && inertia>=-.005){
            return;
        }
        System.out.println(inertia + " INTERIA ");
        double theta = inertia;
        inertia += -.01 * Math.signum(inertia);
        System.out.println(inertia);
        // take each bubble, get relative center, add cos & sin to x and y
        for (Obj o:
             bubbles) {
            float relX = o.getPosition().x - posX;
            float relY = o.getPosition().y - posY;
            float distance = (float) Math.sqrt(Math.pow(relX, 2)+ Math.pow(relY, 2));
            double curAng = Math.atan2(relY, relX);

            double newAngle = curAng + theta;

            relX  = (float) (distance * Math.cos(newAngle));
            relY = (float)(distance* Math.sin(newAngle));

            o.setPosition(relX + posX, relY+ posY);


        }
    }
    public void add(Obj o){
        bubbles.add(o);
    }
    public void giveInertia(double d){
        this.inertia += d;
    }
}
