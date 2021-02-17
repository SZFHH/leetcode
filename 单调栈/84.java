class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        int rv = -1;
        for(int i=0; i < heights.length; i++){
            while(stk.peek()!=-1 && heights[stk.peek()]>=heights[i]){
                int h = heights[stk.peek()];
                stk.pop();
                rv = Math.max(rv, (i-stk.peek()-1)*h);
            }
            stk.push(i);
        }
        while(stk.size()>1){
            int h = heights[stk.peek()];
            stk.pop();
            rv = Math.max(rv,( heights.length-stk.peek()-1)*h);
        }
        return rv;
    }
}