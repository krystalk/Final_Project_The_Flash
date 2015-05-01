package theflash.flash;

/**
 * Created by Krystal on 4/28/2015.
 */
public class scoring { //the scoring class
    public int right; //integer variable for the number of cards gotten right
    public int wrong; //integer variable for the number of cards gotten wrong

    public scoring() //the scoring constructor
    {
        right=0; //sets the initial number of cards gotten right equal to 0
        wrong=0; //sets the initial number of cards gotten wrong equal to 0
    }

    public String getRight()
    {
        return (Integer.toString(right));
    } //the get right function returns a string of the number of cards gotten right

    public String getWrong()
    {
        return (Integer.toString(wrong));
    } //the get wrong function returns a string of the number of cards gotten wrong

    public void incRight()
    {
        right=right+1;
    } //the inc right function increments the number of cards gotten right by 1

    public void incWrong()
    {
        wrong=wrong+1;
    } //the inc wrong function increments the number of cards gotten wrong by 1
}
