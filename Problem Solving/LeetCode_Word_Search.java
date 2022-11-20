class LeetCode_Word_Search{
    public static void main(String[] args) {
        char[][] board = {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };
        String word="eat";

        System.out.println(exist(board, word));
    }
    public static boolean exist(char[][] board, String word){

        int ROWS = board.length;
        int COLUMNS = board[0].length;

        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLUMNS;c++){
                if(word.charAt(0)==board[r][c] && dfs(r, c, 0, word, ROWS, COLUMNS, board))return true;
            }
        }
        return false;
    }
    public static boolean dfs(int r,int c, int pos, String word,int ROWS,int COLUMNS,char[][] board){
        if(word.equals("eat")){
            System.out.println(r+" "+c +" "+pos);
        }
        if(pos==word.length())return true;

        if(r<0 || c<0 || r>=ROWS || c>=COLUMNS || word.charAt(pos)!=board[r][c])return false;

        char temp = board[r][c];
        board[r][c]='*';
        boolean res = dfs(r+1, c, pos+1, word, ROWS, COLUMNS, board) ||
                    dfs(r-1, c, pos+1, word, ROWS, COLUMNS, board) ||
                    dfs(r, c+1, pos+1, word, ROWS, COLUMNS, board)||
                    dfs(r, c-1, pos+1, word, ROWS, COLUMNS, board);
        if(res)return true;
        board[r][c]=temp;
        return false;
    }
}