package com.aiden.boot.dao;

import com.aiden.boot.domain.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tim_Yu
 * @version $Id: CountryDao.java, v0.1 2018/1/9 19:28 Tim_Yu
 */
@Repository
public interface CountryDao extends JpaRepository<Country, Long> {
}
