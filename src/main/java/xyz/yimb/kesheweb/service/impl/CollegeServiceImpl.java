package xyz.yimb.kesheweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yimb.kesheweb.entity.College;
import xyz.yimb.kesheweb.repository.CollegeRepository;
import xyz.yimb.kesheweb.service.CollegeService;

import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    private CollegeRepository collegeRepository;

    @Override
    public List<College> getAll() {
        return collegeRepository.findAll();
    }

    @Override
    public boolean deleteCollege(Integer cid) {
        try {
            collegeRepository.deleteById(cid);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean insertCollege(College college) {
        College save = collegeRepository.save(college);
        return save!=null;
    }

    @Override
    public College getCollegeByCid(Integer cid) {
        return collegeRepository.getOne(cid);
    }
}
