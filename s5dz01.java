/* Задание № 1.
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class s5dz01 {

  private static Map<String, List<String>> addNew(Map<String, List<String>> phoneBook) {
    Scanner scan = new Scanner(System.in, "866");
    System.out.println("Введите нового абонента в формате Фамилия, номер телефона\n");
    String[] inputInfo = scan.nextLine().split(",");
    List<String> value = new LinkedList<>();
    value.add(inputInfo[1].trim());
    
    if (!phoneBook.containsKey(inputInfo[0])) {
      phoneBook.put(inputInfo[0], value);
    } else {
      phoneBook.get(inputInfo[0]).add(inputInfo[1]);
    }
    return phoneBook;
  }

  private static List<String> findBySurname(Map<String, List<String>> phoneBook) {
    Scanner scan = new Scanner(System.in, "866");
    System.out.println();
    System.out.println("Для поиска введите Фамилию абонента\n");
    String inputInfo = scan.nextLine();
    List<String> result = new LinkedList<>();
    result.add(inputInfo);

    if (!phoneBook.containsKey(inputInfo)) {
      result.add(" номер телефона не найден ");
    } else {
      result.add(phoneBook.get(inputInfo).toString());
    }
    return result;
  }

  private static List<String> findByPhoneNumber(Map<String, List<String>> phoneBook) {
    Scanner scan = new Scanner(System.in, "866");
    System.out.println();
    System.out.println("Для поиска введите номер телефона\n");
    String inputInfo = scan.nextLine();
    List<String> result = new LinkedList<>();

    for (Map.Entry<String, List<String>> pair : phoneBook.entrySet()) {
      for (String num : pair.getValue()) {
        if (inputInfo.equals(num)) {
          result.add(pair.getKey());
          result.add(pair.getValue().toString());
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {

    Map<String, List<String>> phoneBook = new HashMap<>();
    int number = 0;
    List<String> result = new LinkedList<>();
    Scanner scan = new Scanner(System.in, "866");
    while (number != 5) {
      System.out.println("\n\n\n\n\n\n");

      number = 0;
      System.out.print("Меню справочника:\n 1 - добавить абонента\n 2 - найти абонента по Фамилии\n ");
      System.out.println("3 - найти абонента по номеру телефона\n 4 - распечатать телефонный справочник\n 5 - выйти\n");
      try {
        number = Integer.parseInt(scan.nextLine());
      } catch (Exception ex) {
        System.out.println("Введено не число или не верное число\n");
        System.out.println("\n\n\n\n\n");
      }
      if (number == 1) {
        phoneBook = addNew(phoneBook);
      } else if (number == 2) {
        result = findBySurname(phoneBook);
        System.out.println(result);
      } else if (number == 3) {
        result = findByPhoneNumber(phoneBook);
        System.out.println(result);
      } else if (number == 4) {
        System.out.println(phoneBook);
      }
    }
    System.out.println("Работа программы завершена");
  }
}
