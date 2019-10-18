package classwork.IntroCW;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import classwork.JoeApplet;

import java.math.*;


//Nicole Kilhullen
//Period B
//May 8, 2018
//Descirption: 

public class ColorTap extends JoeApplet implements MouseListener, KeyListener
{
	int score = 0;
	int count;
	
	boolean startScreen = true;
	boolean playGame = true;
	boolean begin = false;
	boolean level1W  = false;
	
	int[] level1 = {1,2,1,2,3};
	int pos = 0;
	int button = level1[pos];
	
	String pattern;
	String userPattern;
	String level1Pattern = "rbrbg";
	Font big = new Font("arial",Font.BOLD,50);
	
	
	//SolidObject square1SO = new SolidObject();
	//SolidObject square2SO = new SolidObject();
	//SolidObject square3SO = new SolidObject();
	//SolidObject square4SO = new SolidObject();
	
	Color darkerRed = new Color(165,1,1);
	Color darkerBlue = new Color(0,58,97);
	Color darkerGreen = new Color(0,137,27);
	Color darkerYellow = new Color(216,223,0);
	

	Scanner scan = new Scanner(System.in);
	//Random gen = new Random();
	
	//this method is only called once automatically at the beginning of the program
		public void init()
		{
			addMouseListener(this);
			addKeyListener(this);
		}
		
	//this will draw the start screen
		public void drawStartScreen(Graphics art)
		{
			setBackground(Color.black);
			art.setColor(Color.white);
			art.setFont(big);
			art.drawString("Welcome to Color Tap!\n Press the X key to begin.", 100, 500);
		}
	
		//this will draw the score out
		public void drawScore(Graphics art)
		{
			art.setColor(Color.white);
			art.drawString("Score ="+score, 10, 10);
		}
		
		//end screen will be drawn out
		public void drawEndScreen(Graphics art)
		{
			art.setColor(Color.black);
			art.drawString("You lose.", 10, 10);
		}
		
	//this will draw the first rectangle
	public void drawRect1(Graphics art)
	{
		art.drawString("Once the pattern is complete press enter when you are ready to repeat the pattern", 700, 1000);
		art.setColor(Color.red);
		art.fillRect(500, 200, 200, 200);
	}
	
	//
	public void drawRect2(Graphics art)
	{
		art.setColor(Color.blue);
		art.fillRect(700, 200, 200, 200);
	}
	
	//
	public void drawRect3(Graphics art)
	{
		art.setColor(Color.green);
		art.fillRect(500, 400, 200, 200);
	}
	
	// the yellow rect will be drawn
	public void drawRect4(Graphics art)
	{
		art.setColor(Color.yellow);
		art.fillRect(700, 400, 200, 200);
	}
	
	//this will be the directions/start screen
	public void directions(Graphics art)
	{
		art.setFont(big);
		art.setColor(Color.white);
		art.drawString("CLICK SPACE BAR TO BEGIN", 400, 650);
		
	}
	
	//level one 
	public void showPattern(Graphics art)
	{		
		count++;
		if (count%50==0&&pos<level1.length-1)
		{
			pos++;
			button = level1[pos];
		}
		if(button==1)
		{
			art.setColor(darkerRed);
			art.fillRect(500, 200, 200, 200);
		}
		if(button==2)
		{
			art.setColor(darkerBlue);
			art.fillRect(700, 200, 200, 200);
		}
		if(button==3)
		{
			art.setColor(darkerGreen);
			art.fillRect(500, 400, 200, 200);
		}
		if(button==4)
		{
			art.setColor(darkerYellow);
			art.fillRect(700, 400, 200, 200);
		}
		
	}
	
	//user will replicate pattern
	public void level1User(Graphics art)
	{
	
		if (userPattern == level1Pattern)
		{
			art.drawString("Congrats you passed level 1", 100,100);
			level1W = true;
			
		}
		
		
	}
	
	
	
	public void paint(Graphics art)
	{
		setSize(1500,800);
		if(startScreen)
		{
			drawStartScreen(art);
			
		}
		else if(playGame)
		{
			drawRect1(art);
			drawRect2(art);
			drawRect3(art);
			drawRect4(art);
			
			if(begin)
			{
				
				showPattern(art);
	
			}
			else
			{
				directions(art);
				
			}
			if(level1W)
			{
				System.out.println("here");
				level1User(art);
			}
			
		}
		
	}
	
	
	
	
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		
		if(key==e.VK_X)
		{
			System.out.println(startScreen);
			startScreen = false;
			playGame = true;

		}
		
		if(key==e.VK_SPACE)
		{
			startScreen=false;
			playGame=true;
			begin=true;
		}
		
		if (key==e.VK_ENTER)
		{
			userPattern = JOptionPane.showInputDialog("Enter the pattern:");
			
		}

	}

	@Override
	public void keyReleased(KeyEvent e)
	{
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

}
