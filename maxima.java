//Bhargav Vasudeva Vunnam(J387T358)
import java.util.*;
import java.io.*;

public class maxima {
	 static void inputPoints(Scanner infile, Point[] points)
	   {
		 String s="";
		for(int i=0;i<=points.length-1;i++) {
			s=infile.nextLine();
			if(!s.equals(String.valueOf(points.length))) {
				String[] a=s.split("\\s+");
				points[i].setX(Double.parseDouble(a[0]));
				points[i].setY(Double.parseDouble(a[1]));
				points[i].setZ(Double.parseDouble(a[2]));
			}
		}
	   }
	 private static void printMaximal(PrintWriter outfile, Point[] points,int maxNum)
			{  
		   try { 
		    outfile.println("Input Size = " + points.length);
			outfile.println("MaxNum = " + maxNum);
			outfile.println();
			outfile.println("Maxima(S)");
			int count=0;
			for (int i=points.length-1; i >=0; i--)
			{  if (points[i].getMaximal())
			    outfile.println(count);
			count++;
			}
			outfile.println();
			outfile.println("--------------------------------------------");
			outfile.println();
			}
	 catch(Exception e ) {
		 System.out.println(e);
	 }
}
	 static int findMaximal(Point[] a) {	 
		 TreeMap<Double,Double> bst=new TreeMap<Double,Double>(Collections.reverseOrder()); 
		 NavigableMap<Double, Double> subtree=new TreeMap<Double,Double>(Collections.reverseOrder());
		 int count=1;
		 bst.put(1.000000,0.000000);
		 bst.put(a[0].getY(), a[0].getX());
		 a[0].setMaximal();
		 for(int i = 1; i <a.length; i++)
		 {
			 
		 double relativegreatest=bst.floorKey(a[i].getY());//due to using collections reverse order need to use floor key 
          if(bst.get(relativegreatest) != null&& bst.get(relativegreatest)<a[i].getX()) {
        	 a[i].setMaximal();
        	 count++;
        	 bst.put(a[i].getY(), a[i].getX());
        	 subtree=bst.tailMap(a[i].getY(),false);
        	 List<Double> spare=new ArrayList<Double>();
        	 for(double key: subtree.keySet()) {
        		 if(subtree.get(key)<a[i].getX()) {
        			 spare.add(key);
        		 }
        		 else {
        			 break;
        		 }
        	 }
        	 for (Double num : spare) { 		      
        		 subtree.remove(num);		
            }
        	 
         }
         
	 }
		 
		 return count;
	 }
  public static void main(String[] args){
	  

	  if (args.length != 2)
      {  System.out.println("Error Check");
      }
     Scanner infile = null;
     try
     {  infile = new Scanner(new File(args[0])); }
     catch(FileNotFoundException e)
     {  System.out.println("Error opening the input file " + args[0]);
        System.exit(0);
     }

     PrintWriter outfile = null;
     try
     {  outfile = new PrintWriter(args[1]); }
     catch(FileNotFoundException e)
     {  System.out.println("Error opening the output file " + args[1]); 
        System.exit(0);
     }

	  for (int i=1; i<=10; i++)  
      {  int numpoints=Integer.parseInt(infile.nextLine());
		  Point[] points = new Point[numpoints];
	      for(int j=0;j<=numpoints-1;j++) {
	      	 points[j]=new Point();
	       }
         inputPoints(infile,points);
         Arrays.sort(points,Collections.reverseOrder());  // Sorts points
         int maxNum = findMaximal(points);
         outfile.println("Output for "+ i + "-th Set of Points");
         printMaximal(outfile,points,maxNum);
      }
	  infile.close();
	  outfile.close();
  }

}




