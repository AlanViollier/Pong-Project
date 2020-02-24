import javax.swing.JPanel;
import java.awt.GridLayout;
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
import javax.swing.Timer;
import java.awt.geom.Line2D;
public class Starter
{
    public static void main(String[] args)
    {
        int vari = 800;// main value that most sizes are bases off of
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();// Gets the computer's setting
        JFrame frame = new JFrame();//creates a frame
        frame.setSize(vari*3/4+20,vari+70);//sets the size of that frame
        final JPanelOne Master = new JPanelOne();//creates the main panel
        Master.reset();//

        JMenuBar mainMenuBar;
        mainMenuBar = new JMenuBar();

        final JMenu New, Score, BotLevel, DownSpeed, UpSpeed, Quit;
        New = new JMenu("New");
        Score = new JMenu("Score Cap");
        BotLevel = new JMenu("Bot Level");
        DownSpeed = new JMenu("Bottom Player Speed");
        UpSpeed = new JMenu("Top Player Speed");
        Quit = new JMenu("Quit");
        mainMenuBar.add(New);
        mainMenuBar.add(Score);
        mainMenuBar.add(BotLevel);
        mainMenuBar.add(DownSpeed);
        mainMenuBar.add(UpSpeed);
        mainMenuBar.add(Quit);

        final JMenuItem OnePlayer, TwoPlayers, Five, Ten, Fifteen, Twenty, Easy, Medium, Hard, Impossible, UpSlow, UpMedium, UpFast, DownSlow, DownMedium, DownFast, ExitGame;
        OnePlayer = new JMenuItem("1 Player");
        TwoPlayers = new JMenuItem("2 Players");
        Five = new JMenuItem("5");
        Ten = new JMenuItem("10");
        Fifteen = new JMenuItem("15");
        Twenty = new JMenuItem("20");
        Easy = new JMenuItem("Easy");
        Medium = new JMenuItem("Medium");
        Hard = new JMenuItem("Hard");
        Impossible = new JMenuItem("Impossible");
        UpSlow = new JMenuItem("Slow");
        UpMedium = new JMenuItem("Medium");
        UpFast = new JMenuItem("Fast");
        DownSlow = new JMenuItem("Slow");
        DownMedium = new JMenuItem("Medium");
        DownFast = new JMenuItem("Fast");
        ExitGame = new JMenuItem("Exit Game");
        New.add(OnePlayer);
        New.add(TwoPlayers);
        Score.add(Five);
        Score.add(Ten);
        Score.add(Fifteen);
        Score.add(Twenty);
        BotLevel.add(Easy);
        BotLevel.add(Medium);
        BotLevel.add(Hard);
        BotLevel.add(Impossible);
        DownSpeed.add(DownSlow);
        DownSpeed.add(DownMedium);
        DownSpeed.add(DownFast);
        UpSpeed.add(UpSlow);
        UpSpeed.add(UpMedium);
        UpSpeed.add(UpFast);
        Quit.add(ExitGame);

        class AllListener implements ActionListener 
        {
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==OnePlayer)
                {
                    Master.onePlayer(true);
                }
                else if(e.getSource()==TwoPlayers)
                {
                    Master.onePlayer(false);
                }
                else if(e.getSource()==Five)
                {
                    Master.setCap(5);
                }
                else if(e.getSource()==Ten)
                {
                    Master.setCap(10);
                }
                else if(e.getSource()==Fifteen)
                {
                    Master.setCap(15);
                }
                else if(e.getSource()==Twenty)
                {
                    Master.setCap(20);
                }
                else if(e.getSource()==Easy)
                {
                    Master.setBot(1);
                }
                else if(e.getSource()==Medium)
                {
                    Master.setBot(2);
                }
                else if(e.getSource()==Hard)
                {
                    Master.setBot(3);
                }
                else if(e.getSource()==Impossible)
                {
                    Master.setBot(4);
                }
                else if(e.getSource()==UpSlow)
                {
                    Master.UpSensitivity(1);
                }
                else if(e.getSource()==UpMedium)
                {
                    Master.UpSensitivity(2);
                }
                else if(e.getSource()==UpFast)
                {
                    Master.UpSensitivity(3);
                }
                else if(e.getSource()==DownSlow)
                {
                    Master.DownSensitivity(1);
                }
                else if(e.getSource()==DownMedium)
                {
                    Master.DownSensitivity(2);
                }
                else if(e.getSource()==DownFast)
                {
                    Master.DownSensitivity(3);
                }
                else if(e.getSource()==ExitGame)
                {
                    System.exit(0);
                }
            }
        }

        class UpListener implements KeyListener
        {

            public void keyPressed(KeyEvent e)//if ever a key is help down, e will be equals to that key.
            {
                if(e.getKeyCode()==KeyEvent.VK_SPACE)//if the space key is pressed
                {
                    Master.pause();
                    Master.start();
                    
                }
                
                if(e.getKeyCode()==KeyEvent.VK_LEFT)
                {
                    Master.DownLeft(true); 
                }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT)
                {
                    Master.DownRight(true);
                }
                if(e.getKeyCode()==KeyEvent.VK_A)//if the left arrow is pressed
                {
                    Master.UpLeft(true);
                }
                if(e.getKeyCode()==KeyEvent.VK_D)//if the right arrow is pressed
                {
                    Master.UpRight(true);
                }
            }

            public void keyReleased(KeyEvent e)
            {
                if(e.getKeyCode()==KeyEvent.VK_LEFT)
                {
                    Master.DownLeft(false);
                }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT)
                {
                    Master.DownRight(false);
                }
                if(e.getKeyCode()==KeyEvent.VK_A)//if the left arrow is pressed
                {
                    Master.UpLeft(false);
                }
                if(e.getKeyCode()==KeyEvent.VK_D)//if the right arrow is pressed
                {
                    Master.UpRight(false);
                }
            }

            public void keyTyped(KeyEvent e)// if ever a key to pushed down, e will be equals to that key.
            {

            }
        }
        AllListener All = new AllListener();
        UpListener up = new UpListener();
        OnePlayer.addActionListener(All);
        TwoPlayers.addActionListener(All);
        Five.addActionListener(All);
        Ten.addActionListener(All);
        Fifteen.addActionListener(All);
        Twenty.addActionListener(All);
        Easy.addActionListener(All);
        Medium.addActionListener(All);
        Hard.addActionListener(All);
        Impossible.addActionListener(All);
        UpSlow.addActionListener(All);
        UpMedium.addActionListener(All);
        UpFast.addActionListener(All);
        DownSlow.addActionListener(All);
        DownMedium.addActionListener(All);
        DownFast.addActionListener(All);
        ExitGame.addActionListener(All);
        frame.addKeyListener(up);
        Timer t = new Timer(10,Master);// creates a new timer
        t.start();// starts the timer

        frame.setJMenuBar(mainMenuBar);
        frame.add(Master);
        frame.setVisible(true);
    }
}