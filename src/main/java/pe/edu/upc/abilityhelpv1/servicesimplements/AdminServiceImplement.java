package pe.edu.upc.abilityhelpv1.servicesimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.abilityhelpv1.entities.Admin;
import pe.edu.upc.abilityhelpv1.repositories.IAdminRepository;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IAdminServices;

import java.util.List;
@Service
public class AdminServiceImplement implements IAdminServices {
    @Autowired
    private IAdminRepository sR;
    @Override
    public void insert(Admin admin) {
        sR.save(admin);
    }

    @Override
    public List<Admin> list() {
        return sR.findAll();
    }
}
