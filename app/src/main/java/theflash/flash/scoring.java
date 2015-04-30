package theflash.flash;

/**
 * Created by Krystal on 4/28/2015.
 */
public class scoring {
    public int right;
    public int wrong;

    public scoring()
    {
        right=0;
        wrong=0;
    }

    public String getRight()
    {
        return (Integer.toString(right));
    }

    public String getWrong()
    {
        return (Integer.toString(wrong));
    }

    public void incRight()
    {
        right=right+1;
    }

    public void incWrong()
    {
        wrong=wrong+1;
    }
}
