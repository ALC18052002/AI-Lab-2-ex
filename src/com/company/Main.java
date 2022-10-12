package com.company;

public class Main {

    public static void main(String[] args)
    {
	    State state1 = new State();
	    state1.Initialize(3, 4, 1);
	    state1.Transition(Transitions.FILL_M);
	    state1.Transition(Transitions.M_TO_N);
        System.out.println(state1.isFinal());
    }


}
