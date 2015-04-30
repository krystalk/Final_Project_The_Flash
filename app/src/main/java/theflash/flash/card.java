package theflash.flash;

/**
 * Created by rickygomes on 4/27/15.
 */
public class card
{
    private String ans;
    private String ques;

    public card(String answer, String question)
    {
        ans = answer;
        ques = question;

    }

   public String getQuestion()
   {
       return ques;
   }
   public String getAnswer()
    {
        return ans;
    }

   public void setQuestion(String q)
   {
       ques = q;
   }

   public void setAnswer(String a)
   {
       ans = a;
   }

}
