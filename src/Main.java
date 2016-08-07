import java.util.Scanner;

public class Main {
	static int count;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int numGraphs = 0;
		int regions = 0;
		int k = 0;
		while(scan.hasNext()){
			numGraphs = scan.nextInt();
			scan.nextLine();
			regions = scan.nextInt();
			scan.nextLine();
			int[] numArmies = new int[regions];
			for(int i=0; i < regions; i++){
				numArmies[i] = scan.nextInt();
				if(numArmies[i] > 0){
					count++;
				}
			}
			scan.nextLine();
			makeAdjacencyMatrix(scan, regions, numArmies);
			k++;
			if(k == numGraphs){
				break;
			}
		}
		scan.close();

	}
	
	
	
	
	
	public static void makeAdjacencyMatrix(Scanner scan, int regions, int[] armies){
		int borderReg = 0;
		int size = (count*2)+2;
		int[][] adjacencyMatrix = new int[size][size];
		int chk = 0;
		for(int n = 0; n < regions; n++){
			if(armies[n] > 0){
				adjacencyMatrix[chk][count+chk] = armies[n];
				adjacencyMatrix[size-2][chk] = armies[n]-1;
				chk++;
			}
		}
		int currEnemies = 0;
		for(int i = 0; i < regions; i++){
			if(armies[i] ==0){
				currEnemies++;
			}
			String temp = scan.nextLine();
			for(int j = 0; j < regions; j++){
				if(temp.charAt(j) == 'Y'){
					if(armies[i]==0){
						if(armies[j] != 0){
							adjacencyMatrix[j][size-1] = 1;
						}
					}else{
						adjacencyMatrix[i+count][j] = armies[i];
					}
					//adjacencyMatrix[i][j] = armies[i];
					if(armies[i]==0){
						borderReg++; // Counts the number of regions bordering enemy territory.
					}
				}
			}
			
		}
	}

}
