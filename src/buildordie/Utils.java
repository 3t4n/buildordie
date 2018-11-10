package buildordie;

import java.io.*;
import java.awt.*;
import java.awt.image.*;
import java.util.*;
import javax.imageio.*;


public class Utils
{
	public final static Utils instance = new Utils();
	public final static String config = "config.json";

	public static BufferedImage loadImage(String filename)
	{
		BufferedImage frame = null;
		try {
		frame = ImageIO.read(new File(filename));
		return frame;
		}
		catch (IOException e) {
		}
		return frame;
	}

	public  ArrayList<BufferedImage> loadAnimation(String filename, int frames)
	{
		ArrayList<BufferedImage> animacion = new ArrayList<BufferedImage>();
		for(int i = 0; i<=frames; i++)
			animacion.add(this.loadImage(filename+String.format("_%03d", i)+".png"));
		return animacion;
	}

	public static BufferedImage resize(BufferedImage img, int height, int width)
	{
		Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = resized.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		return resized;
    }
public static void toGray(BufferedImage i)
{
	for(int x=0; x<i.getWidth();x++)
	for(int y=0; y<i.getHeight();y++)
	{
		int rgb = i.getRGB(x,y);
		int r = (rgb>>16)& 0xFF;
		int g = (rgb>>8)&0xFF;
		int b = (rgb & 0xFF);
		int grayLevel = (r+g+b)/2;
		int gray = (grayLevel<<16) + (grayLevel<<8) + 255;
		i.setRGB(x,y,gray);
	}
}

	public static int msToTicks(int ms)
	{
        	return (int)((long)ms / GameLoop.FPS);
	}

}
