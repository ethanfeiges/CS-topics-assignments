// Number of levels should be x + y
 // Branching factor: 3 (N, E, NE)
/*                   (0, 0)
        /                |              \
      (0,1)         (1, 0)          (1, 1)
   /   |     \      /  |      \    /     |       \
 (0, 2)(1, 2)(1, 1)(1,1)(2,0)(2,1) (1,1)(2, 1)(2, 2)
 Time: 3^(x + y)
 Space: (x + y) HEIGHT OF TREE
 
*/


public static void travel (int x, int y){
  StringBuilder sb = new StringBuilder();
  dfs(0, 0, x, y, sb); // current state: (0, 0)
}

// Depth First Search
private static void dfs(int currX, int currY, int x, int y, StringBuilder sb){
    if(currX > x || currY > y){ // prevent it from going further (NOT >=)
       return; // stop recursing 
    }
    
    if(currX == x && currY == y) { // if met location 
      System.out.println(sb.toString());
      return; // stop recursion
    }
    





    // E branch (East)
    sb.append("E ");
    dfs(currX + 1, currY, x, y, sb);
    sb.setLength(sb.length() - 2); // deleting "E " from backtracking to keep sb at original state . 
   
    // N branch (North)
    sb.append("N ");
    dfs(currX, currY + 1, x, y, sb);
    sb.setLength(sb.length() - 2);
    
    // NE branch (Northeast)
    sb.append("NE ");
    dfs(currX + 1, currY + 1, x, y, sb);
    sb.setLength(sb.length() - 3);
    
    
   
    
    
}