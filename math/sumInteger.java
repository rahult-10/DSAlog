/* 
371. Sum of Two Integers
Given two integers a and b, return the sum of the two integers without using the operators + and -.
*/

public int sumInteger(int a, int b){
    while(b != 0){
        int carry = (a&b)<<1;
        a = a^b;
        b = carry;
    }
    return a;
}

public void main(String[] args){
    int a = 3;
    int b = 5;
    int sum = sumInteger(a, b);
    System.out.println(sum);
}