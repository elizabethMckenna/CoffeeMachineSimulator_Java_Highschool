/**
 * Elizabeth McKenna
 * Coffee Klatsch
 * Mimic a coffee shop experience, where user must specify their name, size, and strength of coffee,
 * as well as use the menu to perform actions on the coffee machine and cup in order to 
 * prepare the machine to brew coffee, and also to pour and drink the coffee in a cup. 
 * The amount of coffee is kept track of, and different sizes of coffee use different amounts of the brewed coffee
 * the MACHINE menu shows status of the coffee machine and cup.
 */




import java.util.Scanner;

public class CoffeeKlatsch {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        //VARIABLES TO DETERMINE CUSTOMER PREFERENCE
        boolean customerNew = true; //serve a new customer
        char s; //coffee strength
        String n; // cup name
        char h; // cup size
        String c; //menu choice
        //makes sure that valid size and strength has been chosen by customer
        boolean sizeSet = false;
        boolean strengthSet = false;
        //control looping and 
        int menu = 1; // looping variable to keep running program
        

        //INITIALIZE COFFEE CUP AND COFFEE MACHINE
        CoffeeMachine cm = new CoffeeMachine();
        CoffeeCup cup = new CoffeeCup ();
        
        
        //USER INTERFACE TO INTERACT WITH CUPS & MACHINE
        while (menu == 1){
            if (customerNew == true){
                while (sizeSet == false || strengthSet == false){
                    //reset whether size and strength have been set
                    sizeSet = false; strengthSet = false;
                    cup.isFull = false;
                    System.out.print("Welcome to the coffeeKLATSCH\nWhat is your name?  ");
                    n = keyboard.nextLine();
                    cup.getName(n);
                    System.out.print("What size would you like? (s)mall,  (m)edium, (l)arge:   ");
                    h = keyboard.nextLine().charAt(0);
                    cm.getCupSize(cup, h);
                    if (h == 's' || h == 'm' || h == 'l'){
                        sizeSet = true;
                    }
                    System.out.print("How do you like your coffee?  (w)eak,  (r)egular,  (s)trong,  (k)iller intense:  ");
                    s = keyboard.nextLine().charAt(0);
                    cm.setStrength(s);
                    if (s == 'w' || s == 'r' || s == 's' || s == 'k'){
                        strengthSet = true;
                    }
                }
                //once handled properly, customer no longer is new
                customerNew = false;
            }
        
            //DISPLAY STATE AND STATUS OF COFFEE MACHINE AND BREWED COFFEE
                System.out.println("\t\t\t\tMACHINE\t\t\tUSER: " + cup.name + "\tCup Size: " + cm.size);
                System.out.println("\tWater\tCoffeeLevel\tBeans\tBeansGround\tCoffeeBrewed\tCupFull\tStrength");
                System.out.println("\t" + cm.waterAdded + "\t" + cm.coffeeLevel + "\t\t" + cm.beansAdded + "\t" + cm.beansGround + "\t\t" + cm.coffeeBrewed + "\t\t" + cup.isFull + "\t" + cm.strength );
        
            //DISPLAY OPTIONS & ACTIONS WITH MACHINE
                System.out.print("OPTIONS: \n\t n - New Customer \n\t w - Add Water \n\t b - Add Coffee Beans \n\t g - Grind Beans \n\t r - Brew Coffee \n\t p - Pour a Cup \n\t d - Drink a Cup \n\t x - Exit \n\t\t YOUR CHOICE?  ");
                //get and safe user choice
                c = keyboard.nextLine();
                char choice = c.charAt(0);
            
            //CALL ACTIONS FOR EACH MENU OPTION
            switch (choice) {
                case 'n':                   //new customer
                    customerNew = true;
                    sizeSet = false;
                    strengthSet = false;
                    break;
                case 'w':                   // add water
                    cm.addWater();
                    break;
                case 'b':                   //add beans
                    cm.addBeans();
                    break;
                case 'g':                   //grind beans
                    cm.grindBeans();
                    break;
                case 'r':                   //brew coffee
                    cm.brew(cup);
                    break;
                case 'p':                   //pour coffee
                    cm.pour(cup);
                    break;
                case 'd':                   //drink coffee in cup
                    cup.drink();
                    break;
                case 'x':                   //exit the klatch
                    if ((cup.name).equalsIgnoreCase("Elvis")){
                        System.out.println("ELVIS HAS LEFT THE BUILDING!");
                    }
                    else{
                        System.out.println(cup.name + " has left the Coffee Klatch!");
                    }
                    menu = 0;
                    break;
                default:                    //if user chooses non-menu option
                    System.out.println("Please Choose an Option off the Menu");
                    break;
            }
        }
    }
}
