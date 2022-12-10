import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class SoloarSystem {
    private static Set<HeavenlyBody> planets;
    private static Map<HeavenlyBody.Key,HeavenlyBody> solarSystem;
    private static Set<HeavenlyBody> moons;
    public static void main(String[] args){
        planets=new HashSet<>();
        HeavenlyBody earth=new Planet("Earth",365 );
        earth.addSatillite(new Planet("monn",20));
        planets.add(earth);

        HeavenlyBody jupiter=new Planet("Jupiter",700);
        jupiter.addSatillite(new Planet("titan",20));
        jupiter.addSatillite(new Planet("mitan",40));
        planets.add(jupiter);

        HeavenlyBody newjup =new Planet("Jupiter",7236476);
        planets.add(newjup);


        for (HeavenlyBody items:planets
             ) {
            System.out.println(items.getKey().getName()+"--->"+items.getOrbitalPeriod());
        }
        solarSystem=new HashMap<>();
        for(HeavenlyBody item:planets){
            solarSystem.put(jupiter.getKey(),jupiter);
        }
        for (HeavenlyBody moon:moons) {
            System.out.println(moon.getKey().getName());
        }
    }

}
