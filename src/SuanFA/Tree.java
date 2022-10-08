package SuanFA;


/**
 * 数据结构：树(Tree)【详解】
    https://blog.csdn.net/Real_Fool_/article/details/113930623?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-113930623-blog-115323169.pc_relevant_multi_platform_whitelistv4&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-113930623-blog-115323169.pc_relevant_multi_platform_whitelistv4&utm_relevant_index=1
 */
public class Tree
{


    public static void main(String[] args) {

    }

    //二叉树的遍历:  先序、中序、后序
    //算法：1.递归方式        ；2.非递归方式（利用栈）      ；3.层次遍历(利用队列）
    //深度优先遍历(一般指前序，中序、后序)和广度优先遍历(层次)

    /** 1
     *学习初级阶段，搞清楚 二叉树几种遍历的代码，自己写一写
     * 对于二叉树的前序、中序、后序遍历 ；用递归方式太简单 ，不能满足面试官要求 这三种遍历学会用迭代，迭代本质上是在模拟递归，因为在递归的过程中使用了系统栈，所以在迭代的解法中常用Stack来模拟系统栈
     *
     *
     */


    /** 2
     *学习中级阶段，搞清楚 树题目一般有哪些解法
     *可以看看是如何递归的：
     https://leetcode.cn/problems/maximum-depth-of-binary-tree/solution/er-cha-shu-de-zui-da-shen-du-by-leetcode-solution/

     基本上递归都是用到了 深度优先   ；
     */

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

//主要是现在有点裂了，

}
