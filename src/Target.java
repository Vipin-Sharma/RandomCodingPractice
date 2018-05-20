/**
 * Created by nitinkumarsharma on 11/13/16.
 */

import java.util.*;
public class Target{
    Scanner scan = new Scanner(System.in);
    private Location loc;
    private double speed;
    private String type;
    private boolean threat;
    private int count = 0;

    public Target(double x, double y, double speed){
        x=scan.nextDouble();
        y=scan.nextDouble();
        speed=scan.nextDouble();
        if(speed<500)
            type="Helicopter";
        else type="Jet";
        threat = false;
        count++;}

    public String getType(){
        return type;}

    public double getSpeed() {
        return speed;}

    public void setSpeed(double speed) {
        this.speed = speed;}

    public Location getLoc() {
        return loc;}

    public void setLoc(Location loc) {
        this.loc = loc;}

    public boolean isThreat(Location L){
        /*if(Location.getDistance()<100){
            threat=true;}
        else threat=false;*/
        return threat;}

    public String toString(){
        return "Target is " ;
        /*+ getType() + ", speed= " + getSpeed() + "mph, [Location: x=" + Location.x1+ "; y=" + Loc.x + "]";*/
    }}
