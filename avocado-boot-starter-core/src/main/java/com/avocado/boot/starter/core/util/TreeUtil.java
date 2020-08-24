package com.avocado.boot.starter.core.util;

import com.avocado.boot.starter.core.basic.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author ：qiaoliang
 */
public class TreeUtil {

    /**
     * 两层循环实现建树
     *
     * @author ：qiaoliang
     * @param treeNodes :   传入的树节点列表
     * @param root : 顶级ID
     * @return java.util.List<T>
     */
    public static <T extends TreeNode> List<T> bulid(List<T> treeNodes, Long root) {
        List<T> trees = new ArrayList<>();
        for (T treeNode : treeNodes) {
            if (root == treeNode.getParentId()) {
                trees.add(treeNode);
            }
            for (T it : treeNodes) {
                if (it.getParentId() == treeNode.getId()) {
                    if (Objects.isNull(treeNode.getChildren())) {
                        treeNode.setChildren(new ArrayList<>());
                    }
                    treeNode.add(it);
                }
            }
        }
        return trees;
    }

    /**
     * 使用递归方法建树
     *
     * @author ：qiaoliang
     * @param treeNodes : 传入的树节点列表
     * @param root : 顶级ID
     * @return java.util.List<T>
     */
    public static <T extends TreeNode> List<T> buildByRecursive(List<T> treeNodes, Long root) {
        List<T> trees = new ArrayList<T>();
        for (T treeNode : treeNodes) {
            if (root == treeNode.getParentId()) {
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     *
     * @author ：qiaoliang
     * @param treeNode : 子节点
     * @param treeNodes : 传入的树节点列表
     * @return T
     */
    public static <T extends TreeNode> T findChildren(T treeNode, List<T> treeNodes) {
        for (T it : treeNodes) {
            if (treeNode.getId() == it.getParentId()) {
                if (Objects.isNull(treeNode.getChildren())) {
                    treeNode.setChildren(new ArrayList<>());
                }
                treeNode.add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }

}
