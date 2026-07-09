import java.util.*;

class Solution {
    Set<Set<String>> result = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        dfs(0, user_id, banned_id, new HashSet<>());
        return result.size();
    }

    private void dfs(int idx, String[] user_id, String[] banned_id, Set<String> selected){

        if(idx == banned_id.length){
            result.add(new HashSet<>(selected));
            return;
        }

        for(String user : user_id){
            if (selected.contains(user)) continue;

            if(isMatch(user, banned_id[idx])){
                selected.add(user);
                dfs(idx+1, user_id, banned_id, selected);
                selected.remove(user);
            }
        }
    }

    private boolean isMatch(String user, String banned){
        if(user.length() != banned.length()) return false;

        for(int i=0; i<user.length(); i++){
            if(banned.charAt(i) == '*') continue;
            if(user.charAt(i) != banned.charAt(i)) return false;

        }
        return true;
    }
}