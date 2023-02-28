package lottoGame;

import java.util.ArrayList;

/*
 *  This is a first attempt at writing a program to test the odds of winning the Euromillions.
 *  It will generate 5 random winning numbers and 2 random lucky stars for both the game and player.
 *  It will do this 139,838,160 times.(Odds of winning jackpot)
 *  It will check each time if all numbers match and print the result at the end.
 *  There is also a timer to see how long the program took to complete.
 */
public class EuroMillions {
	
	static ArrayList <Integer> tempNumbers = new ArrayList<>();
	static ArrayList <Integer> tempStars = new ArrayList<>();
	static ArrayList <Integer> winningNumbers = new ArrayList<>();
	static ArrayList <Integer> winningStars = new ArrayList<>();
	static ArrayList <Integer> quickPickNumbers = new ArrayList<>();
	static ArrayList <Integer> quickPickStars = new ArrayList<>();
	static int randNum;
	static int numbersMatch2;
	static int numbersMatch3;
	static int numbersMatch4;
	static int numbersMatch5;
	static int starsMatch1;
	static int starsMatch2;
	static int jackpotMatch;
	
	public void generateWinningNumbers() {
		int x = 1;
			while(x < 51) {
				tempNumbers.add(x);
				x++;
			}
		for(int i = 0; i < 5; i++) {
			randNum = (int)(Math.random() * 51);
			if(tempNumbers.contains(randNum) && randNum < tempNumbers.size()) {
				winningNumbers.add(randNum);
				tempNumbers.remove(tempNumbers.indexOf(randNum));
			}
			else {
				--i;
			}
		}
		int b = 1;
			while(b < 13) {
				tempStars.add(b);
				b++;
			}
		for(int i = 0; i < 2; i++) {
			randNum = (int)(Math.random() * 13);
			if(tempStars.contains(randNum) && randNum < tempStars.size()) {
				winningStars.add(randNum);
				tempStars.remove(tempStars.indexOf(randNum));
			}
			else {
				--i;
			}
		}
		winningNumbers.sort(null);
		winningStars.sort(null);
//		System.out.println("Winning Numbers : " +winningNumbers+ " Lucky Stars : " +winningStars);
//		System.out.println();
		tempNumbers.clear();
		tempStars.clear();
		return;
	}
	
	public void generateQuickPickNumbers() {
		int a = 1;
		while(a < 51) {
			tempNumbers.add(a);
			a++;
		}
		for(int i = 0; i < 5; i++) {
			randNum = (int)(Math.random() * 51);
			if(tempNumbers.contains(randNum) && randNum < tempNumbers.size()) {
				quickPickNumbers.add(randNum);
				tempNumbers.remove(tempNumbers.indexOf(randNum));
			}
			else {
				--i;
			}
		}
		int j = 1;
			while(j < 13) {
				tempStars.add(j);
				j++;
			}
		for(int i = 0; i < 2; i++) {
			randNum = (int)(Math.random() * 13);
			if(tempStars.contains(randNum) && randNum < tempStars.size()) {
				quickPickStars.add(randNum);
				tempStars.remove(tempStars.indexOf(randNum));
			}
			else {
				--i;
			}
		}
		quickPickNumbers.sort(null);
		quickPickStars.sort(null);
//		System.out.println("Your Numbers :    " +quickPickNumbers+ " Your Stars : " +quickPickStars);
//		System.out.println();
		return;
	}

	public void results() {

		int numberMatch = 0;
		int starsMatch = 0;
		
		for(Integer a : winningNumbers) {
			if(quickPickNumbers.contains(a)) {
				numberMatch++;
			}
		}
		for(Integer b : winningStars) {
			if(quickPickStars.contains(b)) {
				starsMatch++;
			}
		}
		if(numberMatch == 2) {
			numbersMatch2++;
		}
		if(numberMatch == 3) {
			numbersMatch3++;
		}
		if(numberMatch == 4) {
			numbersMatch4++;
		}
		if(numberMatch == 5) {
			numbersMatch5++;
		}
		if(starsMatch == 1) {
			starsMatch1++;
		}
		if(starsMatch == 2) {
			starsMatch2++;
		}
		if(numberMatch == 5 && starsMatch == 2){
			jackpotMatch++;
		}
		numberMatch = 0;
		starsMatch = 0;
		
		
//		System.out.println("You matched " +numberMatch+ " Numbers and " +starsMatch+ " Lucky Stars.");
//		System.out.println();
		tempNumbers.clear();
		tempStars.clear();
		winningNumbers.clear();
		winningStars.clear();
		quickPickNumbers.clear();
		quickPickStars.clear();
		//return;
	}
	
	public void statistics() {
		
		int x = 1;
		while(x <= 139838160) {
			generateWinningNumbers();
			generateQuickPickNumbers();
			results();
			x++;
		}
		System.out.println("Matched 2 numbers : " +numbersMatch2+ " times.");
		System.out.println("Matched 3 numbers : " +numbersMatch3+ " times.");
		System.out.println("Matched 4 numbers : " +numbersMatch4+ " times.");
		System.out.println("Matched 5 numbers : " +numbersMatch5+ " times.");
		System.out.println("Matched 1 star : " +starsMatch1+ " times.");
		System.out.println("Matched 2 stars : " +starsMatch2+ " times.");
		System.out.println();
		System.out.println("You hit the jackpot : " +jackpotMatch+ " times.");
		
	}
	
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		EuroMillions game = new EuroMillions();
		game.statistics();
		
		long endTime = System.currentTimeMillis();
		long timeTaken = endTime - startTime;
		System.out.println(timeTaken);
	}//main

}//class
