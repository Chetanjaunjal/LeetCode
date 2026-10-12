class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>(26);
        int n = s.length();
        int r = 0;
        int l = 0;
        int maxlen = 0;
        int maxfreq = 0;
        while(r < n){
            freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r),0) + 1);
            maxfreq = Math.max(maxfreq, freq.get(s.charAt(r)));
            if((r - l + 1) - maxfreq > k){
                freq.put(s.charAt(l), freq.get(s.charAt(l)) - 1);
                l++;
            }
            if((r - l + 1) - maxfreq <= k){
                maxlen = Math.max(maxlen, (r - l + 1));
            }
            r++;
        }
        return maxlen;
    }
}