package ua.edu.ukma.e_oss.team3.dao.impl;

import ua.edu.ukma.e_oss.team3.dao.SOappDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ua.edu.ukma.e_oss.team3.entity.SO_application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SOappDaoImpl implements SOappDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactory.getLogger(SOappDaoImpl.class.getSimpleName());

    private static final String GET = "SELECT * FROM SO_application WHERE applicationID=?";
    private static final String INSERT = "INSERT INTO SO_application (applicationID, userID, name, description, aim, approved, " +
            "status, rejected_text, dekanID,skID) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE SO_application SET userID =?, name=?, description=?, aim=?, approved=?, status=?," +
            " rejected_text=?, dekanID=?, skID=? WHERE applicationID=?";
    private static final String GET_ALL = "SELECT * FROM SO_application";

    @Override
    public SO_application get(int id) {
        logger.info("DAO: grabbing object SO_app from DB");
        return jdbcTemplate.queryForObject(GET, mapper, id);
    }

    @Override
    public int insert(SO_application soApp) {
        logger.info("DAO: inserting object SO_app into DB");
        return jdbcTemplate.update(INSERT, soApp.getApp_id(), soApp.getUser_id(), soApp.getName(), soApp.getDescription(),
                soApp.getAim(),soApp.isApproved(), soApp.getStatus(), soApp.getRejected_text(),soApp.getDekan_id(),soApp.getSk_id());
    }

    @Override
    public void update(SO_application soApp) {
        logger.info("DAO: updating object SO_app in DB");
        jdbcTemplate.update(UPDATE,soApp.getUser_id(), soApp.getName(), soApp.getDescription(),
                soApp.getAim(),soApp.isApproved(), soApp.getStatus(), soApp.getRejected_text(),soApp.getDekan_id(),soApp.getSk_id(),soApp.getApp_id());
    }

    @Override
    public List<SO_application> getAll() {
        return jdbcTemplate.query(GET_ALL,mapper);

    }
    private RowMapper<SO_application> mapper = new RowMapper<SO_application>() {
        public SO_application mapRow(ResultSet rs, int rowNum) throws SQLException {
            SO_application soapp = new SO_application();
            soapp.setApp_id(rs.getInt("applicationID"));
            soapp.setUser_id(rs.getInt("userID"));
            soapp.setName(rs.getString("name"));
            soapp.setDescription(rs.getString("description"));
            soapp.setAim(rs.getString("aim"));
            soapp.setApproved(rs.getBoolean("approved"));
            soapp.setStatus(rs.getString("status"));
            soapp.setRejected_text(rs.getString("rejected_text"));
            soapp.setDekan_id(rs.getInt("dekanID"));
            soapp.setSk_id(rs.getInt("skID"));
            return soapp;
        }
    };
}
