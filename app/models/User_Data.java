package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User_Data extends Model {
    
    @Id
    public long Note_id;
    public String title;
    public String description;
  
}