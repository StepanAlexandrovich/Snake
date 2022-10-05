package snake;

class Apples {
    private MyRandom myRandom = new MyRandom();
    private Matrix matrix;
    private int time;
    Apples(Matrix matrix) {
        this.matrix = matrix;
    }

    void process() {
        if(++time>0){
            time = 0;
            Point point = matrix.getPoint(myRandom.nextInt(19), myRandom.nextInt(19));
            if(point.valueSnake == 0){ point.valueApple = 16; }
        }
    }

}
