package com.me.mygdxgame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class Insecto extends Image{
	public Insecto(int x ,int y,Texture a) {
		super(a);
		this.addListener(new input(this));
		this.setX(x);
		this.setY(y);
	}
	
public void  act (float delta) 
{
	setY(getY()+1);
	 if (getY()>400)
	 {
		 setY(0);		 
	 }
}	
	int x,y;
	private Animation animacion; 
	private float tiempo;
	private TextureRegion [] regionsMovimiento;
	private Texture Imagen;
	private TextureRegion FrameActual;

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
	

	/*MoveByAction acc2 = new MoveByAction();
	acc2.setDuration(10f);
	//Cantidad de movimiento, en éste caso se moverá 300 unidades hacia abajo.
	acc2.setAmount(0, -300);
	*/
	
	/*
	
	//Probando otra manera
	
	Vector2 position;
	public static final float SPEED = 100f;
	Animation animation;
	TextureRegion CurrentFrame;
	float statetime;	
	
	public Insecto (float x, float y ){
		position = new Vector2(x,y);
		//Cargamos la animacion
		animation = new Animation(0.25f,new TextureRegion[]{
				new Sprite(new Texture(Gdx.files.internal("data/chitiniac-move.png"))),new Sprite(new Texture(Gdx.files.internal("data/chitiniac-move.png"))),new Sprite(new Texture(Gdx.files.internal("data/chitiniac-move.png"))),new Sprite(new Texture(Gdx.files.internal("data/chitiniac-move.png"))),new Sprite(new Texture(Gdx.files.internal("data/chitiniac-move.png"))),new Sprite(new Texture(Gdx.files.internal("data/chitiniac-move.png"))),new Sprite(new Texture(Gdx.files.internal("data/chitiniac-move.png"))),new Sprite(new Texture(Gdx.files.internal("data/chitiniac-move.png")))
				});
	}
	
	//Dezplazamos
	public void move(Vector2 movement){
		movement.scl(SPEED);
		position.add(movement);
		}
	
	public void render(SpriteBatch batch){
	batch.draw(CurrentFrame,position.x,position.y);
	}
	
	public void update(float dt){
		Calcula el tiempo para cargar el frame  ue procede de la animacion 
	}
	  
	 */
	



}
