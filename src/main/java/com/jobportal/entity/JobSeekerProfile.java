package com.jobportal.entity;

import jakarta.persistence.*;

@Entity
@Table(name="job_seeker_profiles")
public class JobSeekerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false, unique = true)
    private User user;

    @Column(name="resume_text")
    private String resumeText;

    @Column(name="experience_summary")
    private String experienceSummary;

    private String location;

    public JobSeekerProfile() {}

    public JobSeekerProfile(User user, String resumeText, String experienceSummary, String location) {
        this.user = user;
        this.resumeText = resumeText;
        this.experienceSummary = experienceSummary;
        this.location = location;
    }

    public Long getId() {
        return id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getResumeText() {
        return resumeText;
    }

    public void setResumeText(String resumeText) {
        this.resumeText = resumeText;
    }

    public String getExperienceSummary() {
        return experienceSummary;
    }

    public void setExperienceSummary(String experienceSummary) {
        this.experienceSummary = experienceSummary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "JobSeekerProfile{" +
                "id=" + id +
                ", resumeText='" + resumeText + '\'' +
                ", experienceSummary='" + experienceSummary + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
