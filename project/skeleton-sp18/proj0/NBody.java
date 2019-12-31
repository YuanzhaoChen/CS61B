public class NBody{
    public static String starfieldImage = "images/starfield.jpg";
    public static double readRadius(String fileName){
        In in = new In(fileName);
        int num = in.readInt();
        double r = in.readDouble();
        return r;
    }
    public static Body[] readBodies(String fileName){
        In in = new In(fileName);
        int num = in.readInt();
        double r = in.readDouble();
        Body[] bodies = new Body[num];
        for(int i=0; i<num; i++){
            bodies[i] = new Body(0.0, 0.0, 0.0, 0.0, 0.0, null); 
            bodies[i].xxPos = in.readDouble();
            bodies[i].yyPos = in.readDouble();
            bodies[i].xxVel = in.readDouble();
            bodies[i].yyVel = in.readDouble();
            bodies[i].mass = in.readDouble();
            bodies[i].imgFileName = in.readString();
        }
        return bodies;
    }
    public static void drawBackground(double scale1,double scale2){
        StdDraw.setScale(scale1,scale2);
        StdDraw.clear();
        StdDraw.picture(0,0,starfieldImage);
        StdDraw.show(); 
    }
    public static void main(String[] args){
        if (args.length!=3){
            System.out.println("example: java NBody <T> <dt> <fileName>");
            System.exit(0);
        }
        double T,dt;
        String fileName;
        T = Double.parseDouble(args[0]);
        dt = Double.parseDouble(args[1]);
        fileName = args[2];
        double radius = readRadius(fileName);
        Body[] bodies = readBodies(fileName);

        for(int i=0;i<bodies.length;i++){
            bodies[i].draw();
        }

        double time = 0.0;
        double[] xforces = new double[bodies.length];
        double[] yforces = new double[bodies.length];
        StdDraw.enableDoubleBuffering();
        while(time<=T){
            for(int i=0;i<bodies.length;i++){
                xforces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yforces[i] = bodies[i].calcNetForceExertedByY(bodies);
            }
            StdDraw.clear();
            drawBackground(-radius, radius);
            for(int i=0;i<bodies.length;i++){
                bodies[i].update(dt, xforces[i], yforces[i]);
                bodies[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }
        /**print out the universe */
        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                        bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
        }
    }
}