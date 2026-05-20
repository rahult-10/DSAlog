
public int countRangeSum(int[] nums, int lower, int upper) {
    int n = nums.length;
    long[] prefix = new long[n + 1];

    for (int i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i] + nums[i];
    }

    long[] sorted = prefix.clone();
    Arrays.sort(sorted);

    BIT bit = new BIT(sorted.length);

    int count = 0;
    for (long x : prefix) {

        int idx = lowerBound(sorted, x);
        int lowerIdx = lowerBound(sorted, x + lower);
        int upperIdx = upperBound(sorted, x + upper) - 1;

        // remove current prefix sum
        bit.add(idx, -1);
        count += bit.sum(upperIdx) - bit.sum(lowerIdx - 1);
    }
    return count;
}

private int lowerBound(long[] arr, long target) {
    int left = 0, right = arr.length;

    while (left < right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    return left;
}

private int upperBound(long[] arr, long target) {
    int left = 0, right = arr.length;

    while (left < right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] <= target) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    return left;
}

class BIT {
    private int[] tree;

    public BIT(int n) {
        tree = new int[n + 1];

        // initialize all values with 1
        for (int i = 0; i < n; i++) {
            add(i, 1);
        }
    }

    private int next(int idx) {
        return idx + (idx & -idx);
    }

    private int parent(int idx) {
        return idx & (idx - 1);
    }

    public void add(int idx, int val) {
        idx++; // convert to 1-based indexing

        while (idx < tree.length) {
            tree[idx] += val;
            idx = next(idx);
        }
    }

    public int sum(int idx) {
        idx++; // convert to 1-based indexing
        int res = 0;

        while (idx > 0) {
            res += tree[idx];
            idx = parent(idx);
        }

        return res;
    }
}

public void main(String[] args) {
    int[] nums = {-2, 5, -1};
    int lower = -2;
    int upper = 2;
    int res = countRangeSum(nums, lower, upper);
    System.out.print(res);
}
