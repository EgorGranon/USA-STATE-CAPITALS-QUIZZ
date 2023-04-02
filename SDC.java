package SDC;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SDC {
	
	public static void main(String[] args) {
		//Storing 50 States and respective capitals in a 2-Dimensional array in order by state name.
		String[][] stateCapitals = {
				
				{"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"},
                {"Montgomery", "Juneau", "Phoenix", "Little Rock", "Sacramento", "Denver", "Hartford", "Dover", "Tallahassee", "Atlanta", "Honolulu", "Boise", "Springfield", "Indianapolis", "Des Moines", "Topeka", "Frankfort", "Baton Rouge", "Augusta", "Annapolis", "Boston", "Lansing", "Saint Paul", "Jackson", "Jefferson City", "Helena", "Lincoln", "Carson City", "Concord", "Trenton", "Santa Fe", "Albany", "Raleigh", "Bismarck", "Columbus", "Oklahoma City", "Salem", "Harrisburg", "Providence", "Columbia", "Pierre", "Nashville", "Austin", "Salt Lake City", "Montpelier", "Richmond", "Olympia", "Charleston", "Madison", "Cheyenne"}
				
		};
		// Displaying current contents of the array stateCapitals.
		System.out.println("US STATES AND CAPITALS SORTED BY STATES:");
		System.out.println();
		for (int i = 0; i < stateCapitals.length - 1; i++) {
			for (int j = 0; j < stateCapitals[i].length; j++) {
				System.out.println("State, Capital: " +stateCapitals[i][j] + ", " + stateCapitals[i+1][j]);
			}
		}
		// Using BubbleSort to sort the States by capital;
		sortByCapital(stateCapitals);
		//print space for better readability
		System.out.println();
		
		//Initialise scanner 
		Scanner scan = new Scanner(System.in);
		System.out.println("Press Enter to begin quizz");
	    scan.nextLine();  // waits for the user to press Enter
		//Initialising variable which will track number of correct answers provided
		int correctCount  = 0;
		//Initialising variable to track number of questions attempted
		int stateCount = 0;
		System.out.println("Welcome to \"Guess The Capital\" Enter Q to quit the quizz");
		//Looping through sub array of State names for which user will need to provide capital.
		for (int i = 0; i < stateCapitals[0].length; i++) {
			//print space for better readability
			System.out.println();
			//prompt user to enter answers for all the state capitals.
			System.out.println("What is the capital of " + stateCapitals[0][i] + " ? ");
			String ans = scan.nextLine();
			//Comparing the users input to the sub array of State capitals while ignoring case to determine if answer is correct.
			if (ans.equalsIgnoreCase(stateCapitals[1][i])) {
				System.out.println("Well Done that is the correct answer!!!");
				//Incrementing by 1 each time an answer is correct.
				correctCount++;
				stateCount++;
			}
			else {
				if (ans.equalsIgnoreCase("q")) {
					System.out.println("You have quit the quizz");
					break;
				}
				//inform user his answer was incorrect
				System.out.println("Wrong! The actual capital is " + stateCapitals[1][i] + "... Better luck next time...");
				stateCount++;
			}
		}
		System.out.println();
		//Display number of questions attempted
		System.out.println("That was " + stateCount + " out of the 50 States ");
		//Display amount of correct answers provided.
		System.out.println("Your score is " + correctCount + " out of " + stateCount); 
		
		System.out.println();
		
		System.out.println("Press Enter to print HashMap State --> Capital");
	    scan.nextLine();  // waits for the user to press Enter
		//Store the pairs of each state and its capital in a Map using the HashMap function.
		//Declare Map
		Map<String, String> stateCapitalMap = new HashMap<String, String>(stateCapitals[0].length);
		//Assign values to map iterating through the 2-D array stateCapitals.
		for (int i = 0; i < stateCapitals[0].length; i++) {
            stateCapitalMap.put(stateCapitals[0][i], stateCapitals[1][i]);
        }
		// Display contents of the Map.
		stateCapitalMap.entrySet().stream().forEach(n-> System.out.println(n.getKey()+" --> "+n.getValue()));
		//Using the TreeMap class to sort the map while using a binary search tree for storage.
		Map<String, String> sortedStateCapitalMap = new TreeMap<String, String>(stateCapitalMap);
		
		//printing space for better readability
		System.out.println();
		
		//initialise variable which will cause while loop to exit when not blank.
		String quit = "";
		while (quit.isBlank()) {
			//Prompting user to enter a State
			System.out.println("Enter State name to get the Capital ( Q to quit ): ");
			String State = scan.nextLine();
			//Checking to see if Map contains user input
			if(sortedStateCapitalMap.containsKey(State)) {
				//if key is found print out the value to which the key points to
				System.out.println("The capital of " + State + " is " + sortedStateCapitalMap.get(State));
			}
			else {
				//check to see if user would like to quit the program
				if (State.equalsIgnoreCase("q")) {
					quit = "q";
					System.out.println("Thank you for your time! Have a good day!");
				//indicate that no key matched the user input	
				}else {
					System.out.println("That is not a valid State name, try using capitals for example : New Mexico or enter Q to quit");
				}
			}		
		}
		//closing scanner
		scan.close();
	}

	private static void sortByCapital(String[][] stateCapitals) {
		//Incrementing i by 1 through each loop as last value in array after each iteration will be known largest value so no need to check
		for (int i = 0; i < stateCapitals[1].length - 1; i++) {
			// loop through whole remaining array
			for (int j = 0; j < stateCapitals[1].length - i - 1; j++) {
				//Sort the list in alphabetical order, bigger values will be brought to the back
				if (stateCapitals[1][j].compareTo(stateCapitals[1][j+1]) > 0) {
					// if in wrong order swap both values position by storing one of the values in a temporary variable
					String tempCapital = stateCapitals[1][j];
					stateCapitals[1][j] = stateCapitals[1][j+1];
					stateCapitals[1][j+1] = tempCapital;
					
					//swap the State names in accordance with the Capitals being swapped to keep the pair State/Capital matched.
					String tempState = stateCapitals[0][j];
					stateCapitals[0][j] = stateCapitals[0][j+1];
					stateCapitals[0][j+1] = tempState;
				}
			}
		}	
	}
}
