package ua.edu.ukma.e_oss.team3.dao.impl;

import ua.edu.ukma.e_oss.team3.dao.SODao;
import ua.edu.ukma.e_oss.team3.entity.SO;
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
public class SODaoImpl implements SODao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactory.getLogger(SODaoImpl.class.getSimpleName());

    private static final String GET = "SELECT * FROM SO WHERE soID=?";
    private static final String INSERT = "INSERT INTO SO (soID, applicationID, name, description, aim, head, address, tel_num, " +
            "email, facebook) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE SO SET applicationID=?, name=?, description=?, aim=?, head=?, address=?, tel_num=?, " +
            "email=?, facebook=? WHERE soID=?";
    private static final String GET_ALL = "SELECT * FROM SO";

    @Override
    public SO get(int id) {
        logger.info("DAO: grabbing object SO from DB");
        return jdbcTemplate.queryForObject(GET, mapper, id);
    }

    @Override
    public int insert(SO so) {
        logger.info("DAO: inserting object SO into DB");
        return jdbcTemplate.update(INSERT, so.getSo_id(), so.getApp_id(), so.getName(), so.getDescription(),
                so.getAim(),so.getHead(), so.getAddress(), so.getTel_num(),so.getEmail(),so.getFacebook());
    }

    @Override
    public void update(SO so) {
        logger.info("DAO: updating object SO in DB");
        jdbcTemplate.update(UPDATE,so.getApp_id(), so.getName(), so.getDescription(),
                so.getAim(),so.getHead(), so.getAddress(), so.getTel_num(),so.getEmail(),so.getFacebook(),so.getSo_id());
    }

    @Override
    public List<SO> getAll() {
        return jdbcTemplate.query(GET_ALL,mapper);
    }
    private RowMapper<SO> mapper = new RowMapper<SO>() {
        public SO mapRow(ResultSet rs, int rowNum) throws SQLException {
            SO soapp = new SO();
            soapp.setSo_id(rs.getInt("soID"));
            soapp.setApp_id(rs.getInt("applicationID"));
            soapp.setName(rs.getString("name"));
            soapp.setDescription(rs.getString("description"));
            soapp.setAim(rs.getString("aim"));
            soapp.setHead(rs.getString("head"));
            soapp.setAddress(rs.getString("address"));
            soapp.setTel_num(rs.getString("tel_num"));
            soapp.setEmail(rs.getString("email"));
            soapp.setFacebook(rs.getString("facebook"));
            return soapp;
        }
    };
}
