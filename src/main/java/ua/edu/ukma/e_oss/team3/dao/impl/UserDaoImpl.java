package ua.edu.ukma.e_oss.team3.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ua.edu.ukma.e_oss.team3.dao.UserDao;
import ua.edu.ukma.e_oss.team3.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class.getSimpleName());

    private static final String GET = "SELECT userID, role, name, email, tel_num enabled FROM user WHERE userID=?";
    // FIX?
    private static final String INSERT = "INSERT INTO \"user\" (role, name, email, tel_num) SELECT ?,?,?,? WHERE NOT exists(SELECT email FROM \"user\" WHERE email = ?)";
    private static final String UPDATE = "UPDATE \"user\" SET role=?, name=?, email=?, tel_num=? WHERE email=?";
    private static final String DELETE = "DELETE FROM \"user\" WHERE email=?";

    private static final String IF_EXISTS = "SELECT exists (SELECT email FROM \"user\" WHERE email = ?)";

    @Override
    public User get(String email) {
        logger.info("DAO: grabbing object User from DB");
        return jdbcTemplate.queryForObject(GET, mapper, email);
    }

    @Override
    public User get(int id) {
        logger.info("DAO: grabbing object User from DB");
        return jdbcTemplate.queryForObject(GET, mapper, id);
    }

    @Override
    public int insert(User user) {
        logger.info("DAO: inserting object User into DB");
        if(ifExists(user))
            return -1;
        return jdbcTemplate.update(INSERT, user.getEmail(), user.getName(), user.getRole(), user.getTel_num());
    }


    @Override
    public void update(User user) {
        logger.info("DAO: updating object User in DB");
        jdbcTemplate.update(UPDATE, user.getEmail(), user.getName(), user.getRole(), user.getTel_num());
    }

    @Override
    public void remove(User user) {
        logger.info("DAO: removing object User from DB");
        jdbcTemplate.update(DELETE, user.getEmail());
    }

    //FIX!
    public boolean ifExists(User user){
        logger.info("DAO: if exist User "+user);
        // jdbcTemplate.queryForObject(IF_EXISTS, Boolean.class, user.getEmail())
        return true;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    private RowMapper<User> mapper = (rs, rowNum) -> {
        User user = new User();
        user.setUser_id(rs.getInt("userID"));
        user.setEmail(rs.getString("email"));
        user.setName(rs.getString("name"));
        user.setRole(rs.getString("role"));
        user.setTel_num(rs.getString("tel_num"));
        return user;
    };
}
