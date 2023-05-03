/*
 * Пусть дан список сотрудников:
Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. 
Отсортировать по убыванию популярности.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class s5dz02 {
  public static void main(String[] args) {

    List<String> employees = Arrays.asList("Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина",
        "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова",
        "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин",
        "Иван Ежов");

    Map<String, Integer> listOfNames = new HashMap<>();

    for (String people : employees) {
      String[] name = people.split(" ");
      if (!listOfNames.containsKey(name[0])) {
        listOfNames.put(name[0], 1);
      } else {
        Integer val = listOfNames.get(name[0]) + 1;
        listOfNames.put(name[0], val);
      }
    }
    System.out.println();
    System.out.println(listOfNames);
    System.out.println();

    //https://howtodoinjava.com/java/sort/java-sort-map-by-key/
    Map<String, Integer> sortedListOfNames = new LinkedHashMap<>();
    listOfNames.entrySet()   //возвращает множество (Set) наборов “ключ-значение”
        .stream() //Stream — это последовательности элементов, которые можно легко получить из Collection для преобразования и фильтрации
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) //сортировка, взять из Мар значения и расставить по убыванию
        .forEach(entry -> sortedListOfNames.put(entry.getKey(), entry.getValue())); // раскладываем значения в новый Мар

    System.out.println("Сортировка по убыванию популярности:  ");
    System.out.println(sortedListOfNames);
  }
}
