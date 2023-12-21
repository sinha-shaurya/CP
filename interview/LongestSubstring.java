// Longest Substring without repeating characters
class LongestSubstring {
    public static void main(String[] args) {
        // your code goes here
        String s = "aaaaa";
        int left = 0, right = 0;
        boolean visited[] = new boolean[256];
        int max = 0;
        while (right < s.length()) {
            if (visited[(int)s.charAt(right)]) {
                while (visited[(int)s.charAt(right)]) {
                    visited[s.charAt(left)] = false;
                    left += 1;
                }
            }
            visited[(int)s.charAt(right)] = true;
            max = Math.max(max, right - left + 1);
            right += 1;

        }
        System.out.println(max);
    }
}