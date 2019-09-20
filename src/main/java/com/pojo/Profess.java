package com.pojo;

import java.io.Serializable;

/**
 * @author Administrator
 */
public class Profess implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    private String img;

    private String direction;

    private String profession;

    private String description;

    private Integer threshold;

    private Integer difficulty;

    private String period;

    private Integer company;

    private Integer salaryOne;

    private Integer salaryTwo;

    private Integer salaryThree;

    private Long createAt;

    private Long updateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public Integer getSalaryOne() {
        return salaryOne;
    }

    public void setSalaryOne(Integer salaryOne) {
        this.salaryOne = salaryOne;
    }

    public Integer getSalaryTwo() {
        return salaryTwo;
    }

    public void setSalaryTwo(Integer salaryTwo) {
        this.salaryTwo = salaryTwo;
    }

    public Integer getSalaryThree() {
        return salaryThree;
    }

    public void setSalaryThree(Integer salaryThree) {
        this.salaryThree = salaryThree;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }
}