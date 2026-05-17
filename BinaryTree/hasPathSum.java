public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

//M1 -> Using Stack
public boolean hasPathSum(TreeNode root, int targetSum) {
    if(root == null){
        return false;
    }

    Stack<TreeNode> path = new Stack<>();
    Stack<Integer> sumPath = new Stack<>();

    path.push(root);
    sumPath.push(root.val);

    while(!path.isEmpty()){
        TreeNode temp = path.pop();
        int tempVal = sumPath.pop();

        if(temp.left == null && temp.right == null && tempVal == targetSum)
                return true;

        if(temp.right != null){
            path.push(temp.right);
            sumPath.push(temp.right.val + tempVal);
        }

        if(temp.left != null){
            path.push(temp.left);
            sumPath.push(temp.left.val + tempVal);
        }
    }

    return false;
}

public static void main(String[] args) {
    
}