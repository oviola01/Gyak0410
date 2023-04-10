
package Gyak0410;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Gyak0410 {

    static Random rnd = new Random();

    public static void main(String[] args) {
        System.out.print("háló!!!!!");
        int szamom = rnd.nextInt(20) - 5;
        System.out.print(szamom);
        //base
        int[] tomb = tombLetrehozas(10);
        //elso feladat
        Gyak0410.kiirEredmeny(tomb);
        //masodik feladat
        tartalmazCheck(tomb, 13);
        //harmadik feladat
        int sorSzam = mitKeres(tomb);
        abszolutOsztoi(sorSzam);
    }

    public static int[] tombLetrehozas(int qty) {
        int[] tomb = new int[qty];
        for(int i = 0; i < qty; i++) {
            tomb[i] = rnd.nextInt(20) - 5;
        }
        return tomb;
    }
    
    public static void kiirEredmeny(int[] tomb) {
        String tombSzovegkent = "";
        for (int i = 0; tomb.length < i; i++) {
            tombSzovegkent += tomb[i];
            if (i < tomb.length - 1) {
                tombSzovegkent += ", ";
            }
        }
        System.out.println(tombSzovegkent);
    }
    
    public static void kiirEredmeny(ArrayList<Integer> lista) {
        String listaSzovegkent = "";
        for (int i = 0; lista.size() < i; i++) {
            listaSzovegkent += lista.get(i);
            if (i < lista.size() - 1) {
                listaSzovegkent += ", ";
            }
        }
        System.out.println(listaSzovegkent);
    }

    private static void tartalmazCheck(int[] tomb, int szam) {
        boolean benneVan = false;
        int i = 0;
        while (tomb.length < i  && benneVan == false) {
            if (tomb[i] == szam){
            benneVan = true;
            }
            i++;
        }
        if(benneVan == true) {
            System.out.printf("A %d benne van a tömbben", szam);
        }
        else {
            System.out.printf("A %d nincs benne a tömbben", szam);
        }
    }

    private static int mitKeres(int[] tomb) {
        boolean oke = false;
        Scanner sc = new Scanner(System.in, "latin2");
        System.out.println("Kérlek add meg, hanyadik szám érdekel!");
        int szam = sc.nextInt();
        sc.nextLine();
        while(oke == false) {
            if (szam > tomb.length -1) {
                System.out.println("Kérlek adj meg egy másik értéket!");
                szam = sc.nextInt();
                sc.nextLine();
            }
            else {
                oke = true;
            }
        }
        return szam;
    }

    private static void abszolutOsztoi(int sorSzam) {
        if (sorSzam < 0) {
            sorSzam = sorSzam * -1;
        }
        ArrayList<Integer> osztok = new ArrayList<>();
        for (int i = 2; i < sorSzam; i++) {
            if (sorSzam % i == 0) {
                osztok.add(i);
            }
        }
        if (osztok.size() < 1) {
            System.out.println("prím szám");
        }
        else {
            System.out.println("Az általad választott szám osztói: ");
            kiirEredmeny(osztok);
        }    
    }
}
