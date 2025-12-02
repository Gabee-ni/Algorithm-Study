class Solution {
    public String solution(String new_id) {
        String answer = "";
        answer = new_id.toLowerCase();
        
        char[] arr = answer.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(!((arr[i]<='9' && arr[i]>='0')||
                 (arr[i]<='z' && arr[i]>='a') || 
                 arr[i]=='.'||arr[i]=='-'||arr[i]=='_')){
                arr[i]=' ';
            }
        }
        
        for(int a=0; a<arr.length; a++){
            if(arr[a] == '.'){
                int j = a+1;
                while(j < arr.length && (arr[j]==' ' || arr[j]=='.')){
                    if(arr[j]=='.') {
                        arr[j]=' ';
                    }
                    j++;
                }
            }
        }
        answer = new String(arr).replace(" ","");
        
        if(answer.startsWith(".")) answer=answer.substring(1);
        if(answer.endsWith(".")) answer=answer.substring(0,answer.length()-1);

        if(answer.length()==0) answer = "aaa";
        if(answer.length()>15 ) {
            if(answer.charAt(14)=='.') answer=answer.substring(0,14);
            else answer=answer.substring(0,15);
        }
        if(answer.length()<3){
            while(answer.length()<3){
                answer += answer.charAt(answer.length()-1);
            }
        }
        System.out.println(answer);
        return answer;
    }
}