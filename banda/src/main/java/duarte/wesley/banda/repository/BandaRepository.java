package duarte.wesley.banda.repository;

import duarte.wesley.banda.model.BandaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BandaRepository extends CrudRepository<BandaEntity, Long> {
}
