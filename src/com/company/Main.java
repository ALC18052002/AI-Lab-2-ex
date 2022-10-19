package com.company;

public class Main {

    public static void main(String[] args)
    {
	    State state1 = new State();
	    state1.Initialize(3, 4, 1);
        System.out.println(state1.isFinal());
        Solution sol = new Solution();
        sol.BFS((state1));
        //sol.BKT(state1);
    }



}
