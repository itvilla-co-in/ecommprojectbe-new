package com.itvilla.ecomm.prod.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;
@Entity
@Table(name="user_role")
@Getter
@Setter
public class UserRole {
    @Id
    @Column(name="user_role_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long userRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private Customer customer;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="role_id")
    private Role role;






}
