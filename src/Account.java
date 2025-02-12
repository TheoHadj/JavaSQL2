public class Account {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;





    public Account() {
        System.out.println("Account créé");
    }

    public Account(int id, String firstname, String lastname, String email, String password) {
        setId(id);
        setFirstname(firstname);
        setLastname(lastname);
        setEmail(email);
        setPassword(password);

    }





    public int getId() {
        return id;
    }
    private void setId(int id) {
        this.id = id;
    }


    public String getFirstname() {
        return firstname;
    }
    private void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    public String getLastname() {
        return lastname;
    }
    private void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public String getEmail() {
        return email;
    }
    private void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }
    private void setPassword(String password) {
        this.password = password;
    }

}
