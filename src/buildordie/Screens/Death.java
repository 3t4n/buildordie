package buildordie.Screens;
import java.awt.*;
import java.awt.image.*;
import buildordie.*;
import buildordie.interfaces.*;
import buildordie.controllers.*;
import java.awt.event.*;
import java.util.*;

public class Death extends Screen{

  public Death(GameLoop context){
    super(context);
  }

@Override
  public void render(Graphics g){
    g.drawString("Te moriste",0,0);
  }

  public void handleInput(){}

  public void update(){}

}
