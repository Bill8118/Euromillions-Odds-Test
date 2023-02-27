package lottoGame;

import java.util.HashSet;

public class UpdatedEuroMillions {

	static HashSet<Integer> winningNumbers = new HashSet<Integer>(5);
	static HashSet<Integer> winningStars = new HashSet<Integer>(2);
	static HashSet<Integer> quickPickNumbers = new HashSet<Integer>(5);
	static HashSet<Integer> quickPickStars = new HashSet<Integer>(2);
	static int numberMatch;
	static int starsMatch;
	static int jackpot;
	
	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		
		int x = 0;
		while(x < 139838160) {
			winningNumbers();
			winningStars();
			quickPickNumbers();
			quickPickStars();
			results();
			x++;
		}
		System.out.println("Jackpot hit " +jackpot+ " times.");
		
		long endTime = System.currentTimeMillis();
		long timeTaken = endTime - startTime;
		System.out.println("program run time : "+timeTaken);
	}

	public static void winningNumbers() {

		for(int x = 0; x < 5; x++){
			winningNumbers.add((int)(Math.random()* 50 + 1));
		}
		if(!(winningNumbers.size() == 5)) {
			winningNumbers.add((int)(Math.random()* 50 + 1));
		}
	}
	
	public static void winningStars() {
		
		for(int x = 0; x < 2; x++) {
			winningStars.add((int)(Math.random()* 12 + 1));
		}
		if(!(winningStars.size() == 2)) {
			winningStars.add((int)(Math.random()* 12 + 1));
		}
	}
	
	public static void quickPickNumbers() {

		for(int x = 0; x < 5; x++){
			quickPickNumbers.add((int)(Math.random()* 50 + 1));
		}
		if(!(quickPickNumbers.size() == 5)) {
			quickPickNumbers.add((int)(Math.random()* 50 + 1));
		}	
	}
	
	public static void quickPickStars() {
		
		for(int x = 0; x < 2; x++) {
			quickPickStars.add((int)(Math.random()* 12 + 1));
		}
		if(!(quickPickStars.size() == 2)) {
			quickPickStars.add((int)(Math.random()* 12 + 1));
		}
	}

	public static void results() {
		
		for(Integer a:winningNumbers) {
			if(quickPickNumbers.contains(a)) {
				numberMatch++;
			}
		}
		for(Integer b:winningStars) {
			if(quickPickStars.contains(b)) {
				starsMatch++;
			}
		}
		if(numberMatch == 5 && starsMatch == 2) {
			jackpot++;
		}
		numberMatch = 0;
		starsMatch = 0;
		
		winningNumbers.clear();
		winningStars.clear();
		quickPickNumbers.clear();
		quickPickStars.clear();
	}
}


