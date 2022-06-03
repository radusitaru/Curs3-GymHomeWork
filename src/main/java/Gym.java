import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class Gym {

    private final String gymName;
    private List<GymMember> gymMemberList = new ArrayList<>() {
    };

    public Gym(String gymName) {
        this.gymName = gymName;
    }

    public void addGymMember(String memberName, int year, int month, int day) {
        gymMemberList.add(new GymMember(memberName, LocalDate.of(year, month, day)));
    }

    public int averageMemberAge() {
        long totalYears = 0;
        for (GymMember x : gymMemberList) {
            totalYears = totalYears + x.getAge();
        }
        int averageAge = (int) (totalYears / gymMemberList.size());
        System.out.println("Average age: " + averageAge);
        return averageAge;
    }

    public int maxMemberAge() {
        int maxAge = 0;
        for (GymMember x : gymMemberList) {
            if (x.getAge() > maxAge) {
                maxAge = x.getAge();
            }
        }
        System.out.println("Max age: " + maxAge);
        return maxAge;
    }

    public int minMemberAge() {
        int minAge = 200;
        for (GymMember x : gymMemberList) {
            if (x.getAge() < minAge) {
                minAge = x.getAge();
            }
        }
        System.out.println("Min age: " + minAge);
        return minAge;
    }

    public void addTime(String name, int hoursAdded) {
        for (GymMember x : gymMemberList) {
            if (x.getMemberName().equalsIgnoreCase(name)) {
                x.addHoursToSubscription(hoursAdded);
            }
        }
    }

    public void retrieveInfoAboutMember(String name) {
        for (GymMember x : gymMemberList) {
            if (x.getMemberName().equalsIgnoreCase(name)) {
                System.out.println("Name: " + x.getMemberName());
                System.out.println("BirthDate: " + x.getBirthdate());
                System.out.println("HoursLeftOnSubscription: " + x.getHoursLeftOnSubscription());
            }
        }
    }

    public void generateReport() {
        Map<String, List<GymMember>> groupedList = gymMemberList.stream()
                .collect(groupingBy(Gym::groupingLogics));
        System.out.println(groupedList);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/output-file-inheritance.txt"))) {
            writeLine(writer, groupedList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeLine(BufferedWriter writer, Map<String, List<GymMember>> groupedList) throws IOException {

        writer.write(groupedList.values().toString());
        writer.newLine();
    }

    public void registerTimeSpent(String name, int hoursSpent) {
        for (GymMember x : gymMemberList) {
            if (x.getMemberName().equalsIgnoreCase(name)) {
                x.subtractHoursToSubscription(hoursSpent);
            }
        }
    }

    public static String groupingLogics(GymMember x) {
        if (x.getHoursLeftOnSubscription() >= 30) {
            x.setCategory("Green");
        }
        if (x.getHoursLeftOnSubscription() < 30 && x.getHoursLeftOnSubscription() > 10) {
            x.setCategory("Yellow");
        }
        if (x.getHoursLeftOnSubscription() <= 10) {
            x.setCategory("Red");
        }
        return x.getCategory();
    }


}
