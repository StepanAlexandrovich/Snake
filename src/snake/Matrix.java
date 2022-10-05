/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

class Matrix {
    final Point[] points;
    private final int w,h,length;
    Matrix(int width,int height){
        w = width;
        h = height;
        points = new Point[(length = w*h)];
        recursion(0,0);
    }
    Point getPoint(int x,int y){ return points[w*y + x]; }
    private int twoDoneD(int x,int y){ return w*y + x; }
    private Point recursion(int x,int y){
        if(points[twoDoneD(x,y)]==null){
            Point p = new Point(x,y);
            points[twoDoneD(x,y)] = p;
            
            p.points[0] = recursion(border(x + 1, 0, w - 1),border(y, 0, h - 1));
            p.points[1] = recursion(border(x, 0, w - 1),border(y + 1, 0, h - 1));
            p.points[2] = recursion(border(x - 1, 0, w - 1),border(y, 0, h - 1));
            p.points[3] = recursion(border(x, 0, w - 1),border(y - 1, 0, h - 1));
            
            return p;
        }
        else{return points[twoDoneD(x,y)];}
    }
    private int border(int vel,int min, int max){
        if(vel>max){ vel = max; }
        if(vel<min){ vel = min; }
        return vel;
    }
    void process(){
        for(Point point:points){
            if(point.valueSnake>0){ point.valueSnake--; }
            if(point.valueApple>0){ point.valueApple--; }
        }
    }
    
}
