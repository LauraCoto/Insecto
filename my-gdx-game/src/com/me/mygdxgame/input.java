package com.me.mygdxgame;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class input extends InputListener {
	Insecto i;
	input(Insecto pa){
		super ();
		i = pa;
	}
public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){     
		i.remove();	
		return  true;	
	}	
}
