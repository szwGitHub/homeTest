package com.zh.test.pojo;

import java.io.Serializable;

public class TestUser implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_user.ID
     *
     * @mbggenerated Thu Nov 10 19:00:02 CST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_user.NAME
     *
     * @mbggenerated Thu Nov 10 19:00:02 CST 2022
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_user.GENDER
     *
     * @mbggenerated Thu Nov 10 19:00:02 CST 2022
     */
    private String gender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_user.PASSWORD
     *
     * @mbggenerated Thu Nov 10 19:00:02 CST 2022
     */
    private String password;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_user.ID
     *
     * @return the value of test_user.ID
     *
     * @mbggenerated Thu Nov 10 19:00:02 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_user.ID
     *
     * @param id the value for test_user.ID
     *
     * @mbggenerated Thu Nov 10 19:00:02 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_user.NAME
     *
     * @return the value of test_user.NAME
     *
     * @mbggenerated Thu Nov 10 19:00:02 CST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_user.NAME
     *
     * @param name the value for test_user.NAME
     *
     * @mbggenerated Thu Nov 10 19:00:02 CST 2022
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_user.GENDER
     *
     * @return the value of test_user.GENDER
     *
     * @mbggenerated Thu Nov 10 19:00:02 CST 2022
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_user.GENDER
     *
     * @param gender the value for test_user.GENDER
     *
     * @mbggenerated Thu Nov 10 19:00:02 CST 2022
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_user.PASSWORD
     *
     * @return the value of test_user.PASSWORD
     *
     * @mbggenerated Thu Nov 10 19:00:02 CST 2022
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_user.PASSWORD
     *
     * @param password the value for test_user.PASSWORD
     *
     * @mbggenerated Thu Nov 10 19:00:02 CST 2022
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}