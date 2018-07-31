package com.skilldistillery.finance.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.finance.entities.IncomeCategory;

public interface IncomeCategoryRepo extends JpaRepository<IncomeCategory, Integer>{

}
