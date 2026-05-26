public List<List<Integer>> pascalTriangle(int numRows) {
    int n = numRows;
    List<List<Integer>> mat = new ArrayList<>();
    for(int row = 0; row < n; row++){
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i <= row; i++){
            arr.add(binomialCoeff(row, i));
        }
        mat.add(arr);
    }
    return mat;
}

private int binomialCoeff(int n, int k){
    int res = 1;
    if(k > n-k){
        k = n-k;
    }
    for(int i = 0; i < k; ++i){
        res *= (n - i);
        res /= (i + 1);
    }
    return res;
}

public void main(String[] args) {
    int n = 5;
    List<List<Integer>> mat = pascalTriangle(n);
    for (int i = 0; i < mat.size(); i++) {
        for (int j = 0; j < mat.get(i).size(); j++) {
            System.out.print(mat.get(i).get(j) + " ");
        }
        System.out.println();
    }
}