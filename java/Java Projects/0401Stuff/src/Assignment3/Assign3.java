package Assignment3;
/*Sean Myers
 * Assignment 3
 * Lab Day: Thursday 12:15~~
 * Mike Maksymowych
 *11/4/09 11:59
 *roughly 11:00 same day
 *Source code files: Assign3.java, HangPlayer.java, WordDatabase.java
 * Compiled: Assign3.class, HangPlayer.class, WordDatabase.class
 * My program runs without error
 * Additional comments: The code is slightly messy this time but runs perfectly.
 */

import java.io.IOException;
import java.util.*;

public class Assign3 {

	public static void main(String[] args) throws IOException {
		WordDatabase Word = new WordDatabase();
		HangPlayer Person = new HangPlayer();
		Scanner inKey = new Scanner(System.in);
		System.out.println("Welcome to HangMan!");
		System.out.println("What is your name?");
		Person.SetName(inKey.nextLine());
		Word.LoadWords(inKey);
		Boolean repeat = true;
		do
		{
			int wrongTries = 0;
		String WordChoice = Word.GetNextWord();
			if(WordChoice==null)
			{
				System.out.println("You have ran out of words to use!");
				break;
			}
		String HiddenText =LetterHider(WordChoice);
		StringBuffer GuessesTried = new StringBuffer();
		for(Boolean HangGame = true; HangGame==true;)
			{
		Word.HangManPicture(wrongTries);
		System.out.println(" ");
		System.out.println("Your word is: "+HiddenText);
		System.out.println("Your tries so far: "+ GuessesTried);
		System.out.println("If you wish to quit this word press 0, \nIf you want to quit this game press 1");
		System.out.println("Please guess a letter: ");
		char guess;
		Boolean rerun = false;
		do
		{
		rerun = false;
		 String letter = inKey.nextLine();
		 guess= letter.charAt(0);
		if(!Character.isLetter(guess))
		{
			if(0==Integer.parseInt(letter))
			{
			HangGame = false;
			Person.IncrLosses();
			break;	
			}
			else if(1==Integer.parseInt(letter))
			{
			HangGame = false;
			repeat = false;
			break;	
			}
		}
		guess=Character.toLowerCase(guess);
		for(int i = 0; i < GuessesTried.length(); i++ )
			{
		if(GuessesTried.charAt(i)== guess)
				{
			rerun = true;
			System.out.println("You already have guessed that letter, enter another letter");
				}
			}
		}
		while(rerun);
		GuessesTried.append(guess);
		if(WordTrue(WordChoice,guess))
		HiddenText = LetterReveal(HiddenText, WordChoice, guess);
		else
		{
			wrongTries++;
		}
		
		
		if(HiddenText.equals(WordChoice))
				{
			System.out.println("Correct! The word is: "+ WordChoice);
			Person.IncrWins();
			HangGame = false;
				}
		if(wrongTries == 6)
		{
			Word.HangManPicture(wrongTries);
			System.out.println("Oh no, the hang man has been assembled!");
			System.out.println("The correct word was: "+ WordChoice);
			Person.IncrLosses();
			HangGame = false;
		}
			}
		}
		while(repeat);
		Person.Results();
	}
	
	public static String LetterHider(String Word)
	{
		StringBuffer Hide = new StringBuffer();
		for(int i = 0; i < Word.length(); i++)
		Hide.append("_");
		return Hide.toString();
	}
	public static String LetterReveal(String HiddenWord, String ActualWord, char guess)
	{
		char[] HiddenWordArray = new char[HiddenWord.length()];
		HiddenWordArray=HiddenWord.toCharArray();
		StringBuffer AssembleWord = new StringBuffer();
		for(int i = 0; i < ActualWord.length(); i++)
		{
			if (guess== ActualWord.charAt(i))
			{
				HiddenWordArray[i]=guess;
			}
			AssembleWord.append(HiddenWordArray[i]);
		}
		
		return AssembleWord.toString();
	}
	public static Boolean WordTrue(String ActualWord, char guess)
	{
		for(int i = 0; i < ActualWord.length(); i++)
		{
			if(guess==ActualWord.charAt(i))
				return true;
		}
		
		return false;
	}
}
