import javax.swing.*;
import java.awt.*;

public class Draw extends JFrame {

    private Point [] points;
    private int indexOfThePoint;


    public Draw(Point[] points, int indexOfThePoint ) {
        setTitle("Draw Points");
        setSize(800, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.points = points;
        this.indexOfThePoint = indexOfThePoint;
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        Application application = new Application();
        for(int i = 0;i<points.length;i++){
            g.setColor(Color.BLACK);
            g.drawLine(points[i].getX(),points[i].getY(),points[i].getX(),points[i].getY());
            if(i==indexOfThePoint){
                int mod = application.bigModule(points[i],points[i].getClosestPoint());
                //this mod is the maximum number I need to add or decrease to find out the corners
                int x = points[i].getX();
                int y = points[i].getY();
                g.setColor(Color.BLUE);
                g.drawLine(x+mod,y+mod,x+mod,y-mod);
                g.drawLine(x+mod,y-mod,x-mod,y-mod);
                g.drawLine(x-mod,y-mod,x-mod,y+mod);
                g.drawLine(x-mod,y+mod,x+mod,y+mod);
            }
        }
        Graphics2D g2 = (Graphics2D) g;
        int w = 800;// real width of canvas
        int h = 800;// real height of canvas
// Translate used to make sure scale is centered
        g2.translate(w/2, h/2);
        g2.scale(2.0, 2.0);
        g2.translate(-w/2, -h/2);

    }


}
