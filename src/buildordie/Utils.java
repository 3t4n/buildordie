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

	public BufferedImage loadImage(String filename)
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

	public ArrayList<BufferedImage> loadAnimation(String filename, int frames)
	{
		ArrayList<BufferedImage> animacion = new ArrayList<BufferedImage>();
		for(int i = 0; i<=frames; i++)
			animacion.add(this.loadImage(filename+String.format("_%03d", i)+".png"));
		return animacion;
	}


	public static int msToTicks(int ms)
	{
        	return (int)((long)ms / GameLoop.FPS);
	}

}
