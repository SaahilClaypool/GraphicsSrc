import org.jsfml.graphics.CircleShape;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.Keyboard;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

public class HelloWorld{
    public static void main(String[] args) {

        //Create the window
        RenderWindow window = new RenderWindow();
        window.create(new VideoMode(640, 480), "Hello JSFML!");

//Limit the framerate
        window.setFramerateLimit(30);
        MovingCircle c = new MovingCircle();
        c.setPosition(100,100);
//Main loop
        while(window.isOpen()) {
            //Fill the window with red
            window.clear(Color.BLACK);

            //Display what was drawn (... the red color!)

            c.move();

            window.draw(c);
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