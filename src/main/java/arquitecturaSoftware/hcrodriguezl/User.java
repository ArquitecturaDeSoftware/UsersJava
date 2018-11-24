package arquitecturaSoftware.hcrodriguezl;

import javax.persistence.*;

@Entity
public class User {

    public User(){ }

    public User(String userId, String name, String lunchroomId,
                  String activeTicket, String password) {
        this.userId = userId;
        this.name = name;
        this.lunchroomId = lunchroomId;
        this.activeTicket = activeTicket;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getUserId(){
        return userId;
    }
    public String getName(){
        return name;
    }

    public String getLunchroomId(){
        return lunchroomId;
    }

    public String getActiveTicket(){
        return activeTicket;
    }

    public void setActiveTicket( String activeTicket){
         this.activeTicket = activeTicket;
    }
    public String getPassword(){
        return password;
    }

    @Id
    @Column(name="id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userId;
    private String name;
    private String lunchroomId;
    private String activeTicket;
    private String password;
    


}
