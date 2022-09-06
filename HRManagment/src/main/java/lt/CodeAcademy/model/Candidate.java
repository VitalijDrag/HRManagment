package lt.CodeAcademy.model;

import lombok.*;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@DynamicUpdate
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String bi;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String birth;

    @Column
    private int rating;

    @Column
    private String obs;

    @Column
    private String skills;

    @Column(name = "technical_area")
    private String technicalArea;

    @Column(name = "job_interview_date")
    private String jobInterviewDate;

}
