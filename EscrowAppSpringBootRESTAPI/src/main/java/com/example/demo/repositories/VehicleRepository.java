package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Vehicle;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>  {
}

















//List<Vehicle> findByCompany_CompanyId(int companyId);
//
//List<Vehicle> findByModel_ModelId(int modelId);
//
//@Query("Select v from Vehicle v where v.model.modelName like %:modelName%")
//List<Vehicle> findByModel_ModelName(String modelName);



//package com.example.demo.repositories;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import com.example.demo.entities.Vehicle;
//@Repository
//public interface VehicleRepository extends JpaRepository<Vehicle, Integer>  {
//	List<Vehicle> findByCompany_CompanyId(int companyId);
//	
//	List<Vehicle> findByModel_ModelId(int modelId);
//}
