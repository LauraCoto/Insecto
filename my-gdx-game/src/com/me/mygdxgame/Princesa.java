package com.me.mygdxgame;

import com.badlogic.gdx.graphics.Texture;

public class Princesa extends Insecto{
	Loser a;
	
	
	  public Princesa(int x,int y)
		{
			super(x,y, new Texture("data/princesa.png"));
			this.addListener(new Input_Princesa (this));
			this.setX(x);
			this.setY(y);
		}
}
