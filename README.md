Tips-tips dalam menggunakan Spring Boot JPA
1. set fetch type menjadi LAZY untuk semua jenis association (one to one, one to many, many to one, many to many)
2. untuk kebutuhan data fetch only, lebih baik menggunakan DTO (bukan select menggunakan entity). 
   select ke entity di gunakan hanya jika ada keperluan untuk mengupdate entity tersebut.
3. atau gunakan annotation @Transactional(readOnly = true) untuk entity yang hanya di inginkan untuk readOnly
4. jangan enable property berikut, spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
   lebih baik menggunakan annotation @Transactional di level service.



Pustaka :
1. https://vladmihalcea.com/the-best-way-to-map-a-projection-query-to-a-dto-with-jpa-and-hibernate/
2. https://vladmihalcea.com/the-hibernate-enable_lazy_load_no_trans-anti-pattern/
3. https://thorben-janssen.com/dto-projections/
4. https://vladmihalcea.com/spring-read-only-transaction-hibernate-optimization/
5. https://www.baeldung.com/hibernate-entity-lifecycle