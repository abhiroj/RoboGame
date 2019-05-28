package core.src.main.java.core.repository;

import core.src.main.java.core.collection.Collectable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RepositoryCache implements Repository {

    private List<Map<String, Object>> repo = new ArrayList<>();

    public void store(Collectable c) {
        repo.add(c.collect());
    }
}
