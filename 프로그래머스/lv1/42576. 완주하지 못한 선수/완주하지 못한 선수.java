import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> partList = new HashMap<>();

        String answer = "";

        for(int i=0;i<participant.length;i++){
            partList.put(participant[i], partList.getOrDefault(participant[i], 0)+1);
        }
        for(int i=0;i<completion.length;i++){
            partList.put(completion[i], partList.getOrDefault(completion[i], 0)-1);
        }
        
        for(int i=0;i<participant.length;i++){
            if(partList.get(participant[i])!=0){
                answer = participant[i];
            }
        }
        return answer;
    }
}