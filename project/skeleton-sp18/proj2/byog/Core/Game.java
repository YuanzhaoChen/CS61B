package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;
import edu.princeton.cs.algs4.In;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Game {
    TERenderer ter = new TERenderer();
    /* Feel free to change the width and height. */
    public static final int WIDTH = 80;
    public static final int HEIGHT = 30;

    /**
     * Method used for playing a fresh game. The game should start from the main menu.
     */
    public void playWithKeyboard() {

    }

    /**
     * Method used for autograding and testing the game code. The input string will be a series
     * of characters (for example, "n123sswwdasdassadwas", "n123sss:q", "lwww". The game should
     * behave exactly as if the user typed these characters into the game after playing
     * playWithKeyboard. If the string ends in ":q", the same world should be returned as if the
     * string did not end with q. For example "n123sss" and "n123sss:q" should return the same
     * world. However, the behavior is slightly different. After playing with "n123sss:q", the game
     * should save, and thus if we then called playWithInputString with the string "l", we'd expect
     * to get the exact same world back again, since this corresponds to loading the saved game.
     * @param input the input string to feed to your program
     * @return the 2D TETile[][] representing the state of the world
     */

    public TETile[][] playWithInputString(String input) {
        // TODO: Fill out this method to run the game using the input passed in,
        // and return a 2D tile representation of the world that would have been
        // drawn if the same inputs had been given to playWithKeyboard().
        List<Room> list=new ArrayList<>();
        int seed=Integer.parseInt(input.substring(1,input.length()-1));
        Random rand=new Random(seed);
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
        TETile[][] finalWorldFrame = new TETile[WIDTH][HEIGHT];
        clearWorld(finalWorldFrame);//fill with Tileset.NOTHING
        //generate random rooms
        int roomMaxWith=WIDTH/3;
        int roomMaxHeight=HEIGHT/3;
        Room firstRoom=Room.getRandRoom(rand,roomMaxWith,roomMaxHeight);
        firstRoom.addToWorld(finalWorldFrame);
        list.add(firstRoom);
        for(int i=0;i<10;i+=1){
            Room randRoom=list.get(RandomUtils.uniform(rand,0,list.size()));
            //check whether it's save to place another room nearby
            while(randRoom.p2.y<2||randRoom.p2.x>WIDTH-3){
                randRoom=list.get(RandomUtils.uniform(rand,0,list.size()));
            }
            //int x=RandomUtils.uniform(rand,randRoom.p1.x,randRoom.p2.x);
            //int y=RandomUtils.uniform(rand,randRoom.p2.y,randRoom.p1.y);
            int x1=randRoom.p2.x;
            int y1=randRoom.p2.y;
            int x2=randRoom.p3.x;
            int y2=randRoom.p3.y;
            Room newRoom1=Room.getRandRoom(rand,x1,y1,roomMaxWith,roomMaxHeight);
            Room newRoom2=Room.getRandRoom(rand,x2,y2,roomMaxWith,roomMaxHeight);
            newRoom1.addToWorld(finalWorldFrame);
            newRoom2.addToWorld(finalWorldFrame);
            Room.removeExtraWalls(finalWorldFrame);
            list.add(newRoom1);
            list.add(newRoom2);
        }
        //draw the whole world
        Room.removeExtraWalls(finalWorldFrame);
        ter.renderFrame(finalWorldFrame);
        return finalWorldFrame;
    }

    /** Fill the world with Tileset.NOTHING, call this method for initialization */
    public static void clearWorld(TETile[][]world){
        for(int w=0;w<world.length;w+=1){
            for(int h=0;h<world[0].length;h+=1){
                world[w][h]= Tileset.NOTHING;
            }
        }
    }

}
