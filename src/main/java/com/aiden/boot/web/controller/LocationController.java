package com.aiden.boot.web.controller;

import com.aiden.boot.dao.CountryDao;
import com.aiden.boot.domain.entity.Country;
import com.aiden.boot.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Tim_Yu
 * @version $Id: LocationController.java, v0.1 2018/1/9 19:21 Tim_Yu
 */
@Controller
@RequestMapping("location")
public class LocationController {

    @Autowired
    private CountryDao countryDao;

    @RequestMapping("allCountries")
    public String getAllCountriesInfo(Model model) {
        List<Country> all = countryDao.findAll();
        for (Country country : all) {
            country.setContinent(JsonUtil.writeObjectAsString(country));
            //            model.addAttribute(country.getName(), JsonUtil.writeObjectAsString(country));
        }
        model.addAttribute("countryList", all);
        return "/country";
    }

}
