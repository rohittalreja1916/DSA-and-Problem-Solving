import java.util.*;

//Using HashMap and dfs
class LeetCode_Word_Search2 {
    public static void main(String[] args) {
        char board[][] ={
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };
        String words[] = {"oath","pea","eat","rain","hklf","hf"};
        LeetCode_Word_Search2 o = new LeetCode_Word_Search2();
        System.out.println(o.findWords(board,words));
    }    
    //O(mn * mn * no of words)
    public List<String> findWords(char[][] board, String[] words) {
        int ROWS = board.length;
        int COLUMNS = board[0].length;
        Map<Character,List<int[]>> map = new HashMap<>();
        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLUMNS;c++){
                List<int[]> values = new ArrayList<>();
                if(map.containsKey(board[r][c])){
                    values = map.get(board[r][c]);
                }
                values.add(new int[]{r,c});
                map.put(board[r][c], values);
            }
        }
        List<String> res = new ArrayList<>();
        for(String word:words){
            if(map.containsKey(word.charAt(0))){
                if(word.length()==1){
                    res.add(word);
                    continue;
                }
                List<int[]> index = map.get(word.charAt(0));
                for(int[] rc:index){
                    dfs(rc[0],rc[1],0,word,ROWS,COLUMNS,board,res);
                }
            }
        }
        return res;
    }
    public  void dfs(int r,int c, int pos, String word,int ROWS,int COLUMNS,char[][] board,List<String> res){
        if(pos==word.length()){
            if(!res.contains(word))res.add(word);
            return;
        }
        if(word.charAt(pos)!=board[r][c])return;

        char temp = board[r][c];
        board[r][c]='*';
        if(r<ROWS-1)dfs(r+1, c, pos+1, word, ROWS, COLUMNS, board,res);
        if(r>0)dfs(r-1, c, pos+1, word, ROWS, COLUMNS, board,res);
        if(c<COLUMNS-1)dfs(r, c+1, pos+1, word, ROWS, COLUMNS, board,res);
        if(c>0)dfs(r, c-1, pos+1, word, ROWS, COLUMNS, board,res);
        board[r][c]=temp;
    }
}