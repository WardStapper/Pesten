package Pesten;

import java.util.ArrayList;

public class Spelers {
    ArrayList<Kaart> hand  = new ArrayList<>();
    String spelerNaam;
    public Spelers() {

    }


    public void handBekijken()	{
        for (int a = 0; a < hand.size(); a++) {
            System.out.println((a+1) + ". " + hand.get(a).getFullCard_name());
        }}

}