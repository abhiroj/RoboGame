package core.consumer;

import core.provider.CollectionProvider;

/**
 * CollectionConsumer accept CollectionProvider to consume those set of operations.
 */
public interface CollectionConsumer {


    /**
     * sets collection provider the rover commands to make collection at the given coordinate
     * pass null to unset.
     * throws runtime exception if not implemented and tried to be used.
     *
     * @param collectionProvider
     */
    void setCollectionProvider(CollectionProvider collectionProvider);

}