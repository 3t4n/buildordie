package buildordie.Screens;
import java.awt.*;
import buildordie.*;
import buildordie.interfaces.*;
import java.awt.event.*;
import java.util.*;
public class Game extends Screen
{
//	ArraList<Entity> entidades;
	EntityAnimation test;
	public Game(GameLoop contexto)
	{
		super(contexto);
		test = new EntityAnimation("assets/animations/players/Man/Bat/Bat",180,0.2,11,1);

//		entidades.add(new Player());
	}
	@Override
	public void handleInput()
	{
		if (Global.teclado.justPressed(KeyEvent.VK_SPACE)) {
			contexto.setPaused(!contexto.getPaused());
		}
		
	}

	public void update()
	{
		test.update();
	}
	public void render(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0,0,800,600);
		g.drawImage(test.getFrame(), -500,-500,this.contexto);
	}
}
