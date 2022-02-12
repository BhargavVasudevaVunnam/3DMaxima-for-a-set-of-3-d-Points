//Bhargav Vasudeva Vunnam (J387T358)
import java.util.*;
class Point implements Comparable<Point>
{
private double x = 0, y = 0, z = 0;  
private boolean maximal = false;        
public void setMaximal(){
 this.maximal=true;
};


double getX(){
 return x;
};
double getY(){
 return y;
};
double getZ(){
  return z;
}
void setX(double u){
  x=u;
}
void setY(double v){
  y=v;
}
void setZ(double b){
  z=b;
}
@Override
public int compareTo(Point obj){  

	if(this.getZ()<obj.getZ())
	{
		return -1;
	}
	else if(this.getZ()>obj.getZ())
	{
		return 1;
	}
	else{
		if(this.getY()<obj.getY()) {
			return -1;
		}
		else if(this.getY()>obj.getY()) {
			return 1;
		}
		else {
			if(this.getX()<obj.getX()) {
				return -1;
			}
			else if(this.getX()>obj.getX()){
				return 1;
			}
			else {
				return 0;
			}
		}
	}

		
}


boolean getMaximal(){
return this.maximal;
};
};