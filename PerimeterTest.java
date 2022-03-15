import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int numPoints = 0;
        for(Point point : s.getPoints())
        {
            numPoints++;
        }
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        int sides = getNumPoints(s);
        double avgLength = getPerimeter(s) / sides;
        return avgLength;
    }

    public double getLargestSide(Shape s) {
        double maxSide = 0;
        Point prevPoint = s.getLastPoint();
        for(Point currentPoint : s.getPoints())
        {
            double currentDist = prevPoint.distance(currentPoint);
            if(currentDist > maxSide)
            {
                maxSide = currentDist;
            }
        }
        return maxSide;
    }

    public double getLargestX(Shape s) {
        double largestX = 0;
        for(Point point : s.getPoints())
        {
            double currentX = point.getX();
            if(currentX > largestX)
            {
                largestX = currentX;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0.0;
        for(File f : dr.selectedFiles())
        {
            FileResource file = new FileResource(f);
            Shape shape = new Shape(file);
            double perimeter = getPerimeter(shape);
            if(perimeter > largestPerimeter)
            {
                largestPerimeter = perimeter;
            }
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0.0;
        File largestFile = null;
        
        for(File f : dr.selectedFiles())
        {
         FileResource file = new FileResource(f);
         Shape shape = new Shape(file);
         double perimeter = getPerimeter(shape);
         if(perimeter > largestPerimeter)
         {
            largestPerimeter = perimeter;
            largestFile = f;
         }
        }
        return largestFile.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        System.out.println("perimeter = " + getPerimeter(s));
        System.out.println("number of points = " + getNumPoints(s));
        System.out.println("average side length = " + getAverageLength(s));
        System.out.println("Largest side = " + getLargestSide(s));
        System.out.println("Largest X = " + getLargestX(s));
        System.out.println("--------------------");
    }
    
    public void testPerimeterMultipleFiles() {
        double maxPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("Largest Perimeter of all files = " + maxPerimeter);
    }

    public void testFileWithLargestPerimeter() {
        String fileName = getFileWithLargestPerimeter();
        System.out.println("File with largest perimeter = " + fileName);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
