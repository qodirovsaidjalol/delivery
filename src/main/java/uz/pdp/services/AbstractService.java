package uz.pdp.services;

import uz.pdp.mapper.Mapper;
import uz.pdp.repository.AbstractRepository;

/**
 * @param <R> repository
 * @param <M>
 */
public abstract class AbstractService<
        R extends AbstractRepository,
        M extends Mapper> {
    protected final R repository;
    protected final M mapper;

    protected AbstractService(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
