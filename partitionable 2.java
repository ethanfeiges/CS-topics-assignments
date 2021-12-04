/* Branching factor: 2 (to add or not to add next integer)
TIME COMPLEXITY: 2^(L.size())  * (L.size())
Space: L.size()
                                                       {}
                                /                                      \
                             (L.get(0))                                (0)
                        /                 \                        /          \
            (L.get(0) + L.get(1))   (Let.get(0))               (L.get(1))    (0)
                                                                 





*/





public boolean partitionable(List<Integer> L){
    int total = getTotal(0, L);
    StringBuilder sb = new StringBuilder();
    sb.append("False");
    dfs(total, 0, 0, sb, L);
    if(sb.toString().equals("True")){
        return true;
    }
    return false;
    
}

private void dfs(int total, int sum, int index, StringBuilder sb, List<Integer> L){
    if(L.size() == 0){
       sb.setLength(0);
       sb.append("True");
       return;
    }
    if(L.size() == 1){
        return; 
    }
    if(index == L.size()){
       return; 
    }
    if(total - sum == sum){
       sb.setLength(0);
       sb.append("True");
       return;
    }
    sum += L.get(index);
    dfs(total, sum, index + 1, sb, L);
    sum -= L.get(index);
    
    dfs(total, sum, index + 1, sb, L);
   
}

private int getTotal(int index, List<Integer> L){
    if(index == L.size()){
        return 0;
    }
    return L.get(index) + getTotal((index + 1), L);
}