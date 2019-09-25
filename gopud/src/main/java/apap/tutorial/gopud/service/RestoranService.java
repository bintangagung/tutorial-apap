package apap.tutorial.gopud.service;

import java.util.List;

import apap.tutorial.gopud.model.RestoranModel;
import org.springframework.stereotype.Service;

@Service
public interface RestoranService {
    // Method untuk menambah Restoran
    void addRestoran(RestoranModel restoran);

    // Method untuk mendapatkan semua data Restoran yang tersimpan
    List<RestoranModel> getRestoranList();

    // Method untuk mendapatkan data sebuah Restoran berdasarkan idRestoran
    RestoranModel getRestoranByIdRestoran(String idRestoran);

    // LATIHAN 3
    void deleteRestoran(RestoranModel restoran);
}