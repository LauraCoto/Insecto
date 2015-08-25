package com.me.mygdxgame;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MyGdxGame implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	//Creamos un nuevo insecto
	Insecto i,j,k;
	Stage s;
	
	ArrayList<Insecto> Insectos = new ArrayList<Insecto>(); 
	
	@Override
	public void create() {		
		//float w = Gdx.graphics.getWidth();
		//float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);//Apunta hacia arriba
		camera.update();
		batch = new SpriteBatch();//Agrupacion de sprites, los objetos ue van a ser dibujados
		
		i= new Insecto(100,100);
		j= new Insecto(200,150);
		k= new Insecto(400,200);
		
		
		
		texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		
		sprite = new Sprite(region);
		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		
		s=new Stage();
		
	
		for (int i=0 ; i<25; i++){
			Insecto p =new Insecto((int)(Math.random()*2000),(int)(Math.random()*2000),new Texture("data/chitiniac-move.png"));
			s.addActor(p);
			Insectos.add(p);
		}
		
		Gdx.input.setInputProcessor(s);
	
	
	
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
		
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		sprite.draw(batch);
		i.render(batch);
		k.render(batch);
		j.render(batch);
		
		batch.end();
	//s.draw();
	//s.act();
	
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
