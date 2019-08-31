
package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author binchu.liu
 * @date 31/08/2019 16:44
 */
public class xinlang01 {
    class Version implements Comparable {
        int v1;
        int v2;
        int v3;
        int v4;

        public Version(String data) {
            String[] ver = data.split("\\.");
            int[] vers = new int[4];
            for (int i = 0; i < ver.length; i++) {
                vers[i] = Integer.parseInt(ver[i]);
            }
            this.v1 = vers[0];
            this.v2 = vers[1];
            this.v3 = vers[2];
            this.v4 = vers[3];
        }




        @Override
        public int compareTo(Object o) {
            Version other = (Version) o;
            if (v1 != other.v1) {
                return v1 - other.v1;
            }
            if (v2 != other.v2) {
                return v2 - other.v2;
            }
            if (v3 != other.v3) {
                return v3 - other.v3;
            }
            if (v4 != other.v4) {
                return v4 - other.v4;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            if(v1!=0){
                stringBuilder.append(v1);
            }
            if(v2!=0){
                stringBuilder.append(".").append(v2);
            }
            if(v3!=0){
                stringBuilder.append(".").append(v3);
            }
            if(v4!=0){
                stringBuilder.append(".").append(v4);
            }
            return stringBuilder.toString();
        }
    }


    public String getMinVersion(String[] list) {
        // 在这里编写代码
        ArrayList<Version> data = new ArrayList<>(list.length);
        for (int i = 0; i < list.length; i++) {
            data.add(new Version(list[i]));
        }
        Collections.sort(data);
        return data.get(0).toString();
    }

    public static void main(String[] args) {
        xinlang01 solution = new xinlang01();
        String[]data = new String[]{"3", "4.3.5.4", "2.10.3", "2.4"};

        System.out.println( solution.getMinVersion(data));
    }
}
