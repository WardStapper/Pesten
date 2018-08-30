package Pesten;

import java.util.ArrayList;
import java.util.Collections;


public class Deck {
    ArrayList<Kaart> createDeck(){

        ArrayList<Kaart> Deck = new ArrayList();
        CARDNUMBER_LOOP :	for(int i = 2; i < 15; i++) { //loop om alle kaarten values te creeeren (2 t/m Aas)
            ICON_LOOP : for(int j = 0; j < 4; j++) { //loop om elke kaart value 4 soorten te geven (Harten, Schoppen enz)
                Kaart next = new Kaart();
                next.setCard_id(i); //laat het programma onthouden welke kaart value de kaart heeft
                next.setIcon_id(j); // laat het programma onthouden welke soort kaart het is
                Deck.add(next); // voeg de kaart toe aan het deck, herhaal dit voor alle kaarten die gemaakt worden
            }
        }
        for(int k = 0; k < 2; k++) {
            Kaart joker = new Kaart();
            joker.isJoker = true;
            joker.setCard_id(15);
            joker.card_name = "Joker";
            Deck.add(joker);
        }
        return Deck;

    }

    public void shuffleDeck(ArrayList<Kaart> deck) {
        Collections.shuffle(deck);

    }
}