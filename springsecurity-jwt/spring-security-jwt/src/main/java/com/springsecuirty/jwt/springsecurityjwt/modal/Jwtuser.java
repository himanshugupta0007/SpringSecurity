package com.springsecuirty.jwt.springsecurityjwt.modal;

public class Jwtuser {

    private String userName;

    private long id;

    private String role;

    
    /** 
     * @return String
     */
    public String getUserName() {
        return userName;
    }

    
    /** 
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    /** 
     * @return long
     */
    public long getId() {
        return id;
    }

    
    /** 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    
    /** 
     * @return String
     */
    public String getRole() {
        return role;
    }

    
    /** 
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Jwtuser [id=" + id + ", role=" + role + ", userName=" + userName + "]";
    }

}
