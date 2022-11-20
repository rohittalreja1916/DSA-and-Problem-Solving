import java.util.*;

//Using Trie and dfs

class LeetCode_Word_Search2_1 {
    public static void main(String[] args) {
        char board[][] ={
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };
        String words[] = {"oath","pea","eat","rain","hklf","hf"};
        LeetCode_Word_Search2_1 o = new LeetCode_Word_Search2_1();
        System.out.println(o.findWords(board,words));
    }
    //O(mn * mn)
    public List<String> findWords(char[][] board, String[] words) {
        
        int ROWS = board.length;
        int COLUMNS = board[0].length;
        Trie t = new Trie();
        for(int i=0;i<words.length;i++){
            t.insert(words[i]);
        }
        List<String> ans = new ArrayList<>();
        
        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLUMNS;c++){
                dfs(r,c,ROWS,COLUMNS,ans,t.root,board);
            }
        }
        return ans;
    }
    public void dfs(int r, int c, int ROWS, int COLUMNS, List<String> ans, Trie.TrieNode curr,char[][] board){

        int index = board[r][c]-'a';
        if(board[r][c]=='$' || curr.children[index]==null)return;

        curr = curr.children[index];
        if(curr.endOfWord){
            ans.add(curr.word);
            curr.endOfWord=false;
        }

        char ch = board[r][c];
        board[r][c]='$';
        if(r>0)dfs(r-1,c,ROWS,COLUMNS,ans,curr,board);
        if(r<ROWS-1)dfs(r+1,c,ROWS,COLUMNS,ans,curr,board);
        if(c>0)dfs(r,c-1,ROWS,COLUMNS,ans,curr,board);
        if(c<COLUMNS-1)dfs(r,c+1,ROWS,COLUMNS,ans,curr,board);

        board[r][c]=ch;
    }
}
class Trie{
    Trie(){
        root = new TrieNode('/');
    }
    TrieNode root;
    class TrieNode{
        char c;
        boolean endOfWord;
        TrieNode[] children;
        String word;
        TrieNode(char c){
            this.c=c;
            this.endOfWord=false;
            children = new TrieNode[26];
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            word = new String();
        } 
    }
    public TrieNode getNode(char c){
        TrieNode newNode = new TrieNode(c);

        return newNode;
    }
    public void insert(String word){
        TrieNode curr = root;
        int index=0;
        for(char c:word.toCharArray()){
            index = c-'a';
            if(curr.children[index]==null)
                curr.children[index] = new TrieNode(c);
            curr = curr.children[index];
        }
        curr.endOfWord=true;
        curr.word=word;
    }
}