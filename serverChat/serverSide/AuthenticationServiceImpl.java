package serverChat.serverSide;

import java.util.ArrayList;
import java.util.List;

public class AuthenticationServiceImpl implements AuthenticationService {
    private List<User> usersList;

    public AuthenticationServiceImpl() {
        usersList = new ArrayList<>();
        usersList.add(new User("A", "A", "A"));
        usersList.add(new User("B", "B", "B"));
        usersList.add(new User("C", "C", "C"));
    }

    @Override
    public void start() {
        System.out.println("Start");
    }

    @Override
    public void stop() {
        System.out.println("Stop");
    }

    @Override
    public String getNickByLoginAndPassword(String login, String password) {
        for (User u : usersList) {
            if ((u.getLogin()).equals(login) && (u.getPassword()).equals(password)) {
                return (u.getNick());
            }
        }return "";
    }
}

//        return userList.stream().map(a -> {
//            if (a.login.equals(login) && a.password.equals(password)) {
//                return a.nick;
//            }
//            return "";
//        }).collect(Collectors.joining());
//    }
//}

//лямбда
