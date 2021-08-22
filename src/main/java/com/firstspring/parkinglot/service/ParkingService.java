package com.firstspring.parkinglot.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.firstspring.parkinglot.model.VehicleDTO;

public interface ParkingService {
	
	List<VehicleDTO> getAllVehicles();
	String park(VehicleDTO vehicleDTO);
	String unPark(Long id);
}
