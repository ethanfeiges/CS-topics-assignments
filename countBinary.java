// Number of levels should be n
 // Branching factor: 2
/*    
 Time: 2^(n) * n
 Space: n HEIGHT OF TREE
 
                          {}
               /                      \ 
              (0)                    (1)
           /       \             /          \
          00       01           10          11
         /  \    /   \         /  \        /  \
        000 001 010  011      100 101    110  111
        
*/

public static void countBinary(int n){
    StringBuilder sb = new StringBuilder();
    dfs(0, n, sb);
}
private static void dfs(int curr, int n, StringBuilder sb){
    if(curr == n){
       System.out.println(sb.toString());
       return; 
    }
    sb.append("0");
    dfs(curr + 1, n, sb);
    sb.setLength(sb.length() - 1);
    
    sb.append("1");
    dfs(curr + 1, n, sb);
    sb.setLength(sb.length() - 1);
    
}