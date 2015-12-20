import javafx.scene.shape.Circle;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by saahil claypool on 12/15/2015.
 */
public class World {
    public RenderWindow window;
    public ArrayList<Obj> objects = new ArrayList<>();
    CircleSystem circleSystem;
    public float t = 0;
    public int width = 1000;
    public int height = 1000;


    public World(){

       circleSystem = new  CircleSystem(this.width / 2, 100, this);
        //circleSystem = new CircleSystem(0f,0f,this);
    }
    /**
     * class represents collision of two objects
     */
    public class Collision{
        Obj one, two;
        Collision(Obj a, Obj b){
            one = a;
            two = b;
        }

        /**
         * passes collision to both collides
         */
        public void handle(){
            one.handleCollision(two);
            two.handleCollision(one);
        }
    }

    /**
     * starts game
     */
    public void start(){
        //Create the window
        window = new RenderWindow();
        window.create(new VideoMode(width, height), "Hello JSFML!");
//Limit the framerate
        window.setFramerateLimit(30);

        /*this.add(new Bubble(100,100,100,100, "black"));
        this.add(new Bubble(200,100,100,100, "blue"));*/

        while(window.isOpen()){
            updateFrame();
            handleEvents(t);
            handleCollisions();
            moveStuff();
            circleSystem.rotate();

            t+=.1f;
            window.display();
        }
    }
    public void rotateWithBall(Vector2f pos){
        circleSystem.rotateWithBall(pos);
    }
    /**
     * adds obj
     * @param o: object to be added
     */
    public void add(Obj o){
        objects.add(o);
    }
    /**
     * finds and executs collisions
     */
    public void handleCollisions(){
        doCollisions(getCollisions());
    }

    /**
     * gets arrayList of collisions
     * @return
     */
    public ArrayList<Collision> getCollisions(){
        ArrayList<Collision> cols = new ArrayList<>();
        for(Obj a: objects){
            for(Obj b : objects){
                if(a!=b){
                    if(a.doesCollide(b)){
                        cols.add(new Collision(a,b));
                    }
                }
            }
        }
        return cols;
    }

    /**
     * executes each collision
     * @param cols : list of collisions to execute
     */
    public void doCollisions(ArrayList<Collision> cols){
        for (Collision c :
                cols) {
            c.handle();
        }
    }

    /**
     * moves and adds accel to each object
     */
    public void moveStuff(){
        for(Obj o : objects){
            o.move(t);
            o.accel(t);
            window.draw(o);
        }
    }

    /**
     * draw each shape
     */
    public void updateFrame(){
       window.clear(Color.BLACK);

    }

    /**
     * handle user input
     */
    public void handleEvents(float lastMove){
        for(Event event : window.pollEvents()) {
            if(event.type.equals(Event.Type.MOUSE_BUTTON_PRESSED)){
                System.out.println("CLICK");
            }
            else if (event.type.equals(Event.Type.MOUSE_BUTTON_RELEASED)){
                moveToMouse(event.asMouseEvent().position, lastMove);
            }
            else if(event.type == Event.Type.CLOSED) {
                //The user pressed the close button
                window.close();
            }

        }
    }
    public void moveToMouse(Vector2i pos, float time){
        System.out.println("ADDING");
        Bubble b = new Bubble(this.width / 2, this.height -10, 20,20,"blue", this);
        this.add(b);
        Vector2f myPos = b.getPosition();
        Vector2f difference = Vector2f.sub(new Vector2f(pos.x, pos.y), myPos);
        difference = Vector2f.mul(difference, (float) (50/Math.sqrt(difference.x * difference.x + difference.y * difference.y)));
        b.vel = difference;
        b.lastMove = time;
    }

    public static void main(String[] args) {
        World w = new World();
        w.start();
    }
}
