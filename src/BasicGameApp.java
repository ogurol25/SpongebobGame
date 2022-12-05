import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BasicGameApp implements Runnable {

    //Variable Definition Section
    //Declare the variables used in the program
    //You can set their initial values too

    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 700;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;

    public BufferStrategy bufferStrategy;
    public Image spongePic;
    public Image patPic;
    public Image backgroundPic;
    public Image ballPic;
    //public Rectangle left;
    //public Rectangle right;


    //Declare the objects used in the program
    //These are things that are made up of more than one variable type
    public Spongebob sponge;
    public Spongebob pat;
    public Spongebob ball;

    public boolean IsTopCrashing = false;
    public boolean IsBottomCrashing = false;
    public boolean IsLeftCrashing = false;
    public boolean IsRightCrashing = false;



    public static void main(String[] args) {
        BasicGameApp ex = new BasicGameApp();   //creates a new instance of the game
        new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method
    }


    // This section is the setup portion of the program
    // Initialize your variables and construct your program objects here.
    public BasicGameApp() { // BasicGameApp constructor

        setUpGraphics();

        spongePic = Toolkit.getDefaultToolkit().getImage("SpongebobPic.png"); //load the picture
        sponge = new Spongebob("spongebob", 0, 350); //construct the astronaut

        patPic = Toolkit.getDefaultToolkit().getImage("Patrick5.png"); //load the picture
        pat = new Spongebob("patrick", 850, 350); //construct the astronaut


        ballPic = Toolkit.getDefaultToolkit().getImage("ball3.png"); //load the picture
        ball = new Spongebob("patrick", 300, 450);

        backgroundPic = Toolkit.getDefaultToolkit().getImage("basketballcourt.jpeg");

    }

    public void run() {

        //for the moment we will loop things forever.
        while (true) {
            moveThings();  //move all the game objects
            crash();
            render();  // paint the graphics
            pause(5); // sleep for 10 ms
        }
    }


    public void moveThings() {
        //calls the move( ) code in the objects
        sponge.bounce1();
        ball.bounce();
        pat.bounce1();


    }

    public void crash() {

        if (sponge.rec.intersects(ball.topHitBox) && IsTopCrashing == false){
            sponge.dy=-sponge.dy;
            ball.dy=-ball.dy;
            IsTopCrashing = true;

        }
        if(!sponge.rec.intersects(ball.topHitBox)){
            IsTopCrashing = false;
        }
        if (sponge.rec.intersects(ball.bottomHitBox) && IsBottomCrashing == false){
            sponge.dy=-sponge.dy;
            ball.dy=-ball.dy;
            IsBottomCrashing = true;

        }
        if(!sponge.rec.intersects(ball.bottomHitBox)){
            IsBottomCrashing = false;
        }
        if (sponge.rec.intersects(ball.rightHitBox) && IsRightCrashing == false){
            sponge.dx=-sponge.dx;
            ball.dx=-ball.dx;
            IsRightCrashing = true;

        }
        if(!sponge.rec.intersects(ball.rightHitBox)){
            IsRightCrashing = false;
        }
        if (sponge.rec.intersects(ball.leftHitBox) && IsLeftCrashing == false){
            sponge.dx=-sponge.dx;
            ball.dx=-ball.dx;
            IsLeftCrashing = true;

        }
        if(!sponge.rec.intersects(ball.leftHitBox)){
            IsLeftCrashing = false;
        }

        //pat
        if (pat.rec.intersects(ball.topHitBox) && IsTopCrashing == false){
            pat.dy=-pat.dy;
            ball.dy=-ball.dy;
            IsTopCrashing = true;

        }
        if(!pat.rec.intersects(ball.topHitBox)){
            IsTopCrashing = false;
        }
        if (pat.rec.intersects(ball.bottomHitBox) && IsBottomCrashing == false){
            pat.dy=-pat.dy;
            ball.dy=-ball.dy;
            IsBottomCrashing = true;
        }
        if(!pat.rec.intersects(ball.bottomHitBox)){
            IsBottomCrashing = false;
        }
        if (pat.rec.intersects(ball.rightHitBox) && IsRightCrashing == false){
            pat.dx=-pat.dx;
            ball.dx=-ball.dx;
            IsRightCrashing = true;
        }
        if(!pat.rec.intersects(ball.rightHitBox)){
            IsRightCrashing = false;
        }
        if (pat.rec.intersects(ball.leftHitBox) && IsLeftCrashing == false){
            pat.dx=-pat.dx;
            ball.dx=-ball.dx;
            IsLeftCrashing = true;
        }
        if(!pat.rec.intersects(ball.leftHitBox)){
            IsLeftCrashing = false;
        }
        if (ball.rec.intersects(50,300,75,100)){
            System.out.println("BASKET");
            sponge.xpos = 100;
            sponge.ypos = 350;
            pat.xpos = 800;
            pat.ypos = 500;
            ball.xpos = 500;
        ball.ypos = 350;

        }

        if (ball.rec.intersects(875,300,75,100)){
          System.out.println("BASKET");
            sponge.xpos = 100;
            sponge.ypos = 350;
            pat.xpos = 800;
            pat.ypos = 500;
          ball.xpos = 500;
            ball.ypos = 350;
        }

    }



    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time ) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

    //Graphics setup method
    private void setUpGraphics() {
        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");
    }

    //Paints things on the screen using bufferStrategy
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        g.drawImage(backgroundPic, 0,0, WIDTH, HEIGHT, null);

        //draw the image of the astronaut
        g.drawImage(spongePic, sponge.xpos, sponge.ypos, sponge.width, sponge.height, null);
        g.drawImage(patPic, pat.xpos, pat.ypos, pat.width, pat.height, null);
        g.drawImage(ballPic, ball.xpos,ball.ypos, ball.width, ball.height, null);

        g.drawRect(sponge.rec.x, sponge.rec.y, sponge.rec.width, sponge.rec.height);
        g.drawRect(pat.rec.x, pat.rec.y, pat.rec.width, pat.rec.height);
        g.drawRect(ball.rec.x, ball.rec.y, ball.rec.width, ball.rec.height);

        //spongebob
        g.setColor(Color.GREEN);
        g.drawRect(sponge.topHitBox.x, sponge.topHitBox.y, sponge.topHitBox.width, sponge.topHitBox.height);
        g.setColor(Color.RED);
        g.drawRect(sponge.bottomHitBox.x, sponge.bottomHitBox.y, sponge.bottomHitBox.width, sponge.bottomHitBox.height);
        g.setColor(Color.BLUE);
        g.drawRect(sponge.rightHitBox.x, sponge.rightHitBox.y, sponge.rightHitBox.width, sponge.rightHitBox.height);
        g.setColor(Color.YELLOW);
        g.drawRect(sponge.leftHitBox.x, sponge.leftHitBox.y, sponge.leftHitBox.width, sponge.leftHitBox.height);

        //patrick
        g.setColor(Color.GREEN);
        g.drawRect(pat.topHitBox.x, pat.topHitBox.y, pat.topHitBox.width, pat.topHitBox.height);
        g.setColor(Color.RED);
        g.drawRect(pat.bottomHitBox.x, pat.bottomHitBox.y, pat.bottomHitBox.width, sponge.bottomHitBox.height);
        g.setColor(Color.BLUE);
        g.drawRect(pat.rightHitBox.x, pat.rightHitBox.y, pat.rightHitBox.width, pat.rightHitBox.height);
        g.setColor(Color.YELLOW);
        g.drawRect(pat.leftHitBox.x, pat.leftHitBox.y, pat.leftHitBox.width, pat.leftHitBox.height);

        //ball
        g.setColor(Color.GREEN);
        g.drawRect(ball.topHitBox.x, ball.topHitBox.y,ball.topHitBox.width, ball.topHitBox.height);
        g.setColor(Color.RED);
        g.drawRect(ball.bottomHitBox.x, ball.bottomHitBox.y, ball.bottomHitBox.width, ball.bottomHitBox.height);
        g.setColor(Color.BLUE);
        g.drawRect(ball.rightHitBox.x, ball.rightHitBox.y, ball.rightHitBox.width, ball.rightHitBox.height);
        g.setColor(Color.YELLOW);
        g.drawRect(ball.leftHitBox.x, ball.leftHitBox.y, ball.leftHitBox.width, ball.leftHitBox.height);

        g.drawRect(50,300,75,100);
        g.drawRect(875,300,75,100);




        g.dispose();
        bufferStrategy.show();
    }

}