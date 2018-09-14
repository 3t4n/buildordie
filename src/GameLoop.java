package buildordie;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import buildordie.Screen;

public class GameLoop extends JComponent implements Runnable
{
	private Image bf;
	private Screen pantalla;
	public GameLoop()
	{
		super();
		setFocusable(true);
		setIgnoreRepaint(true);
		//Global.keyboard = new keyHandler;
		//this.screen = new Juego(this);
		//Global.screen = this.screen
		//addKeyListener(Global.keyboard);

	}
	@Override
	public void run()
	{

	}
	public void changeScreen(Screen s)
	{
		this.pantalla = s;
	}
}

