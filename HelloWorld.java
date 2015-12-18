import org.jsfml.graphics.CircleShape;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.Keyboard;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

import java.util.ArrayList;
import java.util.Arrays;

public class HelloWorld{
    public static void main(String[] args) {

        //Create the window
        RenderWindow window = new RenderWindow();
        window.create(new VideoMode(640, 480), "Hello JSFML!");

//Limit the framerate
        window.setFramerateLimit(30);
        ArrayList<MovingCircle> moving = new ArrayList<>();
        MovingCircle circ = new MovingCircle(new ArrayList<>(Arrays.asList(10,1, 0)),
                new ArrayList<>(Arrays.asList(100, 0 , 0)), 0);
        MovingCircle circ2 = new MovingCircle(new ArrayList<>(Arrays.asList(300,-1,0)),
                new ArrayList<>(Arrays.asList(100,0,0)), 0);
        circ.setPosition(100,100);
        moving.add(circ);
        moving.add(circ2);
        circ2.setColor(Color.CYAN);
//Main loop
        int time = 0;
        while(window.isOpen()) {
            //Fill the window with red
            window.clear(Color.BLACK);

            //Display what was drawn (... the red color!)
            for (MovingCircle c: moving)
            {
                c.move(time);
                window.draw(c);
            }
            time++;
            if(circ.getGlobalBounds().intersection(circ2.getGlobalBounds()) != null){
                for (MovingCircle c:moving) {
                    System.out.println("FLIP");
                    c.flipX(time);
                }
            }
            window.display();

            //Handle events
            for(Event event : window.pollEvents()) {

                if(event.type == Event.Type.CLOSED) {
                    //The user pressed the close button
                    window.close();
                }
                else{
                    if(event.type==Event.Type.KEY_PRESSED){
                        System.out.println(event.asKeyEvent().key);
                    }
                    else{
                        System.out.println(event);
                    }
                }
            }
        }
    }
}