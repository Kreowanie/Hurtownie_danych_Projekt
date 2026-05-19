package HD.projekt.drug.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dimTime", schema = "dbo")
public class DimTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "timeDay")
    private LocalDate timeDay;

    @Column(name = "timeWeekDay")
    private Integer timeWeekDay;

    @Column(name = "timeWeekNum")
    private Integer timeWeekNum;

    @Column(name = "timeMonth")
    private String timeMonth;

    @Column(name = "timeYear")
    private Integer timeYear;

    public DimTime() {
    }

    public DimTime(
            final LocalDate timeDay,
            final Integer timeWeekDay,
            final Integer timeWeekNum,
            final String timeMonth,
            final Integer timeYear
    ) {
        this.timeDay = timeDay;
        this.timeWeekDay = timeWeekDay;
        this.timeWeekNum = timeWeekNum;
        this.timeMonth = timeMonth;
        this.timeYear = timeYear;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getTimeDay() {
        return timeDay;
    }

    public Integer getTimeWeekDay() {
        return timeWeekDay;
    }

    public Integer getTimeWeekNum() {
        return timeWeekNum;
    }

    public String getTimeMonth() {
        return timeMonth;
    }

    public Integer getTimeYear() {
        return timeYear;
    }
}