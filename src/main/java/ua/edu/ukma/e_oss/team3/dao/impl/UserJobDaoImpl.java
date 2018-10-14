package ua.edu.ukma.e_oss.team3.dao.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ua.edu.ukma.e_oss.team3.dao.UserJobDao;
import ua.edu.ukma.e_oss.team3.entity.UserJob;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserJobDaoImpl implements UserJobDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactory.getLogger(UserJobDaoImpl.class.getSimpleName());

    private static final String GET = "SELECT * FROM UserJob WHERE userID=? AND jobID=? AND startDate=?";
    private static final String INSERT = "INSERT INTO UserJob (userID, jobID, startDate, endDate,feedback) VALUES (?,?,?,?,?)";
    private static final String UPDATE = "UPDATE UserJob SET endDate =?, feedback=? WHERE userId=? AND jobID=? AND startDate=?";
    private static final String GET_ALL = "SELECT * FROM UserJob";
    private static final String GET_BY_JOB = "SELECT * FROM UserJob WHERE jobID=?";
    @Override
    public UserJob get(int user_id, int job_id, String st_date) {
        logger.info("DAO: grabbing object UserJob from DB");
        return jdbcTemplate.queryForObject(GET, mapper, user_id,job_id,st_date);
    }

    @Override
    public int insert(UserJob userJob) {
        logger.info("DAO: inserting object UserJob into DB");
        return jdbcTemplate.update(INSERT, userJob.getUser_id(), userJob.getJob_id(), userJob.getStartDate(),
                userJob.getEndDate(), userJob.getFeedback());
    }

    @Override
    public void update(UserJob userJob) {
        logger.info("DAO: updating object UserJob in DB");
        jdbcTemplate.update(UPDATE, userJob.getEndDate(), userJob.getFeedback(),userJob.getUser_id(), userJob.getJob_id(), userJob.getStartDate());
    }

    @Override
    public List<UserJob> getUserJobByJob_Id(int id) {
        return jdbcTemplate.query(GET_BY_JOB,mapper,id);
    }

    @Override
    public List<UserJob> getAll() {
        return jdbcTemplate.query(GET_ALL,mapper);
    }
    private RowMapper<UserJob> mapper = new RowMapper<UserJob>() {
        public UserJob mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserJob job = new UserJob();
            job.setUser_id(rs.getInt("userID"));
            job.setJob_id(rs.getInt("jobID"));
            job.setStartDate(rs.getDate("startDate"));
            job.setEndDate(rs.getDate("endDate"));
            job.setFeedback(rs.getString("feedback"));
            return job;
        }
    };
}
