package com.leetcode;

import jdk.nashorn.api.tree.Tree;

import java.util.ArrayList;

/**
 * @author liubi
 * @date 2019-01-08 12:39
 **/
public class OfferSord08_56 {
    /**
     * 获得前序遍历顺序下 ，pNode 节点的下一个节点
     * pNode.next 指向pNode 的父节点 实际上是pNode.parent
     * @param pNode
     * @return
     */
    public TreeLinkNode GetPreNext(TreeLinkNode pNode)
    {
        if(pNode.left!=null){
            return pNode.left;
        }
        else if(pNode.right!=null){
            return pNode.right;
        }
        else {
            TreeLinkNode curent = pNode;
            pNode = pNode.next;
            while (pNode.left !=curent){
                curent = pNode;
                pNode = pNode.next;
            }
            return pNode.right;
        }
    }
    private TreeLinkNode getLeftMostNode(TreeLinkNode treeLinkNode){
        while (treeLinkNode.left!=null){
            treeLinkNode = treeLinkNode.left;
        }
        return treeLinkNode;
    }
    public TreeLinkNode GetMidNext(TreeLinkNode pNode){
        if(pNode.right!=null){
            return getLeftMostNode(pNode.right);
        }
        else {
            TreeLinkNode current = pNode;
            pNode = pNode.next;
            while (pNode!=null&&current!= pNode.left){
                current = pNode;
                pNode = pNode.next;
            }
            return pNode;
        }
    }
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        return GetMidNext(pNode);
    }
    public static void main(String[] args) {
        OfferSord08_56 solution = new OfferSord08_56();
        TreeLinkNode t2 = new TreeLinkNode(2);
        TreeLinkNode t3 = new TreeLinkNode(3);
        TreeLinkNode t4 = new TreeLinkNode(4);
        TreeLinkNode t5 = new TreeLinkNode(5);
        t2.right = t3;
        t3.right = t4;
        t4.right = t5;
        t5.next = t4;
        t4.next = t3;
        t3.next = t2;
        ArrayList<TreeLinkNode> treeLinkNodes = new ArrayList<>(7);
        treeLinkNodes.add(t2);
        treeLinkNodes.add(t3);
        treeLinkNodes.add(t4);
        treeLinkNodes.add(t5);

        for(TreeLinkNode treeLinkNode : treeLinkNodes){
            System.out.println(treeLinkNode);
            TreeLinkNode res = solution.GetNext(treeLinkNode);
            System.out.println((res!=null?res:"null")+"\n!!!!!!!!!!!!!!!!!!!!!");
        }
    }
}
