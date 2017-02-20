package com.mytests.spring.jpa20.test0.data;

import javax.persistence.*;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 12/19/2016.
 * Project: SpringJPA20_test0
 * *******************************
 */
@Entity
@Table(name = "chins", schema = "jbtests")
@NamedQuery(name = "MyChinsEntity.secondQuery", query = "select c from MyChinsEntity c where c.weight <= ?1")
public class MyChinsEntity {
    private int id;
    private String name;
    private String color;
    private String birthday;
    private Integer weight;
    private String sex;
    private Byte forSale;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "color", nullable = true, length = 30)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "birthday", nullable = true, length = 15)
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "weight", nullable = true)
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "sex", nullable = true, length = 15)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "forSale", nullable = true)
    public Byte getForSale() {
        return forSale;
    }

    public void setForSale(Byte forSale) {
        this.forSale = forSale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyChinsEntity that = (MyChinsEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (forSale != null ? !forSale.equals(that.forSale) : that.forSale != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (forSale != null ? forSale.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Chin " + id +
                ": name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", birthday='" + birthday + '\'' +
                ", weight=" + weight +
                ", sex='" + sex + '\'' +
                ", forSale=" + forSale +
                ' ';
    }
}
