/**
 * Created by nitinkumarsharma on 11/12/16.
 */

import java.util.*;
public class Location {
    private double x;
    private double y;
    Scanner scan= new Scanner(System.in);

    public Location(double x, double y){
        x= scan.nextDouble();
        y= scan.nextDouble();}

    public double getX(){
        return x;}

    public double getY(){
        return y;}

    public void setX(double x){
        this.x=x;}

    public void setY(double y){
        this.y=y;}

    public String toString(){
        return "Location: x= "+getX()+" ; y= "+getY();}

    public double getDistance(Location L){
        double x1=scan.nextDouble();
        double y1=scan.nextDouble();
        L=new Location(x1,y1);
        return (Math.sqrt((Math.pow((x-x1),2))+(Math.pow((y-y1), 2))));}
}