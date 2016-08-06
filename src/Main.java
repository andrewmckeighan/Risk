import java.util.Scanner;

public class Main {

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
		int[][] adjacencyMatrix = new int[regions][regions];
		for(int i = 0; i < regions; i++){
			String temp = scan.nextLine();
			for(int j = 0; j < regions; j++){
				if(temp.charAt(j) == 'Y'){
					adjacencyMatrix[i][j] = armies[i];
					if(armies[i]==0){
						borderReg++; // Counts the number of regions bordering enemy territory.
					}
				}
			}
			
		}
	}

}
