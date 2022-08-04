package com.company.dto;

import com.company.entity.User;
import com.company.entity.UserSkill;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String profileDescription;
    private List<UserSkillDTO> userSkillDTOList;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
        this.profileDescription = user.getProfileDesc();

        userSkillDTOList = new ArrayList<>();
        List<UserSkill> userSkillList = user.getUserSkillList();

        for (UserSkill userSkill : userSkillList) {
            userSkillDTOList.add(new UserSkillDTO(userSkill));
        }
    }

    public UserDTO(int id, String name, String surname, String email, String password,
                   String profileDescription) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.profileDescription = profileDescription;
    }

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public List<UserSkillDTO> getUserSkillDTOList() {
        return userSkillDTOList;
    }

    public void setUserSkillDTOList(List<UserSkillDTO> userSkillDTOList) {
        this.userSkillDTOList = userSkillDTOList;
    }
}
