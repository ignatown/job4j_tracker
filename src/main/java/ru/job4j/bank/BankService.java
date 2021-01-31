package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу системы банковских переводов
 * @author Никита Игнатов
 * @version 1.0
 */
public class BankService {
    /**
     * Для хранения данных о пользователе используется коллекция HashMap,
     * где ключ - это класс User, а значение - это коллекция List.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя в систему.
     * Если предложенный к добавлению пользователь уже
     * имеется в коллекции, то ничего не происходит.
     * @param user пользователь, который добавляется в системую
     */
    public void addUser(User user) {
    users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет новый аккаунт найденному по паспорту пользователю (если он существует)
     * @param passport ключ, который используется для поиска в системе
     *                 пользователя, которому будет добавлен аккаунт.
     * @param account аккаунт, который будет добавлен пользователю.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport).orElse(null);
        if (user != null) {
            if (!users.get(user).contains(account)) {
                users.get(user).add(account);
            }
        }
    }

    /**
     * Метод позволяющий найти пользователя по паспорту
     * @param passport значение паспорта, по которому будет найден пользователь
     * @return возвращает найденого пользователя или null, если пользователь не найден.
     */
    public Optional<User> findByPassport(String passport) {
       return users.keySet()
               .stream()
               .filter(us -> us.getPassport()
                       .equals(passport))
               .findFirst();
    }

    /**
     * Метод позволяющий найти аккаунт пользователя по реквизитам (если он существует)
     * @param passport паспорт, по которому определяется пользователь
     * @param requisite реквизиты, по которым идет поиск у определенного пользователя
     * @return возвращается аккаунт пользователя или null, если он не найден
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
       User user = findByPassport(passport).orElse(null);
        if (user != null) {
            return  users.get(user)
                   .stream()
                   .filter(us -> us.getRequisite()
                   .equals(requisite))
                   .findFirst();
        }
        return Optional.empty();
    }

    /**
     * Метод позволяющий переводить средства с одного счета на
     * другой между одним и разными пользователями
     * если пользователи будут найдены.
     * @param srcPassport паспорт пользователя, чьи средства списываются
     * @param srcRequisite реквизиты аккаунта пользователя, с которого списываются средства
     * @param destPassport паспорт пользователя, которому зачисляются средства
     * @param destRequisite реквизиты аккаунта пользователя, на который зачисляются средства
     * @param amount число средств, которые необходимо перевести между аккаунтами
     * @return возвращает true, если перевод совершен и false, если перевод совершить не удалось
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
       Account srcAcc = findByRequisite(srcPassport, srcRequisite).orElse(null);
       Account destAcc = findByRequisite(destPassport, destRequisite).orElse(null);
            if  (srcAcc != null && destAcc != null && srcAcc.getBalance() >= amount) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
            return true;
            }
            return false;
    }
}