package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        int rls = -1;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login))  {
              rls = i;
              break;
          }
        }
        if (rls == -1) {
            throw new UserNotFoundException();
        }
        return users[rls];
    }

    public static boolean validate(User user) throws UserInvalidException {
       if (user.getUsername().length() < 3 || !user.isValid()) {
           throw new UserInvalidException();
       }
        return true;
    }

    public static void main(String[] args) throws UserNotFoundException {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        User user = findUser(users, "Petr Arsentev");
        try {
            if (validate(user)) {
                System.out.println("This User has an access");
            } }
        catch (UserNotFoundException ua) {
            System.out.println("User is not found");
            ua.printStackTrace();
        }
    }
}