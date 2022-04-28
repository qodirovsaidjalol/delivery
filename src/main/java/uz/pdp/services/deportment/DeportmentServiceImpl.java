package uz.pdp.services.deportment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import uz.pdp.dto.deportment.DeportmentCreateDto;
import uz.pdp.dto.deportment.DeportmentDto;
import uz.pdp.dto.deportment.DeportmentUpdateDto;
import uz.pdp.entity.deportment.Deportment;
import uz.pdp.mapper.DeportmentMapper;
import uz.pdp.repository.DeportmentRepository;
import uz.pdp.services.AbstractService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DeportmentServiceImpl extends AbstractService<DeportmentRepository, DeportmentMapper> implements DeportmentService {

    @Autowired
    protected DeportmentServiceImpl(DeportmentRepository repository, @Qualifier("deportmentMapperImpl") DeportmentMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Long create(DeportmentCreateDto createDto) {
        Deportment deportment = mapper.fromCreateDto(createDto);
        if (repository.existsByName(createDto.getName())) throw new RuntimeException();
        repository.save(deportment);
        return deportment.getId();
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public Void update(DeportmentUpdateDto updateDto) {
        return null;
    }

    @Override
    public List<DeportmentDto> getAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public DeportmentDto get(Long id) {
        Optional<Deportment> optional = repository.findById(id);
        if (optional.isPresent())
            return mapper.toDto(optional.get());
        return new DeportmentDto();
    }
}
