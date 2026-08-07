package com.jobportal.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name="applications",
        uniqueConstraints = @UniqueConstraint(columnNames = {"profile_id", "job_id"})
)
public class Application {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="profile_id", nullable = false)
    private JobSeekerProfile profile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="job_id", nullable = false)
    private Job job;

    @Column(name="applied_date")
    private LocalDateTime  appliedDate;

    private String status;

    public Application() {}

    public Application(JobSeekerProfile profile, Job job, LocalDateTime appliedDate, String status) {
        this.profile = profile;
        this.job = job;
        this.appliedDate = appliedDate;
        this.status = status;

    }

    public Long getId() {
        return id;
    }


    public JobSeekerProfile getProfile() {
        return profile;
    }

    public void setProfile(JobSeekerProfile profile) {
        this.profile = profile;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public LocalDateTime getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(LocalDateTime appliedDate) {
        this.appliedDate = appliedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", appliedDate=" + appliedDate +
                ", status='" + status + '\'' +
                '}';
    }
}
