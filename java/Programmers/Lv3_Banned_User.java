package PACKAGE_NAME;
import java.util.*;

public class Lv3_Banned_User {
    private static boolean[] check; // 앞에서 사용된 아이디인지 체크
    private static int answer = 0;
    private static List<List<String>> candidates = new ArrayList<>();
    private static Set<Set<String>> resultSet = new HashSet<>();

    // 개인정보 보호을 위해 사용자 아이디 중 일부 문자를 '*' 문자로 가려서 전달
    // 가리고자 하는 문자 하나에 '*' 문자 하나를 사용하였고 아이디 당 최소 하나 이상의 '*' 문자를 사용
    // "무지"와 "프로도"는 불량 사용자 목록에 매핑된 응모자 아이디를 제재 아이디라고 부르기
    // 당첨에서 제외되어야 할 제재 아이디 목록은 몇가지 경우의 수가 가능

    public boolean isMatch(String banned, String user) {
        if (banned.length() != user.length()) return false;
        for (int i = 0; i < banned.length(); i++) {
            if (banned.charAt(i) != '*' && banned.charAt(i) != user.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private void dfs(Set<String> selected, int depth, List<String> currentList) {
        if (depth == candidates.size()) {
            if (selected.size() == candidates.size()) {
                resultSet.add(new HashSet<>(selected)); // 조합 저장
                // System.out.println("조합 추가: " + currentList);
            }
            return;
        }

        for (String user : candidates.get(depth)) {
            if (!selected.contains(user)) {
                selected.add(user);
                currentList.add(user);
                dfs(selected, depth + 1, currentList);
                selected.remove(user); // 백트래킹
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    public int solution(String[] user_id, String[] banned_id) {
        // 각 banned_id에 매칭되는 user_id 후보 저장
        for (String ban : banned_id) {
            List<String> matchList = new ArrayList<>();
            for (String user : user_id) {
                if (isMatch(ban, user)) {
                    matchList.add(user);
                }
            }
            candidates.add(matchList);
        }

        System.out.println(candidates);

        // DFS로 가능한 조합 탐색
        // 순서 O, 중복 X => LinkedHashSet
        // 순서 X, 중복 X => HashSet
        dfs(new LinkedHashSet<>(), 0, new ArrayList<>());

        // System.out.println("최종 가능한 조합:");
        // for (Set<String> result : resultSet) {
        //     System.out.println(result);
        // }

        return resultSet.size();

    }
}

