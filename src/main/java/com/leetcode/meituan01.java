package com.leetcode;

import java.util.*;

/**
 * @author liubi
 * @date 2019-08-23 00:48
 **/
public class meituan01 {


    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //String str = in.nextLine();
        //in.close();
        String str = "MPMPCPMCMDEFEGDEHINHKLIN";
        char[] cs = str.toCharArray();
        class MyMap {
            char c;
            LinkedList<Integer> ls;

            public MyMap(char c) {
                this.c = c;
                this.ls = new LinkedList<Integer>();
            }
        }
        class Item {
            int start;
            int end;

            public Item(int start, int end) {
                super();
                this.start = start;
                this.end = end;
            }

        }
        ;
        MyMap[] map = new MyMap[26];
        for (int i = 0; i < cs.length; i++) {
            if (map[cs[i] - 'A'] == null) {
                map[cs[i] - 'A'] = new MyMap(cs[i]);
                map[cs[i] - 'A'].ls.add(i);
            } else {
                map[cs[i] - 'A'].ls.add(i);
            }
        }
        List<Item> rls = new ArrayList<Item>();
        for (MyMap mp : map) {
            if (mp != null) {
                rls.add(new Item(mp.ls.peekFirst(), mp.ls.peekLast()));
            }

        }
        Collections.sort(rls, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                // TODO Auto-generated method stub
                return o2.end - o1.end;
            }
        });

        LinkedList<Integer> ls = new LinkedList<Integer>();
        int l = rls.get(0).start;
        int r = rls.get(0).end;
        while (!rls.isEmpty()) {
            rls.remove(0);
            while (!rls.isEmpty() && rls.get(0).end > l) {
                l = Math.min(l, rls.get(0).start);
                rls.remove(0);
            }
            ls.addFirst(r - l + 1);
            if (rls.isEmpty()) {
                break;
            }
            l = rls.get(0).start;
            r = rls.get(0).end;
        }
        Iterator<Integer> it = ls.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

    }

}
