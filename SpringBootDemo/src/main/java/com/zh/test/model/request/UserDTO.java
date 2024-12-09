package com.zh.test.model.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class UserDTO implements Serializable {

    @ApiModelProperty("用户Id")
    @NotNull
    private Integer id;

    @ApiModelProperty("用户姓名")
    @NotNull
    private String name;

    @ApiModelProperty("性别")
    @NotNull
    private String gender;

    @ApiModelProperty("密码")
    @NotNull
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
