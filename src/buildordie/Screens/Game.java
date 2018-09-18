package buildordie.Screens;
import java.awt.*;
import buildordie.*;
import buildordie.interfaces.*;
import buildordie.controllers.*;
import java.awt.event.*;
import java.util.*;
public class Game extends Screen
{
//	ArraList<Entity> entidades;
	ImageEntity player;
	public Game(GameLoop contexto)
	{
		super(contexto);

		player = new ImageEntity("assets/animations/players/Man/Walk_bat/Walk_bat",new Point(0,600));
		player.setController(new PlayerController());
		//test = new EntityAnimation("assets/animations/players/Man/Walk_bat/Walk_bat",0,0.2,5,1);

//		entidades.add(new Player());
	}
	@Override
	public void handleInput()
	{
		if (Global.teclado.justPressed(KeyEvent.VK_SPACE)) {
			contexto.setPaused(!contexto.getPaused());
		}
		player.handleInput();		
	}

	public void update()
	{
		player.update();
	}
	public void render(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0,0,800,600);
		player.render(g);
	}
}
