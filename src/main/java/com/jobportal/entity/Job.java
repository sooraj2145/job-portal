package com.jobportal.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="company_id", nullable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id", nullable = false)
    private Category category;

    @Column(nullable=false)
    private String title;

    private String description;

    private String location;

    @Column(name="job_type")
    private String jobType;

    @Column(name="salary_min")
    private Integer salaryMin;

    @Column(name="salary_max")
    private Integer salaryMax;

    private String status;

    @Column(name="posted_date")
    private LocalDateTime postedDate;


    public Job() {}

    public Job(Company company, Category category, String title, String description, String location, String jobType, Integer salaryMin, Integer salaryMax, String status) {
        this.company = company;
        this.category = category;
        this.title = title;
        this.description = description;
        this.location = location;
        this.jobType = jobType;
        this.salaryMin = salaryMin;
        this.salaryMax = salaryMax;
        this.status = status;
    }

    public Long getId() {
        return id;
    }



    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public Integer getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(Integer salaryMin) {
        this.salaryMin = salaryMin;
    }

    public Integer getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(Integer salaryMax) {
        this.salaryMax = salaryMax;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDateTime postedDate) {
        this.postedDate = postedDate;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", jobType='" + jobType + '\'' +
                ", salaryMin=" + salaryMin +
                ", salaryMax=" + salaryMax +
                ", status='" + status + '\'' +
                ", postedDate=" + postedDate +
                '}';
    }
}
