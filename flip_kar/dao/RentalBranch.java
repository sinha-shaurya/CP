package dao;


public class RentalBranch{
    private Integer id;
    private String name;

    public RentalBranch() {
    }

    public RentalBranch(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Branch : %d %s", id, name);
    }

}
