import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Vector2f;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

import java.util.ArrayList;

/**
 * Created by saahil claypool on 12/15/2015.
 */
public class World {
    private RenderWindow window;
    private ArrayList<Obj> objects = new ArrayList<>();
    public float t = 0;
    public void start(){
        //Create the window
        window = new RenderWindow();
        window.create(new VideoMode(1000, 1000), "Hello JSFML!");
//Limit the framerate
        window.setFramerateLimit(30);

        objects.add(new Obj (new Vector2f(100f, 100f), new Vector2f(10f,1f), new Vector2f(0f, -1f),100,100));





        while(window.isOpen()){
            updateFrame();
            handleEvents();
            moveStuff();
            t+=.1f;
            window.display();
        }
    }
    private void moveStuff(){
        for(Obj o : objects){
            o.move(t);
            o.accel(t);
            window.draw(o);
        }
    }
    private void updateFrame(){
        window.clear(Color.BLACK);

    }
    private void handleEvents(){
        for(Event event : window.pollEvents()) {
            if(event.type.equals(Event.Type.MOUSE_BUTTON_PRESSED)){
                System.out.println("CLICK");
            }
            if(event.type == Event.Type.CLOSED) {
                //The user pressed the close button
                window.close();
            }

        }
    }

    public static void main(String[] args) {
        World w = new World();
        w.start();
    }
}
