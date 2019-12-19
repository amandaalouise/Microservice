package amandaalouise.taskservice.resources;

import amandaalouise.taskservice.domain.model.entities.UserTask;
import amandaalouise.taskservice.domain.repositories.UserTaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usertask")
public class UserTaskResource extends AbstractResource<UserTask> {

    private UserTaskRepository userTaskRepository;


    /**
     * @param userTaskRepository
     */
    public UserTaskResource(UserTaskRepository userTaskRepository) {
        super(userTaskRepository);
        this.userTaskRepository = userTaskRepository;
    }

    /**
     * @return
     */
    @GetMapping("byUserId/{id}")
    public Page<UserTask> ListbyUserId(@PathVariable("id") Long id, @RequestParam("page") int pageIndex, @RequestParam("size") int pageSize) {
        PageRequest pageRequest = PageRequest.of(
                pageIndex,
                pageSize,
                Sort.Direction.ASC,
                "id");
        return userTaskRepository.findByUserId(id, pageRequest);
    }

    @DeleteMapping("removeByUser/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void removeByUser(@PathVariable("id") Long id) {
         this.userTaskRepository.deleteByUserId(id);
    }
}
