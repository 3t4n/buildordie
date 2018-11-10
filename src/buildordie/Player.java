package buildordie;
import java.awt.*;

public class Player extends ImageEntity
{
	private int vida;
	public Player()
	{
		vida = 100;
		super("assets/animations/players/Man/Walk_bat/Walk_bat",new Point(400,300));
	}
	@Override
	public void render(Graphics g)
	{
		System.out.println(posicion.toString());
		if(this.animacion!=null)
			g.drawImage(animacion.getFrame(),400,300,Global.panel);
	}


}
