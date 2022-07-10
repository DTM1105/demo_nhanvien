package com.example.models;

import com.example.beans.NhanVien;
import com.example.utils.DbUtils;
import org.sql2o.Connection;

import java.util.List;

public class NhanVienModel {
    public static List<NhanVien> HienThiDsachNhanVien(){
        String sql = " select * from nhanvien where status = 1";
        try (Connection con = DbUtils.getConnection()){
            List<NhanVien> list = con.createQuery(sql)
                    .executeAndFetch(NhanVien.class);
            if (list.size() == 0) {
                return null;
            }
            return list;
        }
    }
    public static void addNhanVien(NhanVien p){
        String sql = "INSERT INTO nhanvien ( name,age,salary,status) VALUES ( :name, :age, :salary,1)";
        try(Connection con = DbUtils.getConnection()) {
            con.createQuery(sql)
                    .addParameter("name",p.getName())
                    .addParameter("age",p.getAge())
                    .addParameter("salary",p.getSalary())
                    .executeUpdate();
        }
    }
    public static void updateNhanVien(NhanVien p){
        String sql = "UPDATE nhanvien SET name=:name, age =:age, salary=:salary WHERE id =:id";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(sql)
                    .addParameter("id",p.getId())
                    .addParameter("name",p.getName())
                    .addParameter("age",p.getAge())
                    .addParameter("salary",p.getSalary())
                    .executeUpdate();
        }
    }
    public static void deleteNhanVien(int id){
        String sql = "UPDATE nhanvien SET status = 0 WHERE id =:id";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

}
