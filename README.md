Tips-tips dalam menggunakan Spring Boot JPA
1. set fetch type menjadi LAZY untuk semua jenis association (one to one, one to many, many to one, many to many)
2. akses data relasi menggunakan DTO, jangan melalui @Entity untuk menghindari query-query yang tidak di inginkan.



Pustaka :
1. https://vladmihalcea.com/the-best-way-to-map-a-projection-query-to-a-dto-with-jpa-and-hibernate/
2. https://vladmihalcea.com/the-hibernate-enable_lazy_load_no_trans-anti-pattern/
3. https://thorben-janssen.com/dto-projections/