package buildordie;

import buildordie.interfaces.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.util.*;
public class EntityAnimation implements Animation
{
	private int numActs; //Numero de actualizaciones para cambiar el frame
	private int ticks = 0;
	private int imagenAct = 0;
	private double escala;
	private int rotacion,numFrames;
	private String nombre;
	private ArrayList<BufferedImage> cuadros;

	public EntityAnimation(String nombre, int rotacion,double escala,int numFrames,int numActs)
	{
		this.nombre=nombre;
		this.rotacion=rotacion;
		this.escala=escala;
		this.numFrames=numFrames;
		this.numActs=numActs;
		cuadros=Utils.instance.loadAnimation(nombre,numFrames);
	}

	@Override 
	public void setRotation(int r)
	{
		this.rotacion=r;
	}

	@Override
	public void update()
	{
		if(ticks%numActs==0){
			imagenAct++;
			ticks=0;
		}
		if(imagenAct%numFrames==0)
		{
			imagenAct=0;	
		}
		ticks++;

	}
	@Override
	public BufferedImage getFrame()
	{
		BufferedImage imag = this.cuadros.get(imagenAct);
		double rotationRequired = Math.toRadians (this.rotacion);
		double locationX = imag.getWidth() / 2;
		double locationY = imag.getHeight() / 2;
		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		tx.scale(this.escala,this.escala);
		tx.translate(4*imag.getWidth(),4*imag.getHeight());
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
       		return	op.filter(imag, null);
	}

}
