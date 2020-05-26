package Strings;
/*
 * http://www.geeksforgeeks.org/recursively-print-all-sentences-that-can-be-formed-from-list-of-word-lists/
 */
public class S047_RecursivelyPrintAllSentencesFormedFromListOfWordLists {

	// A recursive function to print all possible sentences that can be formed
	// from a list of word list
	void printSentence(String mainList[][],int index,String out[]){
		
		if(index == mainList.length){
			for(int i=0;i<out.length;i++){
				System.out.print(out[i]+" ");
			}
			System.out.println();
			return;
		}
	 
		String list[]= mainList[index];
	 
		for(int i=0; i < list.length;i++){
			out[index] = list[i];
			printSentence(mainList,index+1,out);
		}
	 
	}
	
	public static void main(String[] args) {
		S047_RecursivelyPrintAllSentencesFormedFromListOfWordLists obj = new S047_RecursivelyPrintAllSentencesFormedFromListOfWordLists();
		
		String mainList[][]={
				{"you", "we"},
    			{"have", "are"},
				{"sleep", "eat", "drink"}
    			};
				
				//System.out.println(mainList.length);
				/*for(int i=0;i<mainList.length;i++){
				for(int j=0;j<mainList[i].length;j++){
					System.out.println(mainList[i][j]);
				}
				}*/
				
				String out[]= new String[mainList.length];
				
				obj.printSentence(mainList,0,out); 
	}
}
