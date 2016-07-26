package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class User_Data extends Model {
    
    @Id
    public long note_id;
    public String title;
    public String description;
    
    //state->    0 : active
    //           1 : archive 
    public int State=1;
    public Date Reminder_start;
    
    // is_reminder_set->          1:yes
    //                            2: no
    public int is_reminder_set;
    public Date Created_on=new Date();
    public String Deleted_on;
    
}