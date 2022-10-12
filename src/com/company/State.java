package com.company;

public class State
{
    public int n ;
    public int m ;
    public int k ;
    public int capacitate_n;
    public int capacitate_m;
    boolean initialized;

    public State()
    {
        initialized = false;
    }

    public void Initialize(int n , int m , int k )
    {
        initialized = true;
        this.n = n;
        this.m = m;
        this.k = k;
        this.capacitate_m = 0;
        this.capacitate_n = 0;
    }

    public boolean isFinal()
    {
        return (capacitate_m == k ) || (capacitate_n == k);
    }

    public boolean solutionIsPosible()
    {
        return (primeBetween() && ( k <= n ) && ( k <= m ));
    }

    private boolean primeBetween()
    {
        int x = n, y = m;
        int r = n % m;
        while(x * y != 0)
        {
            x = y;
            y = r;
            if ( y != 0 ) r= (x % y) ;
        }
        return (x == 1);
    }

    public boolean Transition (Transitions T)
    {
        if (initialized == false)
            return false;

        boolean isValid;

        switch (T)
        {
            case FILL_M:
                isValid = canFillM();
                if (isValid) capacitate_m = m;
                break;

            case FILL_N:
                isValid = canFillN();
                if (isValid) capacitate_n = n;
                break;

            case EMPTY_M:
                isValid = canEmptyM();
                if (isValid) capacitate_m = 0;
                break;

            case EMPTY_N:
                isValid = canEmptyN();
                if (isValid) capacitate_n = 0;
                break;

            case M_TO_N:
                isValid = canEmptyM() && canFillN();
                if (isValid)
                {
                    int tranzitie = Math.min(capacitate_m, (n - capacitate_n));
                    capacitate_m -= tranzitie;
                    capacitate_n += tranzitie;
                }
                break;

            case N_TO_M:
                isValid = canFillM() && canEmptyN();
                if (isValid)
                {
                    int tranzitie = Math.min(capacitate_n, (m - capacitate_m));
                    capacitate_m += tranzitie;
                    capacitate_n -= tranzitie;
                }
                break;

            default:
                isValid = false;
                break;
        }

        return isValid;
    }

    private boolean canFillM()
    {
        return capacitate_m < m;
    }

    private boolean canFillN()
    {
        return capacitate_n < n;
    }

    private boolean canEmptyM()
    {
        return capacitate_m > 0;
    }

    private boolean canEmptyN()
    {
        return capacitate_n > 0;
    }
}
