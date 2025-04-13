package bureau.domain;

public enum Role {
    CLIENT("Клиент"),
    MANAGER("Менеджер"),
    CONSTRUCTOR("Конструктор");

    private final String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}