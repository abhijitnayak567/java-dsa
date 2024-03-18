package code.dsa.recursion;

public class RotatedBinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{5,6,7,9,1,2,3};
        System.out.println(search(arr, 7, 0, arr.length - 1));
        System.out.println(search(arr, 2, 0, arr.length - 1));
        System.out.println(search(arr, 9, 0, arr.length - 1));
        System.out.println(search(arr, 1, 0, arr.length - 1));
        System.out.println(search(arr, 15, 0, arr.length - 1));
    }

    private static int search(int[] arr, int target, int start, int end) {
        if (end < start) return -1;

        var mid = start + (end - start) / 2;
        if (arr[mid] == target) return mid;

        if (arr[start] <= arr[mid]) {
            if (target >= arr[start] && target < arr[mid])
                return search(arr, target, start, mid - 1);
            else return search(arr, target, mid + 1, end);
        }

        if (target > arr[mid] && target < arr[end])
            return search(arr, target, mid + 1, -1);

        return search(arr,target, start, mid -1);
    }
}
