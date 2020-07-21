package com.user.serviceImpl;

import com.user.dao.MccInfoDao;
import com.user.entity.MccInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Author honva
 * @Date 2020/7/5
 **/

@RestController
@RequestMapping("user")
public class UserService {

//    @Autowired
//    @Qualifier("masterDao")
//    JdbcTemplate jdbcTemplate;

    @Autowired
    MccInfoDao mccInfoDao;

    @RequestMapping("/getUsers")
    public ResponseEntity getUser(){
        List<MccInfo> voList = mccInfoDao.queryMccInfo();
        return new ResponseEntity(voList, HttpStatus.OK);
    }
//    @RequestMapping("/getUsers")
//    public ResponseEntity getUser(){
////        System.out.println(">>> user service in...."+userName);
//        String sql = "select * from t_mcc_info";
//        List<MccInfo> voList = jdbcTemplate.query(sql, new RowMapper<MccInfo>() {
//            MccInfo mccInfo = new MccInfo();
//            public MccInfo mapRow(ResultSet resultSet, int i) throws SQLException {
//                mccInfo = new MccInfo();
//                mccInfo.setMccCode(resultSet.getString("f_mcc_code"));
//                mccInfo.setMccTxt(resultSet.getString("f_mcc_txt"));
//                return mccInfo;
//            }
//        });
//
//        System.out.println(voList);
//
//        return new ResponseEntity(voList, HttpStatus.OK);
//    }
}
