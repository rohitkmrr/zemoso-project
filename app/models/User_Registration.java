package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User_Registration extends Model {
    
    @Id
    public long id;
    public String username;
    public String password;
    public String email ;
}