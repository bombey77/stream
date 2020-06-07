import entities.Department;
import entities.Employee;
import entities.Event;
import entities.Position;

import javax.sound.midi.Soundbank;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Runner {

    private static List<Employee> emps = Arrays.asList(
            new Employee("Michael", "Smith", 243, 43, Position.CHEF),
            new Employee("Jane", "Smith", 523, 40, Position.MANAGER),
            new Employee("Jury", "Gagarin", 6423, 26, Position.MANAGER),
            new Employee("Jack", "London", 5543, 53, Position.WORKER),
            new Employee("Eric", "Jackson", 2534, 22, Position.WORKER),
            new Employee("Andrew", "Bosh", 3456, 44, Position.WORKER),
            new Employee("Joe", "Smith", 723, 30, Position.MANAGER),
            new Employee("Jack", "Gagarin", 7423, 35, Position.MANAGER),
            new Employee("Jane", "London", 7543, 42, Position.WORKER),
            new Employee("Mike", "Jackson", 7534, 31, Position.WORKER),
            new Employee("Jack", "Bosh", 7456, 54, Position.WORKER),
            new Employee("Mark", "Smith", 123, 41, Position.MANAGER),
            new Employee("Jane", "Gagarin", 1423, 28, Position.MANAGER),
            new Employee("Sam", "London", 1543, 52, Position.WORKER),
            new Employee("Jack", "Jackson", 1534, 27, Position.WORKER),
            new Employee("Eric", "Bosh", 1456, 32, Position.WORKER)
    );

    private static List<Department> deps = Arrays.asList(
            new Department(1, 0, "Head"),
            new Department(2, 1, "West"),
            new Department(3, 1, "East"),
            new Department(4, 2, "Germany"),
            new Department(5, 2, "France"),
            new Department(6, 3, "China"),
            new Department(7, 3, "Japan")
    );

    public static void main(String[] args) {
        terminate();
        transform();
    }

    public Department reducer(Department parent, Department child) {
        if (parent.getId() == child.getParent()) {
            parent.getChild().add(child);
        } else {
            parent.getChild().forEach(subParent -> reducer(subParent, child));
        }
        return parent;
    }

    public static void terminate() {
        Stream<Employee> stream = emps.stream();
//        emps.stream().forEach(employee -> System.out.println(employee.getFirstName()));
//        emps.forEach(employee -> System.out.println(employee.getFirstName()));
//        stream.collect(Collectors.toList());
//        stream.toArray();
//        stream.collect(Collectors.toMap(Employee::getId, Employee::getPosition));
//        IntStream intStream = IntStream.of(100, 200, 300);
//        System.out.println(intStream.reduce(((left, right) -> left + right)).orElse(0)); //600
//        System.out.println(intStream.reduce(((left, right) -> left + right)).getAsInt()); //600
//        System.out.println(intStream.reduce(((left, right) -> right - left)).getAsInt()); //200
//        System.out.println(deps.stream().reduce(new Runner()::reducer));

//        System.out.println(IntStream.of(100, 200, 300).average().getAsDouble()); //200
//        System.out.println(IntStream.of(400, 200, 300).max().getAsInt()); //400
//        System.out.println(IntStream.of(400, 200, 300).min().getAsInt()); //200
//        System.out.println(IntStream.of(400, 200, 300).sum()); //900
//        System.out.println(IntStream.of(400, 200, 300).summaryStatistics().getMin()); //200
//        System.out.println(IntStream.of(400, 200, 300).summaryStatistics().getMax()); //400
//        System.out.println(emps.stream().max((e1, e2) -> e1.getAge() - e2.getAge())); //54
//        System.out.println(emps.stream().max(Comparator.comparingInt(Employee::getAge))); //54
//        System.out.println(emps.stream().findAny()); //для параллельных потоков вернет первый найденный элемент
//        System.out.println(emps.stream().findFirst());
//        System.out.println(emps.stream().noneMatch(employee -> employee.getAge() > 60)); //true
//        System.out.println(emps.stream().allMatch(employee -> employee.getAge() > 18)); //true
//        System.out.println(emps.stream().anyMatch(employee -> employee.getPosition() == Position.CHEF)); //true
    }

    public static void transform() {
//        IntStream.of(100, 200, 300).mapToLong(Long::valueOf);
//        Stream<Event> st = IntStream.of(100, 200, 300).mapToObj(year -> new Event(UUID.randomUUID(), LocalDateTime.of(year, 12, 12, 3, 0), ""));
//        IntStream.of(1, 2, 3, 4, 1, 2).distinct().forEach(e -> System.out.println(e)); //1, 2, 3, 4
//        IntStream.of(1, 2, 3, 4, 1, 2).filter(e -> e != 2).forEach(System.out::println); //1, 3, 4, 1
//        IntStream.of(1, 2, 3, 4, 1, 2).skip(2).forEach(System.out::println); //3, 4, 1, 2
//        IntStream.of(1, 2, 3, 4, 1, 2).limit(3).forEach(System.out::println); //1, 2, 3

//        emps.stream()
//                .sorted(Comparator.comparingInt(Employee::getAge)) //сортировка по возрасту
//                .map(e -> String.format("%d %s %s", e.getAge(), e.getFirstName(), e.getLastName())) //получение объекта String с параметрами: возраст, имя, фамилия
//                .forEach(System.out::println);

//        emps.stream().peek(e -> e.setAge(18)).forEach(System.out::println); //устанавливаю возраст для всех сотрудников = 18 лет

//          Java 9
//        IntStream.of(1, 2, 3, 4, 5).takeWhile(i -> i < 4).forEach(System.out::println); //1, 2, 3
//        IntStream.of(1, 2, 3, 4, 5, 1, 2).dropWhile(i -> i < 4).forEach(System.out::println); //4, 5, 1, 2
//        IntStream.iterate(0, i -> i + 1).forEach(System.out::println); //0,1,2,3...
//        IntStream.iterate(0, i -> i + 1).takeWhile(i -> i < 10).forEach(System.out::println); //1,2...9
//    IntStream.iterate(0, i -> i < 10, i -> i++).forEach(System.out::println);

//        Теперь стало возможным создавать Stream из null, тем самым, уходя от проверок на null и уменьшая вероятность NullPointerExceptio
//        emps.stream().flatMap(e -> Stream.ofNullable(e.getPosition())).collect(Collectors.toList()).forEach(System.out::println);

//        IntStream.of(1,3,3,4,5,1).distinct().forEach(System.out::println);
    }
}
