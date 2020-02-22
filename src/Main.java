/*1) Написать класс Person, у которого если следующие поля:
- Фамилия, Имя, Отчество, дата рождения.
Написать конструкторы:
- на все поля,
- только на ФИО
- который принимает 1 параметр - строку с полным именем "Иванов Иван Иванович", и задает отдельные значения в поля Фамилия, Имя, Отчество.
Написать методы:
- который возвращает полное ФИО типа "Иванов Иван Иванович"
- краткое ФИО типа "Иванов И. И."
- который на основе даты рождения выводит количество полных лет.
1.1*) Дата рождения задается как строка типа "18.12.1985"
2) Написать класс "Группа", для отображения учебной группы в Hillel, который содержит поля:
- название курса
- дата старта занятий
- суммарное количество занятий курса
- количество занятий в неделю
- список учащихся типа Person
Написать методы:
- метод который печатает название группы на основе даты старта и названия курса, например: "Java21.12"
- печатает нумерованный список студентов, например:
   1. Иванов
   2. Петров
   3. Сидоров
- добавить студента
2.1*)
- метод который выдает дату старта последней недели курса
- удалить студента по фамилии или по номеру
- узнать если ли студент с такой фамилией в группе
2.2*) Реализовать конструктор копирования для класса Person и Group*/

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Иванов Иван Иванович");
        System.out.println("person1.getFullName()");
        System.out.println(person1.getFullName());
        Person person2 = new Person("Петров", "Петр", "Петрович", "22.02.1985");
        System.out.println("person2.getShortFullName()");
        System.out.println(person2.getShortFullName());
        System.out.println("person2.getFullYear()");
        System.out.println(person2.getFullYear());
        Person person3 = new Person("Сидоров", "Смидор", "Сидорович", "22.08.1985");

        Group group = new Group("Java", "08.02.2020", 5, 2);
        group.addPerson(person1);
        group.addPerson(person2);
        group.addPerson(person3);
        System.out.println("group.getInfoGroup()");
        System.out.println(group.getInfoGroup());
        System.out.println("group.printPersons()");
        group.printPersons();
        System.out.println("group.getStartLastWeek()");
        System.out.println(group.getStartLastWeek());
        System.out.println("group.removePerson(3)");
        group.removePerson(3);
        group.printPersons();
        System.out.println("group.removePerson(\"Иванов\")");
        group.removePerson("Иванов");
        group.printPersons();
        System.out.println("group.containPerson()");
        System.out.println(group.containPerson("Петров"));
        System.out.println(group.containPerson("Иванов"));

        System.out.println("copyPerson");
        Person person4 = new Person(person3);
        person4.setSurname("Петров");
        System.out.println(person3);
        System.out.println(person4);

        group.addPerson(person4);
        Group group2 = new Group(group);
        System.out.println(group.toString());
        System.out.println(group2.toString());

    }
}
