package com.jxonline.sword.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author xs
 * @date 2022/9/11
 **/
public class UserInfoModel implements Serializable {

    private int user_id;
    private String user_name;
    private int user_gender;
    private int user_age;
    private String user_skill;
    private int user_position;
    private int user_stats;
    private int user_energy;
    private Timestamp lastLoginTime;
    private String username;
    private String password;
    private int user_power;
    private int user_sect;

    @Override
    public String toString() {
        return "UserInfoModel{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_gender=" + user_gender +
                ", user_age=" + user_age +
                ", user_skill='" + user_skill + '\'' +
                ", user_position=" + user_position +
                ", user_stats=" + user_stats +
                ", user_energy=" + user_energy +
                ", lastLoginTime=" + lastLoginTime +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", user_power=" + user_power +
                ", user_sect=" + user_sect +
                '}';
    }


    public UserInfoModel() {
    }

    public UserInfoModel(int user_id, String user_name, int user_gender, int user_age, String user_skill, int user_position, int user_stats, int user_energy, Timestamp lastLoginTime, String username, String password, int user_power, int user_sect) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_gender = user_gender;
        this.user_age = user_age;
        this.user_skill = user_skill;
        this.user_position = user_position;
        this.user_stats = user_stats;
        this.user_energy = user_energy;
        this.lastLoginTime = lastLoginTime;
        this.username = username;
        this.password = password;
        this.user_power = user_power;
        this.user_sect = user_sect;
    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(int user_gender) {
        this.user_gender = user_gender;
    }

    public int getUser_age() {
        return user_age;
    }

    public void setUser_age(int user_age) {
        this.user_age = user_age;
    }

    public String getUser_skill() {
        return user_skill;
    }

    public void setUser_skill(String user_skill) {
        this.user_skill = user_skill;
    }

    public int getUser_position() {
        return user_position;
    }

    public void setUser_position(int user_position) {
        this.user_position = user_position;
    }

    public int getUser_stats() {
        return user_stats;
    }

    public void setUser_stats(int user_stats) {
        this.user_stats = user_stats;
    }

    public int getUser_energy() {
        return user_energy;
    }

    public void setUser_energy(int user_energy) {
        this.user_energy = user_energy;
    }

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_power() {
        return user_power;
    }

    public void setUser_power(int user_power) {
        this.user_power = user_power;
    }

    public int getUser_sect() {
        return user_sect;
    }

    public void setUser_sect(int user_sect) {
        this.user_sect = user_sect;
    }
}
