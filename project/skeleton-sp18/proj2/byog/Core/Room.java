package byog.Core;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;
import java.util.Random;
/** Rooms in this project are all rectangles */
public class Room {
    public Point p1;//top-left corner of the Room
    public Point p2;//bottom-right corner of the Room
    public Point p3;//bottom-left corner of the Room
    public Point p4;//top-right corner of the Room
    public Room(Point P1,Point P2){
        p1=P1;
        p2=P2;
        p3=new Point(p1.x,p2.y);
        p4=new Point(p2.x,p1.y);
    }
    /**Generate a random room at a random place*/
    public static Room getRandRoom(Random rand,int maxWidth,int maxHeight){
        int P1_X=RandomUtils.uniform(rand,0,Game.WIDTH-3); //x coordinate of P1
        int P1_Y=RandomUtils.uniform(rand,3,Game.HEIGHT); //y coordinate of P1
        int P2_X=Math.min(Game.WIDTH-1,P1_X+RandomUtils.uniform(rand,4,maxWidth));
        int P2_Y=Math.max(0,P1_Y-RandomUtils.uniform(rand,4,maxHeight));
        Point P1=new Point(P1_X,P1_Y);
        Point P2=new Point(P2_X,P2_Y);
        return new Room(P1,P2);
    }
    /**Generate a random room at specific location*/
    public static Room getRandRoom(Random rand,int x,int y,int maxWidth,int maxHeight){
        int P2_X=Math.min(Game.WIDTH-1, x+RandomUtils.uniform(rand,2,maxWidth));
        int P2_Y=Math.max(0,y-RandomUtils.uniform(rand,2,maxHeight));
        Point P1=new Point(x,y);
        Point P2=new Point(P2_X,P2_Y);
        return new Room(P1,P2);
    }
    /**Add room to worldFrame*/
    public void addToWorld(TETile[][]world){
        int w=p1.x;
        while(w<p2.x){
            int h=p2.y;
            world[w][h]=Tileset.WALL;
            h+=1;
            while(h<p1.y){
                world[w][h]=Tileset.FLOOR;
                h+=1;
            }
            world[w][h-1]=Tileset.WALL;
            w+=1;
        }
        //again
        int h=p2.y;
        while(h<p1.y){
            w=p1.x;
            world[w][h]=Tileset.WALL;
            w+=1;
            while(w<p2.x){
                //world[w][h]=Tileset.FLOOR;
                w+=1;
            }
            world[w-1][h]=Tileset.WALL;
            h+=1;
        }
    }
    /**Remove intersected walls*/
    public static void removeExtraWalls(TETile[][] world){
        for(int w=0;w<Game.WIDTH;w+=1){
            for(int h=0;h<Game.HEIGHT;h+=1){
                if(world[w][h]==Tileset.WALL&&w>0&&w<Game.WIDTH-1&&h>0&&h<Game.HEIGHT-1){
                    if(world[w-1][h]==Tileset.FLOOR&&world[w+1][h]==Tileset.FLOOR){
                        world[w][h]=Tileset.FLOOR;
                    }
                    if(world[w][h+1]==Tileset.FLOOR&&world[w][h-1]==Tileset.FLOOR){
                        world[w][h]=Tileset.FLOOR;
                    }
                }
            }
        }
    }
}
