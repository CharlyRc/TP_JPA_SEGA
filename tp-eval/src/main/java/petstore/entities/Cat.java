package petstore.entities;

public class Cat extends Animal{
    private Integer chipId;

    public Cat(Integer chipId) {
        this.chipId = chipId;
    }

    public Integer getChipId() {
        return chipId;
    }

    public void setChipId(Integer chipId) {
        this.chipId = chipId;
    }
}
