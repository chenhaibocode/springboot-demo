package com.chenhaibo.util;

/**
 * @Author: chenhaibo
 * @Description:
 * @Date: Created in 19:51 2018/7/18
 */
public class RbTreeDemo<T extends Comparable<T>> {

    /**
     * 根节点
     */
    private RbtNode<T> mRoot;

    private static final boolean RED = false;

    private static final boolean BLACK = true;

    /**
     * 对红黑树的节点(x)进行左旋转
     *
     * 左旋示意图(对节点x进行左旋)：
     *      px                              px
     *     /                               /
     *    x                               y
     *   /  \      --(左旋)-.           / \                #
     *  lx   y                          x  ry
     *     /   \                       /  \
     *    ly   ry                     lx  ly
     *
     * @param x
     */
    private void leftRotate(RbtNode<T> x) {
        // 设置x的右孩子为y
        RbtNode<T> y = x.right;
        // 将 “y的左孩子” 设为 “x的右孩子”；
        // 如果y的左孩子非空，将 “x” 设为 “y的左孩子的父亲”
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        // 将 “x的父亲” 设为 “y的父亲”
        y.parent = x.parent;
        if (x.parent == null) {
            //如果 “x的父亲” 是空节点，则将y设为根节点
            this.mRoot = y;
        } else {
            if (x.parent.left == x) {
                //如果 x是它父节点的左孩子，则将y设为“x的父节点的左孩子”
                x.parent.left = y;
            }else {
                // 如果 x是它父节点的左孩子，则将y设为“x的父节点的左孩子”
                x.parent.right = y;
            }
        }

        // 将 “x” 设为 “y的左孩子”
        y.left = x;
        // 将 “x的父节点” 设为 “y”
        x.parent = y;
    }

    /**
     * @param <T>
     */
    public class RbtNode<T extends Comparable<T>> {
        /**
         * 颜色
         */
        boolean color;
        /**
         * 关键字(键值)
         */
        T key;
        /**
         * 左孩子
         */
        RbtNode<T> left;
        /**
         * 右孩子
         */
        RbtNode<T> right;
        /**
         * 父结点
         */
        RbtNode<T> parent;

        public RbtNode(T key, boolean color, RbtNode<T> parent, RbtNode<T> left, RbtNode<T> right) {
            this.key = key;
            this.color = color;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }
}
