
import java.util.Objects;

public class User {
    private int id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String telephoneNumber;
    private String email;
    private String login;
    private String password;
    private Role role;

    public User(int id, String lastName, String firstName, String patronymic,
                String telephoneNumber, String email, String login, String password, Role role) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(int id, String lastName, String firstName, String telephoneNumber, String email, String login,
                String password, Role role) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return (Objects.equals(login, user.login) || Objects.equals(email, user.email)) &&
                Objects.equals(password, user.password);
    }

    @Override
    public String toString() {
        return
                "ID: " + id +
                        ", ФИО: " + lastName + " " + firstName + " " + patronymic +
                        ", Телефон: " + telephoneNumber +
                        ", Логин: " + login +
                        ", Email: " + email +
                        ", Пароль: " + password +
                        ", Статус: " + role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
