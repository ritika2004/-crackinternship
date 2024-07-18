class Solution {
    public int[] sortArray(int[] a) {
        mergesort(a, 0, a.length - 1);
        return a;
    }

    public static void mergesort(int a[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        mergesort(a, si, mid);
        mergesort(a, mid + 1, ei);
        merge(a, si, mid, ei);
    }

    public static void merge(int a[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= ei) {
            if (a[i] < a[j]) {
                temp[k] = a[i];
                i++;
            } else {
                temp[k] = a[j];
                j++;
            }
            k++;
        }
        // remaining part
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= ei) {
            temp[k++] = a[j++];
        }
        
        for (i = si, k = 0; k < temp.length; k++, i++) {
            a[i] = temp[k];
        }
    }
}
