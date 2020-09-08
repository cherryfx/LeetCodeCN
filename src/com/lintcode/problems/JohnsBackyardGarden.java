package com.lintcode.problems;

public class JohnsBackyardGarden {

    public static void main(String[] args) {
        JohnsBackyardGarden jbg = new JohnsBackyardGarden();

        jbg.isBuild(10);



    }


    /**
     * @param x: the wall's height
     * @return: YES or NO
     */
    public String isBuild(int x) {
        // write you code here
        boolean[] flags = new boolean[x+1];

        flags[0] = true;

        for(int i=1; i<flags.length; i++) {
            flags[i] = false;
            if(i >= 3 && flags[i-3]) {
                flags[i] = true;
                continue;
            }
            if(i >= 7 && flags[i-7]) {
                flags[i] = true;
            }
        }
        if(flags[x]) {
            return "YES";
        }
        return "NO";
    }
}
