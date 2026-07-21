class Solution {
    public int isPrefixOfWord(String s, String searchWord) {
        int n = s.length();
       String[] arr = s.split(" ");
       for(int i = 0; i<arr.length; i++){
        if(arr[i].startsWith(searchWord))
        return i + 1;
       } 
       return -1;
    }
}