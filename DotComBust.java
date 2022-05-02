package HeadFirst;
import java.util.*;
import HeadFirst.GameHelper;
public class DotComBust {
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	private int numOfGuesses = 0;
 private void setUpGame() {
	 //first make some dotcoms and give them locations
	 DotCom one = new DotCom();
	 one.setName("Pets.com");
	 DotCom two = new DotCom();
	 two.setName("eToys.com");
	 DotCom three = new DotCom();
	 three.setName("Go2.com");
	 dotComsList.add(one);
	 dotComsList.add(two);
	 dotComsList.add(three);
	 
	 System.out.println("Your goal is to sync three dot coms");
	 System.out.println("Pets.com, eToys.com, Go2.com");
	 System.out.println("Try to sink them all in the fewest number of guesses");
	 
	 for(DotCom dotComToSet : dotComsList) { //Repeat with each DotCom in the list
		 ArrayList<String> newLocation = helper.placeDotCom(3); //Ask the helper for a DotCom location (an array list of Strings)
		 dotComToSet.setLocationCells(newLocation); //call the setter method on this DotCom to give it the location you got from the helper
	 }
 }

 private void startPlaying() {
	 while(!dotComsList.isEmpty()) { //As log as the DotCom list is not Empty
		 String userGuess = helper.getUserInput("Enter a guess"); //get user input
		 checkUserGuess(userGuess); 
	 }
	 finishGame();
 }
 
 private void checkUserGuess(String userGuess) {
	 numOfGuesses++;
	 String result = "miss";
	 for (DotCom dotComToTest : dotComsList) { //repeat with all DotComs in the list
		 result = dotComToTest.checkYourself(userGuess); //ask the DotCom to check the user guess, looking for a hit or a kill
	     if (result.equals("hit")) {
	    	 break; //get out of the loop early, no point in testing the others
	     }
	     if(result.equals("kill")) {
	    	 dotComsList.remove(dotComToTest); //this guys is dead, so take him out of the DotComs list and get out of the loop
	    	 break;
	     }
	 }
	 System.out.println(result);
 }
		 
 private void finishGame() {
	 System.out.println("All Dot Coms are dead!! Your stock is not worthless..");
	 if(numOfGuesses <= 18) {
		 System.out.println("It only took you " +numOfGuesses + "guesses..");
		 System.out.println("You got out before your options sank..");
	 } else {
		 System.out.println("Took you long enough.." +numOfGuesses + " guesses...");
		 System.out.println("Fish are dancing with your options..");
	 }
 }
 
	public static void main(String[] args) {
		DotComBust game = new DotComBust(); //create a game object
		game.setUpGame();
		game.startPlaying();
	}
}

class DotCom {//DotCom's instance variables
	private ArrayList<String> locationCells; //An array list of cell locations
	private String name; // the DotCom's name
	
	public void setLocationCells(ArrayList<String> loc) // A setter method that updates DotCom's location
	{
		locationCells = loc;
	}
	public void setName(String n) { //basic setter method
		name = n;
	}
	
	public String checkYourself(String userInput) {
		String result = "miss";
		int index = locationCells.indexOf(userInput);
		if (index >= 0) {
			locationCells.remove(index);
		if(locationCells.isEmpty()) {
			result = "kill";
			System.out.println("Ouch !! you sunk " + name + " :( ");
		} else {
			result = "hit";
		}
	   }
		return result;
	}
}
