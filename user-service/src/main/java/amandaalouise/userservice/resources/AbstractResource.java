package amandaalouise.userservice.resources;

import amandaalouise.userservice.domain.model.entities.PersistentEntity;
import amandaalouise.userservice.domain.model.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class AbstractResource<T extends PersistentEntity> {

    protected JpaRepository<T, Long> repository;

    /**
     *
     * @param repository
     */
    public AbstractResource(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    /**
     * @return
     */
    @CrossOrigin(origins = "*")
    @GetMapping
    public Page<T> findAll(@RequestParam("page") int pageIndex, @RequestParam("size") int pageSize) {
        PageRequest pageRequest = PageRequest.of(
                pageIndex,
                pageSize,
                Sort.Direction.ASC,
                "id");
        return repository.findAll(pageRequest);
    }

    /**
     * @param value
     * @return
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public T create(@RequestBody @Valid T value) {
        return this.repository.save(value);
    }

    /**
     *
     * @param values
     * @return
     */
    @PostMapping("/list")
    @ResponseStatus(HttpStatus.CREATED)
    public List<T> create(@RequestBody @Valid List<T> values) {
        return this.repository.saveAll(values);
    }

    /**
     * @param id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        this.repository.deleteById(id);
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public T findById(@PathVariable("id") Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource {0} not found", id));
    }
}
