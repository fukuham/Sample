package com.tada.doma2.entity;

import java.math.BigDecimal;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = UserinfoListener.class)
@Table(name = "userinfo")
public class Userinfo {

    /** */
    @Column(name = "name")
    String name;

    /** */
    @Column(name = "age")
    BigDecimal age;

    /** 
     * Returns the name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /** 
     * Sets the name.
     * 
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /** 
     * Returns the age.
     * 
     * @return the age
     */
    public BigDecimal getAge() {
        return age;
    }

    /** 
     * Sets the age.
     * 
     * @param age the age
     */
    public void setAge(BigDecimal age) {
        this.age = age;
    }
}