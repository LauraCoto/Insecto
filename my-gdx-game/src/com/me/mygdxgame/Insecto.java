package com.me.mygdxgame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Insecto extends Image{
	int x,y;
	private Animation animacion; 
	private float tiempo;
	private TextureRegion [] regionsMovimiento;
	private Texture Imagen;
	private TextureRegion FrameActual;
	
	
public Insecto(int x ,int y,Texture a) {
	super(a);
	this.addListener(new Imput(this));   //detecta lo que pasa en la pantalla
	this.setX(x);
	this.setY(y);
}
	
public void  act (float delta){
	setY(getY()+0.9f);
	if (getY()>400)
	{
		setY(0);
	}
}
	 	
	
	
//ANIMACION  DE LA IMAGEN	
	public Insecto (int x, int y){
		this.x = x;
		this.y = y;
	//Cargamos la Imagen
		Imagen = new Texture(Gdx.files.internal("data/chitiniac-move.png"));
		
		TextureRegion [][] temp = TextureRegion.split(Imagen, Imagen.getWidth()/8, Imagen.getHeight());
		
		regionsMovimiento = new TextureRegion[8];
		
		for (int i = 0; i<8; i++) regionsMovimiento[i] = temp[0][i];
		animacion = new Animation(1/10f,regionsMovimiento);
		tiempo = 0f; 
		
		
	}
	
	public  void render(final SpriteBatch batch) {
	
		
			tiempo += Gdx.graphics.getDeltaTime(); //Tiempo k paso desde el ultimo render
		FrameActual = animacion.getKeyFrame(tiempo, true);
		batch.draw (FrameActual,x,y);
	
		y++;
			
		
	
	}



}
