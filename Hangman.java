package hangman;
import java.util.*;

public class Hangman {
	
	static public void guess(String word,int life) {
		
		char[] filler=new char[word.length()];
		int i=0;
		while(i<word.length()) {
			filler[i]='*';
			if(word.charAt(i)==' ') {
				filler[i]=' ';
			}
			i++;
		}
		System.out.print(filler);
		System.out.println(" Life remaining= "+life);
		
		Scanner s = new Scanner(System.in);			//to read characters
		
		ArrayList<Character> l=new ArrayList<Character>();
		
		while(life>0) {
			char x=s.next().charAt(0);				//character input by user
			
			if(l.contains(x)) {
				System.out.println("Already entered");
				continue;
			}
			
			if(word.contains(x+"")) {
				for(int y=0;y<word.length();y++) {
					if(word.charAt(y)==x) {
						filler[y]=x;
					}
				}
			}
			else {
				life-- ;                         //life decreases if character entered is not in word
			}
			
			if(word.equals(String.copyValueOf(filler))) {
				System.out.println(filler);
				System.out.println("You Won!");
				break;
				
			}
			System.out.println(filler);
			System.out.println("Life remaining="+life);
		}
		
		if(life==0) {
			System.out.println("You lost!");
		}
	}
	
	public static void main(String args[]) {
		String word = "welcome to hangman";
		int life=5;
		guess(word,life);
	}
}
