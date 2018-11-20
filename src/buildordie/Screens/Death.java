package buildordie.Screens;
import java.awt.*;
import java.awt.image.*;
import buildordie.*;
import buildordie.interfaces.*;
import buildordie.controllers.*;
import java.awt.event.*;
import java.util.*;

public class Death extends Screen{
  private Image bg, boton1, boton2, muerto;
  private Rectangle reiniciar, salir;

  public Death(GameLoop context){
    super(context);
    bg = Utils.loadImage("assets/ui/elements/background2.png");
    boton1 = Utils.loadImage("assets/ui/elements/boton1.png");
    boton2 = Utils.loadImage("assets/ui/elements/boton2.png");
    muerto = Utils.loadImage("assets/ui/elements/muerto2.png");
  }

  public void render(Graphics g){
    g.drawImage(bg,0,0,Global.panel);
    g.drawImage(muerto,300,200,Global.panel);
    g.drawImage(boton1,200,350,456,76,Global.panel);
    g.drawImage(boton2,200,450,456,76,Global.panel);
    reiniciar = new Rectangle(200,350,456,76);
    salir = new Rectangle(200,450,456,76);

    /*g.setColor(Color.red);
    g.setFont(new Font("Showcard Gothic",Font.BOLD,30));
	  g.drawString("Te moriste prro",300,200);*/
  }

  @Override
  public void handleInput(){
    if(Global.raton.justPressed()){
      if(reiniciar.contains(Global.raton.getX(),Global.raton.getY())){
        Global.pantalla = new Game(contexto);
      }
      if(salir.contains(Global.raton.getX(),Global.raton.getY())){
        //exit panel
      }
    }
  }

  public void update(){}

}
