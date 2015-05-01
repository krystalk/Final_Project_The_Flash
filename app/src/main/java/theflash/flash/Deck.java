package theflash.flash;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Deck //the Deck class that makes vectors of cards from the card class
{
    private ArrayList<card> deck1; //makes a vector of cards called deck1 (the main deck)
    private ArrayList<card> deck2; //makes a vector of cards called deck2 (the deck of cards that have been viewed already)

    public Deck() //the Deck constructor
    {
        deck1 = new ArrayList<card>(); //makes a dynamic vector of cards for deck1
        deck2 = new ArrayList<card>(); //makes a dynamic vector of cards for deck2
    }


    public int getSize()
    {
        return (deck1.size()+ deck2.size());
    } //the get size function returns the total size of the deck by summing up deck1 (cards that haven't been viewed) and deck2 (cards that have been viewed)

    public void deckClear() //function that clears the deck
    {
        deck1 = new ArrayList<card>(); //makes a new dynamic vector of cards for deck1
        deck2 = new ArrayList<card>(); //makes a new dynamic vector of cards for deck2
    }

    public void addCard(card newCard)
    {
        deck1.add(newCard);
    } //the add card function that adds a new card to deck1 (cards that haven't been viewed yet)

    public String deckSave() //function that saves the deck
    {
        String deck = new String();
        for(int i = 0;i<deck1.size();i++)
        {
            card temp = deck1.get(i); //makes a temporary card equal to the current card in deck1 (as it iterates through the loop)
            deck += (temp.getQuestion()+"\n"+temp.getAnswer()+"\n"); //adds the current card to the deck
        }
        for(int i = 0; i<deck2.size(); i++)
        {
            card temp = deck2.get(i); //makes a temporary card equal to the current card in deck2 (as it iterates through the loop)
            deck += (temp.getQuestion()+"\n"+temp.getAnswer()+"\n"); //adds the current card to the deck
        }
        return deck; //returns the deck of all the cards
    }

    public card getCard(boolean x) //the get card function gets the next flashcard to be viewed from deck1
    {
        if(deck1.size() == 0) //if deck1 is empty
        {
            if(deck2.size()==0) //if deck2 is empty as well, then the function doesn't do anything
            {
                return null;
            }
            deck1 = deck2; //otherwise, if deck1 is empty, then deck1 is set to deck2 (reset so that the all the cards can be viewed again)
            deck2 = new ArrayList<card>(); //deck2 is cleared
            return getCard(x); //calls the get card function to get the next card from deck

        }
        else if(x) //if get card function is called with a true input
        {
            Random y = new Random();
            card temp = deck1.remove(y.nextInt(deck1.size())); //makes a temporary card equal to the viewed card and removes the card from deck1
            deck2.add(temp); //adds the temporary (viewed) card to deck2
            return temp; //returns the viewed card to be viewed
        }
        else //if get card function is called with a false input
        {
            card temp = deck1.remove(0); //makes a temporary card equal to the viewed card and removes that card from deck1
            deck2.add(temp); //adds the temporary (viewed) card to deck2
            return temp; //returns the viewed card to be viewed
        }

    }


}
