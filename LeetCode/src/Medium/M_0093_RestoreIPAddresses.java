package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/restore-ip-addresses/
 */
public class M_0093_RestoreIPAddresses {

	/*
	 * Constraints :
	 * 
	 * As all the addresses are IPv4 so the max string length can be 12. 
	 * The subnets in the addresses will be 4. Anything more than 4 return false. 
	 * The min and max value of the subnet can be 0 and 255. So, there will be only 3 characters bounded by the min and max. 
	 * The subnet if has more than 1 digit cannot start with a 0.
	 */

	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<>();
		if (s.length() > 12) return result;
		backtrack(result, s, "", 0, 0);
		return result;
	}

	public void backtrack(List<String> result, String s, String curr, int idx, int count) {
		if (idx == s.length() && count == 4) {
			result.add(curr);
			return;
		}
		if ((count > 3) || (count == 3 && (s.length() - idx > 3))) return;

		for (int i = idx; i < idx+3 && i < s.length(); i++) {
			
			String subnet = s.substring(idx, i+1);
			if (subnet.length() > 1 && subnet.charAt(0) == '0') continue;

			int val = Integer.parseInt(subnet);
			
			if (val >= 0 && val <= 255) {
				String temp = "";
				if (curr.equals("")) temp = subnet;
				else {
					temp = curr + "." + subnet;
				}
				backtrack(result, s, temp, i+1, count+1);
			}
		}
	}

	// Approach2
	public List<String> restoreIpAddressesApproach2(String rawIpString) {
		List<String> restoredIps = new ArrayList<>();
		restoreIps(0, 0, new int[4], rawIpString, restoredIps);
		return restoredIps;
	}

	private void restoreIps(int progressIndex, int currentSegment, int[] ipAddressSegments,	String rawIpString,	List<String> restoredIps) {

		// If we have filled 4 segments (0, 1, 2, 3) and we are on the 4th,
		// we will only record an answer if the string was decomposed fully
		if (currentSegment == 4 && progressIndex == rawIpString.length()) {
			restoredIps.add(buildIpStringFromSegments(ipAddressSegments));
		} else if (currentSegment == 4) {
			return;
		}

		// Generate segments to try, a segment can be 1 to 3 digits long.
		for (int segLength = 1; segLength <= 3 && progressIndex + segLength <= rawIpString.length(); segLength++) {

			// Calculate 1 index past where the segment ends index-wise in the original raw ip string
			int onePastSegmentEnd = progressIndex + segLength;

			// Extract int value from our snapshot from the raw ip string
			String segmentAsString = rawIpString.substring(progressIndex, onePastSegmentEnd);
			int segmentValue = Integer.parseInt(segmentAsString);

			// Check the "snapshot's" validity - if invalid break iteration
			if (segmentValue > 255 || segLength >= 2  && segmentAsString.charAt(0) == '0') {
				break;
			}

			// Add the extracted segment to the working segments
			ipAddressSegments[currentSegment] = segmentValue;

			// Recurse on the segment choice - when finished & we come back here, the next loop iteration will try another segment
			restoreIps(progressIndex + segLength, currentSegment + 1, ipAddressSegments, rawIpString, restoredIps);
		}
	}

	private String buildIpStringFromSegments(int[] ipAddressSegments) {
		return ipAddressSegments[0] + "." + ipAddressSegments[1] + "."+ ipAddressSegments[2] + "." + ipAddressSegments[3];
	}

	// Approach3
	/*
	 * 3-loop divides the string s into 4 substring: s1, s2, s3, s4. Check if each
	 * substring is valid. In isValid, strings whose length greater than 3 or equals
	 * to 0 is not valid; or if the string's length is longer than 1 and the first
	 * letter is '0' then it's invalid; or the string whose integer representation
	 * greater than 255 is invalid.
	 */
	public List<String> restoreIpAddressesApproach3(String s) {
		List<String> res = new ArrayList<String>();
		int len = s.length();
		for(int i = 1; i < 4 && i < len-2; i++){
			for(int j = i+1; j<i+4 && j<len-1; j++){
				for(int k = j+1; k<j+4 && k<len; k++){
					String s1 = s.substring(0,i), s2 = s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k,len);
					if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
						res.add(s1+"."+s2+"."+s3+"."+s4);
					}
				}
			}
		}
		return res;
	}
	public boolean isValid(String s){
		if(s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255)
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		M_0093_RestoreIPAddresses obj = new M_0093_RestoreIPAddresses();
		System.out.println(obj.restoreIpAddresses("25525511135"));
	}
}
