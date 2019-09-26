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


## Tutorial 1
### What I have learned today
(Masukkan pertanyaan yang diikuti jawaban di setiap nomor, contoh seperti dibawah. Anda juga boleh
menambahkan catatan apapun dibagian ini)

#### Github
1. Apa itu Issue Tracker? Masalah apa yang dapat diselesaikan dengan Issue Tracker?
Issue Tracker merupakan cara yang bagus untuk melacak tugas, peningkatan, dan bug untuk sebuah project. Pada halaman repository istimewa karena fokus kami pada kolaborasi, referensi, dan pemformatan teks yang sangat baik. 
2. Apa perbedaan dari git merge dan merge --squash?
git merge ketika beberapa kali commit kemudian di merge menjadi satu di master
merge --squash ketika beberapa kali commit maka di merge menjadi satu commit lalu masuk ke master

#### Spring
3. Apa itu library & dependency?
library merupakan kumpulan class atau method yang dijadikan satu
dependency merupakan hubungan program/software yang saling bergantung sehingga jika salah satu program tidak ada maka program tersebut tidak bisa berjalan
4. Apa itu Maven? Mengapa kita perlu menggunakan Maven?
Maven merupakan perangkat pemahaman yang biasa digunakan untuk proyek berbasis java dan berguna untuk maintenance struktur kode
5. Apa alternatif dari Maven?
Jenkins, Travis CI, Ansible, Gradle, Chef, TeamCity

### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda sudah mengerti
dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [ ] Kenapa saya harus belajar APAP?
- [x] cermat dalam mengetik
- [x] pemahaman mendalam untuk intelij

(Anda dapat membuat tampilan code dalam README.md menjadi lebih baik. Cari tahu lebih dalam
tentang penulisan README.md pada github pada link
[berikut](https://help.github.com/en/articles/basic-writing-and-formatting-syntax))


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




Tutorial 3
1. Pada class MenuDb, terdapat method findByRestoranIdRestoran , apakah kegunaan dari
method tersebut?
method findByRestoranIdRestoran akan melakukan pencarian mune yang terdapat pada objek RestoranModel.
Method ini akan mereturn list yang berisi menu-menu yang tersedia.
2. Pada class RestoranController, jelaskan perbedaan method addRestoranFormPage dan
addRestoranSubmit?
method addRestoranFormPage menggunakan method GET yang berarti pada method addRestoranFormPage akan mengambil form yang telah ada untuk menambahkan sebuah restoran.
Sedangkan untuk method addRestoranSubmit, method yang dilakukan ialah POST yang berarti pada method ini ketika dijalankan akan memposting data yang sudah diisi pada form ke database untuk disimpan
3. Jelaskan apa kegunaan dari JPA Repository?
JPA Repository memudahkan untuk melakukan CRUD (CREATE, READ, UPDATE, serta DELETE) pada database.
4. Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara RestoranModel dan
MenuModel dibuat?
Restoran Model
![Image description](https://drive.google.com/file/d/12qmP22XJ9V6MtAYYz-18_yz-sji2C7fZ/view?usp=sharing)
Menu Model
![Image description](https://drive.google.com/file/d/1-t70uEX9Qpbwglqr4_SLhHs16_7dsONZ/view?usp=sharing)
terhubungnya relasi tersebut disebabkan pada MenuModel memiliki atribut dengan tipe relasi ManyToOne kepada RestoranModel.
Dan RestoranModel memliki atribut dengan tipe relasai OneToMany dan dipetakkan ke MenuModel.
5. Jelaskan kegunaan FetchType.LAZY , CascadeType.ALL , dan FetchType.EAGER
FetchType.LAZY berfungsi ketika kita mengeload suatu table dari database, database hanya akan mengeload hanya sesuatu yang kita butuhkan (misal .getNama()).
CascadeType.ALL ketika terjadi sesuatu pada suatu entitas, maka entitas yang terferensi oleh entitas tersebut akan ikut mengalami kejadian yang sama (misal X di delete, maka entitas lain yang tereferensi oleh X juga ikut di delete).
FetchType.EAGER berfungsi ketika kita mengeload suatu table dari database, database akan mengeload secara EAGER semua yang ada pada tabel tersebut.
