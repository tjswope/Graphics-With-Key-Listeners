// Graphics Panel
// Written by: Mr. Swope
// Date: February 10th, 2015
// This project extends the Jpanel class. In order to draw items on this panel you need use the Graphics2D's methods.
// Update these comments by writing when, who and how you modified this class.
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GraphicsPanel extends JPanel implements KeyListener{
	
	private Rectangle r;
	private Rectangle s;
	private Timer t;
	
	// method: GraphicsPanel Constructor
	// description: This 'method' runs when a new instance of this class in instantiated.  It sets default values  
	// that are necessary to run this project.  You do not need to edit this method.
	public GraphicsPanel(){
		setPreferredSize(new Dimension(500, 500));
        this.setFocusable(true);			// for keylistener
		this.addKeyListener(this);
		r = new Rectangle(0 , 0, 25, 25);
		s = new Rectangle(100 , 100, 25, 25);
        t = new Timer(25, new ClockListener(this));   
        t.start();

	}
	
	public void clock(){
		s.x++;
		s.y++;
		this.repaint();
	}
	
	// method: paintComponent
	// description: This method is called when the Panel is painted.  It contains code that draws shapes onto the panel.
	// parameters: Graphics g - this object is used to draw shapes onto the JPanel.
	// return: void
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
	
		g2.setColor(Color.GRAY);
		g2.fillRect(0, 0, 500, 500);
		
		g2.setColor(Color.BLUE);
		g2.fillRect(r.x, r.y, r.width, s.width);
		
		g2.setColor(Color.RED);
		g2.fillRect(s.x, s.y, s.width, s.width);
		
		
		if(r.intersects(s)){
			g2.setColor(Color.CYAN);
			g2.setFont(new Font("Comic Sans", 2, 40));
			g2.drawString("fail", 120, 120);
		}
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			// move right
			case KeyEvent.VK_RIGHT:
				r.x+=10;
				break;
			
			// add other keys
		}
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
