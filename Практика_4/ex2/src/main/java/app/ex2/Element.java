package app.ex2;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String title;

    public Element() {
    }

    public Element(String title) {
        this.title = title;

    }
}
