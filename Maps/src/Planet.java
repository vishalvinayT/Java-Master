public class Planet extends  HeavenlyBody {
    public Planet(String name,double orbitalPeriod){
        super(name,orbitalPeriod,BodyTypes.PLANET);
    }

    @Override
    public boolean addSatillite(HeavenlyBody body){
        if(body.getKey().getBodyTypes()==BodyTypes.MOON){
            super.addSatillite(body);
            return true;
        }
        else{
            return false;
        }
    }

}
