package buildordie.Screens;
import java.awt.*;
import java.awt.image.*;
import buildordie.*;
import buildordie.interfaces.*;
import buildordie.controllers.*;
import java.awt.event.*;
import java.util.*;
public class Game extends Screen
{
//	ArraList<Entity> entidades;
	ImageEntity player, zombie;
	BufferedImage bg;
	public Game(GameLoop contexto)
	{
		super(contexto);

		player = new ImageEntity("assets/animations/players/Man/Walk_bat/Walk_bat",new Point(0,600));
		zombie = new ImageEntity("assets/animations/enemies/zombie/Walk/walk",new Point(50,50));
		Global.jugador=player;
		player.setController(new PlayerController());
		zombie.setController(new ZombieController());
		bg = Utils.instance.loadImage("assets/bg/test.jpeg");
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
		zombie.update();
	}
	public void render(Graphics g)
	{
		g.drawImage(bg,0,0,Global.panel);
		g.drawImage(bg,0,300,Global.panel);
		player.render(g);
		zombie.render(g);
	}
}
