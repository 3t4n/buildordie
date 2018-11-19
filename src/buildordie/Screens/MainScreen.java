package buildordie.Screens;

import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import buildordie.*;
import buildordie.interfaces.*;
import buildordie.controllers.*;

public class MainScreen extends Screen{

  private BufferedImage img,bg;

  public MainScreen(GameLoop context){
    super(context);
    bg = Utils.instance.resize(Utils.instance.loadImage("assets/ui/elements/background2.png"),600,800);
    img = Utils.instance.resize(Utils.instance.loadImage("assets/ui/window/MainScreen.png"),600,800);
  }

  public void render(Graphics g){
    g.drawImage(bg,0,0,null);
    g.drawImage(img,0,0,null);
    g.setColor(Color.white);
  }

  @Override
  public void handleInput(){}

  public void update(){}

}
