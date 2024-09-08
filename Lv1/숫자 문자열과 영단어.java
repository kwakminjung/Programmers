import java.util.*;

class Solution {
    public int solution(String s) throws NumberFormatException {
        String answer = "";
        String[][] nextC ={{"wo", "hree"}, {"our", "ive"},{"ix", "even"}};
        
        HashMap<Character, String[]> map = new HashMap<>();
        map.put('t', nextC[0]);
        map.put('f', nextC[1]);
        map.put('s', nextC[2]);
        
        HashMap<String, String> number = new HashMap<>();
        number.put("wo", "2");
        number.put("hree", "3");
        number.put("our", "4");
        number.put("ive", "5");
        number.put("ix", "6");
        number.put("even", "7");
        
        Character[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        List<Character> numList = new ArrayList<>(Arrays.asList(num));
            
        for(int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);
            if(numList.contains(curr)) {
                answer += String.valueOf(curr);
                continue;
            }
            
            if(curr == 'z') {
                answer += "0";
                i += 3;
            } else if(curr == 'o') {
                answer += "1";
                i += 2;
            } else if(curr == 'e') {
                answer += "8";
                i += 4;
            } else if(curr == 'n') {
                answer += "9";
                i += 3;
            } else if(map.containsKey(curr)) {
                for(int j=0; j<2; j++) {
                    if(s.charAt(i+1) == map.get(curr)[j].charAt(0)) {
                        answer += number.get(map.get(curr)[j]);
                        i += map.get(curr)[j].length();
                        break;
                    }
                }
                
            }
            
        }
        
        return Integer.parseInt(answer);
    }
}
