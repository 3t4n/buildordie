package buildordie;
import java.awt.*;
import java.awt.image.*;

public class Hud{
  public Rectangle hud;

  public Hud(){

  }

  public static void render(Graphics g){
    g.setColor(Color.green);
    g.fillRect(0,0,((Player)Global.jugador).getVida(),10);
  }

}
