import java.util.List;

public class placement1_word_break {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, 0);
    }
    
    private boolean dfs(String s, List<String> wordDict, int i) {
        if (i == s.length()) {
            return true;
        }

        for (String w : wordDict) {
            if (i + w.length() <= s.length() && 
                s.substring(i, i + w.length()).equals(w)) { // substring function comma represents the start and end indices, s.substring(i, i + w.length()) extracts the substring from index i to i + w.length()
                if (dfs(s, wordDict, i + w.length())) {  // If the substring matches, recursively check the rest of the string
                    return true;
                }
            }
        }
        return false;
    }
}