package com.company;

import java.util.List;
import java.util.ArrayList;

public class MultiTree {
    private TreeNode rootNode;

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.childList.add(n2);
        n1.childList.add(n3);
        n2.childList.add(n4);
        n2.childList.add(n5);
        n3.childList.add(n6);
        n3.childList.add(n7);

        MultiTree mt = new MultiTree();
//        TreeNode tmp = mt.getParentNode(1, n1);
        mt.rootNode = n1;
//        Boolean success = mt.delete(1);
        Boolean success = mt.insert(7, 10);
        System.out.println(success);
    }

    /**
     * insert a new node with the given id as a child node
     *
     * @param pid the parent node
     * @param id  the id of node which is to be inserted
     * @return whether successfully insert, true: success, false: fail
     */
    public boolean insert(int pid, int id) {
        TreeNode targetNode = getNode(pid, rootNode);
        if (targetNode == null) {  // 如果找不到父节点，说明插入的位置不存在，认为插入失败
            return false;
        }
        targetNode.childList.add(new TreeNode(id));
        return true;
    }

    /**
     * delete a node with the given id
     *
     * @param id the id of node which is to be deleted
     * @return whether successfully delete, true: success, false: fail
     */
    public boolean delete(int id) {
        TreeNode parentNode = getParentNode(id, rootNode);
        if (parentNode == null) {  // 没找到父节点有两种情况
            if (rootNode.id != id) {  // 情况一：找不到要删除的节点，认为删除失败
                return false;
            }
            if (rootNode.childList.size() > 0) {  // 情况二：要删除的节点就是根节点，并且根节点有孩子
                TreeNode firstNode = rootNode.childList.get(0);
                for (int i = 1; i < rootNode.childList.size(); i++) {  // 此时默认处理是让根节点的其他孩子（第一个孩子除外）成为第一个节点的孩子
                    firstNode.childList.add(rootNode.childList.get(i));
                }
                rootNode = firstNode;  // 把根节点的第一个子孩子当作根节点
            } else {  // 根节点无孩子，直接置空
                rootNode = null;
            }
        } else {
            TreeNode targetChildNode = null;
            for (int i = 0; i < parentNode.childList.size(); i++) {  // 从父节点的孩子中找到指定id的节点
                if (parentNode.childList.get(i).id == id) {
                    targetChildNode = parentNode.childList.get(i);
                    break;
                }
            }
            parentNode.childList.remove(targetChildNode);
        }
        return true;
    }

    /**
     * Return the node with the given id
     *
     * @param id          the given id
     * @param currentNode the current node
     * @return the target node
     */
    public TreeNode getNode(int id, TreeNode currentNode) {
        if (id == currentNode.id) {  // 判断当前节点是否是目标节点
            return currentNode;
        }

        for (int i = 0; i < currentNode.childList.size(); i++) {
            TreeNode tmpNode = getNode(id, currentNode.childList.get(i));  // 递归方式进行遍历
            if (tmpNode != null) {  // 如果子节点中找到了目标节点，则直接返回
                return tmpNode;
            }
        }
        return null;
    }

    /**
     * @param id         Return the parent node of the node with the given id
     * @param parentNode the parent node
     * @return the parent node
     */
    private TreeNode getParentNode(int id, TreeNode parentNode) {
        for (int i = 0; i < parentNode.childList.size(); i++) {  // 循环所有子节点，判断是否子节点的值等于给定父节点的值
            if (parentNode.childList.get(i).id == id) {  // 终止条件
                return parentNode;
            }
        }
        for (int i = 0; i < parentNode.childList.size(); i++) {  // 若上面的for循环找不到满足条件的子节点，则采用先序遍历的方式继续遍历
            TreeNode tmpNode = getParentNode(id, parentNode.childList.get(i));
            if (tmpNode != null) {
                return tmpNode;
            }
        }
        return null;
    }

    static class TreeNode {
        int id;  // 唯一的id
        List<TreeNode> childList = new ArrayList<TreeNode>();  // 子节点的list集合

        public TreeNode(int id) {
            this.id = id;
        }
    }
}
