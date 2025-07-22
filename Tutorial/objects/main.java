package Tutorial.objects;

public class main {
    public static void main(String[] args){
        Level lvl = Level.LOW;
        System.out.println("Current level: " + lvl.getLvl());
        System.out.println(Level.valueOf(("MEDIUM")));
        lvl.setLvl(5);
        
        Level[] levels = Level.values();
        for(Level level: levels){
            System.out.println("Available level: " + level);
        }
    }
}
