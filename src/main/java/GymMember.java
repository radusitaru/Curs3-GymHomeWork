import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class GymMember {

    private final String memberName;
    private final LocalDate birthdate;
    private int hoursLeftOnSubscription = 50;
    private String category;
    private int age;

    public GymMember(String name, LocalDate birthdate) {
        this.memberName = name;
        this.birthdate = birthdate;
        this.age = (int) ChronoUnit.YEARS.between(getBirthdate(), LocalDate.now());
    }

    public String getMemberName() {
        return memberName;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public int getHoursLeftOnSubscription() {
        return hoursLeftOnSubscription;
    }

    public void addHoursToSubscription(int hours) {
        hoursLeftOnSubscription = hoursLeftOnSubscription + hours;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void subtractHoursToSubscription(int hours) {
        hoursLeftOnSubscription = hoursLeftOnSubscription - hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GymMember gymMember = (GymMember) o;
        return hoursLeftOnSubscription == gymMember.hoursLeftOnSubscription && age == gymMember.age && Objects.equals(memberName, gymMember.memberName) && Objects.equals(birthdate, gymMember.birthdate) && Objects.equals(category, gymMember.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberName, birthdate, hoursLeftOnSubscription, category, age);
    }

    @Override
    public String toString() {
        return "memberName='" + memberName + '\'' +
                ", birthdate=" + birthdate +
                ", hoursLeftOnSubscription=" + hoursLeftOnSubscription +
                ", category='" + category + '\'' +
                ", age=" + age +
                '}';
    }

}
