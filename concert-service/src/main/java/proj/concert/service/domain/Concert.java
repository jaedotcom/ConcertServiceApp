package proj.concert.service.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * class to represent concerts.
 * <p>
 * A Concert describes a concert in terms of
 * id the unique identifier for a concert.
 * title the concert's title.
 * dates the concert's scheduled dates and times (represented as a Set of
 * LocalDateTime instances).
 * imageName an image name for the concert.
 * performers the performers in the concert
 * blurb the concert's description
 */
@Entity
@Table(name = "CONCERTS")
public class Concert implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Column(name = "IMAGE_NAME")
    private String imageName;

    @Column(name = "BLURB", length = 1023)
    private String blrb;

    @ElementCollection
    @CollectionTable(name = "CONCERT_DATES", joinColumns = @JoinColumn(name = "concert_id"))
    @Column(name = "date")
    private Set<LocalDateTime> dates = new TreeSet<LocalDateTime>();

    @ManyToMany
    @JoinTable(name = "CONCERT_PERFORMER", joinColumns = @JoinColumn(name = "concert_id"), inverseJoinColumns = @JoinColumn(name = "performer_id"))
    private List<Performer> performers = new ArrayList<>();

    public Concert() {
    }

    public Concert(Long id, String title, String imageName, String blurb) {
        this.id = id;
        this.title = title;
        this.imageName = imageName;
        this.blrb = blurb;
    }

    public Concert(String title, String imageName) {
        this.title = title;
        this.imageName = imageName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getBlurb() {
        return blrb;
    }

    public void setBlurb(String blrb) {
        this.blrb = blrb;
    }

    public Set<LocalDateTime> getDates() {
        return dates;
    }

    public void setDates(Set<LocalDateTime> dates) {
        this.dates = dates;
    }

    public List<Performer> getPerformers() {
        return performers;
    }

    public void setPerformers(List<Performer> performers) {
        this.performers = performers;
    }
}
