package buildordie.Screens;

import buildordie.*;


public class Game extends Screen
{
	private int x=0;
	private int y=0;
	public Game(GameLoop contexto)
	{
		super(contexto);
	}
	@Override
	public void handleInput()
	{
		if (Global.key.justPressed(KeyEvent.VK_SPACE)) {
			contexto.setPaused(!contexto.getPaused());
			contexto.setScreen(new Menu(contexto));
		}
		
	}

	public void update()
	{
		x+=1;
		y+=1;
	}
	public void render(Graphics g)
	{
		g.fillOval(x,y,10,10);
	}
}
