package com.brunomilitzer.location.controller;

import com.brunomilitzer.location.entity.Location;
import com.brunomilitzer.location.service.LocationService;
import com.brunomilitzer.location.util.EmailUtil;
import com.brunomilitzer.location.util.ReportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import java.util.List;

@Controller
public class LocationController {

    @Autowired
    private LocationService service;

    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    private ReportUtil reportUtil;

    @Autowired
    private ServletContext context;

    @RequestMapping("/showCreate")
    public String showCreate() {

        return "createLocation";
    }

    @RequestMapping("/saveLoc")
    public String saveLocation(@ModelAttribute("location") final Location location, final ModelMap modelMap) {

        final Location locationSaved = this.service.saveLocation(location);

        final String msg = "Location saved with id: " + locationSaved.getId();

        modelMap.addAttribute("msg", msg);

        this.emailUtil.sendEmail("brunomilitzer.work@gmail.com", "New Location Saved!", "Location saved: " + locationSaved.getName());

        return "createLocation";
    }

    @RequestMapping("/displayLocations")
    public String displayLocations(final ModelMap modelMap) {

        final List<Location> locations = this.service.getAllLocations();
        modelMap.addAttribute("locations", locations);

        return "displayLocations";
    }

    @RequestMapping("/showUpdate")
    public String showUpdate(@RequestParam("id") final Long id, final ModelMap modelMap) {

        final Location location = this.service.getLocationById(id);
        modelMap.addAttribute("location", location);

        return "updateLocation";
    }

    @RequestMapping("/updateLoc")
    public String updateLocation(@ModelAttribute("location") final Location location, final ModelMap modelMap) {

        this.service.updateLocation(location);

        final List<Location> locations = this.service.getAllLocations();
        modelMap.addAttribute("locations", locations);

        return "displayLocations";
    }

    @RequestMapping("/deleteLocation")
    public String deleteLocation(@RequestParam("id") final Long id, final ModelMap modelMap) {

        final Location location = this.service.getLocationById(id);

        this.service.deleteLocation(location);

        final List<Location> locations = this.service.getAllLocations();
        modelMap.addAttribute("locations", locations);

        return "displayLocations";
    }

    @RequestMapping("/generateReport")
    public String generateReport() {

        final String path = this.context.getRealPath("/");

        final List<Object[]> data = this.service.findTypeAndTypeCount();

        this.reportUtil.generatePieChart(path, data);

        return "report";
    }

}
