import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final double orbitalPeriod;
    private final  Set<HeavenlyBody> satillites;

    private final Key key;

    public enum BodyTypes{
        PLANET,
        DWARF_PLANET,
        MOON;

    }
    public HeavenlyBody(String name, double oribitalPeriod, BodyTypes bodyTypes){
        this.orbitalPeriod=oribitalPeriod;
        satillites =new HashSet<>();
        this.key=new Key(name,bodyTypes);
    }

    public boolean addSatillite(HeavenlyBody moon){
        if(this.satillites.contains(moon)){
            return false;
        }
        else{
            this.satillites.add(moon);
            return true;
        }
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Key getKey() {
        return key;
    }

    public static Key  makeKey(String name, BodyTypes bodyTypes){
        return new Key(name,bodyTypes);
    }

    public String toString(){
        return this.key.getName()+": "+this.key.getBodyTypes()+" "+this.getOrbitalPeriod();
    }

    @Override
    public boolean equals (Object obj){
        if(this==obj){
            return true;
        }
        if(obj instanceof HeavenlyBody){
            this.key.equals(((HeavenlyBody) obj).getKey());
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.key.hashCode();
    }


    public Set<HeavenlyBody> getSatillites() {
        return new HashSet<>(this.satillites);
    }

    public static class Key{
        private  String name;
        private BodyTypes bodyTypes;
        public Key(String name, BodyTypes bodyTypes){
            this.name=name;
            this.bodyTypes=bodyTypes;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyTypes() {
            return bodyTypes;
        }
        @Override
        public boolean equals(Object obj){
            Key mykey=(Key) obj;
            if(this.getName()==mykey.getName()){
                return this.getBodyTypes()==((Key) obj).getBodyTypes();
            }
            return false;
        }

        @Override
        public int hashCode(){
            return this.name.hashCode()+33+this.bodyTypes.hashCode();
        }

        @Override
        public String toString(){
            return this.name+": "+this.bodyTypes;
        }
    }

}
