package buildordie.interfaces;

import java.awt.*;
public interface Entity
{
	//https://docs.oracle.com/javase/7/docs/api/java/awt/Point.html
	public void setController(Controller c);
	public void setPosition(Point p);
	public Point getPosition();
	public void handleInput();
	public void update();
	public void render(Graphics g);
	public Animation getAnimation();
	public void setAnimation(Animation a);
	public Rectangle getMask();
}
