import java.util.ArrayList;

/**
 * Created by saahil claypool on 12/19/2015.
 */
public class CircleSystem {
    float posX;
    float posY;
    ArrayList<Obj> bubbles;
    World w;

    /**
     *
     * @param x    X Location
     * @param y    Y Location
     */
    public CircleSystem (float x, float y, World w){
        this.w = w;
        this.posX = x;
        this.posY = y;
        System.out.println(x + " " + y);
        bubbles = new ArrayList<>();
        this.add(new Bubble(x ,y,100,100,"black", w));
        w.add(bubbles.get(0));
    }
    public void rotate(float theta){
        // take each bubble, get relative center, add cos & sin to x and y
        for (Obj o:
             bubbles) {
            float relX = o.getPosition().x - posX;
            float relY = o.getPosition().y - posY;
            float distance = (float) Math.sqrt(Math.pow(relX, 2)+ Math.pow(relY, 2));
            double curAng = Math.atan2(relX, relY);
            if(relX<0f){
                curAng+=Math.PI;
            }
            double newAngle = curAng + theta;
            relX  = (float) (distance * Math.cos(newAngle));
            relY = (float)(distance* Math.sin(newAngle));
            o.setPosition(relX + posX, relY+ posY);


        }
    }
    public void add(Obj o){
        bubbles.add(o);
    }

}
