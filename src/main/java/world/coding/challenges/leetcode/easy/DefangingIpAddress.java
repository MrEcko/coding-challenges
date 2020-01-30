package world.coding.challenges.leetcode.easy;

/**
 * https://leetcode.com/problems/defanging-an-ip-address/
 */
public class DefangingIpAddress {
    public String defangIPaddr(String address) {
        StringBuilder output = new StringBuilder();
        for (int i=0; i<address.length(); i++){
            char c = address.charAt(i);
            if (c == '.'){
                output.append('[');
                output.append(c);
                output.append(']');
            } else{
                output.append(c);
            }
        }
        return output.toString();
    }
}
