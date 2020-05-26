package Strings;
/*
 * http://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/
 */

class DLLnode{
	char data;
	DLLnode next;
	DLLnode prev;
	public DLLnode(char a){
		data = a;
		next = null;
		prev = null;
	}
}

public class S028_FindFirstNonRepeatingCharacterFromStreamOfCharacters {

	// A utility function to append a character x at the end of DLL. 
	// Note that the function may change head and tail pointers, that is why pointers to these pointers are passed.
	public DLLnode[] appendNode(DLLnode head, DLLnode tail, char x){
		DLLnode temp = new DLLnode(x);
		DLLnode result[] = new DLLnode[2];
		
		if (head == null){
			head = tail = temp;
			result[0] = head;
			result[1] = tail;
			return result;
		}
		tail.next = temp;
		temp.prev = tail;
		tail = temp;
		result[0] = head;
		result[1] = tail;
		return result;
	}

	// A utility function to remove a node 'temp' fromt DLL. 
	// Note that the function may change head and tail pointers, that is why pointers to these pointers are passed.
	public DLLnode[] removeNode(DLLnode head, DLLnode tail, DLLnode temp){
		DLLnode result[] = new DLLnode[2];
		if (head == null){
			return result;
		}
		if (head == temp)	head = (head).next;
		if (tail == temp)	tail = (tail).prev;
		if (temp.next != null)	temp.next.prev = temp.prev;
		if (temp.prev != null)	temp.prev.next = temp.next;
		result[0] = head;
		result[1] = tail;
		return result;
	}

	public void findFirstNonRepeating(char[] stream){
		// inDLL[x] contains pointer to a DLL node if x is present in DLL. If x is not present, then inDLL[x] is NULL
		DLLnode inDLL[] = new DLLnode[256];
		DLLnode result[] = new DLLnode[2];
		//repeated[x] is true if x is repeated two or more times. If x is not seen so far or x is seen only once. then repeated[x] is false
		boolean repeated[] = new boolean[256];
		DLLnode head = null, tail = null;
	
		for (int i = 0; i < stream.length; i++){
			char x = stream[i];
			System.out.println("Reading: "+x+" from stream");

		    //We process this character only if it has not occurred or occurred only once. repeated[x] is true if x is repeated twice or more.s
			if (!repeated[x]){
				// If the character is not in DLL, then add this at the end of DLL.
				if (inDLL[x] == null){
					result = appendNode(head, tail, stream[i]);
					head = result[0];
					tail = result[1];
					inDLL[x] = tail;
				}
				else{ // Otherwise remove this caharacter from DLL
					result = removeNode(head, tail, inDLL[x]);
					head = result[0];
					tail = result[1];
					inDLL[x] = null;
					repeated[x] = true;  // Also mark it as repeated
				}
			}
			// Print the current first non-repeating character from stream
			if (head != null)
				System.out.println("First non-repeating character so far is: "+head.data);
		}
	}

	public static void main(String[] args) {
		S028_FindFirstNonRepeatingCharacterFromStreamOfCharacters obj = new S028_FindFirstNonRepeatingCharacterFromStreamOfCharacters();
		// Let us consider following stream and see the process
		String s = "geeksforgeeksandgeeksquizfor";
		char stream[] = s.toCharArray();
		obj.findFirstNonRepeating(stream);
	}
}
