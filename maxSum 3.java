/* Branching factor: 2 (to add or not to add next integer)
TIME COMPLEXITY: 2^(L.size())
Space: L.size()
                                                       {}
                                /                                      \
                             (L.get(0))                                (0)
                        /                 \                        /          \
            (L.get(0) + L.get(1))   (Let.get(0))               (L.get(1))    (0)
                                                                 





*/
public static int maxSum(List<Integer>L, int n){
    
    StringBuilder maxSum = new StringBuilder();
    maxSum.append(Integer.MIN_VALUE);
    dfs(L, 0, n, maxSum, 0);
    return Integer.parseInt(maxSum.toString());
}
// Pass maxSum as a reference
private static void dfs(List<Integer>L, int index, int n, StringBuilder maxSum, int sum){
    if (L.size() == 0){
        maxSum.setLength(0);
        maxSum.append(0);
        return;
    }
    
    
    // Check at end. Do not prune branches (check conditions before a branch reaches its end) 
    if(index == L.size()){
        if(sum > n){
           return;
        }
       if (sum > Integer.parseInt(maxSum.toString())) {
          maxSum.setLength(0);
          maxSum.append(sum);
        }
        return;
        
    }
    
    
   
    
    
    // add L.get(index)
    sum += L.get(index);
    dfs(L, index + 1, n, maxSum, sum);
    sum -= L.get(index);
    
    dfs(L, index + 1, n, maxSum, sum);
      
}