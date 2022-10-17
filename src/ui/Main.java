package ui;
import java.util.Scanner;
import model.*;
import static java.lang.Math. *;


public class Main {

	private Scanner scan;
	private int resolution;
	private Game gameController;



	public Main(){
		scan = new Scanner(System.in);
		gameController = new Game();
	}
	
	public static void main(String[] args){

		
		Main main = new Main();
		int option = -1;

		do{
			option = main.showMenu();
			main.executeOption(option);

		}while(option != 0);
	}

	public Game getGameController(){
		return gameController;
	}

	public int showMenu() {
		int option = 0;

		System.out.println();
		System.out.println("WELCOME WARRIOR");
		System.out.println("Are u ready for the battle?");
		System.out.println("loading...");
		System.out.println();
		System.out.println("Please select an option: \n" + 
		"1. Add a Player. \n" +
		"2. Add a Level. \n" +
		"3. Add a new Treasure to a Level. \n" + 
		"4. Add a new Enemy to a Level. \n" +
		"5. Change a Player's score. \n" +
		"6. Increase a Player's level. \n" +
		"7. list treasures and Enemys of a level.\n" +
		"8. Count all the treasures of a type. \n" +
		"9. Count all the enemies of a type. \n" +
		"10. Show most repeated Treasure in all levels.\n" +
		"11. Show the Enemy that gives the Highest Score.\n" +
		"12. Count amount of Consonants in all Enemies names. \n" +
		"13. Show top five players. \n");

		option = validateInt();

		return option;
	}

	public int validateInt(){
		int option = 0;
		
		if(scan.hasNextInt()){
			option = scan.nextInt();
		}
		else{
			scan.next();
			option = -1;
		}

		return option;
	}


	public void executeOption(int option){

		switch(option){

			case 0:
			System.out.println("Fare thee well warrior.");
				break;

			case 1:
				System.out.println();
				String message = "";
				System.out.println("Please type a nickname: ");
				String nickName = scan.next();
				System.out.println("Please type the name: ");
				String name = scan.next();

				message = gameController.createNewPlayer(nickName, name);	

				System.out.println(message);
				System.out.println();
				break;

			case 2:
				System.out.println();
				System.out.println("Please type the number of the level:");
				int number = validateInt();
				System.out.println("Please type the name of the level: ");
				String nameLevel = scan.next();
				System.out.println("Please type the score of the level: ");
				int totalScore = validateInt();

				System.out.println("Please type the name of the first treasure: ");
				String nameTreasureLevel = scan.next();
				System.out.println("Please type the url of the image to the treasure: ");
				String imageTreasureLevel = scan.next();
				System.out.println("Please type the score that the treasure weight: ");
				int scoreTreasureLevel = validateInt();

				String messageTwo = gameController.createNewLevel(number, nameLevel, totalScore, nameTreasureLevel, imageTreasureLevel, scoreTreasureLevel);
				System.out.println(messageTwo);

				break;

			case 3:
				System.out.println();
				System.out.println("Please type the level which contains the new treasure: ");
				int levelContaning = validateInt();
				System.out.println("Please type the name of the treasure: ");
				String nameTreasure = scan.next();
				System.out.println("Please type the url of the image to the treasure: ");
				String imageTreasure = scan.next();
				System.out.println("Please type the score that the treasure weight: ");
				int scoreTreasure = validateInt();

				String messageThree = gameController.createNewTreasure(levelContaning, nameTreasure, imageTreasure, scoreTreasure);

				System.out.println(messageThree);
				System.out.println();

				break;
			
			case 4:
				System.out.println();
				System.out.println("Please type the level which contains the new enemy: ");
				int levelContaningEnemy = validateInt();
				System.out.println("Please type the name of the enemy: ");
				String nameEnemy = scan.next();
				System.out.println("Please select the type of the enemy: \n" +
				"1. OGRE. \n" +
				"2. ABSTRACT. \n" +
				"3. MAGIC. \n" +
				"4. BOSS. \n");
				int typeEnemy = validateInt();
				System.out.println("Please type damage the enemy can cause: ");
				int damageEnemy = validateInt();
				System.out.println("Please type the score of the enemy: ");
				int scoreEnemy = validateInt();


				String messageFour = gameController.createNewEnemy(levelContaningEnemy, nameEnemy, typeEnemy, damageEnemy, scoreEnemy);

				System.out.println(messageFour);
				System.out.println();

				break;

			case 5:
				System.out.println();
				System.out.println("Please type the nickName of the player to change his score: ");
				String nickNameSearched = scan.next();

				String messageFiveOne = gameController.showPlayerScore(nickNameSearched);

				System.out.println(messageFiveOne);
				System.out.println();

				System.out.println("Type the new score for this player: ");
				int newScore = validateInt();

				String messageFiveTwo = gameController.changePlayerScore(nickNameSearched, newScore);

				System.out.println(messageFiveTwo);
				System.out.println();

				break;

			case 6:
				System.out.println();
				System.out.println("Please type the nickname of the player: ");
				String searchedToChangeLevel = scan.next();

				System.out.println("Please type the level you want the player got: ");
				int newLevel = validateInt();

				String messageSix = gameController.changePlayerLevel(searchedToChangeLevel, newLevel);

				System.out.println(messageSix);
				System.out.println();

				break;

			case 7:
				System.out.println();
				System.out.println("Please type the number of the level to show treasures and enemies:");
				int levelToShowAll = validateInt();

				String messageSeven = gameController.showTreasuresAndEnemies(levelToShowAll);

				System.out.println(messageSeven);
				System.out.println();

				break;

			case 8:
				System.out.println();
				System.out.println("Please type the name of the treasure: ");
				String treasureNameToShow = scan.next();

				String messageEight = gameController.showSameTreasureInAllLevels(treasureNameToShow);

				System.out.println(messageEight);
				System.out.println();

				break;

			case 9:
				System.out.println();
				System.out.println("Please select the type of the enemy: \n" +
				"1. OGRE. \n" +
				"2. ABSTRACT. \n" +
				"3. MAGIC. \n" +
				"4. BOSS. \n");

				int enemyTypeToCount = validateInt();

				String messageNine = gameController.countSameTypeEnemy(enemyTypeToCount);

				System.out.println(messageNine);
				System.out.println();

				break;

			case 10:
				
				System.out.println();
				String messageTen = gameController.showMostRepeatedTreasure();

				System.out.println(messageTen);
				System.out.println();

				break;

			case 11:

				System.out.println();
				String messageEleven = gameController.showHighestScoreEnemy();

				System.out.println(messageEleven);
				System.out.println();
				break;

			case 12:
				System.out.println();
				String messageTwelve = gameController.topFivePlayers();

				System.out.println(messageTwelve);
				System.out.println();
				break;

			default:

				System.out.println();
				System.out.println("Please type a valid option. ");
				break;

		}
	}
}