package model;
import static java.lang.Math. *;


public class Enemy{


	private String name;
	private EnemyTypes type;
	private int damage;
	private int score;
	private int positionX;
	private int positionY;
	private int sizeX;
	private int sizeY;

	/**
	 * 
	 * @param name
	 * @param type
	 * @param damage
	 * @param score
	 */
	public Enemy(String name, int type, int damage, int score){
		double x = random() * 1281;
		double y = random() * 721;
		double sX = 1281*0.05;
		double sY = 721*0.05;
		
		this.name = name;
		this.score = score;
		this.damage = damage;
		this.positionX = (int) x;
		this.positionY = (int) y;
		this.sizeX = (int) sX;
		this.sizeY = (int) sY;

		switch(type){
			case 1: 
				this.type = EnemyTypes.OGRE;
				break;

			case 2: 
				this.type = EnemyTypes.ABSTRACT;
				break;

			case 3:
				this.type = EnemyTypes.MAGIC;
				break;
			
			case 4:
				this.type = EnemyTypes.BOSS;
				break;
			 
		}
	}

	public String getName(){
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}

	public EnemyTypes getType(){
		return this.type;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(EnemyTypes type){
		this.type = type;
	}

	public int getScore(){
		return this.score;
	}

	/**
	 * 
	 * @param score
	 */
	public void setScore(int score){
		this.score = score;
	}

	public int getPositionX(){
		return this.positionX;
	}

	/**
	 * 
	 * @param positionX
	 */
	public void setPositionX(int positionX){
		this.positionX = positionX;
	}

	public int getPositionY(){
		return this.positionY;
	}

	/**
	 * 
	 * @param positionY
	 */
	public void setPositionY(int positionY){
		this.positionY = positionY;
	}


	public int getSizeX(){
		return sizeX;
	}

	/**
	 * 
	 * @param sizeX
	 */
	public void setSizeX(int sizeX){
		return this.sizeX;
	}

	public int getSizeY(){
		return sizeY;	
	}

	/**
	 * 
	 * @param sizeY
	 */
	public void setSizeY(int sizeY){
		return this.sizeY;
	}

}