package com.cts.fasttack.admin.web.data.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import com.cts.fasttack.common.core.data.Identifiable;

@Entity
@Table(name = UserPasswordHistory.TABLE_NAME)
public class UserPasswordHistory implements Identifiable<Long> {

    public static final String TABLE_NAME = "USRPWDHIST";

    @Id
    @GenericGenerator(
            name = "USRPWDHIST_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "USRPWDHIST_SEQ"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USRPWDHIST_SEQ")
    private Long id;

    @Column(name = "usr")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "datetime")
    private Date date = new Date();

    public UserPasswordHistory() {
    }

    public UserPasswordHistory(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return id == null || id < 1;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
