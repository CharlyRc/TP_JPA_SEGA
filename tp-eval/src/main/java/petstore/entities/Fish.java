package petstore.entities;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Fish extends Animal{
    @Enumerated(EnumType.STRING)
    private FishIvEnv fishIvEnv;

    public Fish(FishIvEnv fishIvEnv) {
        this.fishIvEnv = fishIvEnv;
    }

    public FishIvEnv getFishIvEnv() {
        return fishIvEnv;
    }

    public void setFishIvEnv(FishIvEnv fishIvEnv) {
        this.fishIvEnv = fishIvEnv;
    }
}
