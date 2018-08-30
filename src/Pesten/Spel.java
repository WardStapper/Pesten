package Pesten;

import java.util.ArrayList;
import java.util.Scanner;


    public class Spel {

        Deck spelDeck = new Deck();
        ArrayList <Kaart> stapel;
        ArrayList<Kaart> pile = new ArrayList<>();
        Spelers spelerEen = new Spelers();
        Spelers spelerTwee = new Spelers();
        Spelers speleraandeBeurt = spelerEen;
        private boolean spelerZet = false;
        private boolean spelKlaar = false;

    public void  startSpel() {
        spelerEen.spelerNaam = "Speler 1";
        spelerTwee.spelerNaam = "Speler 2";



        stapel = spelDeck.createDeck();
        spelDeck.shuffleDeck(stapel);
        stapel.get(0);
        pile.add(stapel.get(0));
        stapel.remove(0);
        kaartenDelen();
        //spelerEen.handBekijken();
        while(!spelKlaar) {
            while(!spelerZet) {
                keuzeMenu(speleraandeBeurt);
            }
            if(checkWinst(speleraandeBeurt)) {
                spelKlaar = true;
            }
            else {
                spelerWissel();
            }

            //beurt = spel.spelWinst
        }
    }


    public void kaartenDelen() {

        for (int a = 0; a < 5; a++) {
            spelerEen.hand.add(stapel.get(0));
            spelerTwee.hand.add(stapel.get(1));
            stapel.remove(0);
            stapel.remove(0);
        }

    }

    public void neemKaart(Spelers speler) {
        speler.hand.add(stapel.get(0));
        stapel.remove(0);
        spelerZet = true;
    }
    public void kaartLeggen(Kaart kaart, Spelers speler) {
        if((kaart.getCard_id() == pile.get(0).getCard_id() || kaart.getIcon_id() == pile.get(0).getIcon_id()) || kaart.isJoker) {
            pile.add(0, kaart);
            speler.hand.remove(speler.hand.indexOf(kaart));
            if(pile.get(0).isPestKaart == true) {
                pestKaart(pile.get(0));
            }
            spelerZet = true;

        }
        else {
            System.out.println("Die kaart kan niet op de pile.");
        }
        //System.out.println(pile.get(0).getFullCard_name() + " ligt bovenop de pile");

    }

    public void kaartKiezen(Spelers speler) {
        System.out.println("Kies een kaartnummer");
        int keuze = userInput();
        kaartLeggen(speler.hand.get(keuze-1), speler);

    }

    public void keuzeMenu(Spelers speler) {
        System.out.println(drawLine());
        System.out.println(speler.spelerNaam + " heeft de volgende kaarten: ");
        speler.handBekijken();
        System.out.println(pile.get(0).getFullCard_name() + " ligt boven op de pile");
        System.out.println("Kies 1 van de volgende opties:");
        System.out.println("1: Kaart leggen");
        System.out.println("2: Kaart pakken");
        switch (userInput()) {
            case 1: kaartKiezen(speler); break;
            case 2: neemKaart(speler); break;
            default: System.out.println("Dit is geen keuze"); break;
        }
    }
    public void spelerWissel() {
        speleraandeBeurt = speleraandeBeurt.equals(spelerEen) ? spelerTwee : spelerEen;
        System.out.println("Er vindt een speler wissel plaats!");
        spelerZet = false;
    }
    public boolean checkWinst(Spelers speler){
        if(speler.hand.size() == 0) {
            System.out.println(speler.spelerNaam + " heeft het spel gewonnen!");
            return true;
        }
        else {
            return false;
        }
    }

    public void pestKaart(Kaart kaart) {
        switch(kaart.getCard_id()) {
            case 2:
                if(speleraandeBeurt.equals(spelerEen) ) {
                    neemKaart(spelerTwee);
                    neemKaart(spelerTwee);
                    System.out.println("Doordat er een 2 is gespeeld, pakte "+ spelerTwee.spelerNaam +" twee kaarten ");}
                else{
                    neemKaart(spelerEen);
                    neemKaart(spelerEen);
                    System.out.println("Doordat er een 2 is gespeeld, pakte "+ spelerEen.spelerNaam +" twee kaarten ");}

        }
    }
    public int userInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();

    }
    String drawLine() {
        return "--------------------------------------------------------------------------------";
    }

}