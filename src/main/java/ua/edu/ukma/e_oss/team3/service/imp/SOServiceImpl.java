package ua.edu.ukma.e_oss.team3.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.ukma.e_oss.team3.dao.JobDao;
import ua.edu.ukma.e_oss.team3.dao.SODao;
import ua.edu.ukma.e_oss.team3.dao.UserDao;
import ua.edu.ukma.e_oss.team3.dao.UserJobDao;
import ua.edu.ukma.e_oss.team3.entity.Job;
import ua.edu.ukma.e_oss.team3.entity.SO;
import ua.edu.ukma.e_oss.team3.entity.User;
import ua.edu.ukma.e_oss.team3.entity.UserJob;
import ua.edu.ukma.e_oss.team3.service.SOService;
import ua.edu.ukma.e_oss.team3.utils.ContactData;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SOServiceImpl implements SOService {

    @Autowired
    private SODao soDao;

    @Autowired
    private JobDao jobDao;

    @Autowired
    private UserJobDao userJobDao;

    @Autowired
    private UserDao userDao;

    @Override
    public SO get(int so) {
        return soDao.get(so);
    }

    @Override
    public int insert(SO so) {
        return soDao.insert(so);
    }

    @Override
    public void update(SO so) {
        soDao.update(so);
    }

    @Override
    public ContactData getContactDataOfSOById(int id) {
        ContactData data = new ContactData();
        SO so = soDao.get(id);
        data.setAddress(so.getAddress());
        data.setEmail(so.getEmail());
        data.setAddress(so.getAddress());
        data.setFacebook(so.getFacebook());
        return data;
    }

    @Override
    public List<User> getListOfMembersById(int id) {
        List<Job> listOfJobs = jobDao.getJobBySo_id(id);
        List<List<UserJob>> listOfUserJob = new ArrayList<>();
        for (Job job : listOfJobs) {
            listOfUserJob.add(userJobDao.getUserJobByJob_Id(job.getJob_id()));
        }
        List<User> listOfMembers = new ArrayList<>();
        for (List<UserJob> listUserJob : listOfUserJob) {
            for (UserJob uj : listUserJob) {
                listOfMembers.add(userDao.get(uj.getUser_id()));
            }
        }
        return listOfMembers;
    }
}
