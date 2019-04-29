import java.util.Scanner;

public class Spiel {

    private Held hero;
    private Karte map;
    Scanner eingabe = new Scanner(System.in);

    Spiel() {
        hero = new Held();
        map = new Karte();
    }

    public void spielStart() {
        map.printMap();
        menu();
    }

    public void menu() {
        System.out.println("---------MENU--------:");
        System.out.println("1. Nach Oben gehen (o)");
        System.out.println("2. Nach Unten gehen (u)");
        System.out.println("3. Nach Rechts gehen (l)");
        System.out.println("4. Nach Links gehen (r)");
        System.out.println("5. Spiel verlassen! (e)");
        System.out.print("Ihre Eingabe :");
        String buchstabe = eingabe.nextLine();
        move(buchstabe);
    }

    public void moveAction(int x, int y) {
        if (map.isWand(hero.posy + y, hero.posx + x)) {
            System.out.println("Du kannst nicht durch die Wand gehen!!!");
            menu();
        }
        //nach Oben
        if (x == 0 && y == -1) {
            map.delHero(hero.posy, hero.posx);
            hero.posy -= 1;
            map.setHero(hero.posy, hero.posx);
        }
        //nach Unten
        if (x == 0 && y == 1) {
            map.delHero(hero.posy, hero.posx);
            hero.posy += 1;
            map.setHero(hero.posy, hero.posx);
        }
        //nach Rechts
        if (x == 1 && y == 0) {
            map.delHero(hero.posy, hero.posx);
            hero.posx += 1;
            map.setHero(hero.posy, hero.posx);
        }
        //nach Links
        if (x == -1 && y == 0) {
            map.delHero(hero.posy, hero.posx);
            hero.posx -= 1;
            map.setHero(hero.posy, hero.posx);
        }
    }

    public void move(String Action) {
        switch (Action) {
            case "o":
                moveAction(0, -1);
                map.printMap();
                menu();
                break;
            case "u":
                moveAction(0, 1);
                map.printMap();
                menu();
                break;
            case "r":
                moveAction(1, 0);
                map.printMap();
                menu();
                break;
            case "l":
                moveAction(-1, 0);
                map.printMap();
                menu();
                break;
            case "e":
                System.exit(0);
                ;
                break;
            default:
                System.out.println("Falsche Eingabe!!!");
                menu();
                break;

        }
    }
}
