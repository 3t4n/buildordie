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

		this.animacion=new EntityAnimation(nombre,180,0.2,5,1);
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
	@Override
	public void setAnimation(Animation a)
	{	
		this.animacion=a;
	}
	public Animation getAnimation()
	{
		return this.animacion;
	}
	@Override
	public void render(Graphics g)
	{
		if(this.animacion!=null)
			g.drawImage(animacion.getFrame(),(int)posicion.getX(),(int)posicion.getY(),Global.panel);
	}
}
