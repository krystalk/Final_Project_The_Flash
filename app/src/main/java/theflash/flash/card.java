package theflash.flash;

public class card //a card class for each flashcard
{
    private String ans; //string answer of the flashcard
    private String ques; //string question of the flashcard

    public card(String answer, String question) //card constructor that takes string inputs for the answer and question
    {
        ans = answer; //sets card ans variable equal to the input answer
        ques = question; //sets card ques variable equal to the input question

    }

   public String getQuestion()
   {
       return ques;
   } //get function for the question that returns the question string
   public String getAnswer()
    {
        return ans;
    } //get function for the answer that returns the answer string

   public void setQuestion(String q)
   {
       ques = q;
   } //set question for the question that sets the ques variable equal to the input string

   public void setAnswer(String a)
   {
       ans = a;
   } //set answer for the answer that sets the ans variable equal to the input string

}
