package ar.com.ada.api.aladas.services;

import org.springframework.stereotype.Service;

import ar.com.ada.api.aladas.entities.Staff;
import ar.com.ada.api.aladas.repos.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class StaffService {

    @Autowired
    StaffRepository repo;

    public void crearStaff(Staff staff) {
        repo.save(staff);
    }
    
}
