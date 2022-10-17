package model;
import static java.lang.Math. *;

public class Treasure {

	private String name;
	private String image;
	private int score;
	private int positionX;
	private int positionY;
	private double sizeX;
	private double sizeY;

	/**
	 * 
	 * @param name
	 * @param image
	 * @param score
	 */
	public Treasure(String name, String image, int score){
		double x = random() * 1281;
		double y = random() * 721;

		this.name = name;
		this.image = image;
		this.score = score;
		this.positionX = (int) x;
		this.positionY = (int) y;
		this.sizeX = 1281*0.05;
		this.sizeY = 721*0.05;
	}

	public String toString(){
		String message = "";

		message += (getName() + "\n" +
		getImage() + "\n" +
		getScore() + "\n" +
		getPositionX() + "\n" +
		getPositionY() + "\n" +
		getSize() + "\n");

		return message;	
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

	public String getImage(){
		String message = "";

		return message;
	}

	/**
	 * 
	 * @param image
	 */
	public void setImage(String image){

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
		return positionX;
	}

	/**
	 * 
	 * @param position
	 */
	public void setPositionX(int positionX){
		this.positionX = positionX;
	}

		public int getPositionY(){
		return positionX;
	}

	/**
	 * 
	 * @param positionY
	 */
	public void setPositionY(int positionY){
		this.positionY = positionY;
	}

	public int getSize(){
		int iterabled = 0;

		return iterabled; 
		
	}

	/**
	 * 
	 * @param size
	 */
	public void setSize(int[] size){

	}

}