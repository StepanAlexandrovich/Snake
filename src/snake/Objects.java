package snake;

import java.awt.event.KeyEvent;

public class Objects {
    final Matrix matrix;
    private final Snake snake;
    private Apples apples;
    
    Objects(int width,int height){
        matrix = new Matrix(width,height);
        snake = new Snake(matrix.getPoint(10,10));
        apples = new Apples(matrix);
    }

    // snake methods
    boolean snakeLive(){ return snake.getLive(); }
    int snakeLength(){ return snake.getLength(); }

    void turnSnakeRight() { snake.turnRight(); }
    void turnSnakeDown()  { snake.turnDown(); }
    void turnSnakeLeft()  { snake.turnLeft();}
    void turnSnakeUp()    { snake.turnUp(); }

    void process(){
        matrix.process();
        snake.process();
        apples.process();
    }
    
}
