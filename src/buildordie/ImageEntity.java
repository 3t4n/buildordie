package buildordie;
import buildordie.interfaces.*;
import java.awt.*;
public class ImageEntity implements Entity
{

	private Point posicion;
	private String nombre;
	private Controller controlador;
	private Animation animacion;
	private boolean existe = true;

	public ImageEntity(String nombre,Point p)
	{
		this.nombre=nombre;
		this.posicion=p;
	}
	@Override
	public void setController(Controller c)
	{
		this.controlador=c;
	}
	
	@Override
	public void setPosition(Point p)
	{
		this.posicion=p;
	}
	@Override
	public Point getPosition()
	{
		return posicion;
	}
	@Override
	public void handleInput()
	{
		this.controlador.handleInput(this);
	}
	@Override
	public void update()
	{
		if(controlador!=null)
			controlador.update(this);
	}
	public void setAnimation(Animation a)
	{	
		this.animacion=a;
	}
	@Override
	public void render(Graphics g)
	{
		////if(this.animacion!=null)
		//	g.drawImage
	}
}
