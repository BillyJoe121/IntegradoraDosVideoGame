package model;


public class Game{

	protected static final int SIZE_LEVEL = 10;
	protected static final int SIZE_PLAYER = 20;
	protected static final int SIZE_TREASURE = 50;
	protected static final int SIZE_ENEMIES = 25;

	private Level[] levels;
	private Player[] players;
	private Treasure[] treasures;
	private Enemy[] enemy;
	private String resolution;
	
	public Game(){
		levels = new Level[SIZE_LEVEL];
		players = new Player[SIZE_PLAYER];
		treasures = new Treasure[SIZE_TREASURE];
		resolution = "HD";
	}

	public String createNewPlayer(String nickName, String name){
		String message = "";
		boolean isCreatedPlayer = false;
		int verifier = 0;
	
		verifier = verifierNickNameRepeated(nickName);
		if(verifier == -1){
			message = "Nickname is already used, try a different one.";
		}
		else{
			for(int i=0; i < SIZE_PLAYER && !isCreatedPlayer;i++){
				if(players[i] == null){

					players[i] = new Player(nickName, name); 
					message = "Player created successful.";
					isCreatedPlayer = true;
				}
				else{
					message = "No space for a new player.";
				}
			}
		}
		return message;		
	}

	public int verifierNickNameRepeated(String nickName){
		int verifier = 0;
		boolean isFoundedNickName = false;
		for(int i = 0; i < SIZE_PLAYER && !isFoundedNickName; i++){
			if(players[i] != null){
				if(players[i].getNickName().equalsIgnoreCase(nickName)){
					verifier = -1;
					isFoundedNickName = true;
				}
			}
		}
		return verifier;
	}


	public String createNewLevel(int number, String nameLevel, int totalScore, String nameTreasureLevel, String imageTreasureLevel, int scoreTreasureLevel){
		String message = "";
		boolean isCreatedLevel = false;
		int verifierScore = 0;

		verifierScore = verifierScore(totalScore, scoreTreasureLevel);

		if(number == -1 || totalScore == -1 || scoreTreasureLevel == -1){
			message = "Please do not type letters or symbols when is needed a number.";
		}
		else if(number > SIZE_LEVEL){
			message = "The maximus level is 10.";
		}
		else{

		int numberValidate = validateLevelNumber(number);

			if(verifierScore == -1){
				message = "The treasure score can not be bigger than the level score.";
			}
			else if(numberValidate == -1){
				message = "Number of level is already created, please try a different one.";
			}
			else{
				for(int i = 0; i < SIZE_LEVEL && !isCreatedLevel; i++){
					if(levels[i] == null){
						levels[i] = new Level(numberValidate, nameLevel, totalScore, nameTreasureLevel, imageTreasureLevel, scoreTreasureLevel);
						isCreatedLevel = true;
						message = "Level created successfully";
					}
					else{
						message = "No space for a new Level.";
					}
				}
			}
		}
		return message;
	}

	public int validateLevelNumber(int number){
		int numberOriginal = number;
		for(int i = 0; i < SIZE_LEVEL; i++){
			if(levels[i] != null){
				if(numberOriginal == levels[i].getNumber()){
					numberOriginal = -1;
				}
			}
			else numberOriginal = numberOriginal;
		}

		return numberOriginal;
	}

	public String createNewTreasure(int levelContaining, String nameTreasure,String imageTreasure,int scoreTreasure){
		String message = "";

		if(levelContaining == -1 || scoreTreasure == -1){
			message = "Please do not type letters or symbols when is needed a number.";
		}
		else{

			int levelPosition = searchLevelByNumber(levelContaining);
			if(levelPosition != -1){
				message = levels[levelPosition].addTreasure(nameTreasure, imageTreasure, scoreTreasure);
			}
			else{
				message = "There is not a level with that number.";
			}
		}
		return message;
	}

	public String createNewEnemy(int levelContaningEnemy, String nameEnemy, int typeEnemy, int damageEnemy, int scoreEnemy){
		String message = "";

		if(levelContaningEnemy == -1 || typeEnemy == -1 || damageEnemy == -1 || scoreEnemy == -1){
			message = "Please do not type letters or symbols when is needed a number.";
		}
		else{
			int levelPosition = searchLevelByNumber(levelContaningEnemy);
			if(levelPosition != -1){
				message = levels[levelPosition].addEnemy(nameEnemy, typeEnemy, damageEnemy, scoreEnemy);
			}
			else{
				message = "There is not a level with that number.";
			}
		}
		return message;
	}

	public int searchLevelByNumber(int searchedInt){
		int position = -1;
		boolean isFounded = false;
		for(int i = 0; i < SIZE_LEVEL && !isFounded; i++){
			if(levels[i] != null){
				if(levels[i].getNumber() == searchedInt){
				position = i;
				isFounded = true;
				}
			}
		}
		return position;

	}

	public int verifierScore(int levelScore, int treasureScore){
		int verifier = 0;
		if(levelScore < treasureScore){
			verifier = -1;
		}

		return verifier;
	}

	public String showPlayerScore(String playerSearched){
		String message = "";
		int position = searchPlayerByNickName(playerSearched);
		if(position != -1){
			message = ("The score of the player " + playerSearched + " is " + players[position].getScore());
		}
		else{
			message = "The player searched does not exist.";
		}

		return message;
	}

	public int searchPlayerByNickName(String playerSearched){

		int position = -1;	
		boolean isFoundedPlayer = false;
			for(int j = 0; j < SIZE_PLAYER && !isFoundedPlayer; j++){
				if(players[j] != null){
					if(players[j].getNickName().equalsIgnoreCase(playerSearched)){
						position = j;
						isFoundedPlayer = true;
					}
				}
			}	
		return position;
	}

	public String changePlayerScore(String playerToChange, int newScore){
		String message = "";
		if(newScore != -1){ 
			message = "Please do not type letters or symbols when is needed a number.";
		}
		else{ 
			int position = searchPlayerByNickName(playerToChange);
			if(position != -1){
				players[position].setScore(newScore);
				message = ("The change was successfully, the new score of the player " + playerToChange + " is " + players[position].getScore());
			}
			else{
				message = "As I already told you, the player does not exist.";
			}
		}
		return message;		
	}

	public String changePlayerLevel(String playerSearched, int newLevel){
		String message = "";
		int position = searchPlayerByNickName(playerSearched);

		if(position != -1){
			players[position].setActualLevel(newLevel);
			message = "Level changed successfully.";

		}
		else{
			message = "Player not founded.";
		}
		return message;
	}

	public String showTreasuresAndEnemies(int levelToShowAll){
		String message = "";

		if(levelToShowAll != -1){
			int position = searchLevelByNumber(levelToShowAll);

			for(int i = 0; i < SIZE_TREASURE; i++){
				if(levels[position].treasures[i] != null){
					message += "Treasure " +  levels[position].treasures[i].getName() + ", ";
				}
			}

			for(int j = 0; j < SIZE_ENEMIES; j++){
				if(levels[position].enemies[j] != null){
				message += "Enemy " + levels[position].enemies[j].getName() + ", ";
				}
			}	

		}
		else{
			message = "The level does not exist.";
		}

		return message;
	}

	public String showSameTreasureInAllLevels(String treasureSearched){
		String message = "";
		int counter = 0;
		for(int i = 0; i < SIZE_LEVEL; i++){
			if(levels[i] != null){
				for(int j = 0; j < SIZE_TREASURE; j++){
					if(levels[i].treasures[j] != null){
						if(treasureSearched.equalsIgnoreCase(levels[i].treasures[j].getName())){
						counter++;
						}
					}
				}
			}
		}
		if(counter == 1){
			message = "The treasure " + treasureSearched + " is " + counter + " time in the game.";
		}
		else{ 
		message = "The treasure " + treasureSearched + " is " + counter + " times in the game.";
		}
		return message;
	}

	public String countSameTypeEnemy(int enemyTypeToCount){
		String message = "";
		int counterTypes = 0;
		EnemyTypes toCompare = null;
		String toWrite = "";

		if(enemyTypeToCount != -1){ 
			if(enemyTypeToCount<1 && enemyTypeToCount > 4){
				message = "Please select a valide enemy type.";
			}
			else{
				switch(enemyTypeToCount){
					case 1: 
						toCompare = EnemyTypes.OGRE;
						toWrite = "Ogre.";
						break;

					case 2: 
						toCompare = EnemyTypes.ABSTRACT;
						toWrite = "Abstract";
						break;

					case 3:
						toCompare = EnemyTypes.MAGIC;
						toWrite = "Magic.";
						break;
					
					case 4:
						toCompare = EnemyTypes.BOSS;
						toWrite = "Boss";
						break;
				}

				for(int i = 0; i < SIZE_LEVEL; i++){
					if(levels[i] != null){
						for(int j = 0; j < SIZE_ENEMIES; j++){
							if(levels[i].enemies[j] != null){
								if(toCompare == levels[i].enemies[j].getType()){
									counterTypes++;
								}

							}
						}
					}
				}

				message = ("There is a total of " + counterTypes + " enemies of the type " + toWrite);
			}
		}
		else{
			message = "Please do not type letters or symbols when is needed a number.";
		}	

		return message;

	}

	public String showMostRepeatedTreasure(){
		String message = "";
		int counterMostRepeated = 0;
		String mostRepeated = "";
		for(int i = 0; i < SIZE_LEVEL; i++){
			if(levels[i] != null){
				for(int k = 0; k < SIZE_TREASURE; k++){
					if(levels[i].treasures[k] != null){
						for(int m = 1; m < SIZE_TREASURE; m++){
							if(levels[i].treasures[m] != null){ 
								if(levels[i].treasures[k].getName().equalsIgnoreCase(levels[i].treasures[m].getName())){ 
									counterMostRepeated++;
								}
							}	
						}
					}
				}
			}
		}
		
		message = "The most repeated treasure in all levels is: " + mostRepeated;

		return message;
	}

	public String showHighestScoreEnemy(){
		String message = "";
		int highest = 0;
		int numberLevel = 0;
		String nameHighest = "";
		for(int i = 0; i < SIZE_LEVEL; i++){
			if(levels[i] != null){
				for(int k = 0; k < SIZE_ENEMIES; k++){
					if(levels[i].enemies[k] != null){
						if(levels[i].enemies[k].getScore() > highest){
							highest = levels[i].enemies[k].getScore();
							nameHighest = levels[i].enemies[k].getName();
							numberLevel = levels[i].getNumber();
						}						
					}
				}
			}
		}

		message = ("The enemy whit the highest score is " + nameHighest + " has " + highest + " of score, and is in the level " + numberLevel);

		return message;
	}

	public String countAmountOfConsonants(){
		String message = "";
		String counter;
		String[] listVocals;
		final int SIZE_VOCALS = 5;
		listVocals = new String[SIZE_VOCALS];
		listVocals[0] = "a";
		listVocals[1] = "e";
		listVocals[2] = "i";
		listVocals[3] = "o";
		listVocals[4] = "u";

		for(int i = 0; i < SIZE_LEVEL; i++){
			if(levels[i] != null){
				for(int k = 0; k < SIZE_ENEMIES; k++){
					if(levels[i].enemies[k] != null){
						counter = levels[i].enemies[k].getName();

					}
				}
			}
		}

		return message;		
	}

	public String topFivePlayers(){
		String message = "";
		

		return message;		
	}

}