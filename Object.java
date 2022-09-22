
abstract class Object{
  double mass;
  double vol;

  abstract void addMass(double m);
  abstract void addVol();
  abstract void setMass()
  public double getMass(){
    return this.mass;
  }
  public double getVol(){
    return this.vol;
  }
}
class Particle extends Object{
  public void addMass(double m){
    this.mass += m;
  }
}