package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
    users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        if (findByPassport(passport) != null) {
            if (users.get(passport).contains(account)) {
                users.get(passport).add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User us:
             users.keySet()) {
            if (us.getPassport().equals(passport)) {
                return us;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        if (findByPassport(passport) != null) {
            for (Account acc:
             users.get(passport)) {
                if (acc.getRequisite() == requisite) {
                    return acc;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
            if  (findByRequisite(srcPassport, srcRequisite) != null &&
                findByRequisite(destPassport, destRequisite) != null &&
                findByRequisite(srcPassport, srcRequisite).getBalance() >= amount) {
            findByRequisite(srcPassport, srcRequisite).setBalance(findByRequisite(srcPassport, srcRequisite).getBalance() - amount);
            findByRequisite(destPassport, destRequisite).setBalance(findByRequisite(destPassport, destRequisite).getBalance() + amount);
            return true;
            }
            return false;
    }
}