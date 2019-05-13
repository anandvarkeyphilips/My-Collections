package io.exnihilo.onlinetests;

class SegregateZeroesAndOnes {
    /*Function to put all 0s on left and all 1s on right*/
    void segregate0and1(int arr[]) {
        for (int i = 0, j = arr.length - 1; i < j; ) {
            if (arr[i] == 1 & arr[j] == 0) {
                arr[i++] = 0;
                arr[j--] = 1;
            }
            if (arr[i] == 0) {
                i++;
            }
            if (arr[j] == 1) {
                j--;
            }
        }
    }

    public static void main(String[] args) {
        SegregateZeroesAndOnes seg = new SegregateZeroesAndOnes();
        int arr[] = new int[]{0, 1, 1, 1, 0, 1};
        seg.segregate0and1(arr);

        System.out.print("Array after segregation is ");
        for (int i : arr)
            System.out.print(i + " ");
    }
}