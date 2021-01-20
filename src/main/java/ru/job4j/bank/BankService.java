package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет новый аккаунт найденному по паспорту пользователю (если он существует)
     * @param passport ключ, который используется для поиска в системе
     *                 пользователя, которому будет добавлен аккаунт.
     * @param account аккаунт, который будет добавлен пользователю.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
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
    public User findByPassport(String passport) {
        for (User us
                : users.keySet()) {
            if (us.getPassport().equals(passport)) {
                return us;
            }
        }
        return null;
    }

    /**
     * Метод позволяющий найти аккаунт пользователя по реквизитам (если он существует)
     * @param passport паспорт, по которому определяется пользователь
     * @param requisite реквизиты, по которым идет поиск у определенного пользователя
     * @return возвращается аккаунт пользователя или null, если он не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        if (findByPassport(passport) != null) {
            for (Account acc
                    : users.get(findByPassport(passport))) {
                if (acc.getRequisite().equals(requisite)) {
                    return acc;
                }
            }
        }
        return null;
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
       Account srcAcc = findByRequisite(srcPassport, srcRequisite);
       Account destAcc = findByRequisite(destPassport, destRequisite);
            if  (srcAcc != null && destAcc != null && srcAcc.getBalance() >= amount) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
            return true;
            }
            return false;
    }
}