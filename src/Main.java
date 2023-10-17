import java.util.Scanner; // Імпортуємо клас Scanner для отримання введення від користувача

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Створюємо об'єкт Scanner для зчитування з консолі

        while (true) { // Входимо в безкінечний цикл для меню
            System.out.println("Оберіть метод:"); // Виводимо доступні методи
            System.out.println("1. Перевірка закінчення рядка на 'ed'");
            System.out.println("2. Сума цифр у рядку");
            System.out.println("3. Знайдення найдовшого блоку символів");
            System.out.println("4. Виведення слів у рядку");
            System.out.println("5. Змішування рядків");

            int choice = scanner.nextInt(); // Зчитуємо вибір користувача
            scanner.nextLine(); // Очищаємо буфер введення

            switch (choice) { // Вибираємо метод відповідно до вибору користувача
                case 1:
                    System.out.println("Введіть рядок:");
                    String input1 = scanner.nextLine(); // Зчитуємо рядок від користувача
                    boolean result1 = endsWithEd(input1); // Викликаємо метод endsWithEd
                    System.out.println("Результат: " + result1); // Виводимо результат
                    break;
                case 2:
                    System.out.println("Введіть рядок:");
                    String input2 = scanner.nextLine();
                    int result2 = sumOfDigits(input2); // Викликаємо метод sumOfDigits
                    System.out.println("Сума цифр: " + result2);
                    break;
                case 3:
                    System.out.println("Введіть рядок:");
                    String input3 = scanner.nextLine();
                    int result3 = longestBlockLength(input3); // Викликаємо метод longestBlockLength
                    System.out.println("Довжина найдовшого блоку: " + result3);
                    break;
                case 4:
                    System.out.println("Введіть рядок:");
                    String input4 = scanner.nextLine();
                    printWords(input4); // Викликаємо метод printWords
                    break;
                case 5:
                    System.out.println("Введіть перший рядок:");
                    String input5A = scanner.nextLine();
                    System.out.println("Введіть другий рядок:");
                    String input5B = scanner.nextLine();
                    String result5 = mixStrings(input5A, input5B); // Викликаємо метод mixStrings
                    System.out.println("Результат змішування рядків: " + result5);
                    break;
                default:
                    System.out.println("Неправильний вибір. Спробуйте ще раз.");
                    break;
            }

            System.out.println("Бажаєте продовжити? (Так/Ні)");
            String continueChoice = scanner.nextLine().toLowerCase();
            if (!continueChoice.equals("так")) { // Перевіряємо, чи користувач бажає продовжити
                scanner.close(); // Закриваємо Scanner
                System.out.println("Дякую за використання!");
                return;
            }
        }
    }

    // Метод для перевірки закінчення рядка на "ed"
    public static boolean endsWithEd(String input) {
        return input.endsWith("ed");
    }

    // Метод для знаходження суми цифр у рядку
    public static int sumOfDigits(String input) {
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            if (Character.isDigit(character)) {
                sum += Character.getNumericValue(character);
            }
        }
        return sum;
    }

    // Метод для знаходження довжини найдовшого блоку символів
    public static int longestBlockLength(String input) {
        int maxBlockLength = 0;
        int currentBlockLength = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                currentBlockLength++;
            } else {
                maxBlockLength = Math.max(maxBlockLength, currentBlockLength);
                currentBlockLength = 1;
            }
        }

        return Math.max(maxBlockLength, currentBlockLength);
    }

    // Метод для виведення слів у рядку
    public static void printWords(String input) {
        String[] words = input.split(" ");
        for (String word : words) {
            System.out.println(word);
        }
    }

    // Метод для змішування рядків
    public static String mixStrings(String inputA, String inputB) {
        StringBuilder result = new StringBuilder();
        int lengthA = inputA.length();
        int lengthB = inputB.length();
        int maxLength = Math.max(lengthA, lengthB);

        for (int i = 0; i < maxLength; i++) {
            if (i < lengthA) {
                result.append(inputA.charAt(i));
            }
            if (i < lengthB) {
                result.append(inputB.charAt(i));
            }
        }

        return result.toString();
    }
}
