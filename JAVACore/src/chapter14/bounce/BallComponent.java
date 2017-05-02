package chapter14.bounce;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class BallComponent extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int DEAFUTL_WIDTH = 450;
	private static final int DEAFUTL_HEIGHT = 350;
	
	List<Ball> balls = new ArrayList<>();
	
	public void add(Ball b){
		balls.add(b);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D graphics2d = (Graphics2D)g;
		
		for(Ball ball : balls){
			graphics2d.fill(ball.getShape());
		}
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(DEAFUTL_WIDTH, DEAFUTL_HEIGHT);
	}
}
