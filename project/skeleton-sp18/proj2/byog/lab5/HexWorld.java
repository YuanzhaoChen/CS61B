package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;
import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 80;
    private static final int HEIGHT = 120;
    public static final LocalTime LOCAL_TIME =LocalTime.now();
    private static final Random RANDOM = new Random(60*LOCAL_TIME.getMinute()+LOCAL_TIME.getSecond());
    public static void addHexagon(TETile[][] world,int hexLength,int inRow,int inColumn, TETile pattern){
        int startColumn=inColumn,endColumn=inColumn+hexLength-1;
        int i=0;
        boolean makeAlarm=false;
        for(int row=inRow;row>inRow-hexLength;row-=1){
            for(int col=startColumn;col<=endColumn;col+=1){
                try{
                    world[col][row]=pattern; //draw upper half of the hex
                    world[col][row-2*hexLength+1+i]=pattern; //draw lower half of the hexs
                }catch (Exception ArrayIndexOutOfBoundsException){
                    if(!makeAlarm){
                        System.out.println("Some parts of the hexagon is out of the world.");
                        makeAlarm=true;
                    }
                }
            }
            startColumn-=1;
            endColumn+=1;
            i+=2;
        }
    }
    public static void tesselateHexagon(TETile[][] world,int hexlength,int inRow,int inColumn,TETile pattern){
        ArrayList<int[]> list=new ArrayList<>();
        list.add(new int[]{inRow,inColumn});
        //tesselate first half
        int row=inRow,col=inColumn;
        for(int i=0;i<hexlength-1;i++){
            int[] arr=findRight(row,col,hexlength);
            list.add(arr);
            row=arr[0];
            col=arr[1];
        }
        int len=0;
        for(int i=0;i<list.size();i+=1){
            int[] arr=list.get(i);
            row=arr[0];
            col=arr[1];
            for(int j=0;j<hexlength+len;j+=1){
                addHexagon(world,hexlength,row,col,randomTile());
                row=findLeft(row,col,hexlength)[0];
                col=findLeft(row,col,hexlength)[1];
            }
            len+=1;
        }
        //tesselate second half
        len-=2;
        ArrayList<int[]> list2=new ArrayList<>();
        row=list.get(hexlength-1)[0];
        col=list.get(hexlength-1)[1];
        for(int i=0;i<hexlength-1;i+=1){
            int[] arr=findMid(row,col,hexlength);
            list2.add(arr);
            row=arr[0];
            col=arr[1];
        }
        for(int i=0;i<hexlength-1;i+=1){
            row=list2.get(i)[0];
            col=list2.get(i)[1];
            for(int j=0;j<hexlength+len;j+=1){
                addHexagon(world,hexlength,row,col,randomTile());
                int[] arr=findLeft(row,col,hexlength);
                row=arr[0];
                col=arr[1];
            }
            len-=1;
        }
    }
    //find top-left corner of left child hexagon
    private static int[] findLeft(int inRow, int inColumn,int hexLength){
        int[] position=new int[]{inRow-hexLength,inColumn-2*hexLength+1};
        return position;
    }
    //find top-right corner of right child hexagon
    private static int[] findRight(int inRow, int inColumn,int hexLength){
        int[] position=new int[]{inRow-hexLength,inColumn+2*hexLength-1};
        return position;
    }
    //find top-right corber of the middle chile hexagon
    private static int[] findMid(int inRow,int inColumn,int hexLength){
        int[] position=new int[]{inRow-2*hexLength,inColumn};
        return position;
    }
    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(5);
        switch (tileNum) {
            case 0: return Tileset.WALL;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.WATER;
            case 3: return Tileset.SAND;
            case 4: return Tileset.GRASS;
            case 5: return Tileset.MOUNTAIN;
            default: return Tileset.NOTHING;
        }
    }
    private static void initializeWorld(TETile[][]world){
        for(int row=0;row<HEIGHT;row+=1){
            for(int col=0;col<WIDTH;col+=1){
                world[col][row]=Tileset.NOTHING;
            }
        }
    }
    public static void main(String[] args){
        TERenderer ter=new TERenderer();
        ter.initialize(WIDTH,HEIGHT);
        TETile[][] hexWorld=new TETile[WIDTH][HEIGHT];
        initializeWorld(hexWorld);
        tesselateHexagon(hexWorld,3,115,40,randomTile());
        ter.renderFrame(hexWorld);
    }
}
