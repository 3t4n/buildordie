package buildordie.Screens;

import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import buildordie.*;
import buildordie.interfaces.*;
import buildordie.controllers.*;

public class Death extends Screen{

  public Death(GameLoop context){
    super(context);
  }

  public void render(Graphics g){
          g.setColor(Color.white);
	  g.fillRect(0,0,800,600);
          g.setColor(Color.black);
	  g.drawString("Te moriste prro",20,100);
  }

  @Override
  public void handleInput(){}

  public void update(){}

}
