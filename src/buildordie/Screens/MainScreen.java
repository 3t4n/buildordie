package buildordie.Screens;

import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import buildordie.*;
import buildordie.interfaces.*;
import buildordie.controllers.*;

public class MainScreen extends Screen{

  private boolean ayudaActivo;
  private BufferedImage img, bg, datos;
  private Rectangle jugar, ayuda, salir;

  public MainScreen(GameLoop context){
    super(context);
    bg = Utils.instance.resize(Utils.instance.loadImage("assets/ui/elements/background2.png"),600,800);
    img = Utils.instance.resize(Utils.instance.loadImage("assets/ui/window/MainScreen.png"),600,800);
    datos = Utils.instance.resize(Utils.instance.loadImage("assets/ui/window/ayudaDatos.png"),400,520);//height & width
    jugar = new Rectangle(40,210,170,50);
    ayuda = new Rectangle(40,285,170,50);
    salir = new Rectangle(40,360,170,50);
    ayudaActivo = false;
  }

  @Override
  public void update(){}

  @Override
  public void render(Graphics g){
    g.drawImage(bg,0,0,null);
    g.drawImage(img,0,0,null);
    if(ayudaActivo){
      g.drawImage(datos,250,110,null);
    }
  }

  @Override
  public void handleInput(){
    if(Global.raton.isPressed()){
      if(jugar.contains(Global.raton.getPoint())){
        setScreen(new Game(contexto));
      }else
      if(ayuda.contains(Global.raton.getPoint())){
        ayudaActivo = !ayudaActivo;
      }else
      if(salir.contains(Global.raton.getPoint())){
        System.exit(0);
      }
    }
  }
}
