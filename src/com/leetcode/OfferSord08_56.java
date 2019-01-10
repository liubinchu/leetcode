package com.leetcode;

import java.util.ArrayList;

/**
 * @author liubi
 * @date 2019-01-08 12:39
 **/
public class OfferSord08_56 {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
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
    public static void main(String[] args) {
        OfferSord08_56 solution = new OfferSord08_56();
        TreeLinkNode t5 = new TreeLinkNode(5);
        TreeLinkNode t6 = new TreeLinkNode(6);
        TreeLinkNode t7 = new TreeLinkNode(7);
        TreeLinkNode t8 = new TreeLinkNode(8);
        TreeLinkNode t9 = new TreeLinkNode(9);
        TreeLinkNode t10 = new TreeLinkNode(10);
        TreeLinkNode t11 = new TreeLinkNode(11);
        t5.left =t6;
        t5.right = t9;
        t6.next = t5;
        t6.left = t7;
        t6.right = t8;
        t9.next = t5;
        t9.left = t10;
        t9.right = t11;
        t7.next = t6;
        t8.next = t6;
        t10.next = t9;
        t11.next = t9;
        ArrayList<TreeLinkNode> treeLinkNodes = new ArrayList<>(7);
        treeLinkNodes.add(t5);
        treeLinkNodes.add(t6);
        treeLinkNodes.add(t7);
        treeLinkNodes.add(t8);
        treeLinkNodes.add(t9);
        treeLinkNodes.add(t10);
        treeLinkNodes.add(t11);
        for(TreeLinkNode treeLinkNode : treeLinkNodes){
            System.out.println(treeLinkNode);
            TreeLinkNode res = solution.GetNext(treeLinkNode);
            System.out.println((res!=null?res:"null")+"\n!!!!!!!!!!!!!!!!!!!!!");
        }
    }
}
