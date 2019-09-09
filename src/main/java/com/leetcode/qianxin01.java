package com.leetcode;

import java.util.*;

public class qianxin01 {
    static List<Integer> res = new ArrayList<>();

    private static void kill(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            map.put(pid.get(i), new Node(pid.get(i)));
        }
        for (int i = 0; i < ppid.size(); i++) {
            if (ppid.get(i) != 0) {
                map.get(ppid.get(i)).children.add(map.get(pid.get(i)));
            }
        }
        dfsCore(map.get(kill), res);
    }

    public static void dfsCore(Node node, List<Integer> res) {
        if (node == null)
            return;
        res.add(node.pid);
        for (Node n : node.children) {
            dfsCore(n, res);
        }
    }

    private static class Node {
        private int pid;
        private List<Node> children = new ArrayList<>();

        public Node(Integer id) {
            this.pid = id;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pidList = sc.nextLine();
        String ppidList = sc.nextLine();
        List<Integer> pids = new ArrayList<>();
        List<Integer> ppids = new ArrayList<>();
        int target = sc.nextInt();
        Map<Integer, Process> processes = new HashMap<>();
        for (String pidS : pidList.split(" ")) {
            pids.add(Integer.parseInt(pidS));
        }
        for (String ppidS : ppidList.split(" ")) {
            ppids.add(Integer.parseInt(ppidS));
        }
        kill(pids, ppids, target);
        System.out.println(res.size());
    }
}
