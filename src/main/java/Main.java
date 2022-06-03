public class Main {
    public static void main(String[] args) {

        Gym xGym = new Gym("xGym");

        xGym.addGymMember("Ionut", 1990, 8, 23);
        xGym.addGymMember("Vlad", 1996, 11, 24);
        xGym.addGymMember("Radu", 1999, 3, 25);

        xGym.minMemberAge();
        xGym.maxMemberAge();
        xGym.averageMemberAge();

        xGym.registerTimeSpent("Radu",30);
        xGym.registerTimeSpent("Ionut",41);

        xGym.retrieveInfoAboutMember("Radu");

        xGym.generateReport();
    }
}
