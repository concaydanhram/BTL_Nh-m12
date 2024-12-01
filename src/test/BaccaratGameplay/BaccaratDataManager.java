package test.BaccaratGameplay;

import gamecardbaccarat.Baccarat;

public class BaccaratDataManager {
    private static BaccaratDataManager instance;

    private Baccarat baccarat;

    private BaccaratDataManager() {
        baccarat = Baccarat.getInstance(); // Hoặc khởi tạo mới nếu cần
    }

    public static BaccaratDataManager getInstance() {
        if (instance == null) {
            instance = new BaccaratDataManager();
        }
        return instance;
    }

    public Baccarat getBaccarat() {
        return baccarat;
    }
}
