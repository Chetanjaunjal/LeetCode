class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(nums[i] >= 0){
                positive.add(nums[i]);
            }else{
                negative.add(nums[i]);
            }
        }
        int[] result = new int[n];
        int k = 0;
        int i = 0;
        int j = 0;
        while(i < positive.size() && j < negative.size()){
            result[k++] = positive.get(i++);
            result[k++] = negative.get(j++);
        }
        while(i < positive.size()){
            result[k++] = positive.get(i++);
        }

        while(j < negative.size()){
            result[k++] = negative.get(j++);
        }
        return result;
    }
}