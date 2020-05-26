package AdvancedDS;

import java.util.*;

public class TrieNode {

	char value;    
	HashMap<Character,TrieNode> children;
	boolean bIsEnd; 
	 
	public TrieNode(char ch)  {
		value = ch;
		children = new HashMap<>();
		bIsEnd = false;
	}    

	public HashMap<Character,TrieNode> getChildren() {   
		return children;  
	}  
	  
	public char getValue(){
		return value;     
	}  
	  
	public void setIsEnd(boolean val){ 
		bIsEnd = val;     
	} 
	   
	public boolean isEnd(){
		return bIsEnd;    
	}

	public static void main(String[] args) {

	}
}
