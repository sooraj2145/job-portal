package com.jobportal.dao;

import com.jobportal.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyDAO {

     Company save(Company company);

     Optional<Company> findById(Long id);

     List<Company> findAll();

     Company update(Company company);

     boolean delete(Long id);
}
