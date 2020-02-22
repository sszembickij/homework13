import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
    private String surname;
    private String name;
    private String patronymic;
    private LocalDate birthday;

    public Person(Person otherPerson) {
        this.surname = otherPerson.surname;
        this.name = otherPerson.name;
        this.patronymic = otherPerson.patronymic;
        this.birthday = otherPerson.birthday;
    }

    public String getSurname() {
        return surname;
    }

    public Person(String surname, String name, String patronymic, String birthday) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        try {
            this.birthday = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (Exception e) {
            System.out.println("Дата введена неверно!!!");
            this.birthday = null;
            e.printStackTrace();
            return;
        }
    }

    public Person(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public Person(String fullName) {
        String[] arr = fullName.split("\\s+");
        if (arr.length != 3) {
            System.out.println("ФИО введено неверно!!!");
            return;
        }
        this.surname = arr[0];
        this.name = arr[1];
        this.patronymic = arr[2];
    }

    public String getFullName() {
        return this.surname + " " + this.name + " " + this.patronymic;
    }

    public String getShortFullName() {
        return this.surname + " " + this.name.charAt(0) + ". " + this.patronymic.charAt(0) + ".";
    }

    public int getFullYear() {
        if (birthday == null) {
            System.out.println("birthday = null");
            return 0;
        }
        if (LocalDate.now().getDayOfYear() >= birthday.getDayOfYear()) {
            return LocalDate.now().getYear() - birthday.getYear();
        } else {
            return LocalDate.now().getYear() - birthday.getYear() - 1;
        }
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return surname + ' ' + name + ' ' + patronymic + ' ' + birthday;
    }
}
