package ua.edu.ukma.e_oss.team3.dao.impl;

import ua.edu.ukma.e_oss.team3.dao.JobDao;
import ua.edu.ukma.e_oss.team3.entity.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JobDaoImpl implements JobDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactory.getLogger(JobDaoImpl.class.getSimpleName());

    private static final String GET = "SELECT * FROM Job WHERE jobID=?";
    private static final String INSERT = "INSERT INTO Job (jobID, soID, title, description) VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE Job SET soID =?, title=?, description=? WHERE jobID=?";
    private static final String GET_ALL = "SELECT * FROM Job";
    private static final String GET_BY_SO = "SELECT * FROM Job WHERE soID=?";
    @Override
    public Job get(int id) {
        logger.info("DAO: grabbing object Car from DB");
        return jdbcTemplate.queryForObject(GET, mapper, id);
    }

    @Override
    public int insert(Job job) {
        logger.info("DAO: inserting object Car into DB");
        return jdbcTemplate.update(INSERT, job.getJob_id(), job.getSo_id(), job.getTitle(), job.getDescription());
    }

    @Override
    public void update(Job job) {
        logger.info("DAO: updating object Car in DB");
        jdbcTemplate.update(UPDATE, job.getSo_id(), job.getTitle(), job.getDescription(), job.getJob_id());
    }

    @Override
    public List<Job> getJobsBySo_id(int id) {
        return jdbcTemplate.query(GET_BY_SO,mapper);
    }

    @Override
    public List<Job> getAll() {
        return jdbcTemplate.query(GET_ALL,mapper);
    }

    private RowMapper<Job> mapper = new RowMapper<Job>() {
        public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
            Job job = new Job();
            job.setJob_id(rs.getInt("jobID"));
            job.setSo_id(rs.getInt("soID"));
            job.setTitle(rs.getString("title"));
            job.setDescription(rs.getString("description"));
            return job;
        }
    };
}

