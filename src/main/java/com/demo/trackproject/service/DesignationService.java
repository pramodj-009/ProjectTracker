package com.demo.trackproject.service;

import com.demo.trackproject.dao.DesignationDAO;
import com.demo.trackproject.model.Designation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DesignationService {
    @Autowired
    private DesignationDAO designationDAO;

    @Transactional
    public long save(Designation designation){
        return designationDAO.addDesignation(designation);
    }

    public Designation get(long id){
        return designationDAO.getDesignation(id);
    }

    public List<Designation> list(){
        return designationDAO.listDesignations();
    }

    @Transactional
    public Designation update(Designation designation){
        return designationDAO.editDesignation(designation);
    }

    @Transactional
    public void delete(long id){
        designationDAO.deleteDesignationById(id);
    }
}
