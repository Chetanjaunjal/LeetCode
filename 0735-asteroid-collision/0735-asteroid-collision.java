class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> st = new ArrayList<>();
        
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                st.add(asteroid);
            } else {
                int currentSize = Math.abs(asteroid);
                boolean destroyed = false;
               
                while (!st.isEmpty()
                        && st.get(st.size() - 1) > 0) {
                    int topIndex = st.size() - 1;
                    int topSize = Math.abs(st.get(topIndex));
                   
                    if (topSize < currentSize) {
                        st.remove(topIndex);
                    } else {
                        
                        if (topSize == currentSize) {
                            st.remove(topIndex);
                        }
                        destroyed = true;
                        break;
                    }
                }
                
                if (!destroyed) {
                    st.add(asteroid);
                }
            }
        }
        int[] answer = new int[st.size()];
        for (int i = 0; i < st.size(); i++) {
            answer[i] = st.get(i);
        }
        return answer;
    }
}