package ua.edu.ukma.e_oss.team3.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import ua.edu.ukma.e_oss.team3.dao.VacancyDao;
import ua.edu.ukma.e_oss.team3.entity.Vacancy;

import java.sql.*;
import java.util.List;

public class VacancyDaoImpl implements VacancyDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactory.getLogger(VacancyDaoImpl.class.getSimpleName());

    private static final String GET = "SELECT v.vacancyID, v.jobID, v.active, v.deadline, v.comment FROM Vacancy v WHERE vacancyID=?";
    private static final String INSERT = "INSERT INTO vacancy VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE Vacancy SET active=?, deadline=?,comment=? WHERE vacancyID=?";
    private static final String DELETE = "DELETE FROM Vacancy WHERE vacancyID=?";
    // group by active
    private static final String GET_ALL = "SELECT * FROM Vacancy ORDER BY active ASC";


    @Override
    public Vacancy get(int id) {
        logger.info("DAO: grabbing object Vacancy from DB id: " + id);
        return jdbcTemplate.queryForObject(GET, mapper, id);
    }

    @Override
    public int insert(Vacancy vac) {
        logger.info("DAO: inserting object Vacancy into DB: " + vac);
        return jdbcTemplate.update(INSERT, vac.getComment(), vac.getDeadline(), vac.isActive());
    }

    @Override
    public void update(Vacancy vac) {
        logger.info("DAO: updating object Vacancy into DB: " + vac);
        jdbcTemplate.update(UPDATE, vac.getComment(), vac.getDeadline(), vac.isActive());
    }

    @Override
    public void remove(Vacancy vac) {
        logger.info("DAO: removing object Vacancy from DB");
        jdbcTemplate.update(DELETE, vac.getVacancy_id());
    }

    @Override
    public List<Vacancy> getAll() {
        return jdbcTemplate.query(GET_ALL, mapper);
    }

    private RowMapper<Vacancy> mapper = new RowMapper<Vacancy>() {
        public Vacancy mapRow(ResultSet rs, int rowNum) throws SQLException {
            Vacancy vacancy = new Vacancy();
            vacancy.setVacancy_id(rs.getInt("vacancyID"));
            vacancy.setJob_id(rs.getInt("jobID"));
            vacancy.setActive(rs.getBoolean("active"));
            vacancy.setDeadline(rs.getDate("deadline"));
            vacancy.setComment(rs.getString("comment"));
            return vacancy;
        }
    };
}
