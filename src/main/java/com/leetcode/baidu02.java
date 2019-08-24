package com.leetcode;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author liubi
 * @date 2019-04-02 20:39
 **/
public class baidu02 {

    public static  class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this(val);
            this.left = left;
            this.right = right;
        }
    }


    public static TreeNode conTree(int numNodes, List<Integer> values,
                                   List<List<Integer>> edges) {
        List<TreeNode> treeNodes = new ArrayList<>(values.size());
        for (int i = 0; i < values.size(); i++) {
            treeNodes.add(new TreeNode(values.get(i)));
        }
        for (List<Integer> edge : edges) {
            TreeNode node1 = treeNodes.get(edge.get(0)-1);
            TreeNode node2 = treeNodes.get(edge.get(1)-1);
            if (node1.left == null) {
                node1.left = node2;
            } else if (node1.right == null) {
                node1.right = node2;
            } else {
                // duplicate edge
            }
        }
        return treeNodes.get(0);
    }
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        List<String> synList = Collections.synchronizedList(list);


    }
}

// METHOD SIGNATURE ENDS

