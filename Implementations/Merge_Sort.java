import java.util.*;
class Merge_Sort {
    public static void main(String args[]){
        int arr[] = {4,7,1,5,8,1,4,7,2,3,4,5,6};

        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int arr[],int left,int right){
        if(right>left){   
            int mid = left + (right-left)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,mid,right);
        }
        return;
    }

    public static void merge(int arr[],int l,int m,int r){
        int n1 = m-l+1;
        int n2 = r-m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for(int i=0;i<n1;i++){
            L[i] = arr[l+i];
        }
        for(int i=0;i<n2;i++){
            R[i] = arr[m+1+i];
        }
        int i = 0,j = 0;
        int k = l;
        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
                arr[k]=L[i];
                i++;
            }else{
                arr[k]=R[j];
                j++;
            }
            k++;
        }
        
        while(i<n1){
            arr[k]=L[i];
            k++;
            i++;
        }
        while(j<n2){
            arr[k]=R[j];
            j++;
            k++;
        }
    }
}
