package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        class Gracz {
            String imie;
            String symbol;
            String pozycjaPobrana;

            void pobierzDaneGracza() {
                System.out.println("Podaj swoje imię i wciśnij enter");
                Scanner pobierzImie = new Scanner(System.in);
                imie = pobierzImie.next();
                System.out.println(imie + " wybierz swój symbol do gry czyli o lub x");
                Scanner pobierzSymbol = new Scanner(System.in);
                //można by tu zrobić jakiegoś if, jeżeli pierwszy gracz wybral symbol to
                // drugi dostaje symbol z automatu, no i może jakąs weryfikacje poprawnosci symbolu ale to poźniej
                symbol = pobierzSymbol.next();
                System.out.println(imie + " grasz przy użyciu   " + symbol);
            }

            void miejsceWstawienia(String imie, String symbol) {
                System.out.println(imie + " wybierz pozycje dla swojego znaku podając litere i cyfre");
                Scanner pobierzPozycje = new Scanner(System.in);
                pozycjaPobrana = pobierzPozycje.next();
                System.out.println("wykonało się miejsce wstawienia, pozycjaPobrana = " + pozycjaPobrana);
            }
        }


        class Gra {
            String a1 = "x";
            String a2 = "x";
            String a3 = " ";
            String b1 = " ";
            String b2 = " ";
            String b3 = " ";
            String c1 = " ";
            String c2 = " ";
            String c3 = " ";
            String pozycja = " ";
            String symbol = " ";
            String zwyciezca = " ";
            String z = (a1 + a2 + a3);

            void sprawdzenie() {
                if ((a1 + a2 + a3).equals("xxx") || (b1 + b2 + b3).equals("xxx") || (c1 + c2 + c3).equals("xxx") || (a1 + b1 + c1).equals("xxx") || (a2 + b2 + c2).equals("xxx") || (a3 + b3 + c3).equals("xxx") || (a1 + b2 + c3).equals("xxx") || (a3 + b2 + c1).equals("xxx")) {
                    zwyciezca = "x";
                } else if ((a1 + a2 + a3).equals("ooo") || (b1 + b2 + b3).equals("ooo") || (c1 + c2 + c3).equals("ooo") || (a1 + b1 + c1).equals("ooo") || (a2 + b2 + c2).equals("ooo") || (a3 + b3 + c3).equals("ooo") || (a1 + b2 + c3).equals("ooo") || (a3 + b2 + c1).equals("ooo")) {
                    zwyciezca = "y";
                }
            }
/*  narazie nieużywana ale możnaby tego użyc
            void ktoWygrywa() {
                if (zwyciezca.equals("x")){
                     System.out.println(" BRAWO !!!  WYGRAŁ SYMBOL x");
                    return;
                    }else if (zwyciezca.equals("y")){
                    System.out.println(" BRAWO !!!  WYGRAŁ SYMBOL y:");
                    return;
                    }else {
                    System.out.println("Gramy dalej");
                    }
            }
*/







            void ustawSymbol(String symbolGracza) {
                symbol = symbolGracza;
            }

            void ustawPozycje(String pozycjaGracza) {
                pozycja = pozycjaGracza;
            }

            void wyswietlPole() {
                System.out.println("    1   2   3  ");
                System.out.println("a | " + a1 + " | " + a2 + " | " + a3);
                System.out.println("b | " + b1 + " | " + b2 + " | " + b3);
                System.out.println("c | " + c1 + " | " + c2 + " | " + c3);
            }

            void ustawZmienna(String poz, String symb) {
                System.out.println("poz wynosi " + poz);
                System.out.println("symb wynosi " + symb);
                if (poz.equals("a1")) {
                    a1 = symb;
                } else if (poz.equals("a2")) {
                    a2 = symb;
                } else if (poz.equals("a3")) {
                    a3 = symb;
                } else if (poz.equals("b1")) {
                    b1 = symb;
                } else if (poz.equals("b2")) {
                    b2 = symb;
                } else if (poz.equals("b3")) {
                    b3 = symb;
                } else if (poz.equals("c1")) {
                    c1 = symb;
                } else if (poz.equals("c2")) {
                    c2 = symb;
                } else if (poz.equals("c3")) {
                    c3 = symb;
                }
            }
        }

        //==============================================================================
        //==============================================================================
        // ROZPOCZECIE PROGRAMU

        System.out.println("Graczu pierwszy odpowiedz na pytania");
            Gracz graczA = new Gracz();
        graczA.pobierzDaneGracza();

        System.out.println("Graczu drugi odpowiedz na pytania");
            Gracz graczB = new Gracz();
        graczB.pobierzDaneGracza();

            //wywołać metodę która wyświetla pole gry i wartości
            Gra pustePole = new Gra();
        System.out.println(pustePole.z);
            //dołożyć jakieś lososwanie kto zaczyna



        for(int i = 1; i< 10; i++){
                //jezeli modulo z i wskazuje nieparzyste to wtedy to poniżej
                if (i % 2 != 0) {
                    pustePole.wyswietlPole();
                    graczA.miejsceWstawienia(graczA.imie, graczA.symbol);
                    pustePole.ustawPozycje(graczA.pozycjaPobrana);
                    System.out.println(pustePole.pozycja + " pozycja");
                    System.out.println(graczA.symbol + " symbol");
                    pustePole.ustawZmienna(pustePole.pozycja, graczA.symbol); //ustawiam nowe zmienne w pustym polu chyba
                    pustePole.wyswietlPole();
                } else {
                    //jeżeli parzyste to to poniżej
                    pustePole.wyswietlPole();
                    graczB.miejsceWstawienia(graczB.imie, graczB.symbol);
                    pustePole.ustawPozycje(graczB.pozycjaPobrana);
                    System.out.println(pustePole.pozycja + " pozycja");
                    System.out.println(graczB.symbol + " symbol");
                    pustePole.ustawZmienna(pustePole.pozycja, graczB.symbol); //ustawiam nowe zmienne w pustym polu chyba
                    pustePole.wyswietlPole();
                }
                pustePole.sprawdzenie();
                if (pustePole.zwyciezca.equals("x")){
                    System.out.println(" BRAWO !!!  WYGRAŁ SYMBOL x");
                    return;
                }else if (pustePole.zwyciezca.equals("y")){
                   System.out.println(" BRAWO !!!  WYGRAŁ SYMBOL y:");
                   return;
                }else {
                    System.out.println("Gramy dalej");
                }
        }








    }
}

