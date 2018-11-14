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
	World mapa;
	ImageEntity player, zombie;
	BufferedImage bg;
	Hud hud;
	public Game(GameLoop contexto)
	{
		super(contexto);
		mapa = new World(40,40,32,32);
		player = new Player();
		zombie = new ImageEntity("assets/animations/enemies/zombie/Walk/walk",new Point(0,0));
		hud = new Hud();
		Global.jugador=player;
		Global.hud = hud;
		player.setController(new PlayerController());
		zombie.setController(new ZombieController());
		//bg = Utils.instance.loadImage("assets/bg/test.jpeg");
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
		mapa.update();
		player.update();
		zombie.update();
		if(((Player)player).getVida()<=0)
			contexto.setScreen(new Death(contexto));
	}

	public void render(Graphics g)
	{
		mapa.render(g);
		player.render(g);
		zombie.render(g);
	}

	public World getWorld(){
		return this.mapa;
	}
}
