package com.me.mygdxgame;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Imput extends  InputListener{
	
	 Insecto p;
	 Imput (Insecto  para) { 
		 super ();
		p = para;
		}	 
	 
	public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
	{
		p.remove();		
		//System.out.println(Math.random()*10000% x);
		return  true;
	}


}
