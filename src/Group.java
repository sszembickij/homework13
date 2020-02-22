import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Group {
    private String name;
    private LocalDate start;
    private int countLessons;
    private int frequencyLessonsOfWeek;
    private List<Person> persons = new ArrayList<>();

    public Group(Group otherGroup) {
        this.name = otherGroup.name;
        this.start = otherGroup.start;
        this.countLessons = otherGroup.countLessons;
        this.frequencyLessonsOfWeek = otherGroup.frequencyLessonsOfWeek;
        this.persons.addAll(otherGroup.persons);

    }

    public void printPersons() {
        for (int i = 0; i < persons.size(); i++) {
            System.out.println((i + 1) + ". " + persons.get(i).getSurname());
        }
    }

    public LocalDate getStart() {
        return start;
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public String getInfoGroup() {
        return name + start.format(DateTimeFormatter.ofPattern("dd.MM"));
    }

    public Group(String name, String start, int countLessons, int frequencyLessonsOfWeek) {
        this.name = name;
        this.start = LocalDate.parse(start, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        this.countLessons = countLessons;
        this.frequencyLessonsOfWeek = frequencyLessonsOfWeek;
    }

    public String getStartLastWeek() {
        LocalDate temp = start.plusWeeks(countLessons / frequencyLessonsOfWeek
                + (countLessons % frequencyLessonsOfWeek == 0 ? 0 : 1));
        temp = temp.minusDays(temp.getDayOfWeek().getValue() - 1);
        return temp.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public void removePerson(String surname) {
        for (int i = 0; i < persons.size(); i++) {
            if (surname.equals(persons.get(i).getSurname())) {
                persons.remove(i);
                return;
            }
        }
    }

    public void removePerson(int number) {
        persons.remove(number - 1);
    }

    public boolean containPerson(String surname) {
        for (Person person : persons) {
            if (surname.equals(person.getSurname())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", start=" + start +
                ", countLessons=" + countLessons +
                ", frequencyLessonsOfWeek=" + frequencyLessonsOfWeek +
                ",\npersons=" + persons.toString() +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public void setCountLessons(int countLessons) {
        this.countLessons = countLessons;
    }

    public void setFrequencyLessonsOfWeek(int frequencyLessonsOfWeek) {
        this.frequencyLessonsOfWeek = frequencyLessonsOfWeek;
    }
}
