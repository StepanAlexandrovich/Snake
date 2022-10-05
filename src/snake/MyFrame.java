package snake;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
class MyFrame extends JFrame implements ActionListener{
    private JPanel panel;
    private int width = 20,height = 20;
    private Objects objects = new Objects(width,height);
    MyFrame(){
        super("Snake");

        panel = new Panel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(500,500));

        this.add(panel);
        this.pack();
        this.addKeyListener(new MyKeyAdapter());

        this.setVisible(true);
        this.setSize(510,530);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        new Timer(200,this).start();
    }

    private void window(String text){
        int i = JOptionPane.showConfirmDialog(
                null,text + " Сыграть ещё раз ??? 1) Да 2) Нет","Программа",
                JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);

        switch (i){
            case 1: System.exit(0); break;
            case 0: objects = new Objects(width,height);
        }
    }
    private void notification(){
        if(!objects.snakeLive())        { window("Вы проиграли."); }
        if(objects.snakeLength() == 20) { window("Вы выиграли.");  }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        notification();
        objects.process();
        panel.repaint();
    }
    
    private class Panel extends JPanel{
        
        @Override
        public void paint(Graphics g){
            Point[] points = objects.matrix.points;
                
            BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
            for(Point point:points){
                if(point.valueSnake >0&& point.valueApple==0){
                    image.setRGB(point.x, point.y, new Color(000,255,000).getRGB());
                }else
                if(point.valueSnake==0&& point.valueApple >0){
                    image.setRGB(point.x, point.y, new Color(point.valueApple*14,000,000).getRGB());
                }else
                if(point.valueSnake >0&& point.valueApple >0){
                    image.setRGB(point.x, point.y, new Color(255,255,000).getRGB());
                }else
                if(point.valueSnake==0&& point.valueApple==0){
                    image.setRGB(point.x, point.y, new Color(000,000,255).getRGB());
                }
            }
            
            g.drawImage(image,0,0,width*25,height*25, null);
        }
    }
    
    private class MyKeyAdapter extends KeyAdapter{
        
        @Override
        public void keyPressed(KeyEvent e){
            if(e.getKeyCode() == KeyEvent.VK_RIGHT){ objects.turnSnakeRight(); }
            if(e.getKeyCode() == KeyEvent.VK_DOWN) { objects.turnSnakeDown();  }
            if(e.getKeyCode() == KeyEvent.VK_LEFT) { objects.turnSnakeLeft();  }
            if(e.getKeyCode() == KeyEvent.VK_UP)   { objects.turnSnakeUp();    }
        }
        
    }

    public static void main(String[] args) {
        new MyFrame();
    }
    
}
