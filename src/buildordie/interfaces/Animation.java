package buildordie.interfaces;
import java.awt.image.*;
import java.awt.*;
public interface Animation
{
	public BufferedImage getFrame();
	public void update();
	public void setRotation(int r);
}
