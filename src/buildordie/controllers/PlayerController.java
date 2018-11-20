package buildordie.controllers;
import java.awt.*;
import buildordie.interfaces.*;
import buildordie.*;
import buildordie.Screens.*;
import java.awt.event.*;

public class PlayerController implements Controller
{
	private int move;
	private boolean atacando = false;
	private int dy=0,dx=0;
	@Override
	public void handleInput(Entity e)
	{


		   move = Global.teclado.justPressed(KeyEvent.VK_D) ? 270
                     : Global.teclado.justPressed(KeyEvent.VK_A) ? 90
                     : Global.teclado.justPressed(KeyEvent.VK_S) ? 0
                     : Global.teclado.justPressed(KeyEvent.VK_W) ? 180
: -1;
  		dx = move==270 ? 10
                     : move==90? -10
                     : 0;

		dy = move==180 ? -10
                     : move==0 ? 10
                     : 0;
		atacando=Global.raton.isPressed();
	}

	@Override
	public void update(Entity e)
	{
		if(((Player)e).getVida()>0)
		{
		Point posicion = e.getPosition();
		int x = (int)posicion.getX();
		int y = (int)posicion.getY();
		if(move!=-1)
		{
			e.getAnimation().setRotation(move);
			e.getAnimation().update();
			Point nueva = new Point(x+dx,y+dy);
			e.setPosition(nueva);
		}
		else
		{
				e.getAnimation().setFrame(0);
			e.getAnimation().setRotation((int) Math.toDegrees(Math.atan2(Global.raton.getY()-posicion.getY(), Global.raton.getX()-posicion.getX()))+220);
		}
		if(e.getMask()!=null)
		if(!((Game)Global.pantalla).getWorld().getRectangle().contains(new Rectangle((int)e.getMask().getX()+400,(int)e.getMask().getY()+300,(int)e.getMask().getWidth(),(int)e.getMask().getHeight())))
		{/*bajar vida*/
			((Player)e).setVida(((Player)e).getVida()-1); //CAMBIAR A -1
		}
	}
}
}
