/*
import junit.framework.TestCase;

import org.jsfml.system.Vector2f;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class test extends TestCase {

    @Test
    public void testCollisionNoOverlap(){
        Obj a = new Obj(new Vector2f(10,10),
                new Vector2f(10,10),
                new Vector2f(10,10),
                100,100, "soccerball.png");
        Obj b = new Obj(new Vector2f(120,100),
                new Vector2f(10,10),
                new Vector2f(10,10),
                100,100, "soccerball.png");

        assertFalse(a.doesCollide(b));

    }
    @Test
    public void testCollisionOverlap(){
        Obj a = new Obj(new Vector2f(10,10),
                new Vector2f(10,10),
                new Vector2f(10,10),
                100,100, "soccerball.png");
        Obj b = new Obj(new Vector2f(10,100),
                new Vector2f(10,10),
                new Vector2f(10,10),
                100,100, "soccerball.png");

        assertTrue(a.doesCollide(b));

    }

    @Test
    public void testCollisionBoundry(){
        Obj a = new Obj(new Vector2f(110,110),
                new Vector2f(10,10),
                new Vector2f(10,10),
                100,100, "soccerball.png");
        Obj b = new Obj(new Vector2f(120,100),
                new Vector2f(10,10),
                new Vector2f(10,10),
                100,100, "soccerball.png");

        assertTrue(a.doesCollide(b));

    }
    @Test
    public void testGetCollisions(){
        World w = new World();
        w.add(new Obj(10,10,10,10) );
        w.add(new Obj(10,10,10,10));
        assertEquals(2, w.getCollisions().size());
    }



    public static void main(String[] args) {
        System.out.println("TEST CASES");
        Result result = JUnitCore.runClasses(test.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("" + result.getFailureCount() + " of " + result.getRunCount() + " failed");
    }


*/