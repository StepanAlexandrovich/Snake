package snake;

class Snake {
    private int direction = 3;
    private Point point;
    private int length = 7;
    private boolean life = true;
    Snake(Point point){
        this.point = point;
        point.valueSnake = length;
    }
    boolean getLive(){ return life; }
    int getLength(){ return length; }

    void turnRight() { direction = 0; }
    void turnDown()  { direction = 1; }
    void turnLeft()  { direction = 2; }
    void turnUp()    { direction = 3; }

    private void move(){
        point = point.points[direction];
        if(point.valueSnake>0){ 
            life = false; 
            point.valueSnake = 0;
        }else{
            point.valueSnake = length;
        }
    }
    
    private void ingestion(){
        if(point.valueApple>0){
            length++;
            point.valueApple = length - 1;
        }     
    }

    void process() {
        if(life){
            move();
            ingestion();
        }
    }
    
    
}
