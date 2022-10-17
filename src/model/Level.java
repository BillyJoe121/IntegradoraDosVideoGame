package model;

public class Level {
	protected static final int SIZE_TREASURE = 50;
	protected static final int SIZE_ENEMIES = 25;


	private int number;
	private String name;
	private int totalScore;
	private String complexity;
	protected Treasure[] treasures;
	protected Enemy[] enemies;
	private int totalScoreTreasures;
	private int totalScoreEnemies;

	/**
	 * 
	 * @param number
	 * @param name
	 * @param totalScore
	 * @param nameTreasureLevel
	 * @param imageTreasureLevel
	 * @param scoreTreasureLevel
	 */
	public Level(int number, String name, int totalScore, String nameTreasureLevel, String imageTreasureLevel, int scoreTreasureLevel) {
		int tST = 0; 
		int tSE = 0;
		this.number = number;
		this.name = name;
		this.totalScore = totalScore;
		this.treasures = new Treasure[SIZE_TREASURE];
		this.enemies = new Enemy[SIZE_ENEMIES];
		treasures[0] = new Treasure(nameTreasureLevel, imageTreasureLevel, scoreTreasureLevel);
		tST += calculateTotalScoreTreasures();
		tSE += calculateTotalScoreEnemies();
		this.totalScoreTreasures = tST;
		this.totalScoreEnemies = tSE;
		this.complexity = calculateComplexity(tST, tSE);
		
	}


	public int getNumber() {
		return this.number;
	}

	/**
	 * 
	 * @param number
	 */
	public void setNumber(int number) {
		this.number = number;
	}


	public int getTotalScore() {
		return this.totalScore;
	}

	/**
	 * 
	 * @param totalScore
	 */
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}


	public String getComplexity() {
		return this.complexity;
	}

	/**
	 * 
	 * @param complexity
	 */
	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}

	/**
	 * 
	 * @param totalScoreTreasures
	 * @param totalScoreEnemies
	 */
	public String calculateComplexity(int totalScoreTreasures, int totalScoreEnemies){
		String message = "";
		totalScoreTreasures = calculateTotalScoreTreasures();
		 totalScoreEnemies = calculateTotalScoreEnemies();
		if(totalScoreEnemies < totalScoreTreasures){
			message = "easy";
		}
		if(totalScoreEnemies == totalScoreTreasures){
			message = "medium";
		}
		else{
			message = "hard";
		}

		return message;		
	}

	public int calculateTotalScoreTreasures(){
		int result = 0;
		for(int i = 0; i< SIZE_TREASURE; i++){
			if(treasures[i] != null){
				result += treasures[i].getScore();
			}
			else{
				result += 0;
			}
		}
		return result;
	}

	public int calculateTotalScoreEnemies(){
		int result = 0;
		for(int i = 0; i < SIZE_ENEMIES; i++){
			if(enemies[i] != null){
				result += enemies[i].getScore();
			}
			else{
				result += 0;
			}
		}

		return result;
	}

	public String addTreasure(String nameTreasure,String imageTreasure,int scoreTreasure){
		String message = "There is no more space in the level to add a new treasure.";
		boolean isCreatedTreasure = false;
		for(int i = 0; i < SIZE_TREASURE && !isCreatedTreasure; i++){
			if(treasures[i] == null){
				treasures[i] = new Treasure( nameTreasure, imageTreasure, scoreTreasure);
				isCreatedTreasure = true;
				message = "Treasure added to the level successfully.";
			}
		}
		return message;
	}

	public String addEnemy(String name, int type, int damage,int score){
		String message = "There is no more space in the level to add a new enemy.";
		boolean isCreatedEnemy = false;
		if(type < 1 && type > 4){
			message = "Select one of the Types showed.";
		}
		else{
			for(int i = 0; i < SIZE_ENEMIES && !isCreatedEnemy; i++){
				if(enemies[i] == null){
					enemies[i] = new Enemy( name, type, damage, score);
					isCreatedEnemy = true;
					message = "Enemy added to the level successfully.";
				}
			}
		}	
		return message;
	}
}