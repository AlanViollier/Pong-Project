import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Random;
public class JPanelOne extends JPanel implements ActionListener
{
    Random gen = new Random();//creates the random generator as gen
    int vari = 800;// main variable thaat determines the size of most objects
    int ballx = vari*3/8;//creates the int value for the balls x coordinate
    int bally = (vari+16)/2-16;//creates the int value for the balls y coordinate
    int speedx = 0;//creates the int value for the balls horizontal speed
    int speedy = 0;//creates the int value for the balls vertical speed
    int uprectx = (vari*3/8+16)-48;//creates the int value for the top rectangle's x coordinate
    int uprecty = 34;//creates the int value for the top rectangle's y coordinate
    int downrectx = (vari*3/8+16)-48;//creates the int value for the bottom rectangle's x coordinate
    int downrecty = 750;//creates the int value for the bottom rectangle's y coordinate
    boolean oneplayer = true;//creates a boolean value for if the game is single player or not
    boolean ingame = false;// creates a boolean value for if the game is currently in a game or not
    boolean pause = false;//creates a boolean value for if the game is paused ir not
    boolean downplayerwin=false;//creates a boolean value for if the bottom player won or not
    boolean upplayerwin=false;//creates a boolean value for if the top player won or not
    boolean moveupright=false;//creates a boolean value for if the top rectangle is moving right or not
    boolean moveupleft=false;//creates a boolean value for if the top rectangle is moving left or not
    boolean movedownright=false;//creates a boolean value for if the bottom rectangle is moving right or not
    boolean movedownleft=false;//creates a boolean value for if the bottom rectangle is moving left or not
    int upsensitivity = 6;//creates the int value for the sensitivity of the top player
    int downsensitivity = 6;//creates the int value for the sensitivity of the bottom player
    int botdifficulty = 1;//creates the int value for the bot difficulty
    int scorecap = 5;//creates the int value for the score cap
    int uppoint = 0;//creates the int value for the top player's points
    int downpoint = 0;//creates the int value for the bottom player's points
    int tempx;//creates the int value for the temporary x value
    int tempy;//creates the int value for the temporary y value
    public JPanelOne() //constructor for the jpanelone class
    {
        setSize(500,100);//sets the size of the panel to 500 by 100 pixels
    }

    public void onePlayer(boolean e)
    {
        oneplayer=e;//sets the boolean of one player to e
        pause=false;//resets the pause boolean
        uppoint=0;//resets the points of the top player
        downpoint=0;//resets the points of the bottom player
        reset();//resets the placement of everything
    }

    public void actionPerformed(ActionEvent e)//whenever an action is performed
    {
        move();//move the ball
        if(moveupright)//if moveupright is true
        {
            moveUpRight();// move the top rectangle right
        }
        if(moveupleft)//if moveupleft is true
        {
            moveUpLeft();// move the top rectangle left
        }
        if(movedownright)//if movedownright is true
        {
            moveDownRight();//move the bottom rectangle right
        }
        if(movedownleft)//if movedownleft is true
        {
            moveDownLeft();// move the bottom rectangle left
        }
        if(oneplayer)//if it is a one player game
        {
            moveAI();//move the rectangle automatically
        }
        if(uprectx>vari*3/4-96)//if top rectangle is to far out to the right of the screen
        {
            uprectx=vari*3/4-96;//put it back inside at the edge of the right
        }
        if(uprectx<0)//if top rectangle is to far out to the left of the screen
        {
            uprectx=0;//put it back inside at the edge of the left
        }
        if(downrectx>vari*3/4-96)//if bottom rectangle is to far out to the right of the screen
        {
            downrectx=vari*3/4-96;//put it back inside at the edge of the right
        }
        if(downrectx<0)//if bottom rectangle is to far out to the left of the screen
        {
            downrectx=0;//put it back inside at the edge of the left
        }
    }

    public void moveAI()
    {
        if(ingame)//only moves the AI if the game is currently going on
        {
            if(!pause)// if the game is not paused
            { 
                if(botdifficulty==1)//if the bot difficulty is 1
                {
                    if(uprectx>ballx+8)//if the ball is to the left of the AI's rectangle
                    {
                        uprectx=uprectx-3;// move the rectangle left
                    }
                    else if(uprectx+96<ballx+8)//if the ball is to the right of the AI's rectangle
                    {
                        uprectx=uprectx+3;// move the rectangle right
                    }
                    else //if the ball is not left or right of the rectangle
                    {
                        if(speedx>=3)
                        {
                            uprectx=uprectx+3;
                        }
                        else if(speedx<=-3)
                        {
                            uprectx=uprectx-3;
                        }
                        else if(speedx>=2)
                        {
                            uprectx=uprectx+2;
                        }
                        else if(speedx<=-2)
                        {
                            uprectx=uprectx-2;
                        }
                        else if(speedx>=1)
                        {
                            uprectx=uprectx+1;
                        }
                        else if(speedx<=-1)
                        {
                            uprectx=uprectx-1;
                        }
                    }
                }
                else if(botdifficulty==2)//if the bot difficulty is 2
                {
                    if(uprectx>ballx+8)//if the ball is to the left of the AI's rectangle
                    {
                        uprectx=uprectx-6;// move the rectangle left
                    }
                    else if(uprectx+96<ballx+8)//if the ball is to the right of the AI's rectangle
                    {
                        uprectx=uprectx+6;// move the rectangle right
                    }
                    else //if the ball is not left or right of the rectangle
                    {
                        if(speedx>=6)
                        {
                            uprectx=uprectx+6;
                        }
                        else if(speedx<=-6)
                        {
                            uprectx=uprectx-6;
                        }
                        else if(speedx>=5)
                        {
                            uprectx=uprectx+5;
                        }
                        else if(speedx<=-5)
                        {
                            uprectx=uprectx-5;
                        }
                        else if(speedx>=4)
                        {
                            uprectx=uprectx+4;
                        }
                        else if(speedx<=-4)
                        {
                            uprectx=uprectx-4;
                        }
                        else if(speedx>=3)
                        {
                            uprectx=uprectx+3;
                        }
                        else if(speedx<=-3)
                        {
                            uprectx=uprectx-3;
                        }
                        else if(speedx>=2)
                        {
                            uprectx=uprectx+2;
                        }
                        else if(speedx<=-2)
                        {
                            uprectx=uprectx-2;
                        }
                        else if(speedx>=1)
                        {
                            uprectx=uprectx+1;
                        }
                        else if(speedx<=-1)
                        {
                            uprectx=uprectx-1;
                        }
                    }
                }
                else if(botdifficulty==3)//if the bot difficulty is 3
                {
                    if(uprectx>ballx+8)//if the ball is to the left of the AI's rectangle
                    { 
                        uprectx=uprectx-8;// move the rectangle left
                    }
                    else if(uprectx+96<ballx+8)//if the ball is to the right of the AI's rectangle
                    {
                        uprectx=uprectx+8;// move the rectangle right
                    }
                    else //if the ball is not left or right of the rectangle
                    {
                        if(speedx>=8)
                        {
                            uprectx=uprectx+8;
                        }
                        else if(speedx<=-8)
                        {
                            uprectx=uprectx-8;
                        }
                        else if(speedx>=7)
                        {
                            uprectx=uprectx+7;
                        }
                        else if(speedx<=-7)
                        {
                            uprectx=uprectx-7;
                        }
                        else if(speedx>=6)
                        {
                            uprectx=uprectx+6;
                        }
                        else if(speedx<=-6)
                        {
                            uprectx=uprectx-6;
                        }
                        else if(speedx>=5)
                        {
                            uprectx=uprectx+5;
                        }
                        else if(speedx<=-5)
                        {
                            uprectx=uprectx-5;
                        }
                        else if(speedx>=4)
                        {
                            uprectx=uprectx+4;
                        }
                        else if(speedx<=-4)
                        {
                            uprectx=uprectx-4;
                        }
                        else if(speedx>=3)
                        {
                            uprectx=uprectx+3;
                        }
                        else if(speedx<=-3)
                        {
                            uprectx=uprectx-3;
                        }
                        else if(speedx>=2)
                        {
                            uprectx=uprectx+2;
                        }
                        else if(speedx<=-2)
                        {
                            uprectx=uprectx-2;
                        }
                        else if(speedx>=1)
                        {
                            uprectx=uprectx+1;
                        }
                        else if(speedx<=-1)
                        {
                            uprectx=uprectx-1;
                        }
                    }
                }
                else if(botdifficulty==4)
                {
                    uprectx=uprectx+speedx;
                }
                repaint();
            }
        }
    }
    
    public void UpSensitivity(int e)
    {
        if(e==1)
        {
            upsensitivity=6;
        }
        else if(e==2)
        {
            upsensitivity=12;
        }
        else if(e==3)
        {
            upsensitivity=24;
        }
    }
    
    public void DownSensitivity(int e)
    {
        if(e==1)
        {
            downsensitivity=6;
        }
        else if(e==2)
        {
            downsensitivity=12;
        }
        else if(e==3)
        {
            downsensitivity=24;
        }
    }

    public void UpRight(boolean e)
    {
        moveupright = e;
    }

    public void UpLeft(boolean e)
    {
        moveupleft = e;
    }

    public void DownRight(boolean e)
    {
        movedownright = e;
    }

    public void DownLeft(boolean e)
    {
        movedownleft = e;
    }

    public void moveUpRight()
    {
        if(ingame)
        {
            if(!oneplayer)
            {
                if(!pause)
                {
                    uprectx=uprectx+upsensitivity;
                    repaint();
                }
            }
        }
    }

    public void moveUpLeft()
    {
        if(ingame)
        {
            if(!oneplayer)
            {
                if(!pause)
                {
                    uprectx=uprectx-upsensitivity;
                    repaint();
                }
            }
        }
    }

    public void moveDownRight()
    {
        if(ingame)
        {
            if(!pause)
            {
                downrectx=downrectx+downsensitivity;
                repaint();
            }
        }
    }

    public void moveDownLeft()
    {
        if(ingame)
        {
            if(!pause)
            {
                downrectx=downrectx-downsensitivity;
                repaint();
            }
        }
    }

    public void start()
    {
        if(!ingame)
        {
            speedx=gen.nextInt(6)-4;
            speedy=2;
            downplayerwin=false;
            upplayerwin=false;
            ingame=true;
            repaint();
        }
    }

    public void move()
    {
        if(!pause)
        {
            ballx = ballx+speedx;
            bally = bally+speedy;
            if(ballx<=0)
            {
                speedx=speedx*(0-1);
                ballx = ballx-(ballx*2);
            }
            else if(ballx>=vari*3/4-16)
            {
                speedx=speedx*(0-1);
                ballx = ballx-((ballx-(vari*3/4-16))*2);
            }
            else if(bally<=50)
            {
                if(uprectx-15<=ballx&&ballx<=uprectx+95)
                {
                    speedx=speedx+(((ballx-(uprectx-15))-60)/6);
                    speedy=(speedy*(0-1));
                    speedy=speedy+((1*speedy)/(speedy));
                    bally = bally+((50-bally)*2);
                }
                else
                {
                    downpoint++;
                    if(downpoint==scorecap)
                    {
                        downplayerwin=true;
                        downpoint=0;
                        uppoint=0;
                    }
                    reset();

                }
            }
            else if(bally>=vari-66)
            {
                if(downrectx-15<=ballx&&ballx<=downrectx+95)
                {
                    speedx=speedx+(((ballx-(downrectx-15))-60)/6);
                    speedy=(speedy*(0-1));
                    speedy=speedy+((1*speedy)/(speedy*(0-1)));
                    bally = bally-((bally-(vari-66))*2);
                }
                else
                {
                    uppoint++;
                    if(uppoint==scorecap)
                    {
                        upplayerwin=true;
                        downpoint=0;
                        uppoint=0;
                    }
                    reset();

                }
            }
            repaint();
        }
    }

    public void pause()
    {
        if(ingame)
        {
            if(pause)
            {
                speedx=tempx;
                speedy=tempy;
                pause=false;
                repaint();
            }
            else
            {
                tempx=speedx;
                tempy=speedy;
                speedx=0;
                speedy=0;
                pause=true;
                repaint();
            }
        }
    }

    public void setCap(int e)
    {
        scorecap = e;
        uppoint=0;
        downpoint=0;
        reset();
    }

    public void setBot(int e)
    {
        botdifficulty = e;
        uppoint=0;
        downpoint=0;
        reset();
    }

    public void reset()
    {
        bally = vari/2-16;
        ballx = vari*3/8;
        uprectx = vari*3/8-48;
        downrectx = vari*3/8-48;
        speedx = 0;
        speedy = 0;
        ingame=false;
        pause=false;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,vari*3/4,vari);
        g.setColor(Color.WHITE);
        g.fillOval(ballx,bally,16,16);
        g.fillRect(uprectx,uprecty,96,16);
        g.fillRect(downrectx,downrecty,96,16); 
        if(pause)
        {
            g.setFont(new Font("Aharoni",Font.BOLD,96)); 
            g.drawString("Paused",140,420);
        }

        if(downplayerwin==true)
        {
            g.setFont(new Font("Aharoni",Font.BOLD,50));
            g.drawString("YOU WIN",185,600);
            g.drawString("YOU LOSE",185,200);
        }
        if(upplayerwin==true)
        {
            g.setFont(new Font("Aharoni",Font.BOLD,50));
            g.drawString("YOU WIN",185,200);
            g.drawString("YOU LOSE",185,600);
        }

        if(!ingame)
        {
            g.setFont(new Font("Aharoni",Font.BOLD,48));
            g.drawString("Press SPACE key to start",30,370);
            g.setFont(new Font("Aharoni",Font.BOLD,24));
            g.drawString("Press SPACE key to pause",150,430);
            g.setFont(new Font("Aharoni",Font.BOLD,20));
            g.drawString("Use Left and Right Arrow keys to move",120,715);
            if(!oneplayer)
            {
                g.setFont(new Font("Aharoni",Font.BOLD,20));
                g.drawString("Use A and D Keys to move",170,90);
            }
        }
        g.setFont(new Font("Aharoni",Font.BOLD,100));
        if(uppoint>=10)
        {
            g.drawString(Integer.toString(uppoint),500,60);
        }
        else
        {
            g.drawString(Integer.toString(uppoint),540,60);
        }
        if(downpoint>=10)
        {
            g.drawString(Integer.toString(downpoint),500,785);
        }
        else
        {
            g.drawString(Integer.toString(downpoint),540,785);
        }

    }
}