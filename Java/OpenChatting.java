package Java;

import java.util.*;

public class OpenChatting {
    public static void main(String[] args){
        OpenChatting o = new OpenChatting();
        String[] record ={"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(o.solution(record)));
    }
    public String[] solution(String[] record){
        String[] answer = {};
        StringTokenizer st;
        HashMap<String, String> hash = new HashMap<>();

        ArrayList<String[]> lst = new ArrayList<>();

        for(int i =0;i<record.length;i++){
            st = new StringTokenizer(record[i]);
            String action = st.nextToken();
            String id = st.nextToken();
            String nick = "";
            if(st.hasMoreTokens())
               nick = st.nextToken();

            if(action.equals("Change")){
                hash.put(id,nick);
            }
            else{
                if( hash.containsKey(id)){
                    if(action.equals("Enter") && !hash.get(id).equals(nick)){
                        hash.put(id,nick);
                    }
                }else{
                    hash.put(id,nick);
                }
                lst.add(new String[]{id,action});
            }
        }
        answer = new String[lst.size()];
        for(int i =0;i<lst.size();i++){
            answer[i] = hash.get(lst.get(i)[0]);
            answer[i] += lst.get(i)[1].equals("Enter") ? "님이 들어왔습니다." : "님이 나갔습니다.";
        }

        return answer;
    }
}
