class LeetCode_Rectangle_Area {
    public static void main(String[] args) {
        int ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2;
        System.out.println(computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
    }   
    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ay2-ay1)*(ax2-ax1);
        int area2 = (by2-by1)*(bx2-bx1);

        int xOverlap = Math.min(ax2,bx2) - Math.max(ax1,bx1);
        int yOverlap = Math.min(ay2,by2) - Math.max(ay1,by1);
        int areaOverlap = 0;
        if(xOverlap > 0 && yOverlap>0){
            areaOverlap = xOverlap * yOverlap;
        }
        return area1+area2-areaOverlap;
    } 
}
