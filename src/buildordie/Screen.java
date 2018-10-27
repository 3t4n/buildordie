package buildordie;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

import buildordie.*;

public abstract class Screen
{
	protected GameLoop contexto;
	protected Image bf;

	public Screen(GameLoop contexto)
	{
		this.contexto = contexto;		
	}
	public abstract void handleInput();
	public abstract void update();
	public abstract void render(Graphics g);

	public void setScreen(Screen s)
	{
		Global.pantalla=s;
	}

}
