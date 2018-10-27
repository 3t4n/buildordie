package buildordie;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import buildordie.*;
import buildordie.Screens.*;

public class GameLoop extends JComponent implements Runnable, Scrollable{
	private BufferedImage bf;
	private Screen pantalla;
	private int numActs = 0;
	private int lag = 0;
	private int numRenders = 0;
	private int numUpdates = 0;
	private int duracion = 0;
	private boolean pausa = false;
	public  static long FPS = 1000/10;
	public  final int altura = 5400;
	public  final int anchura = 10800;
	

	public GameLoop()
	{
		super();
		setFocusable(true);
		setIgnoreRepaint(true);
		Global.teclado = new KeyHandler();
		Global.raton = new MouseHandler();
		Global.pantalla = new Game(this);
		Global.panel = this;
		addKeyListener(Global.teclado);
		addMouseListener(Global.raton);
		addMouseMotionListener(Global.raton);
	}
	@Override
	public void run()
	{
		long previo = System.currentTimeMillis();
		Image buffer = createImage(anchura,altura);

		while(true){
			long actual = System.currentTimeMillis();
			long pasado = actual - previo;
			previo = actual;
			lag += pasado;
			duracion += pasado;
			
			if(duracion>30000)
			{
				duracion=0;
				numRenders = 0;
				numActs = 0;
			}
			while(lag>=FPS)
			{
				handleInput();
				if(!pausa)
				{
					update();
					numActs++;
				}
				Global.teclado.update();
				lag -= FPS;
			}
			Global.pantalla.render(buffer.getGraphics());		
			getGraphics().drawImage(bf, 0,0, this);
		}
	}
	@Override
	public Dimension getPreferredScrollableViewportSize()
		{
			return new Dimension(640, 480);
		}
	@Override
	public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction)
	{
		return 0;
	}
	@Override
	public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction)
	{
		return 0;
	}
	@Override
	public boolean getScrollableTracksViewportWidth()
	{
		return false;
	}
	@Override 
	public boolean getScrollableTracksViewportHeight()
	{
		return false;
	}
	public void setPaused(boolean b)
	{
		this.pausa = b;
	}
	public boolean getPaused()
	{
		return this.pausa;
	}

	public void update()
	{
		Global.teclado.update();
		Global.raton.update();
		Global.pantalla.update();
	}

	public Image getBuffer()
	{
		return this.bf;
	}

	public void setBuffer(Image b)
	{
		this.bf = b;
	}
	public void handleInput()
	{
		Global.pantalla.handleInput();
	}
	    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(anchura,altura);
    }


}

