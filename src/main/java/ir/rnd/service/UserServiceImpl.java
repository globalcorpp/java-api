package ir.rnd.service;

import ir.rnd.model.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
//import org.springframework.transaction.annotation.Transactional;

//import com.websystique.springmvc.model.User;

@Service("userService")
//@Transactional
public class UserServiceImpl implements UserService {

    private static final AtomicLong counter = new AtomicLong();

    private static List<User> users;

    static {
        users = populateDummyUsers();
    }

    public List<User> findAllUsers() {
        return users;
    }

    public User findById(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User findByName(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    public User saveUser(User user) {
        user.setId(counter.incrementAndGet());
        users.add(user);
        return user;
    }

    public void updateUser(User user) {
        int index = users.indexOf(user);
        users.set(index, user);
    }

    public void deleteUserById(long id) {

        for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
            }
        }
    }

    public boolean isUserExist(User user) {
        return findByName(user.getName()) != null;
    }

    private static List<User> populateDummyUsers() {
        List<User> users = new ArrayList<User>();
        users.add(new User(counter.incrementAndGet(), "s.dabaghi", 33, 70000));
        users.add(new User(counter.incrementAndGet(), "s.aghashiri", 30, 530000));
        users.add(new User(counter.incrementAndGet(), "m.mounesan", 30, 510000));
        users.add(new User(counter.incrementAndGet(), "m.nazari", 30, 52000));
        return users;
    }

    public void deleteAllUsers() {
        users.clear();
    }

}
