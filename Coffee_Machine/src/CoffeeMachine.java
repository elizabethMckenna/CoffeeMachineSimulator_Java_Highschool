/* A fancy coffee maker.  Makes coffee of varying strengths. */
/**
 *
 * @author RDCOMP
 */


public class CoffeeMachine {
//for the coffee machine to work, some steps must happen in a specific order.
    //to brew coffee, ground beans and water must be in the maker, strength must be set
    //to grind the beans, whole beans must be in the maker first
    //to pour a cup, the cup must be empty
    
    
    //VARIABLES FOR STEP CHECKS
    boolean beansAdded = false;  // have beans been put in maker
    boolean beansGround = false;  //have beans been ground
    boolean waterAdded = false; //is there water in the tank
    boolean coffeeBrewed = false; //has the coffee been brewed
    int coffeeLevel = 0;  //how much water is in the tank
    String strength = "";
    
    //cup size varibales
    private int small = 2;
    private int medium = 3;
    private int large = 4;
    String size;
    private int sizeNum;
    

    /**
     * Set the strength of the Coffee to s; affects the fineness of the
     * grind.
     * "Weak", "Regular", "Strong", "Killer Intense" are the options for s.
     * @param s Text Description of Strength
     */
    public void setStrength(char s) {
        switch (s) {
            case 'w':               //weak
                strength = "Weak";
                break;
            case 'r':               //regular
                strength = "Regular";
                break;
            case 's':               //strong
                strength = "Strong";
                break;
            case 'k':               //killer intense
                strength = "Killer Intense";
                break;
            default:                //wrong input
                System.out.println("Sorry, no substitutions");
                break;
        }
    }
    
    
    /**
     * Grind the beans for the coffee
     */
    public void grindBeans() {
        //grind beans - only if they are unground in the machine
        if (beansAdded == true && beansGround == false){ 
            beansGround = true;
            System.out.println("Grinding beans for " +
            strength + " coffee.");
            System.out.println("**Beans Ground");
        }
        //beans not in machine yet
        else if (beansAdded == false){
            System.out.println("You need to put the beans in first");
        }
        //when beans are ground already
        else {
            System.out.println("You have already ground the beans");
        }        
    }
    

    /**
     * Brew the coffee into given cup c
     * @param c The cup of coffee to be filled
     */
    public void brew(CoffeeCup c) {
        //if machine is prepared properly
        if (waterAdded == true && beansGround == true){
            System.out.println("Brewing " + strength + " coffee \n");
            //change variable states
            coffeeBrewed = true;        
            waterAdded = false;    
            beansGround = false;
            beansAdded = false;
            coffeeLevel = 10;
            System.out.println("**" + strength + " coffee brewed");
        }
        //if machine not prepared
        else {
            System.out.println("You must finish preparing the machine before you can brew the coffee");
        }
    }
    
    
    /**
     * Pour the coffee into given cup c
     * @param c The cup of coffee to be filled
     */
    public void pour (CoffeeCup c){
        if (coffeeBrewed == true && c.isFull == false && coffeeLevel >= sizeNum){
            System.out.println("Pouring " + strength + " coffee into cup " + c.name + "\n");
            //fill cup and take coffee out of karaf
            c.fill();
            coffeeLevel = coffeeLevel - sizeNum;
            c.isFull = true;
            //if tank becomes empty, set brewed to false
                if (coffeeLevel <= 0){
                    coffeeBrewed = false;
                    coffeeLevel = 0;
                }
            System.out.println("**Cup of coffee poured for " + c.name);
        }        
        else if (coffeeLevel < sizeNum){
            System.out.println("There is not enough coffee left to pour a cup.  Brew some more coffee first");
        }  
        else {
            System.out.println("Your Cup is already full.");
        }  
    }

    
    /**
     * Add water to the machine reservoir
     */
    public void addWater() {
        //add water only if water hasnt been added yet to machine
        if (waterAdded == false ){
            waterAdded = true;
            System.out.println("Adding Water");
            System.out.println("**Water Added");
        }
        else {
            System.out.println("There is already water in the tank\n Coffee Level:" + coffeeLevel);
        }
    }


    /**
     * Add Beans to the Machine
     */
    public void addBeans() {
        if (beansAdded == false){
            beansAdded = true;
            System.out.println("Adding Beans");
            System.out.println("**Beans Added");
        }
        else {
            System.out.println("There are already beans in the machine");
        }
    }
    
    
    /**
     * Get the size of cup that user wants of coffee
     * Affects the amount of coffee taken from karaffe when each cup is poured
     * @param c The cup of coffee for the customer
     * @param h Text description of size wanted
     * "Small", "Medium", "Large" are the options for s.
     */
    public void getCupSize(CoffeeCup c, char h){
       // char x = h.charAt(0);
        if (h == 's'){
            sizeNum = small;
            size = "SMALL";
        }
        else if (h == 'm'){
            sizeNum = medium;
            size = "MEDIUM";
        }
        else if (h == 'l'){
            sizeNum = large;
            size = "LARGE";
        }
        else {
         System.out.println("Sorry, no substitutions");
        }
    }
    
}
