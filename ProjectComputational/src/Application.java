import java.util.Random;
import java.util.Scanner;

public class Application {
    public Point[] createPoints(){

        Random random = new Random();
        //here we create the points
        int n = random.nextInt(40,50);
        Point points[] = new Point[n];
        for (int i =0;i<n;i++){
         Point point = new Point(random.nextInt(100,700),random.nextInt(100,700));
         points[i]=point;
        }
        //
        //now we will find which point is the closest for every point.
        for (int i = 0;i< points.length;i++) {
            float min = 800;
            Point aux = null;
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int x = points[j].getX() - points[i].getX();
                    int y = points[j].getY() - points[i].getY();
                    float distance = (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
                    if (distance < min) {
                        min = distance;
                        aux = new Point(points[j].getX(), points[j].getY());

                    }
                }
            }
            points[i].setMinimumDistance(min);
            points[i].setClosestPoint(aux);
        }
        return points;
    }

    public int bigModule(Point point1,Point point2){
        int maxim = 0;
        int x1= (int)Math.sqrt(Math.pow(point1.getX(),2));
        int x2=(int)Math.sqrt(Math.pow(point2.getX(),2));
        int y1 = (int)Math.sqrt(Math.pow(point1.getY(),2));
        int y2= (int)Math.sqrt(Math.pow(point2.getY(),2));

        if(Math.sqrt(Math.pow(x1-x2,2))>=Math.sqrt(Math.pow(y1-y2,2))){
            maxim = (int)Math.sqrt(Math.pow(x1-x2,2));
        }
        else maxim = (int)Math.sqrt(Math.pow(y1-y2,2));
        return maxim-1;
        // this returns the maximum number I need to add or to decrease to find the corners of the largest empty squares.

    }

    public void showPoints(Point[] points){

        for(int i = 0;i< points.length;i++){
            System.out.println(i+": x:"+points[i].getX()+" y: "+points[i].getY());
        }
    }
    public void run(){
        Point [] points  = createPoints();
        showPoints(points);
        System.out.println("Choose the index of the point you want to make the square ");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        System.out.println("The closest point have x: "+points[index].getClosestPoint().getX()+" y: "+ points[index].getClosestPoint().getY());
        Draw draw = new Draw(points,index);

    }

}
