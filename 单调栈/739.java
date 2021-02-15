// class Solution {
//     public int[] dailyTemperatures(int[] T) {
//         int[] rv = new int[T.length];
//         int[] after = new int[101];
//         for(int i=30; i<=100; i++) {
//             after[i] = -1;
//         }
//         for(int i=T.length-1; i>=0; i--) {
//             int mini = 30005;
//             for(int t = T[i]+1; t<=100; t++) {
//                 if(after[t]>i && after[t]<mini) {
//                     mini = after[t];
//                 }
//             }
//             after[T[i]] = i;
//             if(mini==30005) mini=i;
//             rv[i] = mini-i;
//         }
//         return rv;
        
//     }
// }

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] rv = new int[T.length];
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i=0; i<T.length; i++) {
            int t = T[i];
            while(!stack.isEmpty() && T[stack.peek()]<t) {
                int prev = stack.pop();
                rv[prev] = i-prev; 
            }
            stack.push(i);
        }
        return rv;
    }

}