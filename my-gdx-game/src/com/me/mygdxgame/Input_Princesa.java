package com.me.mygdxgame;

import com.badlogic.gdx.scenes.scene2d.InputEvent;

public class Input_Princesa  extends input{
	Input_Princesa(Insecto p){
		super(p);
	}
	
	public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
	{
		i.remove();	
		return true;
	}

}
