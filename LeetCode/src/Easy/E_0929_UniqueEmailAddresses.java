package Easy;

import java.util.HashSet;

/*
 * https://leetcode.com/problems/unique-email-addresses/
 */
public class E_0929_UniqueEmailAddresses {

	public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<String>();

        for(int i = 0; i < emails.length; i++){
            String email  = emails[i];
            int idx = email.indexOf('@');
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < idx; j++){
                char c = email.charAt(j);
                if(c == '+'){
                    break;
                }
                else if(c != '.'){
                    sb.append(email.charAt(j));
                }
            }
            sb.append(email.substring(idx));
            System.out.println(sb.toString());
            set.add(sb.toString());
        }
        return set.size();
    }
	public static void main(String[] args) {
		E_0929_UniqueEmailAddresses obj = new E_0929_UniqueEmailAddresses();
		System.out.println(obj.numUniqueEmails(new String[] {"t.est.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
	}
}
