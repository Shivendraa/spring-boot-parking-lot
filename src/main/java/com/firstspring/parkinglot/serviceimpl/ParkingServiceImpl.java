package com.firstspring.parkinglot.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstspring.parkinglot.model.VehicleDTO;
import com.firstspring.parkinglot.repository.ParkingRepository;
import com.firstspring.parkinglot.service.ParkingService;

@Service
public class ParkingServiceImpl implements ParkingService{
	
	@Autowired
	ParkingRepository parkingRepository;

	@Override
	public List<VehicleDTO> getAllVehicles() {
		return parkingRepository.findAll();
	}

	@Override
	public String park(VehicleDTO vehicleDTO) {
		if(vehicleDTO.getId() > 0 && vehicleDTO.getId() <=10) {
			if(!parkingRepository.findAll().contains(vehicleDTO))
				parkingRepository.save(vehicleDTO);
			else {
				throw new RuntimeException("Try some other slot");
			}
		}
		else {
			throw new RuntimeException("Kindly Provide ID Between 1 to 10");
		}	
		return "Parked";
	}

	@Override
	public String unPark(Long id) {
		if(id > 0 && id <=10) {
			parkingRepository.deleteById(id);
		}
		else {
			throw new RuntimeException("Kindly Provide ID Between 1 to 10");
		}
		return "Unparked Vehicle"+ parkingRepository.getOne(id).getVehicleNumber() +"at slot num "+ id;
	}
	
}
