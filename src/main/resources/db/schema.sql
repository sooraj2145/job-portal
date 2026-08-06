DROP DATABASE IF EXISTS job_portal_db;

CREATE DATABASE IF NOT EXISTS job_portal_db;

USE job_portal_db;

CREATE TABLE IF NOT EXISTS companies(
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        name VARCHAR(150) NOT NULL,
    description TEXT NULL,
    website VARCHAR(255) NULL,
    location VARCHAR(150) NULL
    );

DESCRIBE companies;

CREATE TABLE IF NOT EXISTS categories(
                                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                         name VARCHAR(100) NOT NULL UNIQUE
    );


CREATE TABLE IF NOT EXISTS users(
                                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    email VARCHAR(150) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL,
    company_id BIGINT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT company_fk
    FOREIGN KEY (company_id) REFERENCES companies(id)
    );

CREATE TABLE IF NOT EXISTS job_seeker_profiles(
                                                  id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                                  user_id BIGINT NOT NULL UNIQUE,
                                                  resume_text TEXT NULL,
                                                  experience_summary VARCHAR(500) NULL,
    location VARCHAR(150) NULL,
    CONSTRAINT user_fk
    FOREIGN KEY (user_id) REFERENCES users(id)
    );

CREATE TABLE IF NOT EXISTS jobs(
                                   id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                   company_id BIGINT NOT NULL,
                                   category_id BIGINT NOT NULL,
                                   title VARCHAR(200) NOT NULL,
    description TEXT NULL,
    location VARCHAR(150) NULL,
    salary_min INT NULL,
    salary_max INT NULL,
    job_type VARCHAR(30) NULL,
    status VARCHAR(20) DEFAULT 'OPEN',
    posted_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT job_company_fk
    FOREIGN KEY (company_id) REFERENCES companies(id),
    CONSTRAINT job_category_fk
    FOREIGN KEY (category_id) REFERENCES categories(id)
    );

CREATE TABLE IF NOT EXISTS skills(
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     name VARCHAR(100) NOT NULL UNIQUE
    );

CREATE TABLE IF NOT EXISTS job_skills(
                                         job_id BIGINT NOT NULL,
                                         skill_id BIGINT NOT NULL,
                                         CONSTRAINT job_skill_fk
                                         FOREIGN KEY (job_id) REFERENCES jobs(id),
    CONSTRAINT job_skill_skills_fk
    FOREIGN KEY (skill_id) REFERENCES skills(id),
    PRIMARY KEY (job_id, skill_id)
    );

CREATE TABLE IF NOT EXISTS applications(
                                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                           profile_id BIGINT NOT NULL,
                                           job_id BIGINT NOT NULL,
                                           applied_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                           status VARCHAR(20) DEFAULT 'APPLIED',
    CONSTRAINT application_profile_fk
    FOREIGN KEY (profile_id) REFERENCES job_seeker_profiles(id),
    CONSTRAINT application_jobs_fk
    FOREIGN KEY (job_id) REFERENCES jobs(id),
    UNIQUE (profile_id, job_id)
    );

SHOW TABLES;

DESCRIBE job_skills;

DESCRIBE applications;