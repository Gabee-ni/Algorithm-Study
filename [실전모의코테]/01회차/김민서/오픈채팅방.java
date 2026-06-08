import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> person = new HashMap<>();
        int cnt = 0;
        
        for (String r : record) {
            String[] text = r.split(" ");
            
            if (text[0].equals("Enter")) {
                person.put(text[1], text[2]);
                cnt++;
            } else if (text[0].equals("Change")) {
                person.put(text[1], text[2]);
            } else {
                cnt++;
            }
        }
        
        String[] answer = new String[cnt];
        int idx = 0;
        
        for (String r : record) {
            String[] text = r.split(" ");
            
            if (text[0].equals("Enter")) {
                answer[idx] = person.get(text[1]) + "님이 들어왔습니다.";
                idx++;
            } else if (text[0].equals("Leave")){
                answer[idx] = person.get(text[1]) + "님이 나갔습니다.";
                idx++;
            } else {
                continue;
            }
        }
        
        return answer;
        
    }
  
}


/**
 * 시간 초과
 * import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        Map<Integer, String> who = new HashMap<>();
        Map<String, String> person = new HashMap<>();
        List<String> text = new ArrayList<>();
        
        for (String s : record) {
            String[] re = s.split(" ");
            
            if (re[0].equals("Enter")) {
                
                person.put(re[1], re[2]);
                
                if (who.containsValue(re[1])) {
                    String enter = makeEnterText(re[2]);
                    String leave = makeLeaveText(re[2]);
                    
                    for (int i = 0; i < text.size(); i++) {
                        if (!who.get(i).equals(re[1])) {
                            continue;
                        }
                        
                        String[] t = text.get(i).split(" ");
                        if (t[1].equals("들어왔습니다.")) {
                            text.set(i, enter);    
                        } else if (t[1].equals("나갔습니다.")) {
                            text.set(i, leave);    
                        }
                        
                    }
                }
                
                
                text.add(makeEnterText(re[2]));
                who.put(text.size() - 1, re[1]);
                
            } else if (re[0].equals("Leave")) {
                
                text.add(makeLeaveText(person.get(re[1])));
                who.put(text.size() - 1, re[1]);
                
            } else if (re[0].equals("Change")) {
                
                person.put(re[1], re[2]);
                
                if (who.containsValue(re[1])) {
                    String enter = makeEnterText(re[2]);
                    String leave = makeLeaveText(re[2]);
                    
                    for (int i = 0; i < text.size(); i++) {
                        
                        if (!who.get(i).equals(re[1])) {
                            continue;
                        }
                        
                        String[] t = text.get(i).split(" ");
                        if (t[1].equals("들어왔습니다.")) {
                            text.set(i, enter);    
                        } else if (t[1].equals("나갔습니다.")) {
                            text.set(i, leave);    
                        }
                        
                    }
                }
            }
        }
        
        String[] answer = new String[text.size()];
        
        for (int i = 0; i < text.size(); i++) {
            answer[i] = text.get(i);
        }
        
        return answer;
    }
    
    static String makeEnterText(String nickname) {
        return nickname + "님이 들어왔습니다.";
    }
    
    static String makeLeaveText(String nickname) {
        return nickname + "님이 나갔습니다.";
    }
}


/**
map<String, Integer> 로 id 당 idx 저장

**/
 */