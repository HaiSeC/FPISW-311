/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OBJETOs;

import java.util.ArrayList;

/**
 *
 * @author Guerrero
 */
public class ObjUser {
    private String User;
    private String Pass;

    public ObjUser(String User, String Pass) {
        this.User = User;
        this.Pass = Pass;
    }
    
    public static ArrayList ALUsers = new ArrayList<>();
    
    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }
    
}
