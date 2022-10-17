package model;

public class Player {

	private String nickName;
	private String name;
	private int score;
	private int lifes;
	private int actualLevel;

	/**
	 * 
	 * @param nickName
	 * @param name

	 */
	public Player(String nickName, String name) {
		this.nickName = nickName;
		this.name = name;
		this.score = 10;
		this.lifes = 5;
		this.actualLevel = 1;
	}

	public String getNickName() {
		return this.nickName;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return this.score;
	}

	/**
	 * 
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	public int getLifes() {
		return this.lifes;
	}

	/**
	 * 
	 * @param lifes
	 */
	public void setLifes(int lifes) {
		this.lifes = lifes;
	}

	public int getActualLevel() {
		return this.actualLevel;
	}

	/**
	 * 
	 * @param actualLevel
	 */
	public void setActualLevel(int actualLevel) {
		this.actualLevel = actualLevel;
	}
}