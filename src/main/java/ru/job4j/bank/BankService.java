package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (users.get(user.getPassport()) == null) {
    users.put(user, new ArrayList<Account>()); 
        }
    }

    public void addAccount(String passport, Account account) {
        if (findByPassport(passport) != null) {
            users.get(passport).add(account);
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
        for (User us:
             users.keySet()) {
          if (us.getPassport().equals(passport)) {
              // ???????
          }
        }
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        return rsl;
    }
}