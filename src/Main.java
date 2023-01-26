
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int user_id = 4;
        int product_id = 5;

        Product product1 = new Product(1, "Ноутбук", "Черный", 50000);
        Product product2 = new Product(2, "Стол", "Серый", 7000);
        Product product3 = new Product(3, "Кресло", "Коричневый", 5000);
        Product product4 = new Product(4, "Утюг", "Белый", 3000);
        Product product5 = new Product(4, "Утюг", "Белый", 3000);

        List<Product> productList = new ArrayList<>();

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);

        User user1 = new User(1, "Иванов", "Иван", "Иванович", "+79998882222",
                "ivanov@mail.ru", "ivanov", "ivanov", Role.USER);
        User user2 = new User(2, "Петров", "Петр", "Петрович", "87778886666",
                "petrov@mail.ru", "petrov", "petrov", Role.USER);
        User user3 = new User(3, "Кириллов", "Кирилл", "Кириллович", "76669994444",
                "kirillov@mail.ru", "kirillov", "kirillov", Role.ADMIN);

        List<User> userList = new ArrayList<>();

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        System.out.println("Добро пожаловать в наш интернет-магазин!");
        menu(user_id, product_id, userList, productList);
    }

    //////////////////////////////////////// MAIN ////////////////////////////////////////////////
    public static void menu(int user_id, int product_id, List<User> userList, List<Product> productList) {

        System.out.println("""
                Выберете действие из списка:
                1 – авторизоваться
                2 – зарегистрироваться\s
                3 – внести данные в программу""");
        Scanner input = new Scanner(System.in);
        int operation = 0;
        try {
            operation = input.nextInt();
        } catch (Exception e) {
            System.out.println("Вы ввели неверные данные\n");
            menu(user_id, product_id, userList, productList);
        }

        switch (operation) {
            case 1 -> authorization(user_id, product_id, userList, productList);
            case 2 -> registration(user_id, product_id, userList, productList);
            case 3 -> inputProduct(user_id, product_id, userList, productList);
            default -> {
                System.out.println("Вы выбрали неверное число\n");
                menu(user_id, product_id, userList, productList);
            }
        }
    }

    public static void authorization(int user_id, int product_id, List<User> userList, List<Product> productList) {
        System.out.println("Вы вошли в раздел авторизации.");
        Scanner input = new Scanner(System.in);
        System.out.println("Введите логин или email: ");
        String user_login_or_email = input.nextLine();
        System.out.println("Введите пароль: ");
        String user_password = input.nextLine();

        for (User user :
                userList) {
            if (user_login_or_email.equals(user.getLogin()) || (user_login_or_email.equals(user.getEmail()))) {
                if (user_password.equals(user.getPassword())) {
                    if (user.getRole().equals(Role.USER)) {
                        userMenu(user_id, product_id, userList, productList);
                        return;
                    } else if (user.getRole().equals(Role.ADMIN)) {
                        adminMenu(user_id, product_id, userList, productList);
                        return;
                    }
                }
            }
        }
        System.out.println("Вы ввели неверные данные\n");
        authorization(user_id, product_id, userList, productList);
    }

    public static void registration(int user_id, int product_id, List<User> userList, List<Product> productList) {
        System.out.println("Вы вошли в раздел регистрации пользователей.");
        Scanner input = new Scanner(System.in);

        System.out.println("Введите вашу фамилию:");
        String lastName = input.nextLine();
        if (lastName.matches("^[а-яА-ЯёЁa-zA-Z]+$")) {
        } else {
            System.out.println("Вы неверно ввели фамилию.\n");
            registration(user_id, product_id, userList, productList);
            return;
        }

        System.out.println("Введите ваше имя:");
        String firstName = input.nextLine();
        if (firstName.matches("^[а-яА-ЯёЁa-zA-Z]+$")) {
        } else {
            System.out.println("Вы неверно ввели имя.\n");
            registration(user_id, product_id, userList, productList);
            return;
        }

        System.out.println("Введите ваше отчество. Если его нет, то оставьте поле пустым:");
        String patronymic = input.nextLine();
        if (patronymic.matches("[а-яА-ЯёЁa-zA-Z]*")) {
        } else {
            System.out.println("Вы неверно ввели отчество.\n");
            registration(user_id, product_id, userList, productList);
            return;
        }

        System.out.println("Введите ваш номер телефона:");
        String telephoneNumber = input.nextLine();
        if (telephoneNumber.matches("^((\\+7|7|8)+([0-9]){10})$")) {
        } else {
            System.out.println("Вы неверно ввели номер телефона.\n" +
                    "Проверьте количество цифр и убедитесь, что номер начинается с +7, 7 или 8.\n");
            registration(user_id, product_id, userList, productList);
            return;
        }

        System.out.println("Введите ваше email:");
        String email = input.nextLine();
        if (email.matches("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$")) {
        } else {
            System.out.println("Вы неверно ввели email.\n");
            registration(user_id, product_id, userList, productList);
            return;
        }

        System.out.println("Введите ваш логин:");
        String login = input.nextLine();
        if (login.matches("^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$")) {
        } else {
            System.out.println("Логин должен быть длиной 2-20 символов, \n" +
                    "которыми могут быть буквы и цифры, первый символ обязательно буква.\n");
            registration(user_id, product_id, userList, productList);
            return;
        }

        System.out.println("Введите ваш пароль:");
        String password = input.nextLine();

        if (password.matches("^(?=.*[a-zA-Z0-9]).{8,}$")) {
        } else {
            System.out.println("Вы неверно задали пароль. Минимум 8 символов.\n" +
                    "Пароль может содержать строчные, прописные латинские буквы или цифры.");
            registration(user_id, product_id, userList, productList);
            return;
        }

        Role role = Role.USER;

        User new_user = new User(user_id, lastName, firstName, patronymic, telephoneNumber, email, login, password, role);
        userList.add(new_user);
        System.out.println("Вы успешно зарегистрировались и авторизовались!\n");
        user_id++;

        userMenu(user_id, product_id, userList, productList);
    }

    public static void userMenu(int user_id, int product_id, List<User> userList, List<Product> productList) {
        System.out.println("""
                Вы авторизованы как посетитель.
                Выберете действие из списка:
                1 - показать все товары;
                2 - вернуться в главное меню;
                3 - выйти из программы интернет-магазин;""");
        Scanner input = new Scanner(System.in);
        int operation = 0;
        try {
            operation = input.nextInt();
        } catch (Exception e) {
            System.out.println("Вы ввели неверные данные\n");
            userMenu(user_id, product_id, userList, productList);
        }

        switch (operation) {
            case 1 -> printProductUser(user_id, product_id, userList, productList);
            case 2 -> menu(user_id, product_id, userList, productList);
            case 3 -> {
                System.out.println("Программа интернет-магазин завершила свою работу.");
                System.exit(0);
            }
            default -> {
                System.out.println("Вы выбрали неверное число\n");
                userMenu(user_id, product_id, userList, productList);
            }
        }
    }

    public static void adminMenu(int user_id, int product_id, List<User> userList, List<Product> productList) {
        System.out.println("""
                Вы авторизованы как администратор.
                Выберете действие из списка:
                1 - добавить товар;
                2 - удалить товар;
                3 - показать все товары;
                4 - информация о пользователях;
                5 - смена статуса пользователя;
                6 - вернуться в главное меню;
                7 - выйти из программы интернет-магазин;""");
        Scanner input = new Scanner(System.in);
        int operation = 0;
        try {
            operation = input.nextInt();
        } catch (Exception e) {
            System.out.println("Вы ввели неверные данные\n");
            adminMenu(user_id, product_id, userList, productList);
        }

        switch (operation) {
            case 1 -> inputProduct(user_id, product_id, userList, productList);
            case 2 -> deleteProduct(user_id, product_id, userList, productList);
            case 3 -> printProductAdmin(user_id, product_id, userList, productList);
            case 4 -> printUser(user_id, product_id, userList, productList);
            case 5 -> changeRole(user_id, product_id, userList, productList);
            case 6 -> menu(user_id, product_id, userList, productList);
            case 7 -> {
                System.out.println("Программа интернет-магазин завершила свою работу.");
                System.exit(0);
            }
            default -> {
                System.out.println("Вы выбрали неверное число\n");
                adminMenu(user_id, product_id, userList, productList);
            }
        }
    }

    public static void inputProduct(int user_id, int product_id, List<User> userList, List<Product> productList) {
        System.out.println("Вы вошли в раздел добавления товаров.");

        Scanner input = new Scanner(System.in);
        System.out.println("Введите наименование товара:");
        String product_name = input.nextLine();

        if (product_name.matches("^[а-яА-ЯёЁa-zA-Z]{2,20}$")) {
        } else {
            System.out.println("""
                    Вы неверно ввели наименование товара. Длина от 2 до 20 символов.
                    Наименование товара не должно содержать цифр или спецсимволов.
                    """);
            inputProduct(user_id, product_id, userList, productList);
            return;
        }

        System.out.println("Введите цвет товара: ");
        String product_color = input.nextLine();

        if (product_color.matches("^[а-яА-ЯёЁa-zA-Z]{2,15}$")) {
        } else {
            System.out.println("""
                    Вы неверно ввели цвет товара. Длина от 2 до 20 символов.
                    Цвет товара не должно содержать цифр или спецсимволов.
                    """);
            inputProduct(user_id, product_id, userList, productList);
            return;
        }

        System.out.println("Введите цену товара: ");
        int product_price = 0;

        try {
            product_price = input.nextInt();
        } catch (Exception e) {
            System.out.println("""
                    Вы неверно ввели цену товара.
                    Цена товара должна состоять из целых чисел.
                    """);
            inputProduct(user_id, product_id, userList, productList);
        }

        Product product = new Product(product_id, product_name, product_color, product_price);
        productList.add(product);
        System.out.println("Товар успешно добавлен в магазин!\n");
        product_id++;

        adminMenu(user_id, product_id, userList, productList);
    }

    public static void deleteProduct(int user_id, int product_id, List<User> userList, List<Product> productList) {
        System.out.println("Вы вошли в раздел удаления товаров.");

        System.out.println("Список всех товаров в магазине:\n");

        for (Product product : productList) {
            System.out.println(product);
        }

        Scanner input = new Scanner(System.in);
        System.out.println("\nВведите ID товара для его удаления: ");
        int id = input.nextInt();

        for (Product product :
                productList) {
            int current_id = product.getId();
            if (current_id == id) {
                productList.remove(product);
                System.out.println("Продукт с ID №" + current_id + " успешно удален.\n");
                adminMenu(user_id, product_id, userList, productList);
                return;
            }
        }
    }

    public static void printProductAdmin(int user_id, int product_id, List<User> userList, List<Product> productList) {
        System.out.println("Список всех товаров в магазине:\n");

        for (Product product : productList) {
            System.out.println(product);
        }

        System.out.println();
        adminMenu(user_id, product_id, userList, productList);
    }

    public static void printProductUser(int user_id, int product_id, List<User> userList, List<Product> productList) {
        System.out.println("Список всех товаров в магазине:\n");

        for (Product product : productList) {
            System.out.println(product);
        }

        System.out.println();
        userMenu(user_id, product_id, userList, productList);
    }

    public static void printUser(int user_id, int product_id, List<User> userList, List<Product> productList) {
        System.out.println("Все зарегистрированные пользователи:\n");

        for (User user : userList) {
            System.out.println(user);
        }
        System.out.println();
        adminMenu(user_id, product_id, userList, productList);
    }

    public static void changeRole(int user_id, int product_id, List<User> userList, List<Product> productList) {
        System.out.println("Вы вошли в раздел добавления/удаления прав администратора.");
        System.out.println("Все зарегистрированные пользователи:\n");

        for (User user : userList) {
            System.out.println(user);
        }
        Scanner input = new Scanner(System.in);
        System.out.println("\nВведите ID пользователя для изменения его статуса: ");
        int id = 0;
        try {
            id = input.nextInt();
        } catch (Exception e) {
            System.out.println("Вы ввели неверные данные.\n");
            changeRole(user_id, product_id, userList, productList);
        }
//        for (User current_user :
//                userList) {
//            if (current_user.getId() == id) {
//            } else {
//                System.out.println("Вы ввели ID, которого нет в списке.\n");
//                changeRole(user_id, product_id, userList, productList);
//            }
//        }
        for (User user_role :
                userList) {
            if (user_role.getId() == id) {
                Role role = user_role.getRole();
                if (role == Role.USER) {
                    user_role.setRole(Role.ADMIN);
                    System.out.println("Статус пользователя: " + user_role.getLastName() + " успешно изменен на " +
                            user_role.getRole() + "\n");
                    adminMenu(user_id, product_id, userList, productList);
                    break;
                } else if (role == Role.ADMIN) {
                    user_role.setRole(Role.USER);
                    System.out.println("Статус пользователя: " + user_role.getLastName() + " успешно изменен на " +
                            user_role.getRole() + "\n");
                    adminMenu(user_id, product_id, userList, productList);
                    break;
                }
            }
        }
        adminMenu(user_id, product_id, userList, productList);
    }
}
