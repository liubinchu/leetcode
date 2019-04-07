package com.leetcode;

import java.util.*;

/**
 * @author liubi
 * @date 2019-04-06 19:57
 **/
public class xukun01 {
    private static int funCore(int start,int end,Map<Integer,Integer> map){
        int resutl = 0;
        int turn = end -start-3;
        for(int k=0;k<turn;k++){
            for(int i=0;i<turn-k;i++){
                int res = 1;
                for(int j=start;j<start+5+k;j++){
                    res *= map.get(j);
                }
                resutl +=res;
            }
        }
        return resutl;
    }
    private static void  fun(int n,int[] data){
        Arrays.sort(data);
        Map<Integer,Integer> map = new HashMap<>();
        for(int pocker:data){
            if(map.containsKey(pocker)){
                map.put(pocker,map.get(pocker)+1);
            }
            else {
                map.put(pocker,1);
            }
        }
        int result = 0;
        int start = 0;
        int len = -1;
        int dupNum =0;
        for(int i=1;i<n;i++){
            if(data[i]==data[i-1]){
                dupNum++;
            }
            if(data[i]-data[i-1]>1){
                len = i-1-dupNum;
                if(len -start >=4){
                    result +=funCore(start,len,map);
                }
                start = i-dupNum;
                len = -1;
            }
        }
        len = n-1-dupNum;
        if(len -start >=4){
            result +=funCore(data[start],data[start]+len,map);
        }
        System.out.println(result);
    }
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int instanceNum = Integer.parseInt(in.nextLine());

/*        int instanceNum  =1;*/
        for(int i=0;i<instanceNum;i++){
            int num = Integer.parseInt(in.nextLine());
            String data = in.nextLine();
/*int num = 5;
String data = "A 2 3 4 5";*/

            int[] pockers = new int[num];
            ArrayList<Pair<Integer,Integer>> pockersUnique = new ArrayList<>();
            String[] data1 = data.split(" ");
            for(int j=0;j<num;j++){
                if(data1[j].charAt(0)<='9'&&data1[j].charAt(0)>='0'){
                    pockers[j] = data1[j].charAt(0)-'0';
                }
                else if (data1[j].charAt(0) <='Z'&& data1[j].charAt(0)>='A'){
                    pockers[j] =data1[j].charAt(0) -'A'+1;
                }
            }
            fun(num,pockers);
        }
    }
}
