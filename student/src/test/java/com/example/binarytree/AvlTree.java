package com.example.binarytree;

/**
 * 平衡二叉树
 * @description: AvlNode
 * @date: 2021/11/30 下午4:16
 * @author: zcy
 * @version: 1.0
 */
class AVLTree<E> {

    //标记左边高，需要调整
    public static final int LEFT_HIGH = 1;
    //标记右边高，需要调整
    public static final int RIGHT_HIGH = -1;
    //标记两边一样高，不需要调整
    public static final int EQUAL_HIGH = 0;

    private TreeNode<E> root;

    private int size;

    /**
     * 插入一个元素，同时需要计算平衡因子,检查平衡情况，做出旋转调整
     * @param element
     * @return
     */
    public boolean insertElement(E element) {
        TreeNode<E> t = root;
        //一个节点都没有，构造节点，作为根节点
        if (t == null) {
            t = new TreeNode<>(element, null);
            root = t;
            size++;//其实现在size=1;等价于size=1;
            return true;
        }
        //如果走到这里，说明已经有了跟节点，就需要先判断插入的位置
        //这里隐含了一个前提条件，在插入之前，整棵树已经平衡了，
        //实际上这个条件是一定满足的，因为在插入之后，就会判断树是否是平衡的

        //用来记录比较树的平衡度的变量
        int comparator = 0;
        //保存父节点
        TreeNode<E> parent;
        //因为是泛型，不能对象的大小，就通过比较器来实现比较大小
        //? super E: E或者E的父类 ? 这里是不是有问题，因该是E或者E的子类
        Comparable<? super E> e = (Comparable<? super E>) element;
        do {
            parent = t;
            //把当前结点和父节点比较大小，
            comparator = e.compareTo(t.element);
            if (comparator < 0) {//说明e小,王parent的左子树上走
                t = t.leftChild;
            } else if (comparator > 0) {
                t = t.rightChild;
            } else {
                //相等就不需要插入
                return false;
            }
        } while (t != null);
        //while循环结束之后，就找到了需要插入节点的位置,即在那个节点下插入，
        // 但是还不能确定是插入在这个节点的左边，还是右边，这个需要判断
        TreeNode<E> child = new TreeNode<>(element, parent);
        //插入左边还是右边
        if (comparator < 0) {
            //插入左边
            parent.leftChild = child;
        } else {
            //插入右边
            parent.rightChild = child;
        }
        //节点的位置已经找到了，并且成功插入，接下来就要判断新的树是否平衡了
        //因为在插入之前树已经是平衡的了，所以如果树是不平衡的，一定是因为新插入的节点引起的，
        //因此采用回溯法来判断新插入的节点的父节点，爷爷节点是否平衡
        while (parent != null) {
            comparator = e.compareTo(parent.element);
            if (comparator < 0) {
                //相当于插在parent的左子树上，因此parent的平衡因子+1
                parent.balance++;
            } else {
                parent.balance--;
            }
            if (parent.balance == 0) {
                //即插入的节点使得树平衡了，说明插入的节点不影响树的平衡性
                break;
            }
            //某一个节点的平衡度最大值只能为2，可能出现的值为-2，-1，0，1，2
            //当为-2，2时，需要调整，这里才出现问题
            if (Math.abs(parent.balance) == 2) {
                fixAfterInsert(parent);
            }
            //如果当前节点没有问题，就接着回溯
            parent = parent.parent;
        }
        size++;
        return true;
    }

    /**
     * 根据某个不平衡的节点对树进行旋转，使其平衡
     * @param parent
     */
    private void fixAfterInsert(TreeNode<E> parent) {
        if (parent.balance == 2) {
            //说明左边高,要进行做平衡操作
            leftBalance(parent);
        } else if (parent.balance == -2) {
            //说明右边高，要进行右平衡操作
            rightBalance(parent);
        }

    }

    private void rightBalance(TreeNode<E> t) {
        TreeNode rc = t.rightChild;
        switch (rc.balance) {
            case LEFT_HIGH:
                TreeNode lc = rc.leftChild;
                switch (lc.balance) {
                    case LEFT_HIGH:
                        t.balance = EQUAL_HIGH;
                        rc.balance = RIGHT_HIGH;
                        lc.balance = EQUAL_HIGH;
                        break;
                    case RIGHT_HIGH:
                        t.balance = LEFT_HIGH;
                        rc.balance = EQUAL_HIGH;
                        lc.balance = EQUAL_HIGH;
                        break;
                    case EQUAL_HIGH:
                        t.balance = EQUAL_HIGH;
                        rc.balance = EQUAL_HIGH;
                        lc.balance = EQUAL_HIGH;
                        break;
                }
                rightRotate(t.rightChild);
                leftRotate(t);
                break;
            case RIGHT_HIGH:
                leftBalance(t);
                //旋转之后节点的平衡度发生了变化
                rc.balance = EQUAL_HIGH;
                t.balance = EQUAL_HIGH;
                break;
            case EQUAL_HIGH:
                break;
        }
    }

    /**
     * 节点t左边的子树过高
     * @param t
     */
    private void leftBalance(TreeNode<E> t) {
        TreeNode<E> lc = t.leftChild;
        //只知道lc的平衡度除了问题，但是不知道是那种情况，是lc的左边，右边，还是左右平衡，因此需要进行判断
        switch (lc.balance) {
            case LEFT_HIGH://lc的左边出了问题，直接进行右旋，但是是旋转t的整个部分
                rightRotate(t);
                lc.balance = EQUAL_HIGH;
                t.balance = EQUAL_HIGH;
                break;
            case RIGHT_HIGH:
                TreeNode rc = lc.rightChild;
                switch (rc.balance) {
                    case LEFT_HIGH:
                        lc.balance = EQUAL_HIGH;
                        t.balance = RIGHT_HIGH;
                        rc.balance = EQUAL_HIGH;
                        break;
                    case RIGHT_HIGH:
                        t.balance = EQUAL_HIGH;
                        rc.balance = EQUAL_HIGH;
                        lc.balance = LEFT_HIGH;
                        break;
                    case EQUAL_HIGH:
                        t.balance = EQUAL_HIGH;
                        lc.balance = EQUAL_HIGH;
                        rc.balance = EQUAL_HIGH;
                        break;
                }
                //统一旋转
                leftRotate(t.leftChild);
                rightRotate(t);
                break;
            case EQUAL_HIGH:
                break;
        }
    }

    private void leftRotate(TreeNode p) {
        if (p != null) {
            TreeNode rc = p.rightChild;
            p.rightChild = rc.leftChild;//把中间夹的多余的元素链接到p的右下
            if (rc.leftChild != null) {
                rc.leftChild.parent = p;
            }

            rc.parent = p.parent;//rc旋转过来作为新树的节点，任然连着以前的父节点
            if (p.parent == null) {
                root = rc;
            } else if (p == p.parent.leftChild) {
                p.parent.leftChild = rc;
            } else if (p == p.parent.rightChild) {
                p.parent.rightChild = rc;
            }
            rc.leftChild = p;
            p.parent = rc;
        }
    }

    private void rightRotate(TreeNode<E> p) {
        if (p != null) {
            TreeNode lc = p.leftChild;
            p.leftChild = lc.rightChild;
            if (lc.rightChild != null) {
                lc.rightChild.parent = p;
            }
            lc.parent = p.parent;
            if (p.parent == null) {
                root = lc;
            } else if (p == p.parent.leftChild) {
                p.parent.leftChild = lc;
            } else if (p == p.parent.rightChild) {
                p.parent.rightChild = lc;
            }
            lc.rightChild = p;
            p.parent = lc;
        }
    }
    class TreeNode<E> {
        private E element;//节点的数据域
        private int balance;//节点的平衡因子，如果绝对值大于1，就表示需要调整
        private TreeNode leftChild;
        private TreeNode rightChild;
        private TreeNode parent;

        public TreeNode(E element, TreeNode parent) {
            this.element = element;
            this.parent = parent;
        }

        @Override
        public String toString() {
            //打印当前结点以及平衡因子
            return element + ",BF:" + balance;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public TreeNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(TreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(TreeNode rightChild) {
            this.rightChild = rightChild;
        }

        public TreeNode getParent() {
            return parent;
        }

        public void setParent(TreeNode parent) {
            this.parent = parent;
        }
    }
}