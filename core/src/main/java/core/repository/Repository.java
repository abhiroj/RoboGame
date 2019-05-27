package core.src.main.java.core.repository;

import core.src.main.java.core.collection.Collectable;

public interface Repository {

    /**
     * Any thing that can be collected should be stored in repository.
     * @ImplNote use thread-safe approaches if the repo is used in multi-threaded scenario.
     * @param c to collect something.
     */
    void store(Collectable c);

}
