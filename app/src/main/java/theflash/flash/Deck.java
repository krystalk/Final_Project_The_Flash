package theflash.flash;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by rickygomes on 4/27/15.
 */
public class Deck
{
    private ArrayList<card> deck1;
    private ArrayList<card> deck2;

    public Deck()
    {
        deck1 = new ArrayList<card>();
        deck2 =new ArrayList<card>();
    }


    public int getSize()
    {
        return (deck1.size()+ deck2.size());
    }

    public void deckClear()
    {
        deck1 = new ArrayList<card>();
        deck2 = new ArrayList<card>();
    }

    public void addCard(card newCard)
    {
        deck1.add(newCard);
    }

    public String deckSave()
    {
        String deck= new String();
        for(int i = 0;i<deck1.size();i++)
        {
            card temp = deck1.get(i);
            deck += (temp.getQuestion()+"\n"+temp.getAnswer()+"\n");
        }
        for(int i = 0; i<deck2.size(); i++)
        {
            card temp = deck2.get(i);
            deck += (temp.getQuestion()+"\n"+temp.getAnswer()+"\n");
        }
        return deck;
    }

    public card getCard(boolean x)
    {
        if(deck1.size() == 0)
        {
            if(deck2.size()==0)
            {
                return null;
            }
            deck1 = deck2;
            deck2 = new ArrayList<card>();
            return getCard(x);

        }
        else if(x)
        {
            Random y = new Random();
            card temp = deck1.remove(y.nextInt(deck1.size()));
            deck2.add(temp);
            return temp;
        }
        else
        {
            card temp = deck1.remove(0);
            deck2.add(temp);
            return temp;
        }

    }


}
