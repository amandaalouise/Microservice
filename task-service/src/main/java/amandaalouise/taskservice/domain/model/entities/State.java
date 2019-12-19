package amandaalouise.taskservice.domain.model.entities;

import lombok.Getter;

public enum State {
    TODO("To do"),
    DONE("Done");

    @Getter
    private final String name;

    /**
     * @param name
     */
    State(String name) {
        this.name = name;
    }
}
