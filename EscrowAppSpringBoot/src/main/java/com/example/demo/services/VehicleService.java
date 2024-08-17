package com.example.demo.services;

import com.example.demo.entities.Category;
import com.example.demo.entities.SubCategory;
import com.example.demo.entities.Vehicle;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.SubCategoryRepository;
import com.example.demo.repositories.VehicleRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;
    
    @Autowired
    private CategoryRepository categoryRepository; 

    @Autowired
    private SubCategoryRepository subCategoryRepository;
    
    
    public List<Vehicle> findVehiclesByModelName(String modelName) {
        return vehicleRepository.findByModelName(modelName);
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> getVehicleById(int vehicleId) {
        return vehicleRepository.findById(vehicleId);
    }
    
 // Methods to fetch categories and subcategories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public List<SubCategory> getSubCategoriesByCategoryId(int categoryId) {
        return subCategoryRepository.findByCategoryId(categoryId);
    }
    
    public List<Vehicle> findVehicleByCompanyName(String companyName){
    	return vehicleRepository.findByCompanyName(companyName);
    }

    public void deleteVehicleById(int vehicleId) {
        vehicleRepository.deleteById(vehicleId);
    }

    
}





























//	if(byCompany_CompanyId == null) {
//	throw new NullPointerException("This id not exists");
//}





//package com.example.demo.services;
//
//import com.example.demo.entities.Vehicle;
//import com.example.demo.repositories.VehicleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class VehicleService {
//
//    @Autowired
//    private VehicleRepository vehicleRepository;
//
//    public Vehicle saveVehicle(Vehicle vehicle) {
//        return vehicleRepository.save(vehicle);
//    }
//
//    public List<Vehicle> getAllVehicles() {
//        return vehicleRepository.findAll();
//    }
//
//    public Optional<Vehicle> getVehicleById(int vehicleId) {
//        return vehicleRepository.findById(vehicleId);
//    }
//
//    public void deleteVehicleById(int vehicleId) {
//        vehicleRepository.deleteById(vehicleId);
//    }
//
//    public List<Vehicle> getVehiclesByCompanyId(int companyId) {
//        return vehicleRepository.findByCompany_CompanyId(companyId);
//    }
//    
//    public List<Vehicle> getVehiclesByModelId(int modelId) {
//        return vehicleRepository.findByModel_ModelId(modelId);
//    }
//}
