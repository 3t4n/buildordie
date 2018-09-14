package buildordie;
import java.awt.*;
import java.awt.image.*;
import buildordie.GameLoop;

public abstract class Screen
{
	private GameLoop contexto;
	private Image bf;

	public Screen(GameLoop contexto)
	{
		this.contexto = contexto;		
	}
	public abstract void handleInput();
	public abstract void update();
	public abstract void render(Graphics g);

	public void changeScreen(Screen s)
	{
		contexto.changeScreen(s);
	}

}
