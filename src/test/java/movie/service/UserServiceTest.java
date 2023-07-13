package movie.service;

import com.example.movie.dto.LoginForm;
import com.example.movie.dto.UserDto;
import com.example.movie.entity.MyMovies;
import com.example.movie.entity.User;
import com.example.movie.repository.UserRepository;
import com.example.movie.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

class UserServiceTest {

    private UserRepository userRepository = new UserRepository() {
        @Override
        public Optional<User> findByEmail(String email) {
            return Optional.empty();
        }

        @Override
        public Optional<User> findByPassword(String password) {
            return Optional.empty();
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends User> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<User> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public User getOne(Long aLong) {
            return null;
        }

        @Override
        public User getById(Long aLong) {
            return null;
        }

        @Override
        public User getReferenceById(Long aLong) {
            return null;
        }

        @Override
        public <S extends User> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public <S extends User> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public List<User> findAll() {
            return null;
        }

        @Override
        public List<User> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends User> S save(S entity) {
            return null;
        }

        @Override
        public Optional<User> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(User entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends User> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public List<User> findAll(Sort sort) {
            return null;
        }

        @Override
        public Page<User> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends User> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends User> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends User> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends User, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };
    private UserService userService=new UserService(userRepository);
    @Test
    void createUser() {
        UserDto userdto = new UserDto("정지현","1234567","jj6778@naver.com","01088526778");


        userService.createUser(userdto);
    }

    @Test
    void duplicateEmail() {
    }
    @Test
    void join(){
        LoginForm loginForm = new LoginForm("jj6778@naver.com","1234567");

        System.out.println(userRepository.findByPassword(loginForm.getPassword()).isPresent());

    }
    @Test
    public void add(){
        User user = new User("재학","12345678","jj6778@naver.com","010-1234-5678");
        MyMovies myMovies = new MyMovies("포스터","아이언맨",user);
        userService.addMyMovies(myMovies,user);
        System.out.println(user.getMovies().get(0).getTitle());


    }
}