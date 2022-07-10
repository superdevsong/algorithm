package sort;

import java.util.*;


public class Sort {
    public static void main(String[] args) {
        int[] arr = {1,3,4,7,5,6,4,5};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));//[1, 3, 4, 4, 5, 6, 7]

    }
    public static void bubbleSort(int[] arr){// 인접한 두 인 원소의 대소를 비교하고 조건에 맞지 않는다면 자리를 교환하며 정렬하는 알고리즘
        int temp = 0;
        for(int i=0;i < arr.length; i++){//1 i는 0부터 하나씩 비교
            for(int j=1; j<arr.length-i;j++){//2 인덱스 1과 0을 비교하기위해 1부터 시작
                if(arr[j-1]>arr[j]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void selectionSort(int[] arr) {// 해당 순서에 원소를 넣을 위치를 이미 정해져있고 그 자리에 들어갈 원소를 찾는것
        int temp,indexMin;//바꿀값, 최소값
        for(int i=0;i < arr.length; i++){//1 i는 0부터 하나씩 비교
            indexMin = i;
            for(int j=i; j<arr.length;j++){//2 인덱스 1과 0을 비교하기위해 1부터 시작
                if(arr[j]<arr[indexMin]){ //현 최소값이 다른 원소값보다 낮으면 최소 인덱스 교체
                    indexMin = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[indexMin];
            arr[indexMin] = temp;
        }
        System.out.println(Arrays.toString(arr));

    }
    public static void insertionSort(int[] arr) {//두번째 원소부터 시작하며 앞쪽의 원소들과 비교하여 삽입할 위치를 정하고 해당 위치보다 뒤에있는 원소들은
        //한칸씩 뒤로 보내고 해당위치에 원소를 삽입하여 정렬한다.
        for(int index = 1 ; index < arr.length ; index++){ // 1.
            int temp = arr[index];
            int prev = index - 1;
            while( (prev >= 0) && (arr[prev] > temp) ) {    // 2.
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = temp;                           // 3.
        }
        System.out.println(Arrays.toString(arr));
        }
    public static void quickSort(int[] array, int left, int right) {
        if(left >= right) return;

        // 분할
        int pivot = partition(array,left,right);

        // 피벗은 제외한 2개의 부분 배열을 대상으로 순환 호출
        quickSort(array, left, pivot-1);  // 정복(Conquer)
        quickSort(array, pivot+1, right); // 정복(Conquer)
    }
    public static int partition(int[] array, int left, int right) {
        /**
         // 최악의 경우, 개선 방법
         int mid = (left + right) / 2;
         swap(array, left, mid);
         */

        int pivot = array[left]; // 가장 왼쪽값을 피벗으로 설정
        int i = left, j = right;

        while(i < j) {
            while(pivot < array[j]) {
                j--;
            }
            while(i < j && pivot >= array[i]){
                i++;
            }
            swap(array, i, j);

        }
        array[left] = array[i];
        array[i] = pivot;

        return i;
    }
    public static void mergeSort(int[] array, int left, int right) {

        if(left < right) {
            int mid = (left + right) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid+1, right);
            merge(array, left, mid, right);
        }

    }
    public static void merge(int[] array, int left, int mid, int right) {
        int[] L = Arrays.copyOfRange(array, left, mid + 1);
        int[] R = Arrays.copyOfRange(array, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        int ll = L.length, rl = R.length;

        while(i < ll && j < rl) {
            if(L[i] <= R[j]) {
                array[k] = L[i++];
            }
            else {
                array[k] = R[j++];
            }
            k++;
        }

        // remain
        while(i < ll) {
            array[k++] = L[i++];
        }
        while(j < rl) {
            array[k++] = R[j++];
        }
    }
    public static void heapSort(int[] array) {
        int n = array.length;

        // max heap 초기화
        for (int i = n/2-1; i>=0; i--){
            heapify(array, n, i); // 1
        }

        // extract 연산
        for (int i = n-1; i>0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0); // 2
        }
    }
    public static void heapify(int array[], int n, int i) {
        int p = i;
        int l = i*2 + 1;
        int r = i*2 + 2;

        //왼쪽 자식노드
        if (l < n && array[p] < array[l]) {
            p = l;
        }
        //오른쪽 자식노드
        if (r < n && array[p] < array[r]) {
            p = r;
        }

        //부모노드 < 자식노드
        if(i != p) {
            swap(array, p, i);
            heapify(array, n, p);
        }
    }
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
