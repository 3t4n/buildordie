package buildordie;
import java.awt.*;

public class Player extends ImageEntity
{
	private int vida;
	public Player()
	{
		super("assets/animations/players/Man/Walk_bat/Walk_bat",new Point(400,300));
		this.mask=new Rectangle(this.posicion,this.animacion.getDimension());
		vida = 100;
	}
	@Override
	public void render(Graphics g)
	{
		System.out.println(posicion.toString());
		if(this.animacion!=null)
			g.drawImage(animacion.getFrame(),400,300,Global.panel);
}




	public int getVida(){
		return vida;
	}

	public void setVida(int vida){
		this.vida = vida;
	}


}
