class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] newArr = new int[nums1.length + nums2.length];
        int i = 0, j =0, k=0;
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                newArr[k++] = nums1[i++];
            } else {
                newArr[k++] = nums2[j++];
            }
        }

        // Copy remaining elements
        while (i < nums1.length) {
            newArr[k++] = nums1[i++];
        }

        while (j < nums2.length) {
            newArr[k++] = nums2[j++];
        }

        int n = newArr.length;

        if (n % 2 == 0) {
            return (newArr[n/2 - 1] + newArr[n/2]) / 2.0;
        } else {
            return newArr[n/2];
        }
    
    }
    
}