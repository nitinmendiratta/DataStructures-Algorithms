package Easy;
/*
 * https://leetcode.com/problems/student-attendance-record-i/
 */
public class E_0551_StudentAttendanceRecord1 {

	public boolean checkRecord(String s) {
		int countA = 0;
		int continuosL = 0;
		int charA = 'A';
		int charL ='L';
		
		for(int i = 0; i < s.length(); i++){
			
			if(s.charAt(i) == charA){
				countA++;
				continuosL = 0;
			}
			else if(s.charAt(i) == charL){
				continuosL++;
			}
			else{
				continuosL = 0;
			}
			if(countA > 1 || continuosL > 2 ){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		E_0551_StudentAttendanceRecord1 obj = new E_0551_StudentAttendanceRecord1();
		System.out.println(obj.checkRecord("PPALLPL"));
	}
}
