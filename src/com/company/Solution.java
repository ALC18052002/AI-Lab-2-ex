package com.company;

import java.util.*;

public class Solution
{
    private ArrayList<State> visited = new ArrayList<>();

    private Queue<State> queue = new LinkedList<State>();

    private ArrayList<Transitions> sol = new ArrayList<>();

    private ArrayList<Transitions> enumList ;

    public void BKT(State s)
    {
        enumList = new ArrayList<>();
        for (Transitions t :
             Transitions.values()) {
            enumList.add(t);
        }
        BKT1(s, 0);
    }

    public void BFS(State s)
    {
        queue.add(s);
        visited.add( s.copyState() );
        while ((s = queue.poll())!= null)
        {
            System.out.println(s);
            if(s.isFinal()) System.out.println( "SOLUTIIE^^^");
            State aux = s.copyState();
            if(aux.Transition(Transitions.EMPTY_N) && !visited.contains(aux))
            {
                queue.add(aux);
                visited.add(aux);
            }
            aux = s.copyState();
            if(aux.Transition(Transitions.EMPTY_M) && !visited.contains(aux))
            {
                queue.add(aux);
                visited.add(aux);
            }
            aux = s.copyState();
            if(aux.Transition(Transitions.FILL_N) && !visited.contains(aux))
            {
                queue.add(aux);
                visited.add(aux);
            }
            aux = s.copyState();
            if(aux.Transition(Transitions.N_TO_M) && !visited.contains(aux))
            {
                queue.add(aux);
                visited.add(aux);
            }
            aux = s.copyState();
            if(aux.Transition(Transitions.M_TO_N) && !visited.contains(aux))
            {
                queue.add(aux);
                visited.add(aux);
            }
        }
    }

    private void BKT1(State s, int k)
    {
        for(int i = 0 ; i < enumList.size() ; ++ i)
        {
            sol.add(k, enumList.get(i));
            State aux = s.copyState();
            if(aux.Transition(enumList.get(i)) && !visited.contains(aux))
            {
                if(aux.isFinal())
                {
                    System.out.println(aux + " " + sol);

                }
                else
                {
                    visited.add(aux.copyState());
                    BKT1(aux.copyState(), k+1);
                }
            }
        }
    }
}
