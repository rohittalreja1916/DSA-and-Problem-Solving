class LeetCode_Guess_Number_Higher_Or_Lower extends GuessGame{
    LeetCode_Guess_Number_Higher_Or_Lower(int n){
        super(n);
    }
    public static void main(String[] args) {
        int n=2126753390; //     length of n 
        LeetCode_Guess_Number_Higher_Or_Lower g = new LeetCode_Guess_Number_Higher_Or_Lower(1702766719); //choose pick number in constructor
        System.out.println(g.guessNumber(n));
    }    
    public int guessNumber(int n) {
        return binarySearch(n);
    }
    public int binarySearch(int n){

        int low =1,high=n;
        while(low<=high){
            int mid = low + (high - low)/2;
            System.out.println(mid);
            int guessed = guess(mid);
            if(guessed==0)return mid;
            else if (guessed==1)low=mid+1;
            else high=mid-1;
        }
        return -1;
    }
}
class GuessGame{
    int num;
    GuessGame(int n){
        this.num=n;
    }
    public int guess(int n){
        if(num==n)return 0;
        else if(n>num)return -1;
        else return 1; 
    }
}