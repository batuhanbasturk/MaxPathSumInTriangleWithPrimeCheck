import java.io.File;
import java.io.FileNotFoundException;  
import java.util.ArrayList;  
import java.util.Scanner;  
class Question {
	
	private static Scanner file;
	
	public static boolean isPrime(int number) {
		if(number == 1 || number == 0) {
			return false;
		}
		
		for(int i = 2; i * i <= number; i++) {
			if(number % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String args[] )throws FileNotFoundException{
		
		file = new Scanner(new File("input.txt"));
		//creating 2d arraylist
		ArrayList<ArrayList<Integer>> tri_input = new ArrayList<ArrayList<Integer>>();
		
		
		while (file.hasNextInt()) {
			// create arraylist to store numbers in lines
			ArrayList<Integer> line = new ArrayList<Integer>();
			String nextLine = file.nextLine();
			//create String array to store numbers
			String[] datas = nextLine.split(" ");
			for(int i = 0; i < datas.length; i++) {
				//convert string values to int and add numbers one by one to 1d arraylist.
				line.add(Integer.parseInt(datas[i]));
			}
			tri_input.add(line);
	    }
	    
		ArrayList<ArrayList<Integer>> nonPrimeinput = removePrimesFromArray(tri_input);
		int maxSum = calculation(nonPrimeinput);
		System.out.println(maxSum);
	}
	
	private static int calculation(ArrayList<ArrayList<Integer>> input) {
		int m = input.size();
		//first of all i used bottom up algorithm to find maxsum.
		// I used layer to reach at the end of pyramid as much as possible purpose.
		// layer keeps the ancestor of which layer the total value comes from.
		int[][] layer = new int[input.size()][input.size()];
		/* As i said i used bottom up algorithm so i started calculating from 1 top of the 
		pyramid floor*/
		for (int i = m - 2; i >= 0; i--){
            for (int j = 0; j <= i; j++){
                int c = input.get(i).get(j);// Since i'm using bottom up center value is at [i,j]
                int down = input.get(i + 1).get(j);// down center is at [i + 1,j]
                int rdiagonal = input.get(i + 1).get(j + 1);// right diagonal of center is at [i + 1, j + 1]
                
                  if((c!=-1 && down!=-1) && (c!=-1 && rdiagonal!=-1)) {
                /* If center and both sides are not prime i check for which ones layer is
                more at the bottom of the pyramid. I sum the center data with whichever's layer is greater
                down or right diagonal and also storing layer's data of that side in layer[i,j].
                If both sides layer is same than i add center with whichever side is more(down or right diagonal)*/
                	if(layer[i + 1][j] > layer[i + 1][j + 1]) {
                		layer[i][j] = layer[i + 1][j];
                		input.get(i).set(j, c + down);
                	}
                	else if(layer[i + 1][j + 1] > layer[i + 1][j]) {
                		layer[i][j] = layer[i + 1][j + 1];
                		input.get(i).set(j, c + rdiagonal);
                	}
                	else {
                		if(layer[i + 1][j + 1] == 0 && layer[i + 1][j] == 0) {
                			layer[i][j] = i + 1;
                    		input.get(i).set(j, c + Math.max(down, rdiagonal));
                		}
                		else {
                			layer[i][j] = layer[i + 1][j + 1];
                    		input.get(i).set(j, c + Math.max(down, rdiagonal));
                		}
                		
                	}
                	
                }

                else if((c!=-1 && down!=-1)) {
                	if(layer[i + 1][j] == 0) {
                		layer[i][j] = i + 1;
                    	input.get(i).set(j, c + down);
                	}
                	else {
                		layer[i][j] = layer[i + 1][j];
                    	input.get(i).set(j, c + down);
                	}
                }

                else if((c != -1 && rdiagonal != -1)) {
                	if(layer[i + 1][j + 1] == 0) {
                		layer[i][j] = i + 1;
                    	input.get(i).set(j, c + rdiagonal);
                	}
                	else {
                		layer[i][j] = layer[i + 1][j + 1];
                    	input.get(i).set(j, c + rdiagonal);
                	}
                	
                }
            }
        }
        return input.get(0).get(0);
		
	}
	// convert prime numbers to -1
	private static ArrayList<ArrayList<Integer>> removePrimesFromArray(ArrayList<ArrayList<Integer>> input){
		int n = input.size();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < input.get(i).size(); j++) {
				if(isPrime(input.get(i).get(j))) {
					input.get(i).set(j, - 1);
				}
			}
		}
		return input;
		
	}
	

}
