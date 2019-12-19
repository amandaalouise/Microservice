package amandaalouise.userservice.resources;

import amandaalouise.userservice.domain.model.entities.User;
import amandaalouise.userservice.domain.repositories.UserRepository;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserResource extends AbstractResource<User> {

     private UserRepository userRepository;


    /**
     * @param userRepository
     */
    public UserResource(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }
    /**
     * @return
     */
    @GetMapping("nopage")
    public List<User> findAll() {
        return repository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void deleteUser(@PathVariable("id") Long id) {
        final String uri = "http://localhost:8762/task-service/api/usertask/removeByUser/{id}";

        this.userRepository.deleteById(id);

        Map<String, Long> params = new HashMap<>();
        params.put("id", id);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor("admin", "admin"));
        restTemplate.delete ( uri,  params );
    }
}
