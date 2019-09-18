# Tutorial APAP
## Authors
Bintang Agung Nusantara-1706043550-C

What I have learned today

(Masukkan pertanyaan yang diikuti jawaban di setiap nomor, contoh seperti dibawah. Anda juga boleh menambahkan catatan apapun dibagian ini)
Github

    Apa itu Issue Tracker? Masalah apa yang dapat diselesaikan dengan Issue Tracker? Issue Tracker merupakan cara yang bagus untuk melacak tugas, peningkatan, dan bug untuk sebuah project. Pada halaman repository istimewa karena fokus kami pada kolaborasi, referensi, dan pemformatan teks yang sangat baik.
    Apa perbedaan dari git merge dan merge --squash? git merge ketika beberapa kali commit kemudian di merge menjadi satu di master merge --squash ketika beberapa kali commit maka di merge menjadi satu commit lalu masuk ke master

Spring

    Apa itu library & dependency? library merupakan kumpulan class atau method yang dijadikan satu dependency merupakan hubungan program/software yang saling bergantung sehingga jika salah satu program tidak ada maka program tersebut tidak bisa berjalan
    Apa itu Maven? Mengapa kita perlu menggunakan Maven? Maven merupakan perangkat pemahaman yang biasa digunakan untuk proyek berbasis java dan berguna untuk maintenance struktur kode
    Apa alternatif dari Maven? Jenkins, Travis CI, Ansible, Gradle, Chef, TeamCity

What I did not understand

(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-check apabila Anda sudah mengerti dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)

    Kenapa saya harus belajar APAP?
    cermat dalam mengetik
    pemahaman mendalam untuk intelij

(Anda dapat membuat tampilan code dalam README.md menjadi lebih baik. Cari tahu lebih dalam tentang penulisan README.md pada github pada link berikut)





Tutorial 2
Pertanyaan 1: Cobalah untuk menambahkan sebuah restoran dengan mengakses link berikut:
http://localhost:8080/restoran/add?idRestoran=1&nama=PanyuFC&alamat=Kantin%20Fasilkom&nomorTelepon=14022
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
terjadi error karena merender ke sebuah template html add-restoran padahal html tersebut tidak ada

Pertanyaan 2: Cobalah untuk menambahkan sebuah restoran dengan mengakses link berikut:
http://localhost:8080/restoran/add?idRestoran=2&nama=KentukuFC&alamat=Kantin%20FIK
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
terjadi error karena tipe variable nomortelepon yaitu integer sedangkan dilink tersebut tidak ada

Pertanyaan 3: Jika Papa APAP ingin melihat restoran PanyuFC, link apa yang harus diakses?
dapat diakses dengan 2 cara yaitu request variable dengan link http://localhost:8080/restoran/view?idRestoran={id-restoran}
 atau path param dengan link localhost:8080/restoran/view/id-restoran/{id-restoran}

4: Tambahkan 1 contoh restoran lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/restoran/viewall , apa yang akan ditampilkan? Sertakan
juga bukti screenshot mu.
list restoran-restoran yang telah ditambahkan
![](https://files.catbox.moe/ut6tqw.PNG)





