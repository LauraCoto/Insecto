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

class Imagen extends Sprite{
	Imagen(Texture texture)
	{
		super(texture);
	}
}

public class MyGdxGame implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	Insecto i,j,k,l,m,n,insecto;
	Stage s;
	ArrayList<Insecto> Insectos = new ArrayList<Insecto>(); 

	@Override
	public void create() {		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);//Apunta hacia arriba
		camera.update();
		batch = new SpriteBatch();//Agrupacion de sprites, los objetos ue van a ser dibujados
		
		i= new Insecto(100,100);j= new Insecto(200,150);k= new Insecto(400,200);
		l= new Insecto(600,120);m= new Insecto(300,110);n= new Insecto(350,105);
		
		texture = new Texture(Gdx.files.internal("data/fondo.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		sprite = new Sprite(region);
		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		sprite.setOrigin(sprite.getWidth(), sprite.getHeight());
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		
		
		s=new Stage();
		
		for (int i=0 ; i<25; i++){
			Insecto p =new Insecto((int)(Math.random()*480),(int)(Math.random()*500),new Texture("data/insecto.png"));
			s.addActor(p);
			Insectos.add(p);		
		}	
		
		
		
		for (int i=0 ; i<8; i++){
			
			Insecto pr =new Princesa ((int)(Math.random()*399),(int)(Math.random()*450));
			s.addActor(pr);
			Insectos.add(pr);
		
			}
		Gdx.input.setInputProcessor(s);	
		
		Loser fi = new Loser ();
		s.addActor(fi);
		
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
		k.render(batch);
		l.render(batch);
		m.render(batch);
		n.render(batch);
		batch.end();

		s.draw();
		s.act(); 
	}

	@Override
	public void resize(int width, int height) {
		s.setViewport(600, 400, true);
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
