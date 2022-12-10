public class Main {
    public static void main(String[] args) {
        Team<footBall> spain=new Team<>("Spain",30);
        Team<footBall> germany=new Team<>("Germany",40);
        Team<footBall> italy=new Team<>("italy",20);

        Team<cricket> ind=new Team<>("ind",50);
        Team<cricket> pak=new Team<>("pak",30);
        Team<cricket> aus=new Team<>("aus",40);


        League<Team<cricket>> cric=new League<>("World cup");

        cric.addTeam(ind);
        cric.addTeam(pak);
        cric.addTeam(aus);
        cric.table();



        League<Team<footBall>> foot=new League<>("fifa");

        foot.addTeam(germany);
        foot.addTeam(italy);
        foot.addTeam(spain);
        foot.table();
    }
}