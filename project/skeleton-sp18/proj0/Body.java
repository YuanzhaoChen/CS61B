public class Body{
    public static double G = 6.67*Math.pow(10, -11);
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public Body(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Body(Body b){
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }
    public double calcDistance(Body b){
        double distance = Math.sqrt(Math.pow(b.xxPos-this.xxPos, 2) + Math.pow(b.yyPos-this.yyPos, 2));
        return distance;
    }
    public double calcForceExertedBy(Body b){
        double force = (G*this.mass*b.mass)/Math.pow(this.calcDistance(b), 2);
        return force;
    }
    public double calcForceExertedByX(Body b){
        double dx = b.xxPos - this.xxPos; 
        double fx = this.calcForceExertedBy(b)*dx/this.calcDistance(b);
        return fx;
    }
    public double calcForceExertedByY(Body b){
        double dy = b.yyPos - this.yyPos;
        double fy = this.calcForceExertedBy(b)*dy/this.calcDistance(b);
        return fy;
    }
    public double calcNetForceExertedByX(Body[] b){
        int N = b.length;
        double netforce=0.0;
        for (int i=0;i<N;i++){
            if(this == b[i] ){
                continue;
            }
            netforce += this.calcForceExertedByX(b[i]);
        }
        return netforce;
    }
    public double calcNetForceExertedByY(Body[] b){
        int N = b.length;
        double netforce=0.0;
        for (int i=0;i<N;i++){
            if(this == b[i]){
                continue;
            }
            netforce += this.calcForceExertedByY(b[i]);
        }
        return netforce;
    }
    public void update(double dt, double fx, double fy){
        double ax,ay;
        ax = fx/this.mass;
        ay = fy/this.mass;
        this.xxVel += ax*dt;
        this.yyVel += ay*dt;
        this.xxPos += xxVel*dt;
        this.yyPos += yyVel*dt;
    }
    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}