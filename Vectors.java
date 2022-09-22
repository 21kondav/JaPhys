import java.util.*;
import java.lang.*;
class Vector{
  double x;
  double y;
  double z;
  public Vector(double i, double j, double k){
    this.x = i;
    this.y = j;
    this.z = k;
  }
  public void setX(double a){
    this.x = a;
  }
  public void setY(double a){
    this.y = a;
  }
  public void setZ(double a){
    this.z = a;
  }
  public double getX(){
    return this.x;
  }
  public double getY(){
    return this.y;
  }
  public double getZ(){
    return this.z;
  }
  
  static double[] matrixForm(Vector a){
    double[] vect = {a.getX(), a.getY(), a.getZ()};
    return vect;
  }
  static double magnitude(Vector a){
    double mag_a = Math.sqrt(Math.pow(a.getX(), 2)+ Math.pow(a.getY(), 2)+ Math.pow(a.getZ(), 2));
    return mag_a;
  }
  static Vector scalProd(double k, Vector a){
    Vector b = new Vector((k * a.getX()),(k * a.getY()), (k * a.getZ()));
    return b;
  }
  static Vector cross(Vector a, Vector b){
    Vector axb = new Vector((a.getY()*b.getZ() - b.getY()*a.getZ()), (a.getZ()*b.getX() - b.getZ()*a.getX()), (a.getX()*b.getY() - b.getX()*a.getY()));
    return axb;
  }
  static double dot(Vector a, Vector b){
    double ab = a.getX()*b.getX()+b.getY()*a.getY() +a.getZ()*b.getZ();
    return ab;
  }
  static Vector sub(Vector b, Vector a){ 
    Vector s = new Vector((b.getX() - a.getX()),     (b.getY()- a.getY()), (b.getZ() - a.getZ()));
    return s;
  }
  static Vector add(Vector b, Vector a){ 
    Vector n = new Vector((b.getX() + a.getX()), (b.getY() + a.getY()), (b.getZ() + a.getZ()));
    return n;
  }
}
class Pos extends Vector{
  public Pos(double rx, double ry, double rz){
    super(rx, ry, rz);
  }
  
  static Vector dplace(Vector a, Vector b){
    Vector r = sub(b, a);
    return r;
  }
  static Vector com(HashMap<Particle, Vector> s){
    double totMass = 0;
    double mx = 0;
    double my = 0;
    double mz = 0;
    for(Particle i: s.keySet()){
      double mass = i.getMass();
      totMass += mass;
      mx += mass * s.get(i).getX();
      my += mass * s.get(i).getY();
      mz += mass * s.get(i).getZ();
    }
    Vector com = new Vector(mx, my, mz);
    com = scalProd(1/totMass, com);
    return com;
  }
}
class Vel extends Vector{
  public Vel(double vx, double vy, double vz){
    super(vx, vy, vz);
  }
  
  public Vector momentum(Vector a, Particle i){
    Vector p = scalProd(i.getMass(), a);
    return p;
  }  
}
class Accel extends Vector{
  public Accel(double ax, double ay, double az){
    super(ax, ay, az);
  }
  
  public Vector force(double m, Vector a){
    Vector f = scalProd(m, a);
    return f;
  }
}