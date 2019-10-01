package apap.tutorial.gopud.repository;

import apap.tutorial.gopud.model.RestoranModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface RestoranDb extends JpaRepository<RestoranModel, Long> {
    Optional<RestoranModel> findByIdRestoran(Long idRestoran);
    //Tambahkan fitur View All Restoran yang menampilkan seluruh restoran beserta atributnya
    //terurut berdasarkan nama restoran dari A ke Z.
    List<RestoranModel> findAllByOrderByNamaAsc();   // I want to use some thing like this
}