package com.example.demo.controllers;

import com.example.demo.entities.Category;
import com.example.demo.entities.SubCategory;
import com.example.demo.entities.Vehicle;
import com.example.demo.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.saveVehicle(vehicle);
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }
    
    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return vehicleService.getAllCategories();
    }

    @GetMapping("/subcategories/{categoryId}")
    public List<SubCategory> getSubCategoriesByCategoryId(@PathVariable("categoryId") int categoryId) {
        return vehicleService.getSubCategoriesByCategoryId(categoryId);
    }

    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable("id") int vehicleId) {
        return vehicleService.getVehicleById(vehicleId).orElse(null);
    }
    
    @GetMapping("/models/{modelName}")
    public List<Vehicle> getVehiclesByModelName(@PathVariable("modelName") String modelName) {
        return vehicleService.findVehiclesByModelName(modelName);
    }
    
    @GetMapping("/companies/{companyName}")
    public List<Vehicle> getVehiclesByCompanyName(@PathVariable("companyName") String companyName){
    	return vehicleService.findVehicleByCompanyName(companyName);
    }
    
    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable("id") int vehicleId, @RequestBody Vehicle vehicleDetails) {
        Optional<Vehicle> vehicle = vehicleService.getVehicleById(vehicleId);

        if (vehicle.isPresent()) {
            Vehicle updatedVehicle = vehicle.get();
            updatedVehicle.setSeller(vehicleDetails.getSeller());
            updatedVehicle.setModel(vehicleDetails.getModel());
            updatedVehicle.setCompany(vehicleDetails.getCompany());
            updatedVehicle.setCategory(vehicleDetails.getCategory());
            updatedVehicle.setSubCategory(vehicleDetails.getSubCategory());
            updatedVehicle.setRegistrationYear(vehicleDetails.getRegistrationYear());
            updatedVehicle.setKmsDriven(vehicleDetails.getKmsDriven());
            updatedVehicle.setFuelType(vehicleDetails.getFuelType());
            updatedVehicle.setNoOfSeats(vehicleDetails.getNoOfSeats());
            updatedVehicle.setOwnership(vehicleDetails.getOwnership());
            updatedVehicle.setTransmission(vehicleDetails.getTransmission());
            updatedVehicle.setEngineCapacity(vehicleDetails.getEngineCapacity());
            updatedVehicle.setRto(vehicleDetails.getRto());
            updatedVehicle.setVehicleImages(vehicleDetails.getVehicleImages());
            updatedVehicle.setVehiclePrice(vehicleDetails.getVehiclePrice());
            updatedVehicle.setStatus(vehicleDetails.getStatus());

            return vehicleService.saveVehicle(updatedVehicle);
        } else {
            return null; // Handle this case more gracefully in production
        }
    }
  

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable("id") int vehicleId) {
        vehicleService.deleteVehicleById(vehicleId);
    }
}
























//@GetMapping("/company/{companyId}")
//public List<Vehicle> getVehiclesByCompanyId(@PathVariable("companyId") int companyId) {
//  return vehicleService.getVehiclesByCompanyId(companyId);
//}
//

//@GetMapping("/models/{modelName}")
//public List<Vehicle> getVehiclesByModelName(@PathVariable String modelName) {
//System.out.println("Received modelName: " + modelName);
//return vehicleService.getVehiclesByModelName(modelName);
//}
